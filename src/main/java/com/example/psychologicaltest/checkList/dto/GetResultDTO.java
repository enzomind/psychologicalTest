package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetResultDTO {
    private Long id;
    private String resultText;
    private List<String> resultList;
}
