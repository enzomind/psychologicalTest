package com.example.psychologicaltest.checkList.service;

import com.example.psychologicaltest.checkList.dto.GetQueryDTO;
import com.example.psychologicaltest.checkList.dto.PostQueryDTO;
import com.example.psychologicaltest.checkList.entity.QueryListEntity;
import com.example.psychologicaltest.checkList.entity.QuerySaveDataEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckListService {
    List<GetQueryDTO> selectQueryAll();
    Long saveQueryResult(PostQueryDTO postQueryDTO);
    void saveQuery(QueryListEntity queryListEntity);


    default QuerySaveDataEntity dtoToEntity(PostQueryDTO postQueryDTO){
        LocalDateTime now = LocalDateTime.now();
        return QuerySaveDataEntity.builder()
                .selection(postQueryDTO.getSelection())
                .sex(postQueryDTO.getSex())
                .age(postQueryDTO.getAge())
                .build();
    }


    default GetQueryDTO entityToDto(QueryListEntity queryLIstEntity){
        return GetQueryDTO.builder()
                .id(queryLIstEntity.getId())
                .question(queryLIstEntity.getQuestion())
                .selection01(queryLIstEntity.getSelection01())
                .selection02(queryLIstEntity.getSelection02())
                .build();
    }
}
