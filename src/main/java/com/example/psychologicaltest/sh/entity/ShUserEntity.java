package com.example.psychologicaltest.sh.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="sh_entity")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 DB에 위임해서 id값이 null이어도 자동으로 1씩 증가
    @Column(name="mid")
    private Long mid;

    @Column(length = 10, nullable = false)
    private String mname;

    @Column(length = 10, nullable = false)
    private String mgender;

    @Column(length = 10, nullable = false)
    private int mage;
}
