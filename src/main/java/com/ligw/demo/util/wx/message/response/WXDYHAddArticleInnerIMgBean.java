/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * 上传图文消息内的图片获取URL
 * @author ligw
 * @version $Id WXDYHAddGraphicInnerIMgBean.java, v 0.1 2017-09-28 10:25 ligw Exp $$
 */
public class WXDYHAddArticleInnerIMgBean extends BaseMessage {

    /**
     * url : http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
