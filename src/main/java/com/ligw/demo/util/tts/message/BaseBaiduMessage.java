package com.ligw.demo.util.tts.message;

import com.alibaba.fastjson.JSON;

/**
 * Description: BaseBaiduMessage
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-04
 */
public class BaseBaiduMessage {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
