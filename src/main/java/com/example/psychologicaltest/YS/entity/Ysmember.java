package com.example.psychologicaltest.YS.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Ysmember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 DB에 위임해서 id값이 null이어도 자동으로 1씩 증가
    private Long mid;

//    @Column(length = 50, nullable = false)
//    private String mname;
//
//    @Column(length = 10, nullable = false)
//    private String mgender;
//
//    @Column(length = 10, nullable = false) // 남 or 여
//    private int mage;

    private String mname;
    private String mgender;
    private int mage;


    @Builder
    public Ysmember(String mname, String mgender, int mage){
        this.mname = mname;
        this.mgender = mgender;
        this.mage = mage;
    }
}
