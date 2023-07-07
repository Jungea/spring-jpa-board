package kr.kro.intellijung.board.user.infrastructure;

import jakarta.transaction.Transactional;
import java.util.List;
import kr.kro.intellijung.board.user.application.UserService;
import kr.kro.intellijung.board.user.domain.User;
import kr.kro.intellijung.board.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
}
