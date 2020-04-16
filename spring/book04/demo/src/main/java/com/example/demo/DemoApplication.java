package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class GreetingController {

    @GetMapping("/")
    Greet greet() {
        return new Greet("Hello World");
    }
}

class Greet {
    private String message;

    public Greet(String message) {
        this.message = message;
    }

}