package com.ligw.demo.util.wxpay.message;

import com.alibaba.fastjson.JSON;

/**
 * Description: Base WXPay Massage
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-11-10
 */
public class BaseWXPayMessage {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
