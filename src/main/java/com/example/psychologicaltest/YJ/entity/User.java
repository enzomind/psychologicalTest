package com.example.psychologicaltest.YJ.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="yjuser")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column
    private String name;
    @Column
    private String birth;
    @Column
    private String gender;

}

