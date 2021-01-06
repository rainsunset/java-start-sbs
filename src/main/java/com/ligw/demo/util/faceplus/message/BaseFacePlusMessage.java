package com.ligw.demo.util.faceplus.message;

import com.alibaba.fastjson.JSON;

/**
 * Description: BaseFacePlusMessage
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class BaseFacePlusMessage {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
