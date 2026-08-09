package com.tecdesoftware.musikitty.services;

import com.tecdesoftware.musikitty.dtos.PlaylistRequestDto;
import com.tecdesoftware.musikitty.dtos.PlaylistResponseDto;
import com.tecdesoftware.musikitty.entities.Playlist;
import com.tecdesoftware.musikitty.mappers.PlaylistMapper;
import com.tecdesoftware.musikitty.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    @Override
    public PlaylistResponseDto createPlaylist(PlaylistRequestDto dto) {
        Playlist playlist = playlistMapper.toEntity(dto);

        // Vínculo manual para garantizar la relación bidireccional y la cascada
        if (playlist.getSongs() != null) {
            playlist.getSongs().forEach(song -> song.setPlaylist(playlist));
        }

        Playlist savedPlaylist = playlistRepository.save(playlist);
        return playlistMapper.toDto(savedPlaylist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlaylistResponseDto> getAllPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .map(playlistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PlaylistResponseDto getPlaylistById(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found with id: " + id));
        return playlistMapper.toDto(playlist);
    }

    @Override
    public void deletePlaylist(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new RuntimeException("Playlist not found with id: " + id);
        }
        playlistRepository.deleteById(id);
    }
}