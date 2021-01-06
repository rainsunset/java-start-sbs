package com.ligw.demo.util.wxpay;

/**
 * Description: WXPayConstants
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-06
 */
public class WXPayConstants {
    //签名类型
    public enum SignType {
        MD5("MD5"), HMACSHA256("HMAC-SHA256");

        private String signType;

        SignType(String signType) {
            this.signType = signType;
        }

        public String getSignType() {
            return signType;
        }
    }

}
