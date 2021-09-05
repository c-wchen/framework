package com.wchen;


import com.wchen.dao.UserMapper;
import com.wchen.pojo.User;
import com.wchen.proxy.jdk.OrderImplProxy;
import com.wchen.proxy.mybatis.SqlSession;
import com.wchen.service.OrderService;
import com.wchen.proxy.jdk.OrderProxy;
import com.wchen.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.util.List;

public class ProxyTest {
    /**
     * 实现对订单类接口的动态代理
     */
    @Test
    public void testOrderService() {
        OrderService proxyOrderService = OrderProxy.createProxyInstance(OrderService.class);
        proxyOrderService.hello();
        proxyOrderService.greeting();
    }

    /**
     * 动态增强
     */
    @Test
    public void testOrderServiceImpl() {
        OrderService proxyOrderService = OrderImplProxy.createProxyInstance(new OrderServiceImpl());
        proxyOrderService.hello();
    }

    /**
     * 简单分析实现mybatis源码
     */
    @Test
    public void testMybatisProxy() {
        UserMapper mapper = SqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }
    /**
     * 使用cglib进行动态代理
     */
    @Test
    public void testCglib() {
        OrderService orderService = new OrderServiceImpl();
        OrderService instance = com.wchen.proxy.cglib.OrderImplProxy.createInstance(orderService);
        instance.hello();
        instance.greeting();
    }
}
