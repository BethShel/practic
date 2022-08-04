package com.example.demo.repos;

import com.example.demo.domain.Album;
import org.springframework.data.repository.CrudRepository;


public interface AlbumRepo extends CrudRepository<Album, Integer> {

}