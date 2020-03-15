package com.rainsunset.demo.dal.mapper;

import com.rainsunset.demo.dal.model.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: Record 表 Mapper
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2020-03-15 15:21:01
 * @Version : 1.0-SNAPSHOT
 */
@Repository
public interface RecordMapper {

    /**
     * 依据条件查找 Record 表 列表
     *
     * @param userId
     * @param num
     * @return
     */
    public List<Record> selectRecordList(
        @Param("userId")String userId, @Param("num")Integer num
    );

    /**
     * 依据Id查找 Record 表 详情
     *
     * @param recordId
     * @return
     */
    public Record getRecordDetail(@Param("recordId")Integer recordId);

    /**
     * 全量插入 Record 表
     *
     * @param record
     */
    public Integer fullInsertRecord(Record record);

    /**
     * 依据主键更新 Record 表
     *
     * @param record
     */
    public Integer updateRecord(Record record);

    /**
     * 依据主键删除 Record 表 记录
     *
     * @param recordIds
     * @param updatedBy
     */
    public Integer deleteRecords(@Param("recordIds") Integer[] recordIds,
                                            @Param("updatedBy") String updatedBy);
}
