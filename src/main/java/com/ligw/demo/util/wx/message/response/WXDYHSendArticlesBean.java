/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.ligw.demo.util.wx.message.response;

/**
 * 群发微信消息返回数据
 *
 * @author ligw
 * @version $Id WXDYHSendArticlesByTagidBean.java, v 0.1 2017-09-28 11:57 ligw
 *          Exp $$
 */
public class WXDYHSendArticlesBean {

    /**
     * errcode : 0
     * errmsg : send job submission success
     * msg_id : 34182
     * msg_data_id : 206227730
     */
    // 错误码
    private int errcode;

    // 错误信息
    private String errmsg;

    // 消息发送任务的ID
    private long msg_id;

    // 消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的
    // msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
    private long msg_data_id;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public long getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(long msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}
