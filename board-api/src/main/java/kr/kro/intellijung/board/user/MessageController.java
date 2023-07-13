package kr.kro.intellijung.board.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/api/messages")
    public String messages() {
        return "messages ok";
    }
}
