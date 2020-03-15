package com.rainsunset.demo.service.request;

import com.cmbi.demo.service.request.base.BaseRequest;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

 /**
  * @Description: 查询Record 表详情请求体
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
public class RecordDetailReqDTO extends BaseRequest {

    /** 记录Id */
    @NotBlank(message = "记录Id不能为空")
    private Integer  recordId;

}



