package com.wchen.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
    @GetMapping("/test")
    public String test() {
        return "被保护的资源";
    }
}
