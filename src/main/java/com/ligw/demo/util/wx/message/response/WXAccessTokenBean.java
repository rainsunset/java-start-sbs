package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: WXAccessTokenBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXAccessTokenBean extends BaseMessage {
    // {
    // "access_token": "accesstoken000001",
    // "expires_in": 7200
    // }
    private String access_token;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
