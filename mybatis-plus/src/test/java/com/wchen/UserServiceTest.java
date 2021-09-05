package com.wchen;

import com.wchen.pojo.User;
import com.wchen.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void testSave() {
       User user = new User();
       user.setUserName("chen");
       user.setPassword("123");
        for (int i = 0; i < 10; i++) {
            userService.save(user);
        }
    }
    @Test
    public void testQuery() {
        User user = userService.getById(5326880615248673L);
        System.out.println(user);
    }
    @Test
    public void interval() {
        System.out.println(userService.isLogin());
    }


}
