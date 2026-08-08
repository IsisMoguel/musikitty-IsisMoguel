package com.tecdesoftware.musikitty.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PlaylistRequestDto {
    private String name;
    private String description;
    private List<SongRequestDto> songs; // Incluye las canciones al crear la playlist (Guardado en Cascada)
}