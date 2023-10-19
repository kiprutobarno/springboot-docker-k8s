package com.tuts.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "Welcome to Kubernetes";
    }

}
