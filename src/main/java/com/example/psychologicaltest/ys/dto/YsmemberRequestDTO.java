package com.example.psychologicaltest.ys.dto;

import com.example.psychologicaltest.ys.entity.Ysmember;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YsmemberRequestDTO { //사용자 정보 입력받을 폼 정보 실어나줄 DTO

    private String mname;
    private String mgender;
    private int mage;

    public Ysmember toEntity() {
        return Ysmember.builder()
                .mname(mname)
                .mgender(mgender)
                .mage(mage)
                .build();
    }

}
