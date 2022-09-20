package com.example.psychologicaltest.YJ.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="yjmbti_test")
@ToString(exclude = "yjuser")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MbtiTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @OneToOne
    private User user;

    @Column
    private String test1;
    @Column
    private String test2;
    @Column
    private String test3;
    @Column
    private String test4;
    @Column
    private String test5;
    @Column
    private String test6;
    @Column
    private String test7;
    @Column
    private String test8;
}
