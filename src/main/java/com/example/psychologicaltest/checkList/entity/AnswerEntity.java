package com.example.psychologicaltest.checkList.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aId;
    @NotNull
    private String answer;
    @NotNull
    private int answerNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name ="QUESTION_ENTITY_Q_ID")
    private QuestionEntity questionEntity;

}
