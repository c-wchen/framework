package com.wchen.basic.innerclass;

/**
 * 成员内部类
 */
public class Outer {
    private String name = "wchen";
    private int count = 20;
    public class Inner {
        private int count = 100;
        public void innerMethod() {
            System.out.println("inner method " + name);
            // 命名冲突, 访问外部同名成员变量
            System.out.println("inner count " + count + " outer count " + Outer.this.count);
        }
    }

    public void outerMethod() {
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        // 第一种调用方式， 直接创建
        Inner inner = new Outer().new Inner();
        inner.innerMethod();
        // 第二种调用方式，间接创建，使用外部类方法进行实例化
        new Outer().outerMethod();

    }
}
