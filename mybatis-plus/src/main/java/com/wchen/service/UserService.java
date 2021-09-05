package com.wchen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wchen.pojo.User;


public interface UserService extends IService<User>{
    boolean isLogin();
}
