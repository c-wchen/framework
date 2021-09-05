package com.wchen.controller;

import com.alibaba.fastjson.JSON;
import com.wchen.pojo.Accept;
import com.wchen.pojo.Room;
import com.wchen.utils.ChatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketController {
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;


    /**
     * 当前用户会话
     */
    private Session session;

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,  Session session)
    {
        // 记录在线人数
        onlineNumber++;
        // 储存登录用户
        ChatUtils.addSession(Long.valueOf(userId), session);
        this.session = session;

        System.out.println("有新连接加入！ 当前在线人数" + onlineNumber);
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId)
    {
        onlineNumber--;
        ChatUtils.removeSession(Long.valueOf(userId));
        System.out.println("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端消息：" + message);

        Accept accept = JSON.parseObject(message, Accept.class);
        switch (accept.getType()) {
            case CREATE_ROOM:
                // 常见房间

                break;
            case DESTROY_ROOM:
                // 删除房间
                break;
            case SEND_MESSAGE:
                // 给房间放松消息
                break;
            default:
                break;
        }
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message)
    {
        try
        {
            session.getBasicRemote().sendText(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Scheduled(cron = "5/10 * * * * ?")
    public void test() {
        // 获取在线用户session  getSessions()
        // Set<Session> sessions
        // item -> {}

        // function(Session session) {}
        // sessions.forEach(item -> {})
    }

}
