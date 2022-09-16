package com.example.psychologicaltest.YS.controller;

import com.example.psychologicaltest.YS.dto.YstestDTO;
import com.example.psychologicaltest.YS.entity.Ystest;
import com.example.psychologicaltest.YS.repository.YstestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class YsController {

    private final YstestRepository ystestRepository;

    @RequestMapping(value = "/insertResult", method = RequestMethod.POST)
    public String insertResult(YstestDTO ystestDTO) throws Exception {

        Ystest ystest = Ystest.builder()
                .tresult(ystestDTO.getTresult())
                .build();
        ystestRepository.save(ystest);

        return "redirect:/ys/ysfinish";
    }
}
