package study.spring_1_5th.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.spring_1_5th.bean.WelcomeBean;

@RestController
public class BasicController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Hello";
    }

    @GetMapping("/welcome-with-object")
    public WelcomeBean welcomeWithObject() {
        return new WelcomeBean("Hello");
    }

    private static final String helloWorldTemplate = "Hello World, %s";

    @GetMapping("/welcome-with-parameter/name/{name}")      //경로변수
    public WelcomeBean welcomeWithParameter(@PathVariable String name) {
        return new WelcomeBean(String.format(helloWorldTemplate, name));
    }
}
