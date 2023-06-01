package kr.kro.intellijung.springjpaboard.api.user.presentation;

import kr.kro.intellijung.springjpaboard.api.user.application.UserService;
import kr.kro.intellijung.springjpaboard.api.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> users() {
        return userService.getUserList();
    }

    @PostMapping("/{userId}")
    public User user(@PathVariable(name = "userId") Long userId) {
        return userService.getUserById(userId);
    }

}
