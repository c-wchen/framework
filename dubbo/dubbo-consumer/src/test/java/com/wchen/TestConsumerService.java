package com.wchen;

import com.wchen.service.impl.ConsumerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestConsumerService {
    @Autowired
    ConsumerServiceImpl userService;
    @Test
    void contextLoads() {
        userService.consumerInfo();
    }

}
