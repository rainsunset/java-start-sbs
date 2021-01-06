package com.ligw.demo.util.faceplus;

/**
 * Description: FacePlusConstants
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FacePlusConstants {
    enum FACE_IMAGE_TYPE {
        FACETOKEN,  //人脸标识 face_token，优先使用该参数
        URL,    //图片的URL
        FILE,   //图片，二进制文件，需要用 post multipart/form-data 的方式上传
        BASE64  //base64 编码的二进制图片数据, 如果同时传入了 image_url1、image_file1 和 image_base64_1 参数，本 API 使用顺序为image_file1 优先，image_url1 最低。
    }

    enum FACE_SET_TYPE{
        FACESETTOKEN,   //用来搜索的 FaceSet 的标识
        OUTERID  //用户自定义的 FaceSet 标识
    }

    public static final String API_KEY = "PXsjernzsjuucH7SvLnRmRmdrFUFzYci";
    public static final String API_SECRET = "ZlNgqz_xuo3yxTsEf5FhGRA3OGz6g0_N";

    //region 人体识别
    public static final String API_BODY_BASE = "https://test-cn.faceplusplus.com/humanbodypp/v1";
    public static final String API_BODY_DETECT = "/detect";
    //endregion

    //region 人脸识别
    public static final String API_FACE_BASE = "https://test-cn.faceplusplus.com/facepp/v3";
    public static final String API_FACEDETECT = "/detect";
    public static final String API_FACECOMPARE = "/compare";
    public static final String API_FACESEARCH = "/search";
    public static final String API_FACESET_GETFACESETS = "/faceset/getfacesets";
    public static final String API_FACESET_GETDETAIL = "/faceset/getdetail";
    public static final String API_FACESET_CREATE = "/faceset/create";
    public static final String API_FACESET_DELETE = "/faceset/delete";
    public static final String API_FACESET_ADDFACE = "/faceset/addface";
    public static final String API_FACESET_REMOVEFACE = "/faceset/removeface";
    //endregion
}
