package com.wchen.service.impl;



public class Target {
    public void method1() {
//        System.out.println(1);  使用Aop
        System.out.println(2);
        System.out.println(3);
    }
    public void method2() {
//        System.out.println(1); 使用Aop
        System.out.println(4);
        System.out.println(5);
    }
}
