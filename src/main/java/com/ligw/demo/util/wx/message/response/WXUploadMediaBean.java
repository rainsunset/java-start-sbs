package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 上传临时素材文件
 * 所有文件size必须大于5个字节
 * 图片（image）:2MB，支持JPG,PNG格式
 * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式
 * 视频（video）：10MB，支持MP4格式
 * 普通文件（file）：20MB
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUploadMediaBean extends BaseMessage {
    /*{
        "errcode": 0,
        "errmsg": ""，
        "type": "image",
        "media_id": "1G6nrLmr5EC3MMb_-zK1dDdzmd0p7cNliYu9V5w7o8K0",
        "created_at": "1380000000"
     }*/
    private int errcode;
    private String errmsg;
    private String type;
    private String media_id;
    private String created_at;
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public int getErrcode() {
        return errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getErrmsg() {
        return errmsg;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
    public String getMedia_id() {
        return media_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getCreated_at() {
        return created_at;
    }
}

