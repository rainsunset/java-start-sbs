package com.rainsunset.demo.service.request;

import com.rainsunset.common.bean.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
  * @Description: Record表Model
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 17:58:48
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
@ApiModel(description = "Record表Model")
public class RecordReqDTO extends BaseRequest {

    @ApiModelProperty(value = "记录Id")
    private Integer recordId;

    @ApiModelProperty(value = "用户Id")
    @NotBlank(message = "用户Id不能为空")
    private String userId;

    @ApiModelProperty(value = "记录值")
    @NotNull(message = "记录值不能为空")
    private Integer num;

}



