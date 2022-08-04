package com.example.demo.repos;

import com.example.demo.domain.songs;
import com.example.demo.domain.style;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StyleRepo extends CrudRepository<style, Long> {
    List<style> findByName(String name);
}
