package kr.kro.intellijung.springjpaboard.api.user.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "MY_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String name;

}
