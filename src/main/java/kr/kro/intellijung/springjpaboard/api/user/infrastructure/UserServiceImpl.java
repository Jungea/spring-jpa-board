package kr.kro.intellijung.springjpaboard.api.user.infrastructure;

import jakarta.transaction.Transactional;
import kr.kro.intellijung.springjpaboard.api.user.UserRepository;
import kr.kro.intellijung.springjpaboard.api.user.application.UserService;
import kr.kro.intellijung.springjpaboard.api.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
