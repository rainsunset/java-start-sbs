/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.ligw.demo.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ligw.demo.exception.ErrorInfoInterface;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ligw
 * @version $Id ResponseResult.java, v 0.1 2018-08-22 1:16 ligw Exp $$
 */
@ApiModel(description = "标准接口返回对象")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {

    @ApiModelProperty(value = "业务成功/失败")
    private boolean success;

    @ApiModelProperty(value = "message")
    private String message;

    @ApiModelProperty(value = "业务返回对象")
    private T data;

    @ApiModelProperty(value = "错误码")
    private String errorcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public ResponseResult() {
    }

    public ResponseResult(ErrorInfoInterface errorInfo) {
        this.setSuccess(false);
        this.setErrorcode(errorInfo.getCode());
        this.setMessage(errorInfo.getMessage());
    }
}
