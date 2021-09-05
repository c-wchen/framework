package com.wchen.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author  wchen
 * @since 2020/11/29
 * 对实现类的增强
 */
public class OrderImplProxy {
    private static class OrderMapperProxy implements InvocationHandler {
        private Object obj;
        public OrderMapperProxy(Object obj) {
            super();
            this.obj = obj;
        }

        /**
         *
         * @param proxy   被代理的对象
         * @param method  目标对象的方法对象
         * @param args    该方法的参数列表
         * @return
         * @throws Throwable
         */
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method.getName() + " is implements by proxy");
            Object invoke = method.invoke(this.obj, args);
            System.out.println(method.getName() + " returning");
            return obj;
        }
    }
    @SuppressWarnings("all")
    public static<T> T createProxyInstance(T obj) {
        /**
         *
         * 参数列表
         * 1. 类加载器 ClassLoader loader
         * 获取方式
         *      * Thread.currentThread().getContextClassLoader();
         *      * mapper.getClassLoader();
         * 2. 待实现的接口集合 Class<?>[] interfaces
         *      * mapper.getClass().getInterfaces()
         * 3. 实现InvocationHandler的对象
         */

        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new OrderMapperProxy(obj)
        );
    }
}