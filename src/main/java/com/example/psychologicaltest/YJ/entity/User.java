package com.example.psychologicaltest.YJ.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="user")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String name;

    @Column
    private String birth;
    @Column
    private String gender;

}

