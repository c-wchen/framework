package com.wchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendMail {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Async
    public void send(String userName) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("这是一个主题");
        mailMessage.setText("这是一个测试消息");
        mailMessage.setTo(userName);
        mailMessage.setFrom("2549422435@qq.com");
        mailSender.send(mailMessage);
    }
}
