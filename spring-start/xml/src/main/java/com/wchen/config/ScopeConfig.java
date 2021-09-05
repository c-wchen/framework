package com.wchen.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.annotation.Annotation;

@Component
public class ScopeConfig implements Scope, BeanFactoryPostProcessor {
    @PostConstruct
    public void init() {
        System.out.println("init");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }


    public Object get(String s, ObjectFactory<?> objectFactory) {
        System.out.println("===test==");
        return objectFactory.getObject();
    }

    public Object remove(String s) {
        return null;
    }

    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    public Object resolveContextualObject(String s) {
        return null;
    }

    public String getConversationId() {
        return null;
    }


    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope("custom-scope",this);
    }
}
