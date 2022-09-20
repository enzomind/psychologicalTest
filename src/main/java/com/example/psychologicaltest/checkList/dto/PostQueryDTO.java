package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostQueryDTO {
    private int selectedQuery;
    private int selectedNum;
    private String resultText;
    private String result;
    private Boolean sex; // true women, false man.
    private int age;
}
