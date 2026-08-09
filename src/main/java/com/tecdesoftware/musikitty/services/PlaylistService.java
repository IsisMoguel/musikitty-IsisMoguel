package com.tecdesoftware.musikitty.services;

import com.tecdesoftware.musikitty.dtos.PlaylistRequestDto;
import com.tecdesoftware.musikitty.dtos.PlaylistResponseDto;
import java.util.List;

public interface PlaylistService {
    PlaylistResponseDto createPlaylist(PlaylistRequestDto dto);
    List<PlaylistResponseDto> getAllPlaylists();
    PlaylistResponseDto getPlaylistById(Long id);
    void deletePlaylist(Long id);
}