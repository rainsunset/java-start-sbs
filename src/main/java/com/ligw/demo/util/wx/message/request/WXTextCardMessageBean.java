package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 文本卡片消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXTextCardMessageBean extends BaseMessage {
    /*  {
          "touser" : "UserID1|UserID2|UserID3",
          "toparty" : " PartyID1 | PartyID2 ",
          "totag" : " TagID1 | TagID2 ",
          "msgtype" : "textcard",
          "agentid" : 1,
          "textcard" : {
                   "title" : "领奖通知",
                   "description" : "<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>",
                   "url" : "URL"
          }*/
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private int agentid;
    private Textcard textcard;

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTouser() {
        return touser;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getToparty() {
        return toparty;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getTotag() {
        return totag;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setTextcard(Textcard textcard) {
        this.textcard = textcard;
    }

    public Textcard getTextcard() {
        return textcard;
    }

    public static class Textcard extends BaseMessage {
        private String title;
        private String description;
        private String url;

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}

