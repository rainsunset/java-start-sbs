package com.rainsunset.demo.service.request;

import com.rainsunset.common.bean.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
 /**
  * @Description: 批量删除Record表请求体
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 17:58:48
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
@ApiModel(description = "批量删除Record表请求体")
public class RecordBatchDelReqDTO extends BaseRequest {

    @ApiModelProperty(value = "待删除记录Id数组")
    @NotNull(message = "待删除记录Id数组不能为空")
    private Integer[] recordIdArray;

    @ApiModelProperty(value = "更新人 必传")
    @NotBlank(message = "更新人不能为空")
    private String updatedBy;

}



