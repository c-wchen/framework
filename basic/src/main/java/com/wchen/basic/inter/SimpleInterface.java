package com.wchen.basic.inter;

public interface SimpleInterface {
    // 静态常量成员
    public static final int count = 100;

    // 接口方法
    public abstract int add(int x, int y);

    // 静态方法
    public  static void staticMethod() {
        System.out.println("这个是静态方法, 需要实现");
    }

    //默认方法，适用场景接口升级，实现类不必重写
    public default void  defaultMethod() {
        System.out.println("默认方法");
    }
}
