package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 文件消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXFileMessageBean extends BaseMessage{
    /*     {
     "touser": "UserID1|UserID2|UserID3",
     "toparty": " PartyID1 | PartyID2 ",
     "totag": " TagID1 | TagID2 ",
     "msgtype": "file",
     "agentid": 1,
     "file": {
     "media_id": "MEDIA_ID"
     },
     "safe":"0"
     }*/

    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private Integer agentid;
    private File file;
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

    public File getImage() {
        return file;
    }

    public void setImage(File file) {
        this.file = file;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public static class File extends BaseMessage {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
