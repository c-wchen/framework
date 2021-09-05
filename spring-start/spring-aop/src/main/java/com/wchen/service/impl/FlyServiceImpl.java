package com.wchen.service.impl;

import com.wchen.service.FlyService;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class FlyServiceImpl  extends DelegatingIntroductionInterceptor implements FlyService {
    public void fly() {
        System.out.println("==============fly============");
    }
}
