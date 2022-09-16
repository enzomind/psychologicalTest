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

    private String mname;

    private String mgender;

    private Long mage;


}
