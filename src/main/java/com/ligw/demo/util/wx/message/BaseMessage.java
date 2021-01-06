package com.ligw.demo.util.wx.message;

import com.alibaba.fastjson.JSON;

/**
 * Description: Base Message
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class BaseMessage {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
