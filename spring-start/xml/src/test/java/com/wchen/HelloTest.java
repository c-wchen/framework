package com.wchen;

import com.wchen.pojo.MethodInject;
import com.wchen.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class HelloTest {
    @Autowired
    MethodInject methodInject;
    @Autowired
    ApplicationContext context;

    @Autowired
    Student student;

    @Test
    public void testHello() {
        System.out.println(methodInject.getHello());
    }

    @Test
    public void testProperties() {
        System.out.println(student);

    }



}
