package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: OpenId 数据
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-09
 */
public class WXOpenIdBean extends BaseMessage {
    /*{
        "errcode": 0,
        "errmsg": "ok",
        "openid": "oDOGms-6yCnGrRovBj2yHij5JL6E",
        "appid":"wxf874e15f78cc84a7"
    }*/
    private int errcode;
    private String errmsg;
    private String openid;
    private String appid;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
