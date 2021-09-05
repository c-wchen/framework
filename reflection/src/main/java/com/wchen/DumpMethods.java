package com.wchen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DumpMethods {

    public static void main(String[] args) {
        /**
         * 反射类获取 Class
         * 构造器  Constructor
         * 成员变量 Field
         * 成员方法 Method
         */
        final String className = "java.lang.String";
        try {
//            Class c = Class.forName(className);
//            Class c = int.class;
//            Class c = Integer.TYPE;
            Class c = Class.forName("java.lang.Integer");
            Constructor[] constructor = c.getDeclaredConstructors();
            for (int i = 0; i < constructor.length; i++) {
                System.out.println(constructor[i]);
            }
            Method[] m = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
