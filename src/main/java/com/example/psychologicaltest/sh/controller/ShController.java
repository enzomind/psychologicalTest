package com.example.psychologicaltest.sh.controller;

import com.example.psychologicaltest.sh.entity.ShTestResultEntity;
import com.example.psychologicaltest.sh.entity.ShUserEntity;
import com.example.psychologicaltest.sh.repository.ShRepository;
import com.example.psychologicaltest.sh.repository.ShUserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class ShController {

    @Autowired
    ShRepository shRepository;
    @Autowired
    ShUserRepository2 shUserRepository2;


    @ResponseBody
    @RequestMapping(value = "result.do", method = RequestMethod.POST)
    public void resTable(@Param("resIndex") int resIndex,@Param("resAnimal") String resAnimal, ShTestResultEntity shTestResultEntity,HttpServletRequest request) {

        Long lastmid = lastInsertMid();
        ShUserEntity aa = ShUserEntity.builder().mid(lastmid).build();

        ShTestResultEntity shTestResult1 = ShTestResultEntity.builder().mid(aa).resIndex(resIndex).resAnimal(resAnimal).build();
        shRepository.save(shTestResult1);
        System.out.println(aa);
        System.out.println(resIndex);
        System.out.println(resAnimal);

    }

    @ResponseBody
    @RequestMapping(value = "result2.do", method = RequestMethod.POST)
    public void resTable2(@Param("mname") String mname, @Param("mgender") String mgender,@Param("mage") int mage, ShUserEntity shUserEntity, HttpServletRequest request){

        ShUserEntity shUserResult1 = ShUserEntity.builder().mname(mname).mgender(mgender).mage(mage).build();

        shUserRepository2.save(shUserResult1);

        System.out.println(mname);
        System.out.println(mgender);
        System.out.println(mage);

    }

    public long lastInsertMid() {
        List<ShUserEntity> all = shUserRepository2.findAll(Sort.by(Sort.Direction.DESC, "mid"));

//        all.stream().forEach( (e) -> System.out.println(e ));
//        System.out.println("찾았니? " + all.get(0).getMid());
        Long lastMid = all.get(0).getMid();
        return lastMid;
    }


}
