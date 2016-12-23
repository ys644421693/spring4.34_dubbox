package com.app.base.service;

import com.app.base.dto.WebSocketSessionInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by BF100365 on 2016/12/16.
 */
public interface SessionInfoCache {

    void put(WebSocketSessionInfo info);

    WebSocketSessionInfo getWebSocketSessionInfo(String sessionId);

    void clear();

    void remove(String sessionId);

    List<WebSocketSessionInfo> getAll();
}
