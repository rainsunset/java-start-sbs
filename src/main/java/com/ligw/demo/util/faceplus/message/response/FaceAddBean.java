package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: FaceAddBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceAddBean extends BaseFacePlusMessage {

    /**
     * faceset_token : 42fb0d5bf81c5ac57c52344dddc3e7c9
     * time_used : 479
     * face_count : 1
     * face_added : 1
     * request_id : 1470293555,78637cd1-f773-47c6-8ba4-5af7153e4e00
     * outer_id : uabREDWZvshpHISwVsav
     * failure_detail : [{"reason":"INVALID_FACE_TOKEN","face_token":"testtest1"},{"reason":"INVALID_FACE_TOKEN","face_token":"testtest2"}]
     */

    private String faceset_token;
    private int time_used;
    private int face_count;
    private int face_added;
    private String request_id;
    private String outer_id;
    private List<FailureDetailBean> failure_detail;

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public int getFace_count() {
        return face_count;
    }

    public void setFace_count(int face_count) {
        this.face_count = face_count;
    }

    public int getFace_added() {
        return face_added;
    }

    public void setFace_added(int face_added) {
        this.face_added = face_added;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public List<FailureDetailBean> getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(List<FailureDetailBean> failure_detail) {
        this.failure_detail = failure_detail;
    }

    public static class FailureDetailBean extends BaseFacePlusMessage{
        /**
         * reason : INVALID_FACE_TOKEN
         * face_token : testtest1
         */

        private String reason;
        private String face_token;

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }
    }
}
