package com.rainsunset.demo.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

 /**
  * @Description: Record 表 Model
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
  * @Version : 1.0-SNAPSHOT
  */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordResDTO implements Serializable {

    /** 记录Id */
    private Integer  recordId;

    /** 用户Id */
    private String userId;

    /** 记录值 */
    private Integer num;

}



