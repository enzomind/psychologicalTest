package com.example.psychologicaltest.HY.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="users")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mno;
    @Column(length = 200, nullable = false)
    private String mname;
    @Column(length = 200, nullable = false)
    private String mgender;
    @Column(length = 200, nullable = false)
    private Long mage;



}
