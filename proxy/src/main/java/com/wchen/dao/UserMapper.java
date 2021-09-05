package com.wchen.dao;


import com.wchen.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User>  selectAll();
}
