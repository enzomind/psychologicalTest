package com.example.psychologicaltest.YS.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ysmember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    @Column(length = 50, nullable = false)
    private String mname;

    @Column(length = 10, nullable = false) // 남 or 여
    private int mage;

    @Column(length = 10, nullable = false)
    private String mgender;


}
