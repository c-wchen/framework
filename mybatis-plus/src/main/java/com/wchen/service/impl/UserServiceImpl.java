package com.wchen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wchen.dao.UserDao;
import com.wchen.pojo.User;
import com.wchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    public boolean isLogin() {
        User user = baseMapper.selectById(532688061524889673L);
        if (!StringUtils.isEmpty(user)) {
            return true;
        }
        return false;
    }

}
