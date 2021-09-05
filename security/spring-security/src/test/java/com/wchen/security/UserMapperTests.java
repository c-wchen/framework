package com.wchen.security;


import com.wchen.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void updateUser() {
        userMapper.findAll().forEach(user -> {
            String salt = BCrypt.gensalt();
            user.setPassword(BCrypt.hashpw("123", salt));
            user.setSalt(salt);
            userMapper.saveAndFlush(user);
        });
    }
}
