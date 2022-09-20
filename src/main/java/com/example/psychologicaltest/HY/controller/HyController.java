package com.example.psychologicaltest.HY.controller;


import com.example.psychologicaltest.HY.entity.Users;
import com.example.psychologicaltest.HY.repository.DevelopeRepository;
import com.example.psychologicaltest.HY.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HyController {

    @Autowired
    UsersRepository userRepository;
    @Autowired
    DevelopeRepository developeRepository;



//    @PostMapping("/insertuserinfo")
//    public String insertinfo(@RequestParam String mname, @RequestParam String mgender, @RequestParam Long mage ) {
//        Users user = Users.builder().mname(mname).mage(mage).mgender(mgender).build();
//        userRepository.save(user);
//        System.out.println(user);
//    }

}
