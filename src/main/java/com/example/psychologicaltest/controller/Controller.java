package com.example.psychologicaltest.controller;

import com.example.psychologicaltest.YS.dto.YsmemberPageRequestDTO;
import com.example.psychologicaltest.YS.entity.Ystest;
import com.example.psychologicaltest.YS.model.YsmemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final YsmemberService ysmemberService;

    @GetMapping("/ys/ystest")
    public String intoQuiz() {

        return "ys/ystest";
    }

    @GetMapping("/ys/ysfinish")
    public String intoResult(@RequestParam int data, Model model1, YsmemberPageRequestDTO ysmemberPageRequestDTO, Model model2) {

        model1.addAttribute("data", data);
        model2.addAttribute("result", ysmemberService.getList(ysmemberPageRequestDTO));

        return "ys/ysfinish";
    }
}