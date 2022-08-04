package com.example.demo.repos;

import com.example.demo.domain.musicGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepo extends CrudRepository<musicGroup, Long> {
    List<musicGroup> findByName(String name);
}
