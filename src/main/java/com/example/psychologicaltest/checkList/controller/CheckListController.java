package com.example.psychologicaltest.checkList.controller;

import com.example.psychologicaltest.checkList.dto.GetQueryDTO;
import com.example.psychologicaltest.checkList.dto.GetResultDTO;
import com.example.psychologicaltest.checkList.dto.PostQueryDTO;
import com.example.psychologicaltest.checkList.entity.QueryListEntity;
import com.example.psychologicaltest.checkList.service.CheckListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checklist")
@Log4j2
public class CheckListController {

    private CheckListService checkListService;

    @GetMapping(value = {"/main", "/","/home", "index"} )
    public ModelAndView toMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/checkListMain");
        return modelAndView;
    }

    @Autowired
    public CheckListController(CheckListService checkListService) {
        this.checkListService = checkListService;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE) // JSON 타입으로 응답(기본)
    public ResponseEntity<List<GetQueryDTO>> selectQueryAll(){
        log.info("-----------selectRecordAll-------------------------------");
        return new ResponseEntity<>(checkListService.selectQueryAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/findAll2", produces = MediaType.APPLICATION_JSON_VALUE) // JSON 타입으로 응답(기본)
    public ResponseEntity<List<GetResultDTO>> selectQueryAll2(){
        log.info("-----------selectRecordAll-------------------------------");
        return new ResponseEntity<>(checkListService.selectQueryAll2(), HttpStatus.OK);
    }


    // record 입력
    @PostMapping(value = {"/saveData"}, consumes = MediaType.APPLICATION_JSON_VALUE) // JSON 타입의 요청만 받음
    public ResponseEntity<Long> saveQueryResult(@RequestBody PostQueryDTO postQueryDTO){
        log.info(postQueryDTO);
        Long dno = checkListService.saveQueryResult(postQueryDTO);
        return new ResponseEntity<>(dno, HttpStatus.OK);
    }
    @PostMapping(value = {"/saveQuery"}, consumes = MediaType.APPLICATION_JSON_VALUE) // JSON 타입의 요청만 받음
    public ResponseEntity<String> saveQuery(@RequestBody QueryListEntity queryListEntity){
        checkListService.saveQuery(queryListEntity);
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }
}
