package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 部门成员信息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXMembersBean {
    /*
         * { "errcode": 0, "errmsg": "ok", "userlist": [ { "userid": "zhangsan",
         * "name": "李四", "department": [1, 2] } ] }
         */
    private int errcode;
    private String errmsg;
    private List<Userlist> userlist;

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

    public void setUserlist(List<Userlist> userlist) {
        this.userlist = userlist;
    }

    public List<Userlist> getUserlist() {
        return userlist;
    }

    public static class Userlist extends BaseMessage {
        private String userid;
        private String name;
        private List<Integer> department;

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserid() {
            return userid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDepartment(List<Integer> department) {
            this.department = department;
        }

        public List<Integer> getDepartment() {
            return department;
        }
    }
}

