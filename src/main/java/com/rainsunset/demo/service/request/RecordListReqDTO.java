package com.rainsunset.demo.service.request;

import com.cmbi.demo.service.request.base.BaseRequest;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

 /**
  * @Description: 查询Record 表列表请求体
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
  * @Version : 1.0-SNAPSHOT
  */
@Data
@ToString(callSuper = true)
public class RecordListReqDTO extends BaseRequest {

    /** 记录Id */
    private Integer  recordId;

    /** 用户Id */
    private String userId;

    /** 记录值 */
    private Integer num;

}



