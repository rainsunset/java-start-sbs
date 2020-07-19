package com.rainsunset.demo.service.request;

import com.rainsunset.common.bean.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

 /**
  * @Description: 查询Record表详情请求体
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 17:58:48
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
@ApiModel(description = "查询Record表详情请求体")
public class RecordDetailReqDTO extends BaseRequest {

    @ApiModelProperty(value = "记录Id")
    @NotBlank(message = "记录Id不能为空")
    private Integer recordId;

}



