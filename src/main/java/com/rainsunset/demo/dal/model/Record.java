package com.rainsunset.demo.dal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: Record 表 Model
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2020-03-15 15:21:01
 * @Version : 1.0-SNAPSHOT
 */
@Data
@ApiModel(description = "Record 表")
public class Record {

    @ApiModelProperty(value = "记录Id")
    private Integer recordId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "记录值")
    private Integer num;

}



