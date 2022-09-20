package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private Long aId;
    private int answerNumber;
    private Long qId;
}
