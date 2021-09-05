package com.wchen.basic.modifier;


public class Son  extends Parent{

    protected void test() {
        System.out.println("son test method");
    }

    public static void main(String[] args) {
        // 父子同类只能重写
        new Son().test();
        Parent p = new Son();
        p.test();

    }
}


class Parent {
    protected void test() {
        System.out.println("parent test method");
    }
}