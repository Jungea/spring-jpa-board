package kr.kro.intellijung.springjpaboard.api.user.application;

import kr.kro.intellijung.springjpaboard.api.user.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();
}
