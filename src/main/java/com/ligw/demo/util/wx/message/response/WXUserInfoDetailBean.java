package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 成员详细信息
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUserInfoDetailBean extends BaseMessage {
    /* {
         "userid":"lisi",
         "name":"李四",
         "department":[3],
         "position": "后台工程师",
         "mobile":"15050495892",
         "gender":1,
         "email":"xxx@xx.com",
         "avatar":"http://shp.qpic.cn/bizmp/xxxxxxxxxxx/0"
      }*/
    private String userid;
    private String name;
    private List<Integer> department;
    private String position;
    private String mobile;
    private Integer gender;
    private String email;
    private String avatar;
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

    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getMobile() {
        return mobile;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }
}

