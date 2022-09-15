package HY.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="developer")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id ;
    @Column(length = 200, nullable = false)
    private String a1;
    @Column(length = 200, nullable = false)
    private String a2;
    @Column(length = 200, nullable = false)
    private String a3;
    @Column(length = 200, nullable = false)
    private String a4;
    @Column(length = 200, nullable = false)
    private String a5;
    @Column(length = 200, nullable = false)
    private String a6;
    @Column(length = 200, nullable = false)
    private String a7;
    @Column(length = 200, nullable = false)
    private String a8;
    @Column(length = 200, nullable = false)
    private String a9;
    @Column(length = 200, nullable = false)
    private String a10;
    @Column(length = 200, nullable = false)
    private String a11;
    @Column(length = 200, nullable = false)
    private String a12;
    @Column(length = 200, nullable = false)
    private String result;

}

