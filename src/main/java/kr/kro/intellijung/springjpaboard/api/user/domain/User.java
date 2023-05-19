package kr.kro.intellijung.springjpaboard.api.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long id;

}
