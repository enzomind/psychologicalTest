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
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    @EventListener(ApplicationReadyEvent.class)
    public void initData(){
        String[] queryList = {
                "초능력을 한개만 가질수 있다면 어떤 것을 가지고 싶은가?",
                "밤에 자다 깼는데 집에 화재가? 무엇을 가지고 도망가겠습니가?",
                " 이성 중에 각각 과일과 딱 어울리는 사람은 누구?"
        };
        String[][] answerList = {
                {"투시능력", "예지능력", "순간이동", "염력", "공중부양"},
                {"양복", "음식", "지갑", "사진", "귀금속과 보석"},
                {"사과", "메론", "석류", "딸기", "귤"}
        };
        for(int i=0;i<3;i++){
            QueryListEntity queryListEntity = QueryListEntity.builder()
                    .question(queryList[i])
                    .a1(answerList[i][0])
                    .a2(answerList[i][1])
                    .a3(answerList[i][2])
                    .a4(answerList[i][3])
                    .a5(answerList[i][4])
                    .build();
            checkListRepository.save(queryListEntity);
            System.out.println(queryListEntity);
        }
        String[] resultTextList = {
                "대답으로 당신의 콤플렉스를 알 수 있습니다.",
                "당신이 가장 소중히 하는 것을 알 수 있습니다.",
                ""
        };
        String[][] resultList = {
                {"대인관계", "경제력", "체력", "인내력", "성적능력"},
                {"자기만족", "생존", "돈벌이", "애정과 우정", "지위"},
                {"첫경험의 상대", "동경하는 사람", "놀수 있는 사람", "첫사랑의 이미지", "결혼 상대"}
        };
        for(int i=0;i<3;i++){
            ResultEntity resultEntity = ResultEntity.builder()
                    .resultText(resultTextList[i])
                    .r1(resultList[i][0])
                    .r2(resultList[i][1])
                    .r3(resultList[i][2])
                    .r4(resultList[i][3])
                    .r5(resultList[i][4])
                    .build();
            resultRepository.save(resultEntity);
            System.out.println(resultEntity);
        }
    }
}
