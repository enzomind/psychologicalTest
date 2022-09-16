package com.example.psychologicaltest.YS.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YsmemberRequestDTO { //사용자 정보 입력받을 폼 정보 실어나줄 DTO

    private String mname;
    private String mgender;
    private int mage;

    public com.example.psychologicaltest.YS.entity.Ysmember toEntity() {
        return com.example.psychologicaltest.YS.entity.Ysmember.builder()
                .mname(mname)
                .mgender(mgender)
                .mage(mage)
                .build();
    }

}
