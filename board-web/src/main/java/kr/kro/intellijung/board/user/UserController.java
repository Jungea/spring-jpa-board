package kr.kro.intellijung.board.user;

import kr.kro.intellijung.board.user.application.UserService;
import kr.kro.intellijung.board.user.application.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("mypage")
    public String mypage() {
        return "user/mypage";
    }

    /**
     * 회원가입 페이지
     *
     * @return
     */
    @GetMapping("users")
    public String createUser() {
        return "user/login/register";
    }

    /**
     * 회원가입
     *
     * @param accountDto
     * @return
     */
    @PostMapping("users")
    public String createUser(AccountDto accountDto) {
        userService.createUser(accountDto);
        return "redirect:/";
    }

}
