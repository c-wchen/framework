package com.wchen.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @GetMapping("/test/p1")
    @ResponseBody
    public String protectResource() {
        return "具有权限P1用户访问";
    }

    @GetMapping("/test/p2")
    @ResponseBody
    public String protectResource2() {
        return "具有权限P2用户访问";
    }
    @GetMapping("/test/p3")
    @ResponseBody
    public String protectResource3() {
        return "具有权限P3用户访问";
    }

    @GetMapping("/test/p4")
    @ResponseBody
    public String protectResource4() {
        return "具有权限P4用户访问";
    }

}
