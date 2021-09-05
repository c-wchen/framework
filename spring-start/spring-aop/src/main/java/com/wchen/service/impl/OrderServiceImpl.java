package com.wchen.service.impl;

import com.wchen.aop.AopAnnotation;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl {
    @AopAnnotation
    public void updateOrder() {
        System.out.println("update order");
    }
    public void queryAll() {
        System.out.println("find all order");
    }
}
