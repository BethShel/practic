package com.example.demo.repos;

import com.example.demo.domain.Artist;
import com.example.demo.domain.albumCharacteristic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepo extends CrudRepository<Artist, Long> {
    List<Artist> findByName(String name);
}
