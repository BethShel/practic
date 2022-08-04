package com.example.demo.repos;

import com.example.demo.domain.songs;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepo extends CrudRepository<songs, Long> {
    List<songs> findByName(String name);
}
