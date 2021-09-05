package com.wchen;


import com.wchen.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringRunner.class)
public class LogTest {
    @Autowired
    OrderServiceImpl orderService;
    @Test
    public void  testLog() {
        orderService.updateOrder();
        orderService.queryAll();
    }
}
