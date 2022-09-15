package HY.controller;


import HY.entity.User;
import HY.repository.DevelopeRepository;
import HY.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HyController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DevelopeRepository developeRepository;



    @PostMapping("/insertuserinfo")
    public void insertinfo(@RequestParam String mname, @RequestParam String mgender, @RequestParam Long mage ) {
        User user = User.builder().mname(mname).mage(mage).mgender(mgender).build();
        userRepository.save(user);
    }

}
