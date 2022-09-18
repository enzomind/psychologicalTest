package com.example.psychologicaltest.YS.controller;

import com.example.psychologicaltest.YS.dto.YsmemberRequestDTO;
import com.example.psychologicaltest.YS.dto.YstestDTO;
import com.example.psychologicaltest.YS.entity.Ysmember;
import com.example.psychologicaltest.YS.entity.Ystest;
import com.example.psychologicaltest.YS.repository.YsmemberRepository;
import com.example.psychologicaltest.YS.repository.YstestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class YsController {

    private final YstestRepository ystestRepository;
    private final YsmemberRepository ysmemberRepository;

    @RequestMapping(value = "/insertResult", method = RequestMethod.POST)
    public void insertResult(YstestDTO ystestDTO) throws Exception {

        Ystest ystest = Ystest.builder()
                .tresult(ystestDTO.getTresult())
                .build();

        ystestRepository.save(ystest);

    }

    @RequestMapping(value = "/insertMember", method = RequestMethod.POST)
    public void insertMemberInfo(YsmemberRequestDTO ysmemberRequestDTO) throws Exception {

        Ysmember ysmember = Ysmember.builder()
                .mname(ysmemberRequestDTO.getMname())
                .mgender(ysmemberRequestDTO.getMgender())
                .mage(ysmemberRequestDTO.getMage())
                .build();

        ysmemberRepository.save(ysmember);

    }
}
