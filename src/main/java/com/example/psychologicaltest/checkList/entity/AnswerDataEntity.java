package com.example.psychologicaltest.checkList.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AnswerDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adId;
    private int answerNumber;
    // FK 멤버 id
    // FK 질문 id
//    private Long uId; // 실시한 테스트 고유번호
//    private Date regData; // 등록 날짜

}
