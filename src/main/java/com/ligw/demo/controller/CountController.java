package com.ligw.demo.controller;


import com.github.pagehelper.PageInfo;
import com.ligw.demo.model.Count;
import com.ligw.demo.service.CountService;
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
 * @version $Id CountController.java, 2018-08-23 11:43:03 wuhaosoft Exp
 *
 */
@Api(tags = "count 表接口")
@RestController
@RequestMapping("/demo")
public class CountController{

    @Autowired
    private CountService countService;

    @ApiOperation("查询 所有 count 表 分页")
    @RequestMapping(value = "/counts", method = RequestMethod.POST)
    public ResponseResult<PageInfo<Count>> getCountPageTurn(
            @ApiParam(value = "用户记录值总和 (非必传参数)") @RequestParam(required = false) Integer numCount,
            @ApiParam(value = "页码(必传)") @RequestParam Integer pageNo,
            @ApiParam(value = "每页显示多少数据(必传)") @RequestParam Integer pageSize) throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        if (null != numCount) {
           rs.put("numCount", numCount);
        }
        PageInfo<Count> pageInfo = countService.getCountPageTurn(rs, pageNo, pageSize);
        return RestResultGenerator.genResult(pageInfo);
    }

    @ApiOperation("查询 所有 count 表")
    @RequestMapping(value = "/allCounts", method = RequestMethod.POST)
    public ResponseResult<List<Count>> selectCountList(
        @ApiParam(value = "用户记录值总和 (非必传参数)") @RequestParam(required = false) Integer numCount
        )throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        if (null != numCount) {
            rs.put("numCount", numCount);
        }
        List<Count> countList = countService.selectCountList(rs);
        return RestResultGenerator.genResult(countList);
    }

    @ApiOperation("新增 count 表")
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public ResponseResult<String> addCount(
                @ApiParam(value = "用户记录值总和 (非必传参数)") @RequestParam(required = false) Integer numCount
            ) throws Exception {
        Count count = new Count();
        if (null != numCount) {
            count.setNumCount(numCount);
        }
        //count.setCreatedDate(new Date());
        countService.addCount(count);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("更新 count 表")
    @RequestMapping(value = "/count/{userId}", method = RequestMethod.PUT)
    public ResponseResult<String> updateCountById(
            @ApiParam(value = " (必传参数)") @PathVariable String  userId,
             @ApiParam(value = "用户记录值总和 (非必传参数)") @RequestParam(required = false) Integer numCount
            ) throws Exception {
        Count count = new Count();
        count.setUserId(userId);

         if (null != numCount) {
            count.setNumCount(numCount);
         }
        //count.setModifiedDate(new Date());
        countService.updateCountById(count);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("删除 count 表")
    @RequestMapping(value = "/count/{userId}", method = RequestMethod.DELETE)
    public ResponseResult<String> delCountById(
             @ApiParam(value = " (必传参数)") @PathVariable String  userId
            ) throws Exception {
        countService.delCountById(userId);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("查询 count 表")
    @RequestMapping(value = "/count/{userId}", method = RequestMethod.GET)
    public ResponseResult<Count> getCountById(
            @ApiParam(value = " (必传参数)") @PathVariable String  userId) throws Exception {
        return RestResultGenerator.genResult(countService.getCountById(userId));
    }
}

