package com.example.psychologicaltest.sh.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="shtestresult")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShTestResultEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int resId;

    @ManyToOne
    @JoinColumn(name="mid")
    ShUserEntity mid;

    @Column
    int resIndex;

    @Column
    String resAnimal;




}
