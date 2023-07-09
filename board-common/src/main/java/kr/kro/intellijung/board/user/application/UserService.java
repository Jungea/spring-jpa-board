package kr.kro.intellijung.board.user.application;

import kr.kro.intellijung.board.user.application.dto.AccountDto;
import kr.kro.intellijung.board.user.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(Long userId);

    /**
     * 회원가입
     *
     * @param accountDto
     */
    void createUser(AccountDto accountDto);
}
