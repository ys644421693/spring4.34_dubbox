package com.app.base.service;

import com.app.base.dto.WebSocketSessionInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by BF100365 on 2016/12/16.
 */
public interface SessionInfoCache {

    List<WebSocketSessionInfo> put(WebSocketSessionInfo info);

    WebSocketSessionInfo getWebSocketSessionInfo(String sessionId);

    List<WebSocketSessionInfo>  clear();

    List<WebSocketSessionInfo>  remove(String sessionId);

    List<WebSocketSessionInfo> getAll();
}
