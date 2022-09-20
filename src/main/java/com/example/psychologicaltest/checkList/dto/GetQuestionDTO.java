package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetQuestionDTO {
    private Long qId;
    private String question;
    private List<AnswerDTO> answerDTOS;

    // { QPK:1, 질문내용: 나는천재인가?, 답변:[{123:1, AID, 답변번호}]}
}
