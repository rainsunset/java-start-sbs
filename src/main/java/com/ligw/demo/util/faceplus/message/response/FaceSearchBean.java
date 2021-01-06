package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: FaceSearchBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FaceSearchBean extends BaseFacePlusMessage {

    /**
     * image_id : NEvwbO3QY4wH4Vvvot1kyg==
     * faces : [{"face_rectangle":{"width":48,"top":54,"left":29,"height":48},"face_token":"d12466230088edea94e4ef043ee2b3f4"}]
     * time_used : 430
     * thresholds : {"1e-3":62.327,"1e-5":73.975,"1e-4":69.101}
     * request_id : 1514538664,82c46b0a-d79e-40ff-a3da-bfefa84f1b28
     * results : [{"confidence":97.389,"user_id":"","face_token":"eb79eda7aca58526c8ee888c30909c95"}]
     */

    private String image_id;
    private int time_used;
    private ThresholdsBean thresholds;
    private String request_id;
    private List<FaceBean> faces;
    private List<ResultBean> results;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

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

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List<FaceBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FaceBean> faces) {
        this.faces = faces;
    }

    public List<ResultBean> getResults() {
        return results;
    }

    public void setResults(List<ResultBean> results) {
        this.results = results;
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

    public static class FaceBean extends BaseFacePlusMessage {
        /**
         * face_rectangle : {"width":48,"top":54,"left":29,"height":48}
         * face_token : d12466230088edea94e4ef043ee2b3f4
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

    public static class ResultBean extends BaseFacePlusMessage{
        /**
         * confidence : 97.389
         * user_id :
         * face_token : eb79eda7aca58526c8ee888c30909c95
         */

        private double confidence;
        private String user_id;
        private String face_token;

        public double getConfidence() {
            return confidence;
        }

        public void setConfidence(double confidence) {
            this.confidence = confidence;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }
    }
}
