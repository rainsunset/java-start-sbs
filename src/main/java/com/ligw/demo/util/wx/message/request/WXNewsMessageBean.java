package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 图文消息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXNewsMessageBean extends BaseMessage {
    /* {
     "touser": "UserID1|UserID2|UserID3",
     "toparty": " PartyID1 | PartyID2 ",
     "totag": " TagID1 | TagID2 ",
     "msgtype": "news",
     "agentid": 1,
     "news": {
     "articles":[
     {
     "title": "Title",
     "description": "Description",
     "url": "URL",
     "picurl": "PIC_URL"
     },
     {
     "title": "Title",
     "description": "Description",
     "url": "URL",
     "picurl": "PIC_URL"
     }
     ]
     }
     }*/
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private Integer agentid;
    private News news;
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public static class News extends BaseMessage {
        private List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    public static class Article extends BaseMessage {
        private String title;
        private String description;
        private String url;
        private String picurl;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }
}

