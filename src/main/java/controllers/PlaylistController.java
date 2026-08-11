package com.tecdesoftware.musikitty.controllers;

import com.tecdesoftware.musikitty.dtos.PlaylistRequestDto;
import com.tecdesoftware.musikitty.dtos.PlaylistResponseDto;
import com.tecdesoftware.musikitty.services.PlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playlists")
@RequiredArgsConstructor
@Tag(name = "Playlists", description = "Endpoints para la gestión de listas de reproducción y sus canciones")
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    @Operation(summary = "Crear nueva playlist con canciones (Guardado en cascada)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Playlist creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<PlaylistResponseDto> createPlaylist(@RequestBody PlaylistRequestDto requestDto) {
        PlaylistResponseDto created = playlistService.createPlaylist(requestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener todas las playlists")
    @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente")
    public ResponseEntity<List<PlaylistResponseDto>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una playlist por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Playlist encontrada"),
            @ApiResponse(responseCode = "404", description = "Playlist no encontrada")
    })
    public ResponseEntity<PlaylistResponseDto> getPlaylistById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una playlist y sus canciones asociadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Playlist eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Playlist no encontrada")
    })
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}