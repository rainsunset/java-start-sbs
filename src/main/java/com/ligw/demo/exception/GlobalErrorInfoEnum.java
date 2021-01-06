/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.ligw.demo.exception;

/**
 * @author ligw
 * @version $Id GlobalErrorInfoEnum.java, v 0.1 2018-08-22 1:03 ligw Exp $$
 */
public enum GlobalErrorInfoEnum implements ErrorInfoInterface{

    //regain
    // 全局系统异常 占用范围-999 -- 1000
    TOKEN_ERROR("-102","登录信息不存在或已在异地登录"),
    TOKEN_ERROR_NULL("-101","登录信息不存在"),
    SUCCESS("0", "success"),
    NOT_FOUND("-1", "service not found"),
    SYSTEM_Branch_Error_SWITCH("-3","该校区无权限") ,
    SYSTEM_Branch_Error("-3","当前校区不正确") ,
    SYSTEM_NO_Permission("-2","无权限") ,
    SYSTEM_ERROR("-100","系统异常") ,
    SYSTEM_NO_ROLE("-4","校区没有此角色") ,
    PARAME_EXCEPTION("999","参数异常"),
    //endregain

    ;

    private String code;

    private String message;

    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String ... msgs){
        for(String msg:msgs){
            this.message=this.message.replaceFirst("#",msg);
        }
    }

    @Override public String getCode(){
        return this.code;
    }

    @Override public String getMessage(){
        return this.message;
    }

    public static GlobalErrorInfoEnum getResponseMsg(String code){
        for(GlobalErrorInfoEnum responseInfo:GlobalErrorInfoEnum.values()){
            if(code.equals(responseInfo.getCode())){
                return responseInfo;
            }
        }
        return SYSTEM_ERROR;
    }

}
