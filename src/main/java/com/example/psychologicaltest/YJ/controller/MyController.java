package com.example.psychologicaltest.YJ.controller;

import com.example.psychologicaltest.YJ.entity.MbtiTest;
import com.example.psychologicaltest.YJ.entity.User;
import com.example.psychologicaltest.YJ.repository.MbtiTestRepository;
import com.example.psychologicaltest.YJ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MbtiTestRepository mbtiTestRepository;

    @GetMapping("/yejin") //메인 홈
    String index() {
        return "user";
    }

    @RequestMapping(value="/userInsert", method= RequestMethod.POST)
    String MbtiTest1(@RequestParam String name, @RequestParam String birth, @RequestParam String gender) {
        User user = User.builder().name(name).birth(birth).gender(gender).build();
        userRepository.save(user);
        return "test";
    }
    @GetMapping("/userform")
    String insert1() { return "user"; }

    @RequestMapping(value="/testInsert", method= RequestMethod.POST)
    String MbtiTest2(@RequestParam(value="test1",required=false) String test1, @RequestParam(value="test2",required=false) String test2, @RequestParam(value="test3",required=false) String test3, @RequestParam(value="test4",required=false) String test4,
                     @RequestParam(value="test5",required=false) String test5, @RequestParam(value="test6",required=false) String test6, @RequestParam(value="test7",required=false) String test7, @RequestParam(value="test8",required=false) String test8) {
        MbtiTest mbtiTest = MbtiTest.builder().test1(test1).test2(test2).test3(test3).test4(test4).test5(test5).test6(test6).test7(test7).test8(test8).build();
        mbtiTestRepository.save(mbtiTest);
        return "success";
    }
    @GetMapping("/testform")
    String insert2() { return "test"; }

    @GetMapping("/success")
    String insertSuccess() { return "success"; }

//    @GetMapping("/success")
//    public String list(Model model) {
//        List<User> userList = UserService.getUserlist();
//        model.addAttribute(("userList", userList);
//        return "success";
//    }


}
