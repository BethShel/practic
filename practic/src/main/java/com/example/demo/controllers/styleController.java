package com.example.demo.controllers;
import com.example.demo.domain.songs;
import com.example.demo.domain.style;
import com.example.demo.repos.SongRepo;
import com.example.demo.repos.StyleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class styleController {
    @Autowired
    private StyleRepo taskRep;

    @GetMapping("/style")
    public String main(Map<String,Object> model){
        Iterable<style> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "style";
    }

    @PostMapping("/style")
    public String add(@RequestParam String name, Map<String,Object> model) {
        style characteristic = new style(name);

        taskRep.save(characteristic);

        Iterable<style> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "style";
    }
    @PostMapping("styleFilter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<style> characteristics;

        if (filter != null && !filter.isEmpty()) {
            characteristics = taskRep.findByName(filter);
        } else {
            characteristics = taskRep.findAll();
        }

        model.put("characteristics",characteristics);

        return "style";
    }
}
