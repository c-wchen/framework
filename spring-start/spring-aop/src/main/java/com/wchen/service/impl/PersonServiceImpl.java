package com.wchen.service.impl;

import com.wchen.service.PersonService;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl implements PersonService {
    public void run() {
        System.out.println("=============== run =============");
    }
}
