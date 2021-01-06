package com.ligw.demo.util.faceplus.message.request;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

/**
 * Description: FaceBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceBean extends BaseFacePlusMessage {
    private String face_tokens;

    public String getFace_tokens() {
        return face_tokens;
    }

    public void setFace_tokens(String face_tokens) {
        this.face_tokens = face_tokens;
    }
}
