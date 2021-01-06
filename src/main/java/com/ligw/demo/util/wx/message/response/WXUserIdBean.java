package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: UserId 数据
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-09
 */
public class WXUserIdBean extends BaseMessage{
    /*{
        "errcode": 0,
        "errmsg": "ok",
        "userid": "zhangsan"
    }*/
    private int errcode;
    private String errmsg;
    private String userid;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
