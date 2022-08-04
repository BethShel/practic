package com.example.demo.controllers;
import com.example.demo.domain.Album;
import com.example.demo.domain.albumCharacteristic;
import com.example.demo.repos.ACharacteristicRepo;
import com.example.demo.repos.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class ACharacteristicController {
    @Autowired
    private ACharacteristicRepo taskRep;
    @GetMapping("/")
    public String mainMenu(Map<String, Object> model) {
        return "main";
    }
    @GetMapping("/albumCharacteristic")
    public String main(Map<String,Object> model){
        Iterable<albumCharacteristic> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "albumCharacteristic";
    }

    @PostMapping("/albumCharacteristic")
    public String add(@RequestParam String name, @RequestParam Date date, @RequestParam String style, @RequestParam Integer countTracks, @RequestParam Integer length, @RequestParam String carrierType, Map<String,Object> model) {
        albumCharacteristic characteristic = new albumCharacteristic(name,date,style,countTracks,length,carrierType);

        taskRep.save(characteristic);

        Iterable<albumCharacteristic> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "albumCharacteristic";
    }
    @PostMapping("albumFilter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<albumCharacteristic> characteristics;

        if (filter != null && !filter.isEmpty()) {
            characteristics = taskRep.findByName(filter);
        } else {
            characteristics = taskRep.findAll();
        }

        model.put("characteristics",characteristics);

        return "albumCharacteristic";
        }
}
