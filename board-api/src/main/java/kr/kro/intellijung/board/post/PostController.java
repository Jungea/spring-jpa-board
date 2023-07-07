package kr.kro.intellijung.board.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping("/")
    public String index() {
        return "HELLO POST!";
    }

}
