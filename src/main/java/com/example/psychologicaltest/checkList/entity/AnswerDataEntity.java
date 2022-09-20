package com.example.psychologicaltest.checkList.entity;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name ="QUESTION_ENTITY_Q_ID")
    private QuestionEntity questionEntity;
//    private Long uId; // 실시한 테스트 고유번호
//    private Date regData; // 등록 날짜

}
