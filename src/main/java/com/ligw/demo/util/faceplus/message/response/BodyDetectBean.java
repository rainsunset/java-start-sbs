package com.ligw.demo.util.faceplus.message.response;

import com.ligw.demo.util.faceplus.message.BaseFacePlusMessage;

import java.util.List;

/**
 * Description: BodyDetectBean
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class BodyDetectBean extends BaseFacePlusMessage {

    /**
     * image_id : 3qlpCWPWDypoyZjoRbUqRQ==
     * request_id : 1514523903,2670ed5b-5a04-4a19-8927-fa38e3d36558
     * time_used : 809
     * humanbodies : [{"humanbody_rectangle":{"width":141,"top":203,"height":430,"left":451},"confidence":99.837},{"humanbody_rectangle":{"width":149,"top":229,"height":418,"left":304},"confidence":99.806},{"humanbody_rectangle":{"width":161,"top":166,"height":409,"left":751},"confidence":99.801},{"humanbody_rectangle":{"width":155,"top":209,"height":442,"left":157},"confidence":99.746},{"humanbody_rectangle":{"width":152,"top":203,"height":400,"left":596},"confidence":98.008},{"humanbody_rectangle":{"width":114,"top":169,"height":404,"left":916},"confidence":95.952}]
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<HumanbodyBean> humanbodies;

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

    public List<HumanbodyBean> getHumanbodies() {
        return humanbodies;
    }

    public void setHumanbodies(List<HumanbodyBean> humanbodies) {
        this.humanbodies = humanbodies;
    }

    public static class HumanbodyBean extends BaseFacePlusMessage {
        /**
         * humanbody_rectangle : {"width":141,"top":203,"height":430,"left":451}
         * confidence : 99.837
         */

        private HumanbodyRectangleBean humanbody_rectangle;
        private double confidence;

        public HumanbodyRectangleBean getHumanbody_rectangle() {
            return humanbody_rectangle;
        }

        public void setHumanbody_rectangle(HumanbodyRectangleBean humanbody_rectangle) {
            this.humanbody_rectangle = humanbody_rectangle;
        }

        public double getConfidence() {
            return confidence;
        }

        public void setConfidence(double confidence) {
            this.confidence = confidence;
        }

        public static class HumanbodyRectangleBean extends BaseFacePlusMessage {
            /**
             * width : 141
             * top : 203
             * height : 430
             * left : 451
             */

            private int width;
            private int top;
            private int height;
            private int left;

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

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }
        }
    }
}
