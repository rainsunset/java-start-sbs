package com.ligw.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Count.java, 2018-08-23 11:43:03 wuhaosoft Exp
 *
 */
@ApiModel(description = "count 表")
public class Count {

    @ApiModelProperty(value = "")
    private String  userId;

    @ApiModelProperty(value = "用户记录值总和")
    private Integer numCount;

    public Count(){}

    public Count(
        String  userId,
        Integer numCount
    ) {
        this.numCount = numCount;
    }
    public String getUserId(){
        return userId;
    }

    public void setUserId(String  userId) {
        this.userId = userId;
    }

    public Integer getNumCount() {
        return numCount;
    }

    public void setNumCount(Integer  numCount) {
        this.numCount = numCount;
    }

}



