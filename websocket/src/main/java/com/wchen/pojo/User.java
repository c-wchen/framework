package com.wchen.pojo;

import lombok.Data;

@Data
public class User {
    // 用户标识，唯一标识
    private Long userId;
    // 用户名
    private String userName;
}
