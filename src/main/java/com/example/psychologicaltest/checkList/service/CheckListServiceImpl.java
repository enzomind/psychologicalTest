package com.example.psychologicaltest.checkList.service;

import com.example.psychologicaltest.checkList.dto.GetQueryDTO;
import com.example.psychologicaltest.checkList.dto.GetResultDTO;
import com.example.psychologicaltest.checkList.dto.PostQueryDTO;
import com.example.psychologicaltest.checkList.entity.QueryListEntity;
import com.example.psychologicaltest.checkList.entity.QuerySaveDataEntity;
import com.example.psychologicaltest.checkList.entity.ResultEntity;
import com.example.psychologicaltest.checkList.repository.CheckListRepository;
import com.example.psychologicaltest.checkList.repository.ResultRepository;
import com.example.psychologicaltest.checkList.repository.SaveQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckListServiceImpl implements CheckListService{
    private final CheckListRepository checkListRepository;
    private final SaveQueryRepository saveQueryRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public CheckListServiceImpl(CheckListRepository checkListRepository, SaveQueryRepository saveQueryRepository, ResultRepository resultRepository) {
        this.checkListRepository = checkListRepository;
        this.saveQueryRepository = saveQueryRepository;
        this.resultRepository = resultRepository;
    }


    @Override
    public List<GetQueryDTO> selectQueryAll() {
        List<QueryListEntity> queryListEntityList = checkListRepository.findAll();
        return queryListEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    @Override
    public List<GetResultDTO> selectQueryAll2() {
        List<ResultEntity> resultEntityList = resultRepository.findAll();
        return resultEntityList.stream().map(this::entityToDto2).collect(Collectors.toList());
    }

    @Override
    public Long saveQueryResult(PostQueryDTO postQueryDTO) {
        QuerySaveDataEntity querySaveDataEntity = dtoToEntity(postQueryDTO);
        saveQueryRepository.save(querySaveDataEntity);
        return querySaveDataEntity.getId();
    }

    @Override
    public void saveQuery(QueryListEntity queryListEntity) {
        checkListRepository.save(queryListEntity);
    }
}
