package study.spring_1_5th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import study.spring_1_5th.bean.WelcomeBean;

import java.util.Locale;

@RestController
public class BasicController {
    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/welcome-internationalized")
    public String msg(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {      //로케일은 요청헤더 Accept-Language에서 선택된다. 지정하지 않으면 기본 로케일이 사용된다.
        return messageSource.getMessage("welcome.message", null, locale);
    }
}
