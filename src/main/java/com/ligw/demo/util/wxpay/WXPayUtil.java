package com.ligw.demo.util.wxpay;

import com.ligw.demo.util.XmlUtil;
import com.ligw.demo.util.http.HttpUtil;
import org.apache.log4j.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Description: WXPayUtil
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-06
 */
public class WXPayUtil {
    public final static String CODE_SUCCESS = "SUCCESS";
    public final static String CODE_FAILED = "FAIL";

    private final static Logger mLogger = Logger.getLogger(WXPayUtil.class);
    private final static String DEFAULT_ROOT_NAME = "xml";


    //region 通用方法
    /**
     * 生成32位随机字符串nonceStr
     * @return String
     */
    public static String getNonceString(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    /**
     * 生成系统时间戳
     * @return String
     */
    public static String getTimeStamp(){
        String timeStamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        return timeStamp.substring(0, timeStamp.length() -3);
    }

    /**
     * 获取16位商户订单号(时间戳 + 6位随机数)
     * @return String
     */
    public static String getMchOrderId(){
        return getTimeStamp() + String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    /**
     * 生成MD5签名字符串
     * @param data 加密字符串
     * @return String
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String getWXPaySignatureByMD5(String data) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
//        mLogger.info("WXPay======>MD5 Sign:" + sb.toString().toUpperCase());
        return sb.toString().toUpperCase();
    }

    /**
     * 生成HmacSHA256签名
     * @param data 加密字符串
     * @param apiKey API密钥
     * @return String
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String getWXPaySignatureByHMACSHA256(String data, String apiKey) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(apiKey.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
//        mLogger.info("WXPay======>:HMACSHA256 Sign:" + sb.toString().toUpperCase());
        return sb.toString().toUpperCase();
    }

    /**
     * 获取微信支付签名
     * @param dataMap dataMap
     * @param apiKey API密钥
     * @param signType 签名类型
     * @return String
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String getWXPaySignature(Map<String, String> dataMap, String apiKey, WXPayConstants.SignType signType) throws
            UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        if (dataMap == null || dataMap.size() == 0 || apiKey == null || apiKey.equals("")) {
            throw new RuntimeException("Invalid data parameters");
        }
        Set<String> dataKeySet = dataMap.keySet();
        String[] keyArray = dataKeySet.toArray(new String[dataKeySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : keyArray) {
            if (key.equals("sign")){
                continue;
            }
            if (dataMap.get(key).trim().length() > 0) {
                stringBuilder.append(key).append("=").append(dataMap.get(key).trim()).append("&");
            }
        }
        stringBuilder.append("key=").append(apiKey);
//        mLogger.info("WXPay======>ASCII String:" + stringBuilder.toString());
        String signature = null;
        if (signType == WXPayConstants.SignType.MD5){
            signature = getWXPaySignatureByMD5(stringBuilder.toString());
        } else if(signType == WXPayConstants.SignType.HMACSHA256) {
            signature = getWXPaySignatureByHMACSHA256(stringBuilder.toString(), apiKey);
        }
        if (signature == null) {
            throw new RuntimeException("Get signature failed");
        }
        return signature;
    }

    /**
     * 微信支付请求(不带证书)
     * @param url url
     * @param dataMap XML数据哈希
     * @return
     */
    public static Map<String, String> wxPayRequest(String url, Map<String, String> dataMap){
        mLogger.info("======>requestUrl:" + url);
        String requestBody = XmlUtil.createXMLStringByMap(dataMap, DEFAULT_ROOT_NAME);
        mLogger.info("======>requestBody:" + requestBody);

        Map<String, String> respMap = null;
        try {
            String response = HttpUtil.httpPostString(url, "text/xml", requestBody);
            if (response == null || response.equals(""))
                return null;
            respMap = XmlUtil.parseXMLToMap(response);
            mLogger.info("======>response:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respMap;
    }
    //endregion

    /**
     * 统一下单
     * @param dataMap 请求数据
     * @return Map
     */
    public static Map<String, String> wxPayUnifiedorder(Map<String, String> dataMap){
        String requestUrl = WXPayApis.DOMAIN_API + WXPayApis.URL_SUFFIX_UNIFIEDORDER;
        if (dataMap == null || dataMap.size() == 0)
            return null;
        return wxPayRequest(requestUrl, dataMap);
    }

    /**
     * 查询订单
     * @param dataMap 请求数据
     * @return Map
     */
    public static Map<String, String> wxPayOrderQuery(Map<String, String> dataMap){
        String requestUrl = WXPayApis.DOMAIN_API + WXPayApis.URL_SUFFIX_ORDERQUERY;
        if (dataMap == null || dataMap.size() == 0)
            return null;
        return wxPayRequest(requestUrl, dataMap);
    }

    /**
     * 关闭订单
     * @param dataMap 请求数据
     * @return Map
     */
    public static Map<String, String> wxPayCloseOrder(Map<String, String> dataMap){
        String requestUrl = WXPayApis.DOMAIN_API + WXPayApis.URL_SUFFIX_CLOSEORDER;
        if (dataMap == null || dataMap.size() == 0)
            return null;
        return wxPayRequest(requestUrl, dataMap);
    }


    //申请退款
    public static void wxPayRefund(){}
    //查询退款
    public static void wxPayRefundquery(){}
    //下载对账单
    public static void wxPayDownloadBill(){}
    //支付结果通知
    public static void wxPayUnifiedorderNotification(){}
    //交易保障
    public static void wxPayReport(){}
    //退款结果通知
    public static void wxPayRefundNotification(){}
    //拉取订单评价数据
    public static void wxBatchQueryComment(){}
}
