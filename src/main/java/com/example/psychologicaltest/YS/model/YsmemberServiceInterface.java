package com.example.psychologicaltest.YS.model;

import com.example.psychologicaltest.YS.dto.YsmemberDTO;
import com.example.psychologicaltest.YS.dto.YsmemberPageRequestDTO;
import com.example.psychologicaltest.YS.dto.YsmemberPageResultDTO;
import com.example.psychologicaltest.YS.entity.Ysmember;



public interface YsmemberServiceInterface {

    YsmemberPageResultDTO<YsmemberDTO, Ysmember> getList(YsmemberPageRequestDTO ysmemberPageRequestDTO);


    default Ysmember dtoToEntity(YsmemberDTO dto) {
        Ysmember ysmember = Ysmember.builder()
                .mid(dto.getMid())
                .mname(dto.getMname())
                .mage(dto.getMage())
                .mgender(dto.getMgender())
                .build();

        return ysmember;
    }

    default YsmemberDTO entityToDto(Ysmember ysmember){
        YsmemberDTO dto = YsmemberDTO.builder()
                .mid(ysmember.getMid())
                .mname(ysmember.getMname())
//                .mage(ysmember.getMage())
                .mgender(ysmember.getMgender())
                .mresult(ysmember.getMresult())
                .build();

        return dto;
    }



}
