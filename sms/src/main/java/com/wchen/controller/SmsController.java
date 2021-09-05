package com.wchen.controller;

import com.wchen.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class SmsController {
    @Autowired
    SendSmsService sendSmsService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @GetMapping("/send/{phone}")
    public String code(@PathVariable("phone") String phoneNumber) {
//        String code = redisTemplate.opsForValue().get(phoneNumber);
//        if (code != null) {
//            return phoneNumber + ": " + code + "exist";
//        }
        String code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<String, String> param = new HashMap<>();
        param.put("code", code);
        boolean isSend = sendSmsService.send(phoneNumber, param);
        if (isSend) {
//            redisTemplate.opsForValue().set(phoneNumber, code, 5, TimeUnit.SECONDS);
            return "send success";
        }
        return "send not success";

        
    }

}
