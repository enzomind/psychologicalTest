package com.example.psychologicaltest.checkList.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;
    @NotNull
    private String question;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionEntity", cascade = CascadeType.ALL)
    private List<AnswerEntity> answerEntityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionEntity", cascade = CascadeType.ALL)
    private List<AnswerDataEntity> answerDataEntityList = new ArrayList<>();

}
