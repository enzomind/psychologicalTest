package HY.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mno;
    @Column(length = 200, nullable = false)
    private String mname;
    @Column(length = 200, nullable = false)
    private String mgender;
    @Column(length = 200, nullable = false)
    private Long mage;



}
