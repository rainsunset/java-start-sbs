package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

/**
 * Description: FaceSetDeleteBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceSetDeleteBean extends BaseFacePlusMessage {

    /**
     * faceset_token : deb366a514d018bbac4b3c598abff57f
     * request_id : 1514541799,dbe1b75b-8d9a-44ad-ab3b-f8e597131f59
     * time_used : 92
     * outer_id :
     */

    private String faceset_token;
    private String request_id;
    private int time_used;
    private String outer_id;

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }
}
