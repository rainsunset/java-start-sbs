/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * 微信订阅号上传永久图片素材返回参数
 * @author ligw
 * @version $Id WXDYHAddImgBean.java, v 0.1 2017-09-28 10:05 ligw Exp $$
 */
public class WXDYHAddImgBean extends BaseMessage{

    /**
     * media_id : MEDIA_ID
     * url : URL
     */
    private String media_id;

    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
