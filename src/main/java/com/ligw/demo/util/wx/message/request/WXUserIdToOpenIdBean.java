package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: UserId 转 OpenId 请求体
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-09
 */
public class WXUserIdToOpenIdBean extends BaseMessage {
    /*{
        "userid": "zhangsan",
        "agentid": 1
    }*/

    private String userid;
    private Integer agentid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }
}
