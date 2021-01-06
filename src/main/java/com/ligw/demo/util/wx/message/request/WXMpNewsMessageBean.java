package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 图文消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXMpNewsMessageBean extends BaseMessage {
    /* {
         "touser" : "UserID1|UserID2|UserID3",
         "toparty" : " PartyID1 | PartyID2 ",
         "totag": " TagID1 | TagID2 ",
         "msgtype" : "mpnews",
         "agentid" : 1,
         "mpnews" : {
             "articles":[
                 {
                     "title": "Title",
                     "thumb_media_id": "MEDIA_ID",
                     "author": "Author",
                     "content_source_url": "URL",
                     "content": "Content",
                     "digest": "Digest description"
                  }
             ]
         },
         "safe":0
      }*/
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private int agentid;
    private Mpnews mpnews;
    private int safe;

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

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }

    public int getSafe() {
        return safe;
    }

    public static class Mpnews extends BaseMessage {
        private List<Articles> articles;

        public void setArticles(List<Articles> articles) {
            this.articles = articles;
        }

        public List<Articles> getArticles() {
            return articles;
        }
    }

    public static class Articles extends BaseMessage {
        private String title;
        private String thumb_media_id;
        private String author;
        private String content_source_url;
        private String content;
        private String digest;

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getContent_source_url() {
            return content_source_url;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getDigest() {
            return digest;
        }
    }
}

