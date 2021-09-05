package com.wchen.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wchen.pojo.Employee;
import com.wchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    public Object test() {
        return userService.list();
    }

    @JsonView(Employee.T1View.class)
    @GetMapping("/t1")
    public Object t1View() {
        return new Employee(
                "chen",
                "1212",
                "222@qq.com",
                10,
                10,
                "zunyi"
        );
    }

    @JsonView(Employee.T2View.class)
    @GetMapping("/t2")
    public Object t2View() {
        return new Employee(
                "chen",
                "1212",
                "222@qq.com",
                10,
                10,
                "zunyi"
        );
    }
}
