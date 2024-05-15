package com.example.esun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("Hello World");
        return "Hello";
    }
}
