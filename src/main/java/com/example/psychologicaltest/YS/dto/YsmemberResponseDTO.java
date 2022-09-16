package com.example.psychologicaltest.YS.dto;

import com.example.psychologicaltest.YS.entity.Ysmember;
import lombok.Getter;

@Getter
public class YsmemberResponseDTO { //메인에서 뿌려줄...수도있지않을까해서 걍 세팅

    private Long mid;
    private String mname;
    private String mgender;
    private int mage;

    public YsmemberResponseDTO(Ysmember entity) {
        this.mid = entity.getMid();
        this.mname = entity.getMname();
        this.mgender = entity.getMgender();
        this.mage = entity.getMage();
    }
}
