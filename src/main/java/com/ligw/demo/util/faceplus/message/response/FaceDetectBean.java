package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: FaceDetectBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceDetectBean extends BaseFacePlusMessage {

    /**
     * image_id : NEvwbO3QY4wH4Vvvot1kyg==
     * request_id : 1514521887,9d925718-d757-4ccc-9579-5b30a7dcfbe5
     * time_used : 245
     * faces : [{"face_rectangle":{"width":48,"top":54,"left":29,"height":48},"face_token":"0346de732b6edfb3f6cab51156cd43b8"}]
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<FaceBean> faces;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
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

    public List<FaceBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FaceBean> faces) {
        this.faces = faces;
    }

    public static class FaceBean extends BaseFacePlusMessage {
        /**
         * face_rectangle : {"width":48,"top":54,"left":29,"height":48}
         * face_token : 0346de732b6edfb3f6cab51156cd43b8
         */

        private FaceRectangleBean face_rectangle;
        private String face_token;

        public FaceRectangleBean getFace_rectangle() {
            return face_rectangle;
        }

        public void setFace_rectangle(FaceRectangleBean face_rectangle) {
            this.face_rectangle = face_rectangle;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }

        public static class FaceRectangleBean extends BaseFacePlusMessage {
            /**
             * width : 48
             * top : 54
             * left : 29
             * height : 48
             */

            private int width;
            private int top;
            private int left;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
