package com.example.psychologicaltest.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/ys/ystest")
    public String intoQuiz() {

        return "ys/ystest";
    }

    @GetMapping("/ys/ysfinish")
    public String intoResult() {

        return "ys/ysfinish";
    }
}
