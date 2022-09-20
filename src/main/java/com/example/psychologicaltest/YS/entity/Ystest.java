package com.example.psychologicaltest.YS.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ystest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    @Column(length = 20, nullable = false)
    private String tresult;

    @Column(length = 5, nullable = false)
    private int tcode;
}
