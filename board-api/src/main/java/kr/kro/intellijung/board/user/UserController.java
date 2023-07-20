package kr.kro.intellijung.board.user;

import java.util.List;
import kr.kro.intellijung.board.user.application.UserNotFoundException;
import kr.kro.intellijung.board.user.domain.User;
import kr.kro.intellijung.board.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }


    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
            .map(user -> {
                user.setName(newUser.getName());
                user.setRole(newUser.getRole());
                return userRepository.save(user);
            })
            .orElseGet(() -> {
                newUser.setId(id);
                return userRepository.save(newUser);
            });
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
