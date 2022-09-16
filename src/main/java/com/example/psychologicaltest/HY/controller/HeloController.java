package com.example.psychologicaltest.HY.controller;

import com.example.psychologicaltest.HY.DTO.DevloperDTO;
import com.example.psychologicaltest.HY.DTO.UsersDTO;
import com.example.psychologicaltest.HY.entity.Developer;
import com.example.psychologicaltest.HY.entity.Users;
import com.example.psychologicaltest.HY.repository.DevelopeRepository;
import com.example.psychologicaltest.HY.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeloController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    DevelopeRepository developeRepository;

    @RequestMapping(value = "/insertuserinfo", method = RequestMethod.POST)
    public void InsertUserInfo(UsersDTO usersDTO) throws Exception {
        Users users= Users.builder().mname(usersDTO.getMname()).mage(usersDTO.getMage()).mgender(usersDTO.getMgender()).build();
        usersRepository.save(users);
    }


    @RequestMapping(value = "/insertAnsInfo", method = RequestMethod.POST)
    public void InsertAnsInfo(DevloperDTO devloperDTO) throws Exception {
        Developer develope = Developer.builder()
                .a1(devloperDTO.getA1())
                .a2(devloperDTO.getA2())
                .a3(devloperDTO.getA3())
                .a4(devloperDTO.getA4())
                .a5(devloperDTO.getA5())
                .a6(devloperDTO.getA6())
                .a7(devloperDTO.getA7())
                .a8(devloperDTO.getA8())
                .a9(devloperDTO.getA9())
                .a10(devloperDTO.getA10())
                .a11(devloperDTO.getA11())
                .a12(devloperDTO.getA12())
                .result(devloperDTO.getResult())
                .build();
        developeRepository.save(develope);
    }

}


