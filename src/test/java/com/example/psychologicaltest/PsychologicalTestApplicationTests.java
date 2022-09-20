package com.example.psychologicaltest;


import com.example.psychologicaltest.YS.entity.Ysmember;
import com.example.psychologicaltest.YS.entity.Ystest;
import com.example.psychologicaltest.YS.repository.YstestRepository;
import com.example.psychologicaltest.sh.entity.ShUserEntity;
import com.example.psychologicaltest.sh.repository.ShUserRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.psychologicaltest.YS.repository.YsmemberRepository;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;

@SpringBootTest
class PsychologicalTestApplicationTests {

    @Autowired
    private YsmemberRepository ysmemberRepository;
    @Autowired
    private YstestRepository ystestRepository;

    @Autowired
    ShUserRepository2 shUserRepository2;

    @Test
    void saveTest() {
        Ystest ystest = Ystest.builder()
                .tresult("horse")
                .build();

        ystestRepository.save(ystest);
    }

    @Test
    void saveMember() {
        Ysmember ysmember = Ysmember.builder()
                .mname("오윤섭")
                .mgender("남")
                .mage(123)
                .build();

        ysmemberRepository.save(ysmember);
    }

    @Test
    public void findmidAll() {
        List<ShUserEntity> all = shUserRepository2.findAll(Sort.by(Sort.Direction.DESC, "mid"));

        all.stream().forEach( (e) -> System.out.println(e ));
        System.out.println("찾았니? " + all.get(0).getMid());



    }




}
