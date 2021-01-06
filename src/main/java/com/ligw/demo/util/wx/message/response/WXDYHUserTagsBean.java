/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * 获取公众号已创建的标签
 * @author ligw
 * @version $Id WXDYHUserTags.java, v 0.1 2017-09-28 13:44 ligw Exp $$
 */
public class WXDYHUserTagsBean extends BaseMessage{

    private List<TagsBean> tags;

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {

        /**
         * id : 1
         * name : 每天一罐可乐星人
         * count : 0
         */
        private int id;

        private String name;

        ////此标签下粉丝数
        private int count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
