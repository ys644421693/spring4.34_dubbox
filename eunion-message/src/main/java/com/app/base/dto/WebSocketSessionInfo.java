package com.app.base.dto;

import java.io.Serializable;

/**
 * Created by BF100365 on 2016/12/16.
 */
public class WebSocketSessionInfo implements Serializable {

    private String sessionId;
    private String localAddress;
    private int textMessageSizeLimit;
    private String uri;
    private String principalName;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public int getTextMessageSizeLimit() {
        return textMessageSizeLimit;
    }

    public void setTextMessageSizeLimit(int textMessageSizeLimit) {
        this.textMessageSizeLimit = textMessageSizeLimit;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
}
