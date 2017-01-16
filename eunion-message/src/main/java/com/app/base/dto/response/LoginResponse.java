package com.app.base.dto.response;

import com.app.base.dto.ResponseBase;

/**
 * Created by BF100365 on 2017/1/16.
 */
public class LoginResponse extends ResponseBase {

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
