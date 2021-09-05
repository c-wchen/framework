package com.wchen;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AnnotationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
