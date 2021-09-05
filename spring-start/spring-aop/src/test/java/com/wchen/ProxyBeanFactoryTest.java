package com.wchen;


import com.wchen.service.FlyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ProxyBeanFactoryTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void testPerson() {

        ((FlyService)context.getBean("personProxy")).fly();

    }
}
