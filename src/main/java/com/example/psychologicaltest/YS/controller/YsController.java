package com.example.psychologicaltest.YS.controller;

import com.example.psychologicaltest.YS.dto.YsmemberDTO;
import com.example.psychologicaltest.YS.dto.YstestDTO;
import com.example.psychologicaltest.YS.entity.Ysmember;
import com.example.psychologicaltest.YS.entity.Ystest;
import com.example.psychologicaltest.YS.repository.YsmemberRepository;
import com.example.psychologicaltest.YS.repository.YstestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Log4j2
public class YsController {

    private final YstestRepository ystestRepository;
    private final YsmemberRepository ysmemberRepository;


    @RequestMapping(value = "/insertResult", method = RequestMethod.POST)
    public void insertResult(YstestDTO ystestDTO) throws Exception {

        Ystest ystest = Ystest.builder()
                .tresult(ystestDTO.getTresult())
                .tcode(ystestDTO.getTcode())
                .build();

        ystestRepository.save(ystest);
    }

    @RequestMapping(value = "/insertMember", method = RequestMethod.POST)
    public void insertMemberInfo(YsmemberDTO ysmemberDTO) throws Exception {

        Ysmember ysmember = Ysmember.builder()
                .mname(ysmemberDTO.getMname())
                .mgender(ysmemberDTO.getMgender())
                .mage(ysmemberDTO.getMage())
                .mresult(ysmemberDTO.getMresult())
                .build();

        ysmemberRepository.save(ysmember);

    }

}

