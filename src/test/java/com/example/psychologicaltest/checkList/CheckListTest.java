package com.example.psychologicaltest.checkList;

import com.example.psychologicaltest.checkList.repository.CheckListRepository;
import com.example.psychologicaltest.checkList.repository.SaveQueryRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Log4j2
public class CheckListTest {
    private CheckListRepository checkListRepository;
    private SaveQueryRepository saveQueryRepository;

    @Autowired
    public CheckListTest(CheckListRepository checkListRepository, SaveQueryRepository saveQueryRepository) {
        this.checkListRepository = checkListRepository;
        this.saveQueryRepository = saveQueryRepository;
    }

//    @Test
//    void name() {
//        System.out.println("-----------SELECT ALL TEST-------------------------------");
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            RecordDto recordDto = RecordDto.builder()
//                    .recordType("input"+i)
//                    .recordTitle("shop"+i)
//                    .recordDetail("something"+i)
//                    .recordPrice(999+i)
//                    .paymentMethod("card"+i)
//                    .build();
//            recordService.insertRecord(recordDto);
//        });
//        mybatisRepository.selectRecordAll().forEach(System.out::println);
//
//
//        System.out.println("-----------UPDATE TEST-------------------------------");
//        RecordDto updateSample = RecordDto.builder()
//                .recordType("input@@@@@@@@@")
//                .recordTitle("shop@@@@@@@@@")
//                .recordDetail("something@@@@@@")
//                .recordPrice(111)
//                .paymentMethod("card@@@@@@@")
//                .recordId(1L)
//                .build();
//        recordService.updateRecord(updateSample);
//        mybatisRepository.selectRecordAll().forEach(System.out::println);
//        System.out.println("-----------SELECT TEST-------------------------------");
//        System.out.println(mybatisRepository.selectByID(1L));
//
//    }
}
