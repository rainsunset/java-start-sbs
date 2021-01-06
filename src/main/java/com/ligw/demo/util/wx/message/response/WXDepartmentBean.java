package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 部门信息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXDepartmentBean extends BaseMessage {
    /*{
        "errcode": 0,
        "errmsg": "ok",
        "department": [
            {
                "id": 2,
                "name": "广州研发中心",
                "parentid": 1,
                "order": 10
            },
            {
                "id": 3
                "name": "邮箱产品部",
                "parentid": 2,
                "order": 40
            }
        ]
     }*/
    private int errcode;
    private String errmsg;
    private List<Department> department;
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public int getErrcode() {
        return errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getErrmsg() {
        return errmsg;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
    public List<Department> getDepartment() {
        return department;
    }
    public static class Department extends BaseMessage {
        private int id;
        private String name;
        private int parentid;
        private int order;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }
        public int getParentid() {
            return parentid;
        }

        public void setOrder(int order) {
            this.order = order;
        }
        public int getOrder() {
            return order;
        }
    }
}
