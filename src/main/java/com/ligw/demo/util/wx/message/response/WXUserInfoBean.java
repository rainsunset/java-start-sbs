package com.ligw.demo.util.wx.message.response;

import com.ligw.demo.util.wx.message.BaseMessage;

import java.util.List;

/**
 * Description: 读取成员
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUserInfoBean extends BaseMessage{
    // {
    // "errcode": 0,
    // "errmsg": "ok",
    // "userid": "zhangsan",
    // "name": "李四",
    // "department": [1, 2],
    // "position": "后台工程师",
    // "mobile": "15913215421",
    // "gender": "1",
    // "email": "zhangsan@gzdev.com",
    // "isleader": 1,
    // "avatar":
    // "http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0",
    // "telephone": "020-123456",
    // "english_name": "jackzhang",
    // "extattr":
    // {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]},
    // "enable": 1,
    // "status": 1
    // }

    private int errcode;
    private String errmsg;
    private String userid;
    private String name;
    private List<Integer> department;
    private String position;
    private String mobile;
    private String gender;
    private String email;
    private int isleader;
    private String avatar;
    private String telephone;
    private String english_name;
    private Extattr extattr;
    private int enable;
    private int status;

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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIsleader(int isleader) {
        this.isleader = isleader;
    }

    public int getIsleader() {
        return isleader;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setExtattr(Extattr extattr) {
        this.extattr = extattr;
    }

    public Extattr getExtattr() {
        return extattr;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getEnable() {
        return enable;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static class Extattr  extends BaseMessage {
        private List<Attrs> attrs;

        public void setAttrs(List<Attrs> attrs) {
            this.attrs = attrs;
        }

        public List<Attrs> getAttrs() {
            return attrs;
        }
    }

    public static class Attrs  extends BaseMessage {
        private String name;
        private String value;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

