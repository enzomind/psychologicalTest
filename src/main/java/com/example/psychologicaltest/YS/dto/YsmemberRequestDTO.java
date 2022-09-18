package com.example.psychologicaltest.YS.dto;

import lombok.*;

@Data
@Builder
public class YsmemberRequestDTO { //사용자 정보 입력받을 폼 정보 실어나줄 DTO

    private String mname;
    private String mgender;
    private int mage;

}
