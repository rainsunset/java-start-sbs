package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: FaceCompareBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceCompareBean extends BaseFacePlusMessage {

    /**
     * faces1 : [{"face_rectangle":{"width":48,"top":54,"left":29,"height":48},"face_token":"6ba6e4e93cbea9e1e38ae0270e13afa0"}]
     * faces2 : [{"face_rectangle":{"width":48,"top":54,"left":29,"height":48},"face_token":"6f033d35d175c6dd27c899bf7e9ba899"}]
     * time_used : 867
     * thresholds : {"1e-3":62.327,"1e-5":73.975,"1e-4":69.101}
     * confidence : 97.389
     * image_id2 : NEvwbO3QY4wH4Vvvot1kyg==
     * image_id1 : NEvwbO3QY4wH4Vvvot1kyg==
     * request_id : 1514536767,19ed23ff-10f9-4942-83a8-aec475e97aba
     */

    private int time_used;
    private ThresholdsBean thresholds;
    private double confidence;
    private String image_id2;
    private String image_id1;
    private String request_id;
    private List<FaceBean> faces1;
    private List<FaceBean> faces2;

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public ThresholdsBean getThresholds() {
        return thresholds;
    }

    public void setThresholds(ThresholdsBean thresholds) {
        this.thresholds = thresholds;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getImage_id2() {
        return image_id2;
    }

    public void setImage_id2(String image_id2) {
        this.image_id2 = image_id2;
    }

    public String getImage_id1() {
        return image_id1;
    }

    public void setImage_id1(String image_id1) {
        this.image_id1 = image_id1;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List<FaceBean> getFaces1() {
        return faces1;
    }

    public void setFaces1(List<FaceBean> faces1) {
        this.faces1 = faces1;
    }

    public List<FaceBean> getFaces2() {
        return faces2;
    }

    public void setFaces2(List<FaceBean> faces2) {
        this.faces2 = faces2;
    }

    public static class ThresholdsBean extends BaseFacePlusMessage {
        /**
         * 1e-3 : 62.327
         * 1e-5 : 73.975
         * 1e-4 : 69.101
         */

        private double _$1e3;
        private double _$1e5;
        private double _$1e4;

        public double get_$1e3() {
            return _$1e3;
        }

        public void set_$1e3(double _$1e3) {
            this._$1e3 = _$1e3;
        }

        public double get_$1e5() {
            return _$1e5;
        }

        public void set_$1e5(double _$1e5) {
            this._$1e5 = _$1e5;
        }

        public double get_$1e4() {
            return _$1e4;
        }

        public void set_$1e4(double _$1e4) {
            this._$1e4 = _$1e4;
        }
    }

    public static class FaceBean extends BaseFacePlusMessage{
        /**
         * face_rectangle : {"width":48,"top":54,"left":29,"height":48}
         * face_token : 6ba6e4e93cbea9e1e38ae0270e13afa0
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
