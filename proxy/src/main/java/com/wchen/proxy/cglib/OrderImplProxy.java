package com.wchen.proxy.cglib;

import com.wchen.service.OrderService;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class OrderImplProxy {
    /**
     * 1. 生成字节码对象
     * 2. 设置父类对象
     * 3. 被增强的方法、回调方法
     */
    @SuppressWarnings("all")
    public static<T>  T  createInstance(T obj) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        Callback callback = new CallbackMethod();
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }

    private static class CallbackMethod implements MethodInterceptor {
        /**
         *
         * @param o            代理对象
         * @param method       目标对象中的方法
         * @param objects      目标对象的参数
         * @param methodProxy  代理对象中代理方法对象
         * @return
         * @throws Throwable
         */
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            // 不能用invoke
            System.out.println(method.getName() + " implements by proxy");
            methodProxy.invokeSuper(proxy, args);
            System.out.println("returning");
            return null;
        }
    }
}
