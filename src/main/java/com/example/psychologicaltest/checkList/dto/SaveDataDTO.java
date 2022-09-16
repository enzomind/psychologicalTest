package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveDataDTO {
    private Long qId; // 질문 ID
    private int answerNumber; // 질문 선택한 번호 값
    private Long mId; // 유저 ID
    // [{ QPK:1, 답변번호:1, mID:user}]
}
