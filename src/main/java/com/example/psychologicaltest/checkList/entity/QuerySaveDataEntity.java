package com.example.psychologicaltest.checkList.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuerySaveDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int selectedQueryId;
    private int selectedNum;
    private String resultText;
    private String result;
    private Boolean sex; // true women, false man.
    private int age;

}
