package com.example.demo.controllers;

import com.example.demo.domain.Album;
import com.example.demo.repos.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepo taskRep;


    @GetMapping("/album")
    public String main(Map<String,Object> model){
        Iterable<Album> albums = taskRep.findAll();
        model.put("answers",albums);
        return "album";
    }
    @PostMapping("/album")
    public String add(@RequestParam Integer songID, @RequestParam Integer characteristicID, Map<String,Object> model) {
        Album album = new Album(songID,characteristicID);

        taskRep.save(album);

        Iterable<Album> albums = taskRep.findAll();
        model.put("albums",albums);
        return "album";
    }
}
