package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostQueryDTO {
    private String selection; // 질문에 선택한 탑변 예> 1211511221
    private Boolean sex; // true women, false man.
    private int age;
}
