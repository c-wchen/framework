package com.wchen.test.myinterface;

public interface MyInterfaceDefault {
    // 参数统一类型定义
    public static final int count = 0;
    // 方法统一类型
    public abstract int add();
    // 默认方法
    public default void test() {
        System.out.println("test");
    }
    // 静态方法
    public static void print() {
        System.out.println("这个是静态方法");
    }
}
