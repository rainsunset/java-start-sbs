package com.rainsunset.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码
 *
 * @author ChenYanRui
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    /*
     * 200，成功
     * 201，已存在
     * 401，未授权
     * 403，禁止
     * 404，不存在
     * 405，状态异常
     * 412，前提条件失败
     * 415，格式错
     * 500，内部错误
     */

    //415 格式错
    /**
     * 请求参数有误
     */
    ERROR_400001("ERROR_400001", "请求参数有误"),
    /**
     * 请求方式有误
     */
    ERROR_405001("ERROR_405001", "请求方式有误"),
    /**
     * 请求类型有误
     */
    ERROR_415001("ERROR_415001", "请求类型有误"),

    //500 内部错误
    /**
     * 数据库异常
     */
    ERROR_500001("ERROR_500001", "数据库异常"),
    /**
     * 系统忙，请稍后再试
     */
    ERROR_500002("ERROR_500002", "系统忙，请稍后再试")

    ;

    private final String code;
    private final String desc;

}
