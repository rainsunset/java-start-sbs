package com.rainsunset.demo.service;

import com.rainsunset.common.bean.ResponseResult;
import com.rainsunset.demo.service.request.RecordBatchDelReqDTO;
import com.rainsunset.demo.service.request.RecordDetailReqDTO;
import com.rainsunset.demo.service.request.RecordListReqDTO;
import com.rainsunset.demo.service.request.RecordReqDTO;
import com.rainsunset.demo.service.response.RecordResDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: Record 表 接口
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2020-03-15 17:58:48
 * @Version : 1.0-SNAPSHOT
 */
public interface RecordService {

    /**
     * 依据条件查找 Record 表 列表
     *
     * @param recordListReqDTO
     * @return
     */
    public ResponseResult<List<RecordResDTO>> selectRecordList(RecordListReqDTO recordListReqDTO);

    /**
     * 依据Id查找 Record 表 详情
     *
     * @param recordDetailReqDTO
     * @return
     */
    public ResponseResult<RecordResDTO> getRecordDetail(RecordDetailReqDTO recordDetailReqDTO);

    /**
     * 新增或更新 Record 表
     *
     * @param recordReqDTO
     */
    public ResponseResult<Integer> addOrUpdateRecord(RecordReqDTO recordReqDTO);

    /**
     * 依据Id批量删除 Record 表 记录
     *
     * @param recordBatchDelReqDTO 待删除记录Id数组
     */
    public ResponseResult<Integer> deleteRecords(RecordBatchDelReqDTO recordBatchDelReqDTO);

    /**
     *
     * @param recordReqDTO
     * @return
     */
    ResponseResult<Integer> transactionTest(@RequestBody RecordReqDTO recordReqDTO);
}
