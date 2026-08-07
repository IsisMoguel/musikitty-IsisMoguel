package com.tecdesoftware.musikitty.repositories;

import com.tecdesoftware.musikitty.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}