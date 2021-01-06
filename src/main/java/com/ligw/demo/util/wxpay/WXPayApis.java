package com.ligw.demo.util.wxpay;

/**
 * Description: WXPayApis
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-06
 */
public class WXPayApis {
    //域名
    public static final String DOMAIN_API = "https://test.mch.weixin.qq.com";
    public static final String DOMAIN_API2 = "https://api2.mch.weixin.qq.com";
    public static final String DOMAIN_APIHK = "https://apihk.mch.weixin.qq.com";
    public static final String DOMAIN_APIUS = "https://apius.mch.weixin.qq.com";

    //统一下单
    public static final String URL_SUFFIX_UNIFIEDORDER = "/pay/unifiedorder";
    //订单查询
    public static final String URL_SUFFIX_ORDERQUERY = "/pay/orderquery";
    //关闭订单
    public static final String URL_SUFFIX_CLOSEORDER = "/pay/closeorder";
    //申请退款
    public static final String URL_SUFFIX_REFUND = "/secapi/pay/refund";
    //查询退款
    public static final String URL_SUFFIX_REFUNDQUERY = "/pay/refundquery";
    //下载对账单
    public static final String URL_SUFFIX_DOWNLOADBILL = "/pay/downloadbill";
    //交易保障
    public static final String URL_SUFFIX_REPORT = "/payitil/report";

    public static final String URL_SUFFIX_REVERSE = "/secapi/pay/reverse";
    public static final String URL_SUFFIX_MICROPAY     = "/pay/micropay";
    public static final String URL_SUFFIX_SHORTURL     = "/tools/shorturl";
    public static final String URL_SUFFIX_AUTHCODETOOPENID = "/tools/authcodetoopenid";

    // sandbox
    public static final String URL_SUFFIX_SANDBOX_MICROPAY     = "/sandboxnew/pay/micropay";
    public static final String URL_SUFFIX_SANDBOX_UNIFIEDORDER = "/sandboxnew/pay/unifiedorder";
    public static final String URL_SUFFIX_SANDBOX_ORDERQUERY   = "/sandboxnew/pay/orderquery";
    public static final String URL_SUFFIX_SANDBOX_REVERSE      = "/sandboxnew/secapi/pay/reverse";
    public static final String URL_SUFFIX_SANDBOX_CLOSEORDER   = "/sandboxnew/pay/closeorder";
    public static final String URL_SUFFIX_SANDBOX_REFUND       = "/sandboxnew/secapi/pay/refund";
    public static final String URL_SUFFIX_SANDBOX_REFUNDQUERY  = "/sandboxnew/pay/refundquery";
    public static final String URL_SUFFIX_SANDBOX_DOWNLOADBILL = "/sandboxnew/pay/downloadbill";
    public static final String URL_SUFFIX_SANDBOX_REPORT       = "/sandboxnew/payitil/report";
    public static final String URL_SUFFIX_SANDBOX_SHORTURL     = "/sandboxnew/tools/shorturl";
    public static final String URL_SUFFIX_SANDBOX_AUTHCODETOOPENID = "/sandboxnew/tools/authcodetoopenid";
}
