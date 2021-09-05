package com.wchen;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SmsTest {
    @Test
    void testSms() {
        DefaultProfile profile = DefaultProfile
                .getProfile("cn-hangzhou", "LTAI4GBbZP3ZJVqpykFtiUHS", "aNKz3hLUZqs7t7KzOR9RHgecUQndj5");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", "15185295761");
        request.putQueryParameter("SignName", "忘尘科技");
        request.putQueryParameter("TemplateCode", "SMS_205133950");
        Map<String, String> map = new HashMap<>();
        map.put("code", "1212");
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
