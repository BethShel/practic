package com.example.demo.controllers;
import com.example.demo.domain.songs;
import com.example.demo.repos.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class songController {
    @Autowired
    private SongRepo taskRep;

    @GetMapping("/song")
    public String main(Map<String,Object> model){
        Iterable<songs> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "song";
    }

    @PostMapping("/song")
    public String add(@RequestParam String name, @RequestParam Date writedate, @RequestParam String style, @RequestParam Integer length, Map<String,Object> model) {
        songs characteristic = new songs(name,writedate,style, length);

        taskRep.save(characteristic);

        Iterable<songs> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "song";
    }
    @PostMapping("songFilter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<songs> characteristics;

        if (filter != null && !filter.isEmpty()) {
            characteristics = taskRep.findByName(filter);
        } else {
            characteristics = taskRep.findAll();
        }

        model.put("characteristics",characteristics);

        return "song";
    }
}
