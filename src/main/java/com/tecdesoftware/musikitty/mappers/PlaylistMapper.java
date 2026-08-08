package com.tecdesoftware.musikitty.mappers;

import com.tecdesoftware.musikitty.dtos.PlaylistRequestDto;
import com.tecdesoftware.musikitty.dtos.PlaylistResponseDto;
import com.tecdesoftware.musikitty.dtos.SongRequestDto;
import com.tecdesoftware.musikitty.dtos.SongResponseDto;
import com.tecdesoftware.musikitty.entities.Playlist;
import com.tecdesoftware.musikitty.entities.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    Playlist toEntity(PlaylistRequestDto dto);
    PlaylistResponseDto toDto(Playlist entity);

    Song toEntity(SongRequestDto dto);
    SongResponseDto toDto(Song entity);
}