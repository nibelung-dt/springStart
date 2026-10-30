package com.example.demo.controllers;

import com.example.demo.UserRepository;
import com.example.demo.models.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    private final UserRepository userRepository;
    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/hello

    @GetMapping("/hello")
    public String hello() {
        log.info("Получен запрос /hello с параметром");


        return"Hello World! Hello!!!!!";
    }

    // http://localhost:8080/greeting
    // {"id":1,"content":"Hello, World!"}

    // http://localhost:8080/greeting?name=User
    // {"id":1,"content":"Hello, User!"}


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        System.out.print("counter = " + counter + "/n");

        return new Greeting(counter.incrementAndGet(), template.formatted(name));
    }
}
