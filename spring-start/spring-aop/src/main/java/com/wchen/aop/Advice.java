package com.wchen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

public class Advice {
    public void before() {
        System.out.println("=before=");
    }
    public void after() {
        System.out.println("=after=");
    }
    public void afterThrowing() {
        System.out.println("=after throwing=");
    }
    public void afterReturning() {
        System.out.println("=after returning=");
    }
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=around start=");
        // 目标对象的执行
        joinPoint.proceed();
        System.out.println("=around end=");
    }
}
