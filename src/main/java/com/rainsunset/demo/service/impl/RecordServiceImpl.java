package com.rainsunset.demo.service.impl;

import com.rainsunset.common.bean.GlobalException;
import com.rainsunset.common.bean.ResponseResult;
import com.rainsunset.common.bean.ResponseGenerator;
import com.rainsunset.demo.constant.GlobalErrorInfoEnum;
import com.rainsunset.demo.dal.mapper.RecordMapper;
import com.rainsunset.demo.dal.model.Record;
import com.rainsunset.demo.service.RecordService;
import com.rainsunset.demo.service.request.RecordBatchDelReqDTO;
import com.rainsunset.demo.service.request.RecordDetailReqDTO;
import com.rainsunset.demo.service.request.RecordListReqDTO;
import com.rainsunset.demo.service.request.RecordReqDTO;
import com.rainsunset.demo.service.response.RecordResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;


 /**
  * @Description: Record 表 接口实现
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 17:58:48
  * @Version : 1.0-SNAPSHOT
  */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public ResponseResult<List<RecordResDTO>> selectRecordList(RecordListReqDTO recordListReqDTO){
        String userId = recordListReqDTO.getUserId();
        Integer num = recordListReqDTO.getNum();
        List<Record> recordList = recordMapper.selectRecordList(
        userId, num
        );
        if (CollectionUtils.isEmpty(recordList)) {
            return null;
        }
        List<RecordResDTO> recordResDTOList = new LinkedList<RecordResDTO>();
        for (int i = 0; i < recordList.size(); i++) {
            RecordResDTO recordResDTO = recordDO2ResDTO(recordList.get(i));
            if (null == recordResDTO) {
                continue;
            }
            recordResDTOList.add(recordResDTO);
        }
        return ResponseGenerator.genResult(recordResDTOList);
    }

    @Override
    public ResponseResult<RecordResDTO> getRecordDetail(RecordDetailReqDTO recordDetailReqDTO){
        Integer recordId= recordDetailReqDTO.getRecordId();
        if (null == recordId) {
            throw new GlobalException(GlobalErrorInfoEnum.DEMOEC_412000);
        }
        Record record = recordMapper.getRecordDetail(recordId);
        RecordResDTO recordResDTO = recordDO2ResDTO(record);
        return ResponseGenerator.genResult(recordResDTO);
    }

    @Override
    public ResponseResult<Integer> addOrUpdateRecord(RecordReqDTO recordReqDTO){
        Record record = recordReqDTO2DO(recordReqDTO);
        if (null == record){
            throw new GlobalException(GlobalErrorInfoEnum.DEMOEC_415000);
        }
        // 检查参数
        if(null == record.getRecordId()){
            recordMapper.fullInsertRecord(record);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } else {
            recordMapper.updateRecord(record);
        }
        Integer tabPrikeySmallCamel= record.getRecordId();
        return ResponseGenerator.genResult(tabPrikeySmallCamel);
    }

    @Override
    public ResponseResult<Integer> deleteRecords(RecordBatchDelReqDTO recordBatchDelReqDTO){
        Integer[] recordIdArray = recordBatchDelReqDTO.getRecordIdArray();
        if (null == recordIdArray || 0 == recordIdArray.length) {
             throw new GlobalException(GlobalErrorInfoEnum.DEMOEC_415000);
         }
        String updatedBy = recordBatchDelReqDTO.getUpdatedBy();
        Integer rows = recordMapper.deleteRecords(recordIdArray,updatedBy);
        return ResponseGenerator.genResult(rows);
    }

     @Override
     @Transactional
     public ResponseResult<Integer> transactionTest(RecordReqDTO recordReqDTO) {
         recordMapper.fullInsertRecord(new Record(null, recordReqDTO.getUserId(), recordReqDTO.getNum()));
         throw new GlobalException(GlobalErrorInfoEnum.DEMOEC_500000);
     }

     /**
     * 对象转换 Record  DO  -> ResDTO
     *
     * @param record
     * @return
     */
    private RecordResDTO recordDO2ResDTO(Record record){
        RecordResDTO recordResDTO = new RecordResDTO(
        record.getRecordId(), 
            record.getUserId(), record.getNum()
        );
        return recordResDTO;
    }

    /**
     * 对象转换 Record  ReqDTO  -> DO
     *
     * @param recordReqDTO
     * @return
     */
    private Record recordReqDTO2DO(RecordReqDTO recordReqDTO){
        Record record = new Record();
        record.setUserId(recordReqDTO.getUserId());
        record.setNum(recordReqDTO.getNum());
        return record;
    }
}
