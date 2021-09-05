package com.wchen;

import com.wchen.dao.UserMapper;
import com.wchen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ImportResource("classpath*:spring/spring-mybatis.xml")
public class SpringMybatisTest {


    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
//        System.out.println(new SpringMybatisTest().userMapper.selectAll());
//        System.out.println(context.getBean(UserMapper.class).selectAll());
//        System.out.println(new SpringMybatisTest().userMapper.selectAll());
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMybatisTest.class);
        System.out.println(context.getBean(UserMapper.class).selectAll());

        System.out.println(context.getBeanDefinitionCount());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println(context.getApplicationName());

    }
}
