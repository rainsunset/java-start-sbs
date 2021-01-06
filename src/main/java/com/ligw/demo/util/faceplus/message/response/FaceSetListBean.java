package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: FaceSetListBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceSetListBean extends BaseFacePlusMessage{

    /**
     * time_used : 63
     * facesets : [{"faceset_token":"872d1fe47a1291f72904e5bf9dab5c22","outer_id":"","display_name":"","tags":""}]
     * request_id : 1514539694,78f3cca2-e5ad-4105-802d-04c8c45d0302
     */

    private int time_used;
    private String request_id;
    private List<FaceSetBean> facesets;

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List<FaceSetBean> getFacesets() {
        return facesets;
    }

    public void setFacesets(List<FaceSetBean> facesets) {
        this.facesets = facesets;
    }

    public static class FaceSetBean extends BaseFacePlusMessage{
        /**
         * faceset_token : 872d1fe47a1291f72904e5bf9dab5c22
         * outer_id :
         * display_name :
         * tags :
         */

        private String faceset_token;
        private String outer_id;
        private String display_name;
        private String tags;

        public String getFaceset_token() {
            return faceset_token;
        }

        public void setFaceset_token(String faceset_token) {
            this.faceset_token = faceset_token;
        }

        public String getOuter_id() {
            return outer_id;
        }

        public void setOuter_id(String outer_id) {
            this.outer_id = outer_id;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }
}
