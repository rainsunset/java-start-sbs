/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;
import org.apache.commons.lang.StringUtils;

/**
 * @author ligw
 * @version $Id WXDYHArticleSendallBean.java, v 0.1 2017-09-28 11:21 ligw Exp $$
 */
public class WXDYHArticleSendallBean extends BaseMessage {

    /**
     * filter : {"is_to_all":false,"tag_id":2}
     * mpnews : {"media_id":"123dsdajkasd231jhksad"}
     * msgtype : mpnews
     * send_ignore_reprint : 0
     */
    //必传	用于设定图文消息的接收者
    private FilterBean filter;

    // 必传 用于设定即将发送的图文消息
    private MpnewsBean mpnews;

    // 必传 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
    private String msgtype;

    // 必传 图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
    private int send_ignore_reprint;
    //使用 clientmsgid 参数，避免重复推送
    //群发时，微信后台将对 24 小时内的群发记录进行检查，如果该 clientmsgid 已经存在一条群发记录，则会拒绝本次群发请求，返回已存在的群发msgid，开发者可以调用“查询群发消息发送状态”接口查看该条群发的状态。
    //开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
    private String clientmsgid;

    public WXDYHArticleSendallBean (Boolean is_to_all,Integer tag_id,String media_id,Integer send_ignore_reprint,String clientmsgid){
        if (null == media_id || media_id.trim().isEmpty() || null == is_to_all || ((!is_to_all)&&(null == tag_id) )){
            return;
        }
        this.send_ignore_reprint = (null == send_ignore_reprint) ? 1 : send_ignore_reprint;
        this.msgtype = "mpnews";
        this.filter = new FilterBean(is_to_all,tag_id);
        this.mpnews = new MpnewsBean(media_id);
        if(!StringUtils.isEmpty(clientmsgid)){
            this.clientmsgid = clientmsgid;
        }
    }

    public FilterBean getFilter() {
        return filter;
    }

    public void setFilter(FilterBean filter) {
        this.filter = filter;
    }

    public MpnewsBean getMpnews() {
        return mpnews;
    }

    public void setMpnews(MpnewsBean mpnews) {
        this.mpnews = mpnews;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(int send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }

    public static class FilterBean {

        /**
         * is_to_all : false
         * tag_id : 2
         */
        //非必传 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
        private boolean is_to_all;

        // 非必传 群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
        private int tag_id;

        public FilterBean(Boolean is_to_all, Integer tag_id) {
            if (null != is_to_all){
                this.is_to_all = is_to_all;
            }
            if (null != tag_id){
                this.tag_id = tag_id;
            }
        }

        public boolean isIs_to_all() {
            return is_to_all;
        }

        public void setIs_to_all(boolean is_to_all) {
            this.is_to_all = is_to_all;
        }

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }
    }

    public static class MpnewsBean {
        /**
         * media_id : 123dsdajkasd231jhksad
         */
        //必传 用于群发的消息的media_id
        private String media_id;

        public MpnewsBean(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
