package com.ligw.demo.util.wx.util;

/**
 * Description: WXMessageTypeUtil
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXMessageTypeUtil {
    public final static int MESSAGE_TYPE_TEXT = 0x1;    //文本
    public final static int MESSAGE_TYPE_TEXTCARD = 0x2;    //文本卡
    public final static int MESSAGE_TYPE_NEWS = 0x3;    //图文
    public final static int MESSAGE_TYPE_MPNEWS = 0x4;  //图文
    public final static int MESSAGE_TYPE_IMAGE = 0x5;   //图片
    public final static int MESSAGE_TYPE_VOICE = 0x6;   //声音
    public final static int MESSAGE_TYPE_VIDEO = 0x7;   //视频
    public final static int MESSAGE_TYPE_FILE = 0x8;    //文件

    public static String getWXMessageType(int type) {
        switch (type) {
            case MESSAGE_TYPE_TEXT: {
                return "text";
            }
            case MESSAGE_TYPE_TEXTCARD: {
                return "textcard";
            }
            case MESSAGE_TYPE_NEWS: {
                return "news";
            }
            case MESSAGE_TYPE_MPNEWS: {
                return "mpnews";
            }
            case MESSAGE_TYPE_IMAGE: {
                return "image";
            }
            case MESSAGE_TYPE_VOICE: {
                return "voice";
            }
            case MESSAGE_TYPE_VIDEO: {
                return "video";
            }
            case MESSAGE_TYPE_FILE: {
                return "file";
            }
        }
        return null;
    }

}
