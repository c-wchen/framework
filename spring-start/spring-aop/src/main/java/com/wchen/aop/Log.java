package com.wchen.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class Log {
    @Pointcut("@annotation(com.wchen.aop.AopAnnotation) && !execution(* com.wchen.service.impl.OrderServiceImpl.queryAll())")
    public void comm() {}

    @After("comm()")
    public void afterLog() {
        log.info("===after log===");
    }

}
