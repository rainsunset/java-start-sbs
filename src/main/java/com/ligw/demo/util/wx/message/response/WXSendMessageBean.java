package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 发送消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXSendMessageBean extends BaseMessage {
/*    {
        "errcode" : 0,
        "errmsg" : "ok",
        "invaliduser" : "UserID1", // 不区分大小写，返回的列表都统一转为小写
        "invalidparty" : "PartyID1",
        }*/

    private int errcode;
    private String errmsg;
    private String invaliduser;
    private String invalidparty;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }
}

