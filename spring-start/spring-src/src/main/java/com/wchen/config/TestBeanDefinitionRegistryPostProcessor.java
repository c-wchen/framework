package com.wchen.config;

import com.sun.org.glassfish.gmbal.util.GenericConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        System.out.println("========================");
//        System.out.println(registry);
//        BeanDefinition studentBeanDefinition = registry.getBeanDefinition("student");
//        System.out.println(studentBeanDefinition);
//        studentBeanDefinition.setAttribute("name", "This is a error");
//        BeanDefinition teacherBeanDefinition = new GenericBeanDefinition();
//        teacherBeanDefinition.setBeanClassName("com.wchen.pojo.Teacher");
//        teacherBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("1212");
//        teacherBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("1212");
//        registry.registerBeanDefinition("teacher", teacherBeanDefinition);
//        registry.removeBeanDefinition("student");


//        teacherBeanDefinition.setAttribute("");

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
