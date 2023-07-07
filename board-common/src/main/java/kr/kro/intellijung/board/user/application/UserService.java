package kr.kro.intellijung.board.user.application;

import java.util.List;
import kr.kro.intellijung.board.user.domain.User;

public interface UserService {

    List<User> getUserList();

    User getUserById(Long userId);
}
