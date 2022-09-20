package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetQueryDTO {
    private Long id;
    private String question;
    private List<String> answer;
}
