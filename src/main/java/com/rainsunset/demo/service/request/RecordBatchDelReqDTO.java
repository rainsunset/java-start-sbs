package com.rainsunset.demo.service.request;

import com.cmbi.demo.service.request.base.BaseRequest;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
 /**
  * @Description: 批量删除Record 表请求体
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
public class RecordBatchDelReqDTO extends BaseRequest {

    /** 待删除记录Id数组 */
    @NotNull(message = "待删除记录Id数组不能为空")
    private Integer[]  recordIds;

    /** 更新人 必传 */
    @NotBlank(message = "更新人不能为空")
    private String updatedBy;

}



