package com.rainsunset.demo.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Record 表 Model
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2020-03-15 17:58:48
 * @Version : 1.0-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    /**
     * 记录Id
     */
    private Integer recordId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 记录值
     */
    private Integer num;

}



