package kr.kro.intellijung.board.user.application.dto;

import lombok.Data;

@Data
public class AccountDto {

    private String username;
    private String password;
    private String email;
    private String age;
    private String role;

}
