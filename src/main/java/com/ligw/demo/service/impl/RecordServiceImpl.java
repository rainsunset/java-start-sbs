package com.ligw.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ligw.demo.mapper.RecordMapper;
import com.ligw.demo.model.Record;
import com.ligw.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author whaosoft
 *
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void  addRecord(Record record) {
        recordMapper.addRecord(record);
    }

    @Override
    public void  updateRecordById(Record record) {
        recordMapper.updateRecordById(record);
    }

    @Override
    public List<Record> selectRecordList(Map<String, Object> param) {
        return recordMapper.selectRecordList(param);
    }

    @Override
    public PageInfo<Record> getRecordPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Record> recordList = recordMapper.selectRecordList(param);
        PageInfo<Record> pageInfo = new PageInfo<Record>(recordList);
        return pageInfo;
    }

    @Override
    public Record getRecordById(Integer recordId) {
        Record recordinfo = new Record();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("recordId", recordId);
        List<Record> recordList = recordMapper.selectRecordList(rs);
        if ((null != recordList) && (recordList.size() > 0)) {
            recordinfo = recordList.get(0);
        }
        return recordinfo;
    }

    @Override
    public void delRecordById(Integer recordId) {

     //Record record = new Record();
     //record.setIsDeleted(1);
     //record.setRecordId(recordId);
     //recordMapper.updateRecordById(record);

        recordMapper.delRecordById(recordId);

    }

}
