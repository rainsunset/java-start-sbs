package com.ligw.demo.util.faceplus.message.request;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

/**
 * Description: FaceSetBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceSetBean extends BaseFacePlusMessage {
    /*
        可选	display_name	String	人脸集合的名字，最长256个字符，不能包括字符^@,&=*'"
        可选	outer_id	String	账号下全局唯一的 FaceSet 自定义标识，可以用来管理 FaceSet 对象。最长255个字符，不能包括字符^@,&=*'"
        可选	tags	String	FaceSet 自定义标签组成的字符串，用来对 FaceSet 分组。最长255个字符，多个 tag 用逗号分隔，每个 tag 不能包括字符^@,&=*'"
        可选 face_tokens String 人脸标识 face_token，可以是一个或者多个，用逗号分隔。最多不超过5个 face_token
        可选	user_data	String	自定义用户信息，不大于16 KB，不能包括字符^@,&=*'"
        可选	force_merge	Int  在传入 outer_id 的情况下，如果 outer_id 已经存在，是否将 face_token 加入已经存在的 FaceSet 中
                             0：不将 face_tokens 加入已存在的 FaceSet 中，直接返回 FACESET_EXIST 错误
                             1：将 face_tokens 加入已存在的 FaceSet 中
                             默认值为0
     */
    private String display_name;
    private String outer_id;
    private String tags;
    private String face_tokens;
    private String user_data;
    private String force_merge;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFace_tokens() {
        return face_tokens;
    }

    public void setFace_tokens(String face_tokens) {
        this.face_tokens = face_tokens;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    public String getForce_merge() {
        return force_merge;
    }

    public void setForce_merge(String force_merge) {
        this.force_merge = force_merge;
    }
}
