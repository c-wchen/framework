package com.wchen.basic.innerclass;

/**
 * 局部内部类
 */
public class LocalOuter {
    public void outerMethod() {
        // 常量
        int count = 10;
        class LocalInner {
            public void localInnerMethod() {
                System.out.println("local inner count " + count);
            }
        }
        new LocalInner().localInnerMethod();
    }
    public static void main(String[] args) {
        new LocalOuter().outerMethod();
    }
}
