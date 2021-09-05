package com.wchen.pojo;

import lombok.Data;

import java.util.Set;


@Data
public class Room {
    private String roomId;
    // 一个房间多个用户
    private Set<User> users;
}
