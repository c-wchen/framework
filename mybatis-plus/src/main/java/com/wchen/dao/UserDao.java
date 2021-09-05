package com.wchen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wchen.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
