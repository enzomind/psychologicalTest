package YJ.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="mbti")
@ToString(exclude = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mbti {
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
