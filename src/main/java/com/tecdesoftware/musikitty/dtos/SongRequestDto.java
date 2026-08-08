package com.tecdesoftware.musikitty.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongRequestDto {
    private String title;
    private String artist;
    private Integer durationSeconds;
}