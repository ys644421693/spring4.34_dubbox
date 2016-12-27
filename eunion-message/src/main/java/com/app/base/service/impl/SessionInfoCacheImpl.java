package com.app.base.service.impl;

import com.app.base.dto.WebSocketSessionInfo;
import com.app.base.service.SessionInfoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by BF100365 on 2016/12/16.
 */
@Service("sessionInfoCache")
public class SessionInfoCacheImpl implements SessionInfoCache {

    private Logger logger = LoggerFactory.getLogger(SessionInfoCacheImpl.class);

    private List<WebSocketSessionInfo> webSocketSessionInfoList = new ArrayList<WebSocketSessionInfo>();

    @CachePut(value = "webSocket", key = "#info.getSessionId()")
    public List<WebSocketSessionInfo> put(WebSocketSessionInfo info) {
        this.webSocketSessionInfoList.add(info);
        logger.debug("---------------添加数据" + info.getSessionId() + "到缓存------------------");
        return this.webSocketSessionInfoList;
    }

    @Cacheable(value = "webSocketInfo", key = "#sessionId")
    public WebSocketSessionInfo getWebSocketSessionInfo(final String sessionId) {
        logger.debug("---------------从缓存中获取数据------------------");
        return webSocketSessionInfoList.stream().filter(s -> s.getSessionId().equals(sessionId)).collect(Collectors.toList()).get(0);
    }

    @CacheEvict(value = "webSocket", allEntries = true)
    public List<WebSocketSessionInfo>  clear() {
        logger.debug("---------------清空所有数据------------------");
        webSocketSessionInfoList.clear();
        return webSocketSessionInfoList;
    }

    @CacheEvict(value = "webSocket", key = "#sessionId")
    public List<WebSocketSessionInfo> remove(String sessionId) {
        logger.debug("---------------删除数据" + sessionId + "------------------");
        int count = webSocketSessionInfoList.size();
        for (int i = 0; i < count; i++) {
            if (webSocketSessionInfoList.get(i).getSessionId().equals(sessionId)) {
                webSocketSessionInfoList.remove(i);
                return webSocketSessionInfoList;
            }
        }
        return webSocketSessionInfoList;
    }

    @Cacheable(value = "webSocket")
    public List<WebSocketSessionInfo> getAll() {
        return this.webSocketSessionInfoList;
    }
}
