package com.ligw.demo.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.ligw.demo.model.Record;
import com.ligw.demo.service.RecordService;
import com.ligw.demo.view.ResponseResult;
import com.ligw.demo.view.RestResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wuhaosoft
 * @version $Id RecordController.java, 2018-08-23 11:43:03 wuhaosoft Exp
 *
 */
@Api(tags = "Record 表接口")
@RestController
@RequestMapping("/demo")
public class RecordController{

    @Autowired
    private RecordService recordService;

    @ApiOperation("查询 所有 Record 表 分页")
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public ResponseResult<PageInfo<Record>> getRecordPageTurn(
            @ApiParam(value = "用户Id (非必传参数)") @RequestParam(required = false) String userId,
            @ApiParam(value = "记录值 (非必传参数)") @RequestParam(required = false) Integer num,
            @ApiParam(value = "页码(必传)") @RequestParam Integer pageNo,
            @ApiParam(value = "每页显示多少数据(必传)") @RequestParam Integer pageSize) throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(userId)) {
           rs.put("userId", "%" + userId + "%");
        }
        if (null != num) {
           rs.put("num", num);
        }
        PageInfo<Record> pageInfo = recordService.getRecordPageTurn(rs, pageNo, pageSize);
        return RestResultGenerator.genResult(pageInfo);
    }

    @ApiOperation("查询 所有 Record 表")
    @RequestMapping(value = "/allRecords", method = RequestMethod.POST)
    public ResponseResult<List<Record>> selectRecordList(
        @ApiParam(value = "用户Id (非必传参数)") @RequestParam(required = false) String userId,
        @ApiParam(value = "记录值 (非必传参数)") @RequestParam(required = false) Integer num
        )throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
         if (StringUtil.isNotEmpty(userId)) {
            rs.put("userId", "%" + userId + "%");
         }
        if (null != num) {
            rs.put("num", num);
        }
        List<Record> recordList = recordService.selectRecordList(rs);
        return RestResultGenerator.genResult(recordList);
    }

    @ApiOperation("新增 Record 表")
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public ResponseResult<String> addRecord(
                @ApiParam(value = "用户Id (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "记录值 (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        Record record = new Record();
        if (StringUtil.isNotEmpty(userId)) {
           record.setUserId(userId);
        }
        if (null != num) {
            record.setNum(num);
        }
        //record.setCreatedDate(new Date());
        recordService.addRecord(record);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("更新 Record 表")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.PUT)
    public ResponseResult<String> updateRecordById(
            @ApiParam(value = " (必传参数)") @PathVariable Integer  recordId,
             @ApiParam(value = "用户Id (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "记录值 (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        Record record = new Record();
        record.setRecordId(recordId);

         if (StringUtil.isNotEmpty(userId)) {
            record.setUserId(userId);
         }
         if (null != num) {
            record.setNum(num);
         }
        //record.setModifiedDate(new Date());
        recordService.updateRecordById(record);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("删除 Record 表")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.DELETE)
    public ResponseResult<String> delRecordById(
             @ApiParam(value = " (必传参数)") @PathVariable Integer  recordId
            ) throws Exception {
        recordService.delRecordById(recordId);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("查询 Record 表")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.GET)
    public ResponseResult<Record> getRecordById(
            @ApiParam(value = " (必传参数)") @PathVariable Integer  recordId) throws Exception {
        return RestResultGenerator.genResult(recordService.getRecordById(recordId));
    }
}

