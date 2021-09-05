package com.wchen.service;

import java.util.Map;

public interface SendSmsService {
    public boolean send(String phoneNum,  Map<String, String> code);
}
