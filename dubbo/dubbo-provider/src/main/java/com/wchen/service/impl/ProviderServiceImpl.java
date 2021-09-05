package com.wchen.service.impl;

import com.wchen.service.ProviderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service
@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String getInfo() {
        return "====== Provider Info =====";
    }
}
