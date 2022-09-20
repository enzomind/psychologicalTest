package com.example.psychologicaltest.sh.controller;

import com.example.psychologicaltest.sh.repository.ShRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RsController {


    @Autowired
    ShRepository shRepository;

    @GetMapping("/shHome")
    String root() {
        return "성후네";
    }

}
