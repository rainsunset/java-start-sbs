package com.ligw.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Record.java, 2018-08-23 11:43:03 wuhaosoft Exp
 *
 */
@ApiModel(description = "Record 表")
public class Record {

    @ApiModelProperty(value = "")
    private Integer  recordId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "记录值")
    private Integer num;

    public Record(){}

    public Record(
        Integer  recordId,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }
    public Integer getRecordId(){
        return recordId;
    }

    public void setRecordId(Integer  recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String  userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer  num) {
        this.num = num;
    }

}



