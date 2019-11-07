package study.spring_1_5th.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Hello";
    }
}
