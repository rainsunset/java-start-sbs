package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 文本消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXTextMessageBean extends BaseMessage {
    /*     {
         "touser": "UserID1|UserID2|UserID3",
         "toparty": " PartyID1 | PartyID2 ",
         "totag": " TagID1 | TagID2 ",
         "msgtype": "text",
         "agentid": 1,
         "text": {
         "content": "Holiday Request For Pony(http://xxxxx)"
         },
         "safe":0
         }*/
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private Integer agentid;
    private Content text;
    private Integer safe;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Content getText() {
        return text;
    }

    public void setText(Content text) {
        this.text = text;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public static class Content extends BaseMessage {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
