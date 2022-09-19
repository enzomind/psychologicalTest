package com.example.psychologicaltest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/ys/ystest")
    public String intoQuiz() {

        return "ys/ystest";
    }

    @GetMapping("/ys/ysfinish")
    public String intoResult(@RequestParam int data, Model model) {

        System.out.println(data);
        model.addAttribute("data", data);
        return "ys/ysfinish";
    }
}