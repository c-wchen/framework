package com.wchen.controller;

import com.wchen.service.SendMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MailController {
    @Autowired
    SendMail sendMail;
    @GetMapping("/send/{userName}")
    String send(@PathVariable String userName) {
        log.info("user name: {}", userName);
        sendMail.send(userName);
        return "ok";
    }

}
