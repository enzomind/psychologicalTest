package YJ.controller;

import YJ.entity.Mbti;
import YJ.entity.User;
import YJ.repository.MbtiRepository;
import YJ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    MbtiRepository mbtiRepository;
//
//    @GetMapping("/") //메인 홈
//    String index() {
//        return "test";
//    }
//
//    @RequestMapping(value="/insert", method= RequestMethod.POST)
//    String MbtiTest1(@RequestParam String name, @RequestParam String birth, @RequestParam String gender,
//                     @RequestParam String test1, @RequestParam String test2, @RequestParam String test3, @RequestParam String test4,
//                     @RequestParam String test5, @RequestParam String test6, @RequestParam String test7, @RequestParam String test8) {
//        User user = User.builder().name(name).birth(birth).gender(gender).build();
//        Mbti mbti = Mbti.builder().test1(test1).test2(test2).test3(test3).test4(test4).test5(test5).test6(test6).test7(test7).test8(test8).build();
//        userRepository.save(user);
//        mbtiRepository.save(mbti);
//        return "success";
//    }
//    @GetMapping("/mbtiform")
//    String insert2() { return "test"; }

}

