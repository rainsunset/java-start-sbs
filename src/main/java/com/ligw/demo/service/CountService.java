package com.ligw.demo.service;

import com.github.pagehelper.PageInfo;
import com.ligw.demo.model.Count;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface CountService {

    /**
     * 添加 count 表
     * @param count
     */
    public void  addCount(Count count);

    /**
     * 依据主键更新 count 表
     * @param count
     */
    public void  updateCountById(Count count);

    /**
     * 依据条件查找 count 表 列表
     * @param param
     * @return
     */
    public List<Count> selectCountList(Map<String, Object> param);

    /**
     * 依据条件查找分页 count 表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Count> getCountPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 count 表 详情
     * @param userId
     * @return
     */
    public Count getCountById(String userId);

    /**
     * 依据Id删除 count 表 记录
     * @param userId
     */
    public void delCountById(String userId);
}
