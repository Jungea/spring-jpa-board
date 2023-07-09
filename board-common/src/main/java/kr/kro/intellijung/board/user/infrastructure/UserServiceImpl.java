package kr.kro.intellijung.board.user.infrastructure;

import jakarta.transaction.Transactional;
import kr.kro.intellijung.board.user.application.UserMapper;
import kr.kro.intellijung.board.user.application.UserService;
import kr.kro.intellijung.board.user.application.dto.AccountDto;
import kr.kro.intellijung.board.user.domain.Account;
import kr.kro.intellijung.board.user.domain.AccountRepository;
import kr.kro.intellijung.board.user.domain.User;
import kr.kro.intellijung.board.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Transactional
    @Override
    public void createUser(AccountDto accountDto) {
        Account account = UserMapper.INSTANCE.AccountDtoToAccount(accountDto);
        account.encodingPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }
}
