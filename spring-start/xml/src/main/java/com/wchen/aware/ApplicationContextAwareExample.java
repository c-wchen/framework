package com.wchen.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextAwareExample implements ApplicationContextAware {
    ApplicationContext context;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
    public ApplicationContext getApplicationContext() {
        return context;
    }
}
