package com.example.psychologicaltest.checkList.entity;

import com.sun.istack.NotNull;
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
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;
    @NotNull
    private String name;
    @NotNull
    private String sex;
    @NotNull
    private int age;
//    @ManyToOne
//    @JoinColumn(name="QUESTIONENTIY_QID")
//    private QuestionEntity questionEntity;
}
