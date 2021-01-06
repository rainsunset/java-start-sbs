package com.ligw.demo.mapper;

import com.ligw.demo.model.Count;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface CountMapper {

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
     * 依据主键删除 count 表 记录
     * @param userId
     */
    public void  delCountById(String userId);

}
