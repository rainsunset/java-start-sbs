package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 视频消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXVideoMessageBean extends BaseMessage{
    /*     {
         "touser": "UserID1|UserID2|UserID3",
         "toparty": " PartyID1 | PartyID2 ",
         "totag": " TagID1 | TagID2 ",
         "msgtype": "video",
         "agentid": 1,
         "video": {
         "media_id": "MEDIA_ID",
         "title": "Title",
         "description": "Description"
         },
         "safe":0
         }*/
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private Integer agentid;
    private Video video;
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

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public static class Video extends BaseMessage {
        private String media_id;
        private String title;
        private String description;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

