package com.wchen.service.impl;

import com.wchen.service.ConsumerService;
import com.wchen.service.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Reference
    ProviderService providerService;
    public void consumerInfo() {
        // 获取从提供者信息
        System.out.println("====== Consumer Info =======, "  + providerService.getInfo());
    }

}
