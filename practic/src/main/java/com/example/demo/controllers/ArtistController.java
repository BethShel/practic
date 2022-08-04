package com.example.demo.controllers;
import com.example.demo.domain.Artist;
import com.example.demo.domain.albumCharacteristic;
import com.example.demo.repos.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepo taskRep;

    @GetMapping("/artist")
    public String main(Map<String,Object> model){
        Iterable<Artist> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "artist";
    }

    @PostMapping("/artist")
    public String add(@RequestParam String name, @RequestParam String surname, @RequestParam Date birthdate, @RequestParam Date deathdate,@RequestParam String style, Map<String,Object> model) {
        Artist characteristic = new Artist(name,surname,birthdate,deathdate,style);

        taskRep.save(characteristic);

        Iterable<Artist> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "artist";
    }
    @PostMapping("artistFilter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Artist> characteristics;

        if (filter != null && !filter.isEmpty()) {
            characteristics = taskRep.findByName(filter);
        } else {
            characteristics = taskRep.findAll();
        }

        model.put("characteristics",characteristics);

        return "artist";
    }
}
