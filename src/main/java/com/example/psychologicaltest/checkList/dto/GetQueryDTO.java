package com.example.psychologicaltest.checkList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetQueryDTO {
    private Long id;
    private String question;
    private String selection01;
    private String selection02;
}
