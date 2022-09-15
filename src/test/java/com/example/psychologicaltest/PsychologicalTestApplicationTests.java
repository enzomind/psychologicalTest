package com.example.psychologicaltest;


import com.example.psychologicaltest.ys.entity.Ysmember;
import com.example.psychologicaltest.ys.entity.Ystest;
import com.example.psychologicaltest.ys.repository.YstestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.psychologicaltest.ys.repository.YsmemberRepository;


@SpringBootTest
class PsychologicalTestApplicationTests {

    @Autowired
    private YsmemberRepository ysmemberRepository;
    @Autowired
    private YstestRepository ystestRepository;

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




}
