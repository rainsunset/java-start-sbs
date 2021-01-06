package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: OpenId 转 UserId 请求体
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-09
 */
public class WXOpenIdToUserIdBean extends BaseMessage{
    /*{
        "openid": "oDOGms-6yCnGrRovBj2yHij5JL6E"
    }*/
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
