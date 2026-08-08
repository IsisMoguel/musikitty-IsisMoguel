package com.tecdesoftware.musikitty.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PlaylistResponseDto {
    private Long id;
    private String name;
    private String description;
    private List<SongResponseDto> songs;
}