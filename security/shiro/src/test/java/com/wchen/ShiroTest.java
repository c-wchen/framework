package com.wchen;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



@Slf4j
public class ShiroTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Test
    @SuppressWarnings("all")
    public void testShiroAuth() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager

        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);


        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1213");

        try {
            //4、登录，即身份验证
            subject.login(token);
            log.info("登录成功");
        } catch (AuthenticationException e) {
            log.info("登录失败");
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    @BeforeEach
    public void addUser() {
        simpleAccountRealm.addAccount("chen", "123");
    }

    @Test
    public void testShiroRealm() {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("chen", "123", true);
        subject.login(token);
        if (subject.isAuthenticated()) {
            log.info("=====登录成功");
        } else {
            log.info("=====登录失败");
        }

        subject.logout();
        if (subject.isAuthenticated()) {
            log.info("=====登录成功");
        } else {
            log.info("=====登录失败");
        }




    }



}
