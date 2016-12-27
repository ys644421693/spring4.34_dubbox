package com.app.base.controller;

import com.app.base.dto.WebSocketSessionInfo;
import com.app.base.service.SessionInfoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BF100365 on 2016/12/15.
 */
@Controller
@RequestMapping("/")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionInfoCache sessionInfoCache;

    @RequestMapping(value = {"/","/index"})
    public String getAllData(){
        logger.debug("cceshioshdfoaih");
        WebSocketSessionInfo webSocketSessionInfo = new WebSocketSessionInfo();
        webSocketSessionInfo.setSessionId("0");
        sessionInfoCache.put(webSocketSessionInfo);
        return "index";
    }

}
