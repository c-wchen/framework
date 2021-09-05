package com.wchen.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wchen.service.SendSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource(value = {"classpath:application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "sms")
@Slf4j
public class SendSmsServiceImpl implements SendSmsService {
    @Value("${regionId}")
    private  String regionId;
    @Value("${accessId}")
    private String accessId;
    @Value("${secret}")
    private String secret;
    @Value("${signName}")
    private String signName;
    @Value("${templateCode}")
    private String templateCode;

    @Override
    public boolean send(String phoneNum, Map<String, String> code) {
        // 设置访问accessKey
        DefaultProfile profile = DefaultProfile
                .getProfile(regionId, accessId, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        // 自定义参数
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
        return true;
    }
}
