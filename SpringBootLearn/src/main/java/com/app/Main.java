package com.app;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main{


    @RequestMapping("/main")
    String home() {
        return "Hello World!";
    }

}