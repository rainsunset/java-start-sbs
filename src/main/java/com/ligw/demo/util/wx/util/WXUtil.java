package com.ligw.demo.util.wx.util;

import com.alibaba.fastjson.JSON;
import com.ligw.demo.util.http.HttpConstants;
import com.ligw.demo.util.http.HttpUtil;
import com.ligw.demo.util.wx.message.BaseMessage;
import com.ligw.demo.util.wx.message.WXJSSDKSignBean;
import com.ligw.demo.util.wx.message.request.*;
import com.ligw.demo.util.wx.message.response.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description: WXUtilh
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUtil {

    private final static Logger mLogger = Logger.getLogger(WXUtil.class);

    public final static String HTTP_METHOD_GET = "GET";

    public final static String HTTP_METHOD_POST = "POST";

    // 发送请求到微信服务器
    public static String httpRequest(String requestUrl, String requestMethod, HashMap<String, String> params,
            String postBody) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer urlBuffer = new StringBuffer();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            X509TrustManager x509TrustManager = new X509TrustManager() {

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            };
            TrustManager[] tm = {x509TrustManager};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            String requestUrlStr = null;
            urlBuffer.append(requestUrl);
            if (params != null && params.entrySet().size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    urlBuffer.append(param.getKey()).append("=").append(param.getValue()).append("&");
                }
                requestUrlStr = urlBuffer.toString();
                requestUrlStr = requestUrlStr.substring(0, requestUrlStr.length() - 1);
            }
            else {
                requestUrlStr = urlBuffer.toString();
            }
            mLogger.info("======>wx request url : " + requestUrlStr);
            URL url = new URL(requestUrlStr);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(requestMethod);
            if (requestMethod.equalsIgnoreCase(HTTP_METHOD_POST)) {
                if (postBody != null) {
                    outputStream = httpUrlConn.getOutputStream();
                    outputStream.write(postBody.getBytes("UTF-8"));
                    outputStream.close();
                }
            }
            httpUrlConn.connect();
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
            return buffer.toString();
        }
        catch (KeyManagementException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        catch (ConnectException exception) {
            exception.printStackTrace();
        }
        catch (ProtocolException exception) {
            exception.printStackTrace();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchProviderException exception) {
            exception.printStackTrace();
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        mLogger.info("======>wx url response : " + buffer.toString());
        return buffer.toString();
    }

    // 下载微信服务器资源
    private static boolean httpDownload(String requestUrl, HashMap<String, String> params, String filePath,
            String fileName) {
        boolean result = false;
        StringBuffer urlBuffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            X509TrustManager x509TrustManager = new X509TrustManager() {

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            };
            TrustManager[] tm = {x509TrustManager};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            String requestUrlStr = null;
            urlBuffer.append(requestUrl);
            if (params != null && params.entrySet().size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    urlBuffer.append(param.getKey()).append("=").append(param.getValue()).append("&");
                }
                requestUrlStr = urlBuffer.toString();
                requestUrlStr = requestUrlStr.substring(0, requestUrlStr.length() - 1);
            }
            else {
                requestUrlStr = urlBuffer.toString();
            }
            mLogger.info("======>download url : " + requestUrlStr);
            URL url = new URL(requestUrlStr);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod(HTTP_METHOD_GET);
            httpUrlConn.connect();
            inputStream = httpUrlConn.getInputStream();
            // String fileExt =
            // getFileExt(httpUrlConn.getHeaderField("Content-Type"));
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File desFile = new File(filePath, fileName);
            if (desFile.exists()) {
                desFile.delete();
            }
            FileUtils.copyInputStreamToFile(inputStream, desFile);
            mLogger.info("======>copy file to : " + desFile.getAbsolutePath());
            inputStream.close();
            httpUrlConn.disconnect();
            result = true;
        }
        catch (KeyManagementException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        catch (ConnectException exception) {
            exception.printStackTrace();
        }
        catch (ProtocolException exception) {
            exception.printStackTrace();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchProviderException exception) {
            exception.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return result;
    }

    // 上传资源到微信服务器
    public static String httpUpload(String requestUrl, HashMap<String, String> params, File file) {
        String BOUNDARY = UUID.randomUUID().toString();
        String PREFIX = "--";
        String LINE_END = "\r\n";
        StringBuffer buffer = new StringBuffer();
        StringBuffer urlBuffer = new StringBuffer();
        OutputStream outputStream = null;
        InputStream is = null;
        DataOutputStream dos = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            X509TrustManager x509TrustManager = new X509TrustManager() {

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            };
            TrustManager[] tm = {x509TrustManager};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            String requestUrlStr = null;
            urlBuffer.append(requestUrl);
            if (params != null && params.entrySet().size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    urlBuffer.append(param.getKey()).append("=").append(param.getValue()).append("&");
                }
                requestUrlStr = urlBuffer.toString();
                requestUrlStr = requestUrlStr.substring(0, requestUrlStr.length() - 1);
            }
            else {
                requestUrlStr = urlBuffer.toString();
            }
            mLogger.info("======>wx request url : " + requestUrlStr);
            URL url = new URL(requestUrlStr);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(HTTP_METHOD_POST);
            httpUrlConn.setRequestProperty("connection", "keep-alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            httpUrlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
            if (file != null) {
                outputStream = httpUrlConn.getOutputStream();
                dos = new DataOutputStream(outputStream);
                StringBuffer sb = new StringBuffer();
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINE_END);
                sb.append("Content-Disposition: form-data; name=\"media\"; filename=\"" + file.getName() + "\""
                        + LINE_END);
                sb.append("Content-Type: application/octet-stream; charset=utf-8" + LINE_END);
                sb.append(LINE_END);
                dos.write(sb.toString().getBytes());
                is = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = is.read(bytes)) != -1) {
                    dos.write(bytes, 0, len);
                }
                is.close();
                dos.write(LINE_END.getBytes());
                dos.write((PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes());
                dos.flush();
                dos.close();
            }
            httpUrlConn.connect();
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
            mLogger.info("======>wx url response : " + buffer.toString());
            return buffer.toString();
        }
        catch (KeyManagementException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        catch (ConnectException exception) {
            exception.printStackTrace();
        }
        catch (ProtocolException exception) {
            exception.printStackTrace();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        catch (NoSuchProviderException exception) {
            exception.printStackTrace();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }

    // 微信企业号
    // 获取AccessToken
    public static WXAccessTokenBean getAccessToken(String appid, String appsecret) {
        WXAccessTokenBean wxAccessTokenBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_ACCESSTOKEN_CORPID, appid);
        params.put(WXApis.P_GET_ACCESSTOKEN_CORPSECRET, appsecret);
        String response = httpRequest(WXApis.API_GET_ACCESSTOKEN, HTTP_METHOD_GET, params, null);
        try {
            wxAccessTokenBean = JSON.parseObject(response, WXAccessTokenBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxAccessTokenBean = null;
        }
        return wxAccessTokenBean;
    }

    // 获取JSAPI TICKET
    public static WXJsApiTicketBean getJSAPITicket(String accessToken) {
        if (accessToken == null || accessToken == null || accessToken.length() == 0) {
            return null;
        }
        WXJsApiTicketBean jsApiTicket = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_JSAPI_TICKET_ACCESS_TOKEN, accessToken);
        String response = httpRequest(WXApis.API_GET_JSAPI_TICKET, HTTP_METHOD_GET, params, null);
        try {
            jsApiTicket = JSON.parseObject(response, WXJsApiTicketBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsApiTicket = null;
        }
        return jsApiTicket;
    }

    // 获取微信JSSDK签名
    public static WXJSSDKSignBean getWXJSSDKSignature(String corpId, String jsapi_ticket, String url) {
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        // 注意这里参数名必须全部小写，且必须有序
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(noncestr).append("&timestamp=").append(timestamp).append("&url=").append(url);
        String string1 = stringBuilder.toString();
        mLogger.info("======>string1 : " + string1);
        String signature = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(string1.getBytes("UTF-8"));
            // Byte2HEX
            Formatter formatter = new Formatter();
            for (byte b : messageDigest.digest()) {
                formatter.format("%02x", b);
            }
            signature = formatter.toString();
            formatter.close();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (signature == null) {
            mLogger.info("======>Get signature failed");
            return null;
        }
        WXJSSDKSignBean wxjssdkSignBean = new WXJSSDKSignBean();
        wxjssdkSignBean.setAppId(corpId);
        wxjssdkSignBean.setNonceStr(noncestr);
        wxjssdkSignBean.setTimestamp(timestamp);
        wxjssdkSignBean.setSignature(signature);
        mLogger.info("======>wxjssdkSignBean : " + wxjssdkSignBean);
        return wxjssdkSignBean;
    }

    // 获取重定向微信请求URL
    public static String getWXRedirectURL(String appId, int agentId, String url, String scope, String state) {
        String redirectURL = null;
        try {
            redirectURL = URLEncoder.encode(url, "UTF-8");
        }
        catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WXApis.API_GET_OAUTH);
        stringBuffer.append(WXApis.P_GET_OAUTH_APPID).append("=").append(appId).append("&");
        stringBuffer.append(WXApis.P_GET_OAUTH_REDIRECT_URI).append("=").append(redirectURL).append("&");
        stringBuffer.append(WXApis.P_GET_OAUTH_RESPONSE_TYPE).append("=").append("code").append("&");
        stringBuffer.append(WXApis.P_GET_OAUTH_SCOPE).append("=").append(scope).append("&");
        if (scope.equals(WXApis.SCOPE_SNSAPI_USERINFO) || scope.equals(WXApis.SCOPE_SNSAPI_PRIVATEINFO)) {
            stringBuffer.append(WXApis.P_GET_OAUTH_AGENTID).append("=").append(agentId).append("&");
        }
        stringBuffer.append(WXApis.P_GET_OAUTH_STATE).append("=").append(state);
        stringBuffer.append(WXApis.P_GET_OAUTH_WECHAT_REDIRECT);
        return stringBuffer.toString();
    }

    // 通过code获取用户信息
    public static WXUserBaseInfoBean getWXUserInfoByCode(String accessToken, String code) {
        WXUserBaseInfoBean wxUserBaseInfoBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_USER_INFO_BY_CODE_ACCESSTOKEN, accessToken);
        params.put(WXApis.P_GET_USER_INFO_BY_CODE_CODE, code);
        String response = httpRequest(WXApis.API_GET_USER_INFO_BY_CODE, HTTP_METHOD_GET, params, null);
        try {
            wxUserBaseInfoBean = JSON.parseObject(response, WXUserBaseInfoBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxUserBaseInfoBean = null;
        }
        return wxUserBaseInfoBean;
    }

    // 获取openId通过userId
    public static WXOpenIdBean getOpenIdByUserId(String accessToken, WXUserIdToOpenIdBean postData) {
        WXOpenIdBean wxOpenIdBean;
        Map<String, String> params = new HashMap<>();
        params.put(WXApis.P_POST_OPENID_BY_USERID_ACCESSTOKEN, accessToken);
        try {
            String response = HttpUtil.httpPostString(WXApis.API_POST_OPENID_BY_USERID, HttpConstants.MIMETYPE_APPLICATION_JSON, postData.toString(), params, null);
            wxOpenIdBean = JSON.parseObject(response, WXOpenIdBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxOpenIdBean = null;
        }
        return wxOpenIdBean;
    }

    // 获取userId通过openId
    public static WXUserIdBean getUserIdByOpenId(String accessToken, WXOpenIdToUserIdBean postData) {
        WXUserIdBean wxUserIdBean;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_POST_USERID_BY_OPENID_ACCESSTOKEN, accessToken);
        try {
            String response = HttpUtil.httpPostString(WXApis.API_POST_USERID_BY_OPENID, HttpConstants.MIMETYPE_APPLICATION_JSON, postData.toString(), params, null);
            wxUserIdBean = JSON.parseObject(response, WXUserIdBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxUserIdBean = null;
        }
        return wxUserIdBean;
    }

    // 通过code获取的user_ticket获取成员信息
    public static WXUserInfoDetailBean getWXUserInfoDetailByCode(String accessToken, String userTicket) {
        WXUserTicket wxUserTicket = new WXUserTicket();
        wxUserTicket.setUser_ticket(userTicket);
        WXUserInfoDetailBean wxUserInfoDetailBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_USER_INFO_DETAIL_BY_CODE_ACCESSTOKEN, accessToken);
        String response = httpRequest(WXApis.API_GET_USER_INFO_DETAIL_BY_CODE, HTTP_METHOD_POST, params, wxUserTicket.toString());
        try {
            wxUserInfoDetailBean = JSON.parseObject(response, WXUserInfoDetailBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxUserInfoDetailBean = null;
        }
        return wxUserInfoDetailBean;
    }

    // 通过通讯录读取成员
    public static WXUserInfoBean getWXUserInfo(String accessToken, String userId) {
        WXUserInfoBean wxUserInfoBean;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_USER_INFO_ACCESSTOKEN, accessToken);
        params.put(WXApis.P_GET_USER_INFO_USERID, userId);
        String response = httpRequest(WXApis.API_GET_USER_INFO, HTTP_METHOD_GET, params, null);
        try {
            wxUserInfoBean = JSON.parseObject(response, WXUserInfoBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxUserInfoBean = null;
        }
        return wxUserInfoBean;
    }

    // 获取部门列表
    public static WXDepartmentBean getWXDepartments(String accessToken, String departmentId) {
        WXDepartmentBean wxDepartmentBean;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_DEPARTMENT_INFO_ACCESSTOKEN, accessToken);
        params.put(WXApis.P_GET_DEPARTMENT_INFO_ID, departmentId);
        String response = httpRequest(WXApis.API_GET_DEPARTMENT_INFO, HTTP_METHOD_GET, params, null);
        try {
            wxDepartmentBean = JSON.parseObject(response, WXDepartmentBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxDepartmentBean = null;
        }
        return wxDepartmentBean;
    }

    // 获取部门成员
    public static WXMembersBean getWXDepartmentMembes(String accessToken, String departmentId, String fetchChild) {
        WXMembersBean wxMembersBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_DEPARTMENT_USER_INFO_ACCESSTOKEN, accessToken);
        params.put(WXApis.P_GET_DEPARTMENT_USER_INFO_DEPARTMENT_ID, departmentId);
        params.put(WXApis.P_GET_DEPARTMENT_USER_INFO_FETCH_CHILD, fetchChild);
        String response = httpRequest(WXApis.API_GET_DEPARTMENT_USER_INFO, HTTP_METHOD_GET, params, null);
        try {
            wxMembersBean = JSON.parseObject(response, WXMembersBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxMembersBean = null;
        }
        return wxMembersBean;
    }

    // 发送消息
    public static WXSendMessageBean sendWXMessage(String accessToken, BaseMessage messageData) {
        String postBody = getMessageData(messageData);
        WXSendMessageBean wxSendMessageBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_SEND_MESSAGE_ACCESSTOKEN, accessToken);
        String response = httpRequest(WXApis.API_SEND_MESSAGE, HTTP_METHOD_POST, params, postBody);
        try {
            wxSendMessageBean = JSON.parseObject(response, WXSendMessageBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxSendMessageBean = null;
        }
        return wxSendMessageBean;
    }

    private static String getMessageData(BaseMessage messageData) {
        String postBody = null;
        if (messageData instanceof WXTextMessageBean) {
            postBody = ((WXTextMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXTextCardMessageBean) {
            postBody = ((WXTextCardMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXNewsMessageBean) {
            postBody = ((WXNewsMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXMpNewsMessageBean) {
            postBody = ((WXMpNewsMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXImageMessageBean) {
            postBody = ((WXImageMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXVoiceMessageBean) {
            postBody = ((WXVoiceMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXVideoMessageBean) {
            postBody = ((WXVideoMessageBean) messageData).toString();
        }
        else if (messageData instanceof WXFileMessageBean) {
            postBody = ((WXFileMessageBean) messageData).toString();
        }
        return postBody;
    }

    // 获取临时素材保存服务器本地
    public static boolean getWXMedia(String accessToken, String mediaId, String filePath, String fileName) {
        String requestUrl = WXApis.API_GET_MEDIA;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_GET_MEDIA_ACCESS_TOKEN, accessToken);
        params.put(WXApis.P_GET_MEDIA_MEDIA_ID, mediaId);
        return httpDownload(requestUrl, params, filePath, fileName);
    }
    // private static String getFileExt(String contentType) {
    // String fileExt = "";
    // if ("image/jpeg".equals(contentType))
    // fileExt = ".jpg";
    // else if ("audio/png".equals(contentType))
    // fileExt = ".png";
    // else if ("audio/mpeg".equals(contentType))
    // fileExt = ".mp3";
    // else if ("audio/amr".equals(contentType))
    // fileExt = ".amr";
    // else if ("video/mp4".equals(contentType))
    // fileExt = ".mp4";
    // else if ("video/mpeg4".equals(contentType))
    // fileExt = ".mp4";
    // return fileExt;
    // }

    // 上传临时素材到微信服务器
    public static WXUploadMediaBean uploadWXMedia(String accessToken, String type, File file) {
        WXUploadMediaBean wxUploadMediaBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.P_UPLOAD_MEDIA_ACCESS_TOKEN, accessToken);
        params.put(WXApis.P_UPLOAD_MEDIA_TYPE, type);
        String response = httpUpload(WXApis.API_UPLOAD_MEDIA, params, file);
        try {
            wxUploadMediaBean = JSON.parseObject(response, WXUploadMediaBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxUploadMediaBean = null;
        }
        return wxUploadMediaBean;
    }

    /**
     * 微信订阅号 获取AccessToken
     *
     * @param appid
     * @param appsecret
     * @return
     */
    public static WXAccessTokenBean getDYHAccessToken(String appid, String appsecret) {
        WXAccessTokenBean wxAccessTokenBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_GET_ACCESSTOKEN_APPID, appid);
        params.put(WXApis.DYH_P_GET_ACCESSTOKEN_SECRET, appsecret);
        String response = httpRequest(WXApis.DYH_API_GET_ACCESSTOKEN, HTTP_METHOD_GET, params, null);
        try {
            wxAccessTokenBean = JSON.parseObject(response, WXAccessTokenBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxAccessTokenBean = null;
        }
        return wxAccessTokenBean;
    }

    /**
     * 上传永久图片素材到微信订阅号
     *
     * @param accessToken
     * @param type
     * @param file
     * @return
     */
    public static WXDYHAddImgBean addImgForDYH(String accessToken, String type, File file) {
        WXDYHAddImgBean wxdyhAddImgBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_MATERIAL_ADD_IMG_ACCESSTOKEN, accessToken);
        params.put(WXApis.DYH_P_MATERIAL_ADD_IMG_TYPE, type);
        String response = httpUpload(WXApis.DYH_API_MATERIAL_ADD_IMG, params, file);
        try {
            wxdyhAddImgBean = JSON.parseObject(response, WXDYHAddImgBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            if (null == file){
                mLogger.info("->->->微信上传永久图片素材到微信订阅号失败:/n，文件不存在",e);
            } else {
                mLogger.info("->->->微信上传永久图片素材到微信订阅号失败:/n[file:"+JSON.toJSONString(file.getPath())+"][accessToken"+accessToken+"]",e);
            }
            wxdyhAddImgBean = null;
        }
        return wxdyhAddImgBean;
    }

    /**
     * 上传图文消息内的图片获取URL
     *
     * @param accessToken
     * @param type
     * @param file
     * @return
     */
    public static WXDYHAddArticleInnerIMgBean addArticleInnerImgForDYH(String accessToken, String type, File file) {
        WXDYHAddArticleInnerIMgBean wxdyhAddArticleInnerIMgBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_MATERIAL_ADD_ARTICLEIMG_ACCESSTOKEN, accessToken);
        String response = httpUpload(WXApis.DYH_API_MATERIAL_ADD_ARTICLEIMG, params, file);
        try {
            wxdyhAddArticleInnerIMgBean = JSON.parseObject(response, WXDYHAddArticleInnerIMgBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            if (null == file){
                mLogger.info("->->->微信上传图文内图片失败:/n，文件不存在",e);
            } else {
                mLogger.info("->->->微信上传图文内图片失败:/n[file:"+JSON.toJSONString(file.getPath())+"][accessToken"+accessToken+"]",e);
            }
            wxdyhAddArticleInnerIMgBean = null;
        }
        return wxdyhAddArticleInnerIMgBean;
    }

    /**
     * 新增永久图文素材
     *
     * @param accessToken
     * @param wxdyhArticlesBean
     * @return
     */
    public static WXDYHAddArticlesBean addArticlesForDYH(String accessToken, WXDYHArticlesBean wxdyhArticlesBean) {
        WXDYHAddArticlesBean wxdyhAddArticlesBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_MATERIAL_ADD_ARTICLE_ACCESSTOKEN, accessToken);
        String response = httpRequest(WXApis.DYH_API_MATERIAL_ADD_ARTICLE, HTTP_METHOD_POST, params, wxdyhArticlesBean.toString());
        try {
            wxdyhAddArticlesBean = JSON.parseObject(response, WXDYHAddArticlesBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            mLogger.info("->->->微信新增永久素材失败:/n[wxdyhArticlesBean:"+JSON.toJSONString(wxdyhArticlesBean)+"][accessToken"+accessToken+"]",e);
            wxdyhAddArticlesBean = null;
        }
        return wxdyhAddArticlesBean;
    }

    /**
     * 根据标签进行群发图文消息
     *
     * @param accessToken
     * @param wxdyhArticleSendallBean
     * @return
     */
    public static WXDYHSendArticlesBean sendArticlesByDyhTagid(String accessToken,
            WXDYHArticleSendallBean wxdyhArticleSendallBean) {
        WXDYHSendArticlesBean wxdyhSendArticlesBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_MESSAGE_SENDALL_ACCESSTOKEN, accessToken);
        String response = httpRequest(WXApis.DYH_API_MESSAGE_SENDALL, HTTP_METHOD_POST, params, wxdyhArticleSendallBean.toString());
        try {
            wxdyhSendArticlesBean = JSON.parseObject(response, WXDYHSendArticlesBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            mLogger.info("->->->微信群发失败:/n[wxdyhArticleSendallBean:"+JSON.toJSONString(wxdyhArticleSendallBean)+"][accessToken"+accessToken+"]",e);
            wxdyhSendArticlesBean = null;
        }
        return wxdyhSendArticlesBean;
    }

    /**
     * 获取公众号已创建的标签
     *
     * @param accessToken
     * @return
     */
    public static WXDYHUserTagsBean getDYHUserTags(String accessToken) {
        WXDYHUserTagsBean wxdyhUserTagsBean = null;
        HashMap<String, String> params = new HashMap<>();
        params.put(WXApis.DYH_P_USER_GETTAGS_ACCESSTOKEN, accessToken);
        String response = httpRequest(WXApis.DYH_API_USER_GETTAGS, HTTP_METHOD_GET, params, null);
        try {
            wxdyhUserTagsBean = JSON.parseObject(response, WXDYHUserTagsBean.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            wxdyhUserTagsBean = null;
        }
        return wxdyhUserTagsBean;
    }
}
