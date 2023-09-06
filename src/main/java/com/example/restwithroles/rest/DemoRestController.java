package com.example.restwithroles.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
