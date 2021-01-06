package com.ligw.demo.service;

import com.github.pagehelper.PageInfo;
import com.ligw.demo.model.Record;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface RecordService {

    /**
     * 添加 Record 表
     * @param record
     */
    public void  addRecord(Record record);

    /**
     * 依据主键更新 Record 表
     * @param record
     */
    public void  updateRecordById(Record record);

    /**
     * 依据条件查找 Record 表 列表
     * @param param
     * @return
     */
    public List<Record> selectRecordList(Map<String, Object> param);

    /**
     * 依据条件查找分页 Record 表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Record> getRecordPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 Record 表 详情
     * @param recordId
     * @return
     */
    public Record getRecordById(Integer recordId);

    /**
     * 依据Id删除 Record 表 记录
     * @param recordId
     */
    public void delRecordById(Integer recordId);
}
