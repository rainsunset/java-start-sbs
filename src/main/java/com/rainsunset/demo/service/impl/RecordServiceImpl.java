package com.rainsunset.demo.service.impl;

import com.rainsunset.common.bean.GlobalErrorInfoException;
import com.rainsunset.common.bean.ResponseResult;
import com.rainsunset.common.bean.RestResultGenerator;
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
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;


 /**
  * @Description: Record 表 接口实现
  * @Author: ligangwei
  * @Company rainsunset
  * @CreateDate: 2020-03-15 15:21:01
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
        return RestResultGenerator.genResult(recordResDTOList);
    }

    @Override
    public ResponseResult<RecordResDTO> getRecordDetail(RecordDetailReqDTO recordDetailReqDTO){
        Integer recordId= recordDetailReqDTO.getRecordId();
        if (null == recordId) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.DEMOEC_412000);
        }
        Record record = recordMapper.getRecordDetail(recordId);
        RecordResDTO recordResDTO = recordDO2ResDTO(record);
        return RestResultGenerator.genResult(recordResDTO);
    }

    @Override
    public ResponseResult<Integer> addOrUpdateRecord(RecordReqDTO recordReqDTO){
        Record record = recordReqDTO2DO(recordReqDTO);
        if (null == record){
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.DEMOEC_415000);
        }
        // 检查参数
        if(null == record.getRecordId()){
            recordMapper.fullInsertRecord(record);
        } else {
            recordMapper.updateRecord(record);
        }
        Integer tabPrikeySmallCamel= record.getRecordId();
        return RestResultGenerator.genResult(tabPrikeySmallCamel);
    }

    @Override
    public ResponseResult<Integer> deleteRecords(RecordBatchDelReqDTO recordBatchDelReqDTO){
        Integer[] recordIds = recordBatchDelReqDTO.getRecordIds();
        if (null == recordIds || 0 == recordIds.length) {
             throw new GlobalErrorInfoException(GlobalErrorInfoEnum.DEMOEC_415000);
         }
        String updatedBy = recordBatchDelReqDTO.getUpdatedBy();
        Integer rows = recordMapper.deleteRecords(recordIds,updatedBy);
        return RestResultGenerator.genResult(rows);
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
