package com.rainsunset.demo.service.request;

import com.cmbi.demo.service.request.base.BaseRequest;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

 /**
  * @Description: Record 表 Model
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
public class RecordReqDTO extends BaseRequest {

    /** 记录Id */
    private Integer  recordId;

    /** 用户Id */
    @NotBlank(message = "用户Id不能为空")
    private String userId;

    /** 记录值 */
    @NotBlank(message = "记录值不能为空")
    private Integer num;

}



