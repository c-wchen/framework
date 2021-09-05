package com.wchen.utils;

import com.alibaba.fastjson.JSON;
import com.wchen.pojo.Reply;
import com.wchen.pojo.Room;
import com.wchen.pojo.User;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;


public class ChatUtils {
    // 储存房间, 房间号 ==>  房间
    private static ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();
    // 储存用户与session之间的关系
    private static  ConcurrentHashMap<Long, Session> userSessions =  new ConcurrentHashMap<>();


    // 缓存用户session
    public static void addSession(Long userId, Session session) {
        userSessions.put(userId, session);
    }

    // 移除用户Session
    public static  void removeSession(Long userId) {
        userSessions.remove(userId);
    }
    // 添加用户到房间
    public static  void addRoom(User user, String roomId) {
        rooms.get(roomId).getUsers().add(user);
    }


    // 给房间发送消息
    public static  void sendMessage(String roomId, Reply message) {
        rooms.get(roomId).getUsers().forEach(user -> {
            userSessions.get(user.getUserId()).getAsyncRemote().sendText(JSON.toJSONString(message));
        });
    }

}
