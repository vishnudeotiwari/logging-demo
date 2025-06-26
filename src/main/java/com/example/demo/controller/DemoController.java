package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @PostMapping("/echo")
    public String echo(@RequestBody String body) {
        return "Received: " + body;
    }
}