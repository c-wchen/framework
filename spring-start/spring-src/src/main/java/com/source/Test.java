package com.source;

import com.source.framework.ApplicationContext;
import com.source.service.UserService;


public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        UserService userService = (UserService) context.getBean("userService");

    }
}
