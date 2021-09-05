package com.wchen;


import com.wchen.service.impl.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class AopTest {
    @Autowired
    Target target;
    @Test
    public void testAop() {
        target.method1();
        target.method2();
    }
}
