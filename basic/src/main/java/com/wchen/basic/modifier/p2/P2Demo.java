package com.wchen.basic.modifier.p2;

import com.wchen.basic.modifier.p1.P1Demo;

/**
 * 外部类中的修饰符不能是protected、private权限
 * 只能是public 、（default）
 */
public class P2Demo extends P1Demo{
    private void test() {
        System.out.println("p2demo test");
    }
    public static void main(String[] args) {
        /**
         * 1. 无法直接方法new P1Demo().name;
         * 2. 在不同包中通过子类可以访问 protected 权限
         */
        System.out.println(new P2Demo().name);



    }
}

