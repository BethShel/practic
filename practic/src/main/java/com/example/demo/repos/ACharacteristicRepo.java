package com.example.demo.repos;

import com.example.demo.domain.albumCharacteristic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ACharacteristicRepo extends CrudRepository<albumCharacteristic, Long> {
    List<albumCharacteristic> findByName(String name);
}
