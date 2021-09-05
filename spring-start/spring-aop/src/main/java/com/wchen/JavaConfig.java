package com.wchen;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan({"com.wchen.service.impl", "com.wchen.aop"})
@Configuration
public class JavaConfig {

}
