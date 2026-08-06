package com.tecdesoftware.musikitty.repositories;

import com.tecdesoftware.musikitty.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByPlaylistId(Long playlistId);
}