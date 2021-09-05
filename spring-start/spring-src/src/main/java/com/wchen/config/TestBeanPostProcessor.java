package com.wchen.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


//        System.out.printf("%s %s\n", beanName, bean);
        return bean;
    }
}
