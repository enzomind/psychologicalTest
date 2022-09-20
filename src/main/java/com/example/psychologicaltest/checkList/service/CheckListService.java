package com.example.psychologicaltest.checkList.service;

import com.example.psychologicaltest.checkList.dto.GetQueryDTO;
import com.example.psychologicaltest.checkList.dto.GetResultDTO;
import com.example.psychologicaltest.checkList.dto.PostQueryDTO;
import com.example.psychologicaltest.checkList.entity.QueryListEntity;
import com.example.psychologicaltest.checkList.entity.QuerySaveDataEntity;
import com.example.psychologicaltest.checkList.entity.ResultEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface CheckListService {
    List<GetQueryDTO> selectQueryAll();
    Long saveQueryResult(PostQueryDTO postQueryDTO);
    void saveQuery(QueryListEntity queryListEntity);
    List<GetResultDTO> selectQueryAll2();

    default QuerySaveDataEntity dtoToEntity(PostQueryDTO postQueryDTO){
        LocalDateTime now = LocalDateTime.now();
        return QuerySaveDataEntity.builder()
                .selectedQueryId(postQueryDTO.getSelectedQuery())
                .selectedNum(postQueryDTO.getSelectedNum())
                .resultText(postQueryDTO.getResultText())
                .result(postQueryDTO.getResult())
                .sex(postQueryDTO.getSex())
                .age(postQueryDTO.getAge())
                .build();
    }


    default GetQueryDTO entityToDto(QueryListEntity queryListEntity){

        List<String> answerList = new ArrayList<>();
        answerList.add(queryListEntity.getA1());
        answerList.add(queryListEntity.getA2());
        answerList.add(queryListEntity.getA3());
        answerList.add(queryListEntity.getA4());
        answerList.add(queryListEntity.getA5());

        return GetQueryDTO.builder()
                .id(queryListEntity.getId())
                .question(queryListEntity.getQuestion())
                .answer(answerList)
                .build();
    }
    default GetResultDTO entityToDto2(ResultEntity resultEntity){
        List<String> resultList =new ArrayList<>();
        resultList.add(resultEntity.getR1());
        resultList.add(resultEntity.getR2());
        resultList.add(resultEntity.getR3());
        resultList.add(resultEntity.getR4());
        resultList.add(resultEntity.getR5());

        return GetResultDTO.builder()
                .id(resultEntity.getId())
                .resultText(resultEntity.getResultText())
                .resultList(resultList)
                .build();
    }

//    default AnswerDataEntity toEntity(AnswerDTO answerDTO){
//        return AnswerDataEntity.builder()
//                .answerNumber(answerDTO.getAnswerNumber())
//                .
//    }
}
