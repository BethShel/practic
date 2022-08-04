package com.example.demo.controllers;
import com.example.demo.domain.musicGroup;
import com.example.demo.repos.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class GroupController {
    @Autowired
    private GroupRepo taskRep;

    @GetMapping("/group")
    public String main(Map<String,Object> model){
        Iterable<musicGroup> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "group";
    }

    @PostMapping("/group")
    public String add(@RequestParam String name, @RequestParam Date startdate, @RequestParam Date enddate, @RequestParam String style, Map<String,Object> model) {
        musicGroup characteristic = new musicGroup(name,startdate, enddate,style);

        taskRep.save(characteristic);

        Iterable<musicGroup> characteristics = taskRep.findAll();
        model.put("characteristics",characteristics);
        return "group";
    }
    @PostMapping("groupFilter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<musicGroup> characteristics;

        if (filter != null && !filter.isEmpty()) {
            characteristics = taskRep.findByName(filter);
        } else {
            characteristics = taskRep.findAll();
        }

        model.put("characteristics",characteristics);

        return "group";
    }
}
