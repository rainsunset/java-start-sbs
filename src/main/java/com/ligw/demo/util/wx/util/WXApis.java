package com.ligw.demo.util.wx.util;

/**
 * Description: WXApis
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXApis {
    //企业微信
    //获取accessToken(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
    public final static String API_GET_ACCESSTOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?";
    public final static String P_GET_ACCESSTOKEN_CORPID = "corpid";
    public final static String P_GET_ACCESSTOKEN_CORPSECRET = "corpsecret";

    //获取JSAPI TICKET(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=ACCESS_TOKE
    public final static String API_GET_JSAPI_TICKET = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?";
    public final static String P_GET_JSAPI_TICKET_ACCESS_TOKEN = "access_token";

    //网页授权，重定向到带有code信息的网页(GET)
    //https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&agentid=AGENTID&state=STATE#wechat_redirect
    public final static String API_GET_OAUTH = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    public final static String P_GET_OAUTH_APPID = "appid";
    public final static String P_GET_OAUTH_REDIRECT_URI = "redirect_uri";
    public final static String P_GET_OAUTH_RESPONSE_TYPE = "response_type";
    public final static String P_GET_OAUTH_SCOPE ="scope";
    public final static String P_GET_OAUTH_AGENTID ="agentid";
    public final static String P_GET_OAUTH_STATE ="state";
    public final static String V_GET_OAUTH_STATE= "web_login";
    public final static String P_GET_OAUTH_WECHAT_REDIRECT = "#wechat_redirect";
    //静默授权，可获取成员的基础信息
    public final static String SCOPE_SNSAPI_BASE = "snsapi_base";
    //静默授权，可获取成员的详细信息，但不包含手机、邮箱
    public final static String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
    //手动授权，可获取成员的详细信息，包含手机、邮箱
    public final static String SCOPE_SNSAPI_PRIVATEINFO = "snsapi_privateinfo";

    //通过code获取用户信息(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE
    public final static String API_GET_USER_INFO_BY_CODE = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?";
    public final static String P_GET_USER_INFO_BY_CODE_ACCESSTOKEN = "access_token";
    public final static String P_GET_USER_INFO_BY_CODE_CODE = "code";

    //通过code获取的user_ticket获取成员信息详情(POST)
    //https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?access_token=ACCESS_TOKEN
    public final static String API_GET_USER_INFO_DETAIL_BY_CODE = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?";
    public final static String P_GET_USER_INFO_DETAIL_BY_CODE_ACCESSTOKEN = "access_token";

    //通过USERID获取OPENID(POST)
    public final static String API_POST_OPENID_BY_USERID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid";
    public final static String P_POST_OPENID_BY_USERID_ACCESSTOKEN = "access_token";

    //通过OPERID获取USERID(POST)
    public final static String API_POST_USERID_BY_OPENID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid";
    public final static String P_POST_USERID_BY_OPENID_ACCESSTOKEN = "access_token";

    //通过通讯录获取成员信息(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID
    public final static String API_GET_USER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/user/get?";
    public final static String P_GET_USER_INFO_ACCESSTOKEN = "access_token";
    public final static String P_GET_USER_INFO_USERID = "userid";

    //获取部门列表(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID
    public final static String API_GET_DEPARTMENT_INFO = "https://qyapi.weixin.qq.com/cgi-bin/department/list?";
    public final static String P_GET_DEPARTMENT_INFO_ACCESSTOKEN = "access_token";
    public final static String P_GET_DEPARTMENT_INFO_ID = "id";

    //获取部门成员信息(GET)
    //https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD
    public final static String API_GET_DEPARTMENT_USER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?";
    public final static String P_GET_DEPARTMENT_USER_INFO_ACCESSTOKEN = "access_token";
    public final static String P_GET_DEPARTMENT_USER_INFO_DEPARTMENT_ID = "department_id";
    public final static String P_GET_DEPARTMENT_USER_INFO_FETCH_CHILD = "fetch_child";

    //发送消息(POST)
    //https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN
    public final static String API_SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/message/send?";
    public final static String P_SEND_MESSAGE_ACCESSTOKEN = "access_token";
    public final static String SEND_MESSAGE_TYPE_TEXT = "text";
    public final static String SEND_MESSAGE_TYPE_TEXTCARD = "textcard";
    public final static String SEND_MESSAGE_TYPE_IMAGE = "image";
    public final static String SEND_MESSAGE_TYPE_VOICE = "voice";
    public final static String SEND_MESSAGE_TYPE_VIDEO = "video";
    public final static String SEND_MESSAGE_TYPE_NEWS = "news";
    public final static String SEND_MESSAGE_TYPE_MPNEWS = "mpnews";
    public final static String SEND_MESSAGE_TYPE_FILE = "file";


    //获取临时素材(GET)（图片，声音，视频）
    //https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
    public final static String API_GET_MEDIA = "https://qyapi.weixin.qq.com/cgi-bin/media/get?";
    public final static String P_GET_MEDIA_ACCESS_TOKEN = "access_token";
    public final static String P_GET_MEDIA_MEDIA_ID = "media_id";

    //上传临时素材(POST)（图片，声音，视频） 使用http multipart/form-data上传文件， 文件标识名为”media”.
    //https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
    public final static String API_UPLOAD_MEDIA = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?";
    public final static String P_UPLOAD_MEDIA_ACCESS_TOKEN = "access_token";
    public final static String P_UPLOAD_MEDIA_TYPE = "type";
    //上传素材类型
    public final static String UPLOAD_MEDIA_TYPE_IMAGE = "image";
    public final static String UPLOAD_MEDIA_TYPE_VOICE = "voice";
    public final static String UPLOAD_MEDIA_TYPE_VIDEO = "video";
    public final static String UPLOAD_MEDIA_TYPE_FILE = "file";


    //微信公众号
    //菜单创建（POST） 限100（次/天）
    public static final String STR_MENU_CREATE_URL = "https://test.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    //获取授权code
    public static final String STR_GETCODEURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx89f76283cc53a87c&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=1#wechat_redirect";
    //获取openid 和 网页授权access_token(与基础支持中的access_token（该access_token用于调用其他接口）不同)
    public static final String STR_GETACCESS_TOKEN = "https://test.weixin.qq.com/sns/oauth2/access_token?appid=wx89f76283cc53a87c&secret=RvTI5n77iEd-YHOLG-LlWY4XZMZq3R338QS2kQyifByIulilgWL8lIXDZVLVzvxd&code=CODE&grant_type=authorization_code";
    //发送模板消息(推送通知)
    public static final String STR_SENDTEMPLATEMESSAGE = "https://test.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    //模板id(兑换成功通知)
    public static final String STR_TEMP_SUCCESS = "ilombBxlI-t0URu_UGSxYJskiwva6FvqxHzRVHbD8U4";
    //模板id(处理进度通知)
    public static final String STR_TEMP_PROGRESS = "weuiA7uxpSDYD7V7I3X9fJTtJRVQ_9P3qw7bq_NaFWk";
    //模板id(任务派发通知)
    public static final String STR_TEMP_TASK = "A_0TaTaiOOtGpXB52Rd6lyiT5qHefkLnkqugHF_5WE0";

    //---------------------  分割线 以下为微信订阅号接口  -----------------------
    // 获取access_token https请求方式: GET
    //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
    public static final String DYH_API_GET_ACCESSTOKEN = "https://test.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
    public static final String DYH_P_GET_ACCESSTOKEN_APPID = "appid";
    public static final String DYH_P_GET_ACCESSTOKEN_SECRET = "secret";

    //素材管理-新增图片永久素材 http请求方式: POST，需使用https
    //https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE
    public static final String DYH_API_MATERIAL_ADD_IMG = "https://test.weixin.qq.com/cgi-bin/material/add_material?";
    public static final String DYH_P_MATERIAL_ADD_IMG_ACCESSTOKEN = "access_token";
    public static final String DYH_P_MATERIAL_ADD_IMG_TYPE = "type";

    //上传图文消息内的图片获取URL  图片仅支持jpg/png格式，大小必须在1MB以下。 http请求方式: POST，https协议
    //https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN
    public static final String DYH_API_MATERIAL_ADD_ARTICLEIMG = "https://test.weixin.qq.com/cgi-bin/media/uploadimg?";
    public static final String DYH_P_MATERIAL_ADD_ARTICLEIMG_ACCESSTOKEN = "access_token";

    //新增永久图文素材 http请求方式: POST，https协议
    //https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
    public static final String DYH_API_MATERIAL_ADD_ARTICLE = "https://test.weixin.qq.com/cgi-bin/material/add_news?";
    public static final String DYH_P_MATERIAL_ADD_ARTICLE_ACCESSTOKEN = "access_token";

    //根据标签进行群发 http请求方式: POST
    //https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN
    public static final String DYH_API_MESSAGE_SENDALL = "https://test.weixin.qq.com/cgi-bin/message/mass/sendall?";
    public static final String DYH_P_MESSAGE_SENDALL_ACCESSTOKEN = "access_token";

    //获取公众号已创建的标签 http请求方式：GET（请使用https协议）
    //https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN
    public static final String DYH_API_USER_GETTAGS = "https://test.weixin.qq.com/cgi-bin/tags/get?";
    public static final String DYH_P_USER_GETTAGS_ACCESSTOKEN = "access_token";

    //---------------------  分割线 微信订阅号接口  结束 -----------------------

}
