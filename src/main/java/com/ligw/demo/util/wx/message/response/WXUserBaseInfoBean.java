package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 通过code获取成员信息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUserBaseInfoBean extends BaseMessage {
    /*   {
            "errcode": 0,
            "errmsg": "ok",
            "UserId":"USERID",
            "DeviceId":"DEVICEID",
            "user_ticket": "USER_TICKET"，
            "expires_in":7200
         }*/
    private int errcode;
    private String errmsg;
    private String UserId;
    private String DeviceId;
    private String user_ticket;
    private int expires_in;
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public int getErrcode() {
        return errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getErrmsg() {
        return errmsg;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
    public String getUserId() {
        return UserId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }
    public String getDeviceId() {
        return DeviceId;
    }

    public void setUser_ticket(String user_ticket) {
        this.user_ticket = user_ticket;
    }
    public String getUser_ticket() {
        return user_ticket;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
    public int getExpires_in() {
        return expires_in;
    }

}
