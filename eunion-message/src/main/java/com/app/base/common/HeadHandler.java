package com.app.base.common;

import com.app.base.dto.WebSocketSessionInfo;
import com.app.base.service.SessionInfoCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by BF100365 on 2016/12/15.
 */
@Component
public class HeadHandler extends AbstractWebSocketHandler {

    @Autowired
    private SessionInfoCache sessionInfoCache;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //接收到客户端消息时调用
        System.out.println("text message: " + session.getId() + "-" + message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 与客户端完成连接后调用
        System.out.println("-------------连接成功---------------");
        System.out.println("getId:" + session.getId());
        System.out.println("getLocalAddress:" + session.getLocalAddress().toString());
        System.out.println("getTextMessageSizeLimit:" + session.getTextMessageSizeLimit());
        System.out.println("getUri:" + session.getUri().toString());

        WebSocketSessionInfo webSocketSessionInfo = new WebSocketSessionInfo();
        webSocketSessionInfo.setLocalAddress(session.getLocalAddress().toString());
        webSocketSessionInfo.setPrincipalName("");
        webSocketSessionInfo.setSessionId(session.getId());
        webSocketSessionInfo.setTextMessageSizeLimit(session.getTextMessageSizeLimit());
        webSocketSessionInfo.setUri(session.getUri().toString());
        sessionInfoCache.put(webSocketSessionInfo);

        session.sendMessage(new TextMessage("你好".getBytes()));
    }

    @Override
    public void handleTransportError(WebSocketSession session,  Throwable exception) throws Exception {
        // 消息传输出错时调用
        System.out.println("handleTransportError");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 一个客户端连接断开时关闭
        System.out.println("afterConnectionClosed");
        sessionInfoCache.remove(session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        return false;
    }
}
