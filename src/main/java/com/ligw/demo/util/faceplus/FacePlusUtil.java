package com.ligw.demo.util.faceplus;

import com.alibaba.fastjson.JSON;
import com.ligw.demo.util.faceplus.message.request.FaceBean;
import com.ligw.demo.util.faceplus.message.request.FaceSetBean;
import com.ligw.demo.util.faceplus.message.response.*;
import com.ligw.demo.util.http.HttpUtil;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.ligw.demo.util.faceplus.FacePlusConstants.*;
import static com.ligw.demo.util.http.HttpConstants.MIMETYPE_APPLICATION_JSON;

/**
 * Description: FacePlusUtil
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-29
 */
public class FacePlusUtil {
    //region 通用方法
    /**
     * 检查API KEY
     * @param apiKey
     * @param apiSecret
     * @return
     */
    private static boolean checkApiKey(String apiKey, String apiSecret) {
        return apiKey != null && apiKey.length() > 0 && apiSecret != null && apiSecret.length() > 0;
    }

    /**
     * base64字符串转图片文件
     * @param imageStr base64字符串
     * @param path 文件路径
     * @return
     */
    private static boolean base642Image(String imageStr, String path) {
        boolean result = true;
        if (imageStr == null || imageStr.length() == 0)
            return false;
        if (path == null || path.length() == 0)
            return false;
        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream(path);
             byte[] bytes = Base64.decodeBase64(imageStr);
             fos.write(bytes);
             fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 图片文件转base64字符串
     * @param imageFile 文件路径
     * @return
     */
    private static String image2Base64(String imageFile){
        String result;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imageFile);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            result = Base64.encodeBase64String(bytes);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    //endregion

    //region 人体识别
    /**
     * 人体识别
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param imageType 图片类型
     * @param imageStr  图片字符串(图片不同类型，含义不同，见FACE_IMAGE_TYPE枚举)
     *                  图片格式：JPG(JPEG)，PNG
     *                  图片像素尺寸：最小 48*48 像素，最大 1280*1280 像素
     *                  图片文件大小：2 MB
     * @return
     */
    public static BodyDetectBean bodyDetect(String apiKey, String apiSecret, FACE_IMAGE_TYPE imageType, String imageStr){
        BodyDetectBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }
        if (imageStr == null || imageStr.length() == 0){
            return null;
        }

        String apiUrl = API_BODY_BASE + API_BODY_DETECT;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        switch (imageType){
            case URL:{
                multipartBuilder.addFormDataPart("image_url", imageStr);
                break;
            }
            case BASE64:{
                multipartBuilder.addFormDataPart("image_base64", imageStr);
                break;
            }
            case FILE:{
                File imageFile = new File(imageStr);
                if (!imageFile.exists()){
                    return null;
                }
                RequestBody fileBody = MultipartBody.create(null, imageFile);
                multipartBuilder.addFormDataPart("image_file", imageFile.getName(), fileBody);
                break;
            }
            default:{
                return null;
            }
        }
        MultipartBody multipartBody = multipartBuilder.build();

        try {
            String response = HttpUtil.httpPostMultiPart(apiUrl, multipartBody, params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, BodyDetectBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }
    //endregion

    //region 人脸识别
    /**
     * 人脸检测
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param imageType 图片类型
     * @param imageStr  图片字符串(图片不同类型，含义不同，见FACE_IMAGE_TYPE枚举)
     *                  图片格式：JPG(JPEG)，PNG
     *                  图片像素尺寸：最小 48*48 像素，最大 4096*4096 像素
     *                  图片文件大小：2 MB
     *                  最小人脸像素尺寸： 系统能够检测到的人脸框为一个正方形，
     *                  正方形边长的最小值为图像短边长度的 48 分之一，最小值不低于 48 像素。
     *                  例如图片为 4096*3200 像素，则最小人脸像素尺寸为 66*66 像素。
     * @return 识别结果
     */
    public static FaceDetectBean faceDetect(String apiKey, String apiSecret, FACE_IMAGE_TYPE imageType, String imageStr){
        FaceDetectBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }
        if (imageStr == null || imageStr.length() == 0){
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACEDETECT;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        switch (imageType){
            case URL:{
                multipartBuilder.addFormDataPart("image_url", imageStr);
                break;
            }
            case BASE64:{
                multipartBuilder.addFormDataPart("image_base64", imageStr);
                break;
            }
            case FILE:{
                File imageFile = new File(imageStr);
                if (!imageFile.exists()){
                    return null;
                }
                RequestBody fileBody = MultipartBody.create(null, imageFile);
                multipartBuilder.addFormDataPart("image_file", imageFile.getName(), fileBody);
                break;
            }
            default:{
                return null;
            }
        }

        MultipartBody multipartBody = multipartBuilder.build();
        try {
            String response = HttpUtil.httpPostMultiPart(apiUrl, multipartBody, params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceDetectBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 人脸对比
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param fType1 图片1类型
     * @param imageStr1 图片字符串1(图片不同类型，含义不同，见FACE_IMAGE_TYPE枚举)
     * @param fType2 图片2类型
     * @param imageStr2 图片字符串2(图片不同类型，含义不同，见FACE_IMAGE_TYPE枚举)
     *                  图片格式：JPG(JPEG)，PNG
     *                  图片像素尺寸：最小 48*48 像素，最大 4096*4096 像素
     *                  图片文件大小：2MB
     *                  最小人脸像素尺寸： 系统能够检测到的人脸框为一个正方形，正方形边长的最小值为 150 像素。
     * @return
     */
    public static FaceCompareBean compareFace(String apiKey, String apiSecret,
                                              FACE_IMAGE_TYPE fType1, String imageStr1,
                                              FACE_IMAGE_TYPE fType2, String imageStr2){
        FaceCompareBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }
        if (imageStr1 == null || imageStr1.length() == 0
                || imageStr2 == null || imageStr2.length() == 0){
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACECOMPARE;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        switch (fType1){
            case FACETOKEN:{
                multipartBuilder.addFormDataPart("face_token1", imageStr1);
                break;
            }
            case URL:{
                multipartBuilder.addFormDataPart("image_url1", imageStr1);
                break;
            }
            case BASE64:{
                multipartBuilder.addFormDataPart("image_base64_1", imageStr1);
                break;
            }
            case FILE:{
                File imageFile = new File(imageStr1);
                if (!imageFile.exists()){
                    return null;
                }
                RequestBody fileBody = MultipartBody.create(null, imageFile);
                multipartBuilder.addFormDataPart("image_file1", imageFile.getName(), fileBody);
                break;
            }
            default:{
                return null;
            }
        }

        switch (fType2){
            case FACETOKEN:{
                multipartBuilder.addFormDataPart("face_token2", imageStr2);
                break;
            }
            case URL:{
                multipartBuilder.addFormDataPart("image_url2", imageStr2);
                break;
            }
            case BASE64:{
                multipartBuilder.addFormDataPart("image_base64_2", imageStr2);
                break;
            }
            case FILE:{
                File imageFile = new File(imageStr2);
                if (!imageFile.exists()){
                    return null;
                }
                RequestBody fileBody = MultipartBody.create(null, imageFile);
                multipartBuilder.addFormDataPart("image_file2", imageFile.getName(), fileBody);
                break;
            }
            default:{
                return null;
            }
        }

        MultipartBody multipartBody = multipartBuilder.build();
        try {
            String response = HttpUtil.httpPostMultiPart(apiUrl, multipartBody, params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceCompareBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 人脸搜索
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param imageType 图片类型
     * @param imageStr 图片字符串
     *                 图片格式：JPG(JPEG)，PNG
     *                 图片像素尺寸：最小 48*48 像素，最大 4096*4096 像素
     *                 图片文件大小：2MB
     *                 最小人脸像素尺寸： 系统能够检测到的人脸框为一个正方形，正方形边长的最小值为 150 像素。
     * @param faceSetType 人脸集合类型
     * @param faceSetStr 人脸集合字符串
     * @return
     */
    public static FaceSearchBean searchFace(String apiKey, String apiSecret,
                                            FACE_IMAGE_TYPE imageType, String imageStr,
                                            FACE_SET_TYPE faceSetType, String faceSetStr){
        FaceSearchBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }
        if (imageStr == null || imageStr.length() == 0
                || faceSetStr == null || faceSetStr.length() == 0){
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESEARCH;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);

        switch (imageType){
            case FACETOKEN:{
                multipartBuilder.addFormDataPart("face_token", imageStr);
                break;
            }
            case URL:{
                multipartBuilder.addFormDataPart("image_url", imageStr);
                break;
            }
            case BASE64:{
                multipartBuilder.addFormDataPart("image_base64", imageStr);
                break;
            }
            case FILE:{
                File imageFile = new File(imageStr);
                if (!imageFile.exists()){
                    return null;
                }
                RequestBody fileBody = MultipartBody.create(null, imageFile);
                multipartBuilder.addFormDataPart("image_file", imageFile.getName(), fileBody);
                break;
            }
            default:{
                return null;
            }
        }

        switch (faceSetType){
            case FACESETTOKEN:{
                multipartBuilder.addFormDataPart("faceset_token", faceSetStr);
                break;
            }
            case OUTERID:{
                multipartBuilder.addFormDataPart("outer_id", faceSetStr);
                break;
            }
            default:{
                return null;
            }
        }

        MultipartBody multipartBody = multipartBuilder.build();
        try {
            String response = HttpUtil.httpPostMultiPart(apiUrl, multipartBody, params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceSearchBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 获取人脸集合
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @return
     */
    public static FaceSetListBean getFaceSets(String apiKey, String apiSecret){
        FaceSetListBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_GETFACESETS;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceSetListBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;

    }

    /**
     * 获取人脸详情
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param faceSetType 人脸集合类型
     * @param faceSetStr 人脸集合字符串
     * @return
     */
    public static FaceSetDetailBean getFaceSetDetail(String apiKey, String apiSecret, FACE_SET_TYPE faceSetType, String faceSetStr){
        FaceSetDetailBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_GETDETAIL;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        switch (faceSetType){
            case FACESETTOKEN:{
                params.put("faceset_token", faceSetStr);
                break;
            }
            case OUTERID:{
                params.put("outer_id", faceSetStr);
                break;
            }
            default: {
                return null;
            }
        }

        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceSetDetailBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;

    }

    /**
     * 新增人脸集合
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param data 新增人脸集合
     * @return
     */
    public static FaceSetCreateBean createFaceSet(String apiKey, String apiSecret, FaceSetBean data){
        FaceSetCreateBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_CREATE;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);
        if (data != null) {
            params.put("display_name", data.getDisplay_name());
            params.put("outer_id", data.getOuter_id());
            params.put("tags", data.getTags());
            params.put("face_tokens", data.getFace_tokens());
            params.put("user_data", data.getUser_data());
            params.put("force_merge", data.getForce_merge());
        }
        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceSetCreateBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 删除人脸集合
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param faceSetType 人脸集合类型
     * @param faceSetStr 人脸集合字符串
     * @return
     */
    public static FaceSetDeleteBean deleteFaceSet(String apiKey, String apiSecret, FACE_SET_TYPE faceSetType, String faceSetStr){
        FaceSetDeleteBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_DELETE;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);

        switch (faceSetType){
            case FACESETTOKEN:{
                params.put("faceset_token", faceSetStr);
                break;
            }
            case OUTERID:{
                params.put("outer_id", faceSetStr);
                break;
            }
            default:{
                return null;
            }
        }

        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceSetDeleteBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 新增人脸
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param faceSetType 人脸集合类型
     * @param faceSetStr 人脸集合字符串
     * @param data 人脸数据
     * @return
     */
    public static FaceAddBean addFace(String apiKey, String apiSecret,
                                      FACE_SET_TYPE faceSetType, String faceSetStr, FaceBean data){
        FaceAddBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }
        if (data == null){
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_ADDFACE;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);
        params.put("face_tokens", data.getFace_tokens());

        switch (faceSetType){
            case FACESETTOKEN:{
                params.put("faceset_token", faceSetStr);
                break;
            }
            case OUTERID:{
                params.put("outer_id", faceSetStr);
                break;
            }
            default:{
                return null;
            }
        }

        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceAddBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }

    /**
     * 删除人脸
     * @param apiKey apiKey
     * @param apiSecret apiSecret
     * @param faceSetType 人脸集合类型
     * @param faceSetStr 人脸集合字符串
     * @param data 人脸数据
     * @return
     */
    public static FaceRemoveBean removeFace(String apiKey, String apiSecret,
                                            FACE_SET_TYPE faceSetType, String faceSetStr, FaceBean data){
        FaceRemoveBean bean;
        if (!checkApiKey(apiKey, apiSecret)) {
            return null;
        }

        String apiUrl = API_FACE_BASE + API_FACESET_REMOVEFACE;
        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("api_secret", apiSecret);
        params.put("face_tokens", data.getFace_tokens());

        switch (faceSetType){
            case FACESETTOKEN:{
                params.put("faceset_token", faceSetStr);
                break;
            }
            case OUTERID:{
                params.put("outer_id", faceSetStr);
                break;
            }
            default:{
                return null;
            }
        }

        try {
            String response = HttpUtil.httpPostString(apiUrl, MIMETYPE_APPLICATION_JSON, "", params, null);
//            System.out.println("======>http response:" + response);
            bean = JSON.parseObject(response, FaceRemoveBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }
    //endregion

//    public static void main(String[] args) {
////        testBodyDetect();
////        testDetectFace();
////        testCompareFace();
////        testSearchFace();
////        testGetFaceSets();
////        testGetFaceSetDetail();
////        testCreateFaceSet();
////        testDeleteFaceSet();
////        testAddFace();
////        testRemoveFace();
//    }
//
//    private static void testBodyDetect(){
//        //File
//        String file = "D:\\Downloads\\images\\f_all_2.jpg";
//        BodyDetectBean model = bodyDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.FILE, file);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//
//        //Url
//        String fileUrl = "https://www.faceplusplus.com.cn/images/detection/detection.png";
//        BodyDetectBean urlBean = bodyDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.URL, fileUrl);
//        System.out.println("======>resp:" + (urlBean == null ? null : urlBean.toString()));
//
//        //Base64
//        String fileBase64 = image2Base64("D:\\Downloads\\images\\f_all_2.jpg");
//        System.out.println(fileBase64);
//        BodyDetectBean base64Bean = bodyDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.BASE64, fileBase64);
//        System.out.println("======>resp:" + base64Bean == null ? null : base64Bean.toString());
//    }
//
//    private static void testDetectFace() {
//        //File
//        String file = "D:\\Downloads\\images\\f_2.jpg";
//        FaceDetectBean model = faceDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.FILE, file);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//
//        //Url
//        String fileUrl = "https://www.faceplusplus.com.cn/images/detection/detection.png";
//        FaceDetectBean urlBean = faceDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.URL, fileUrl);
//        System.out.println("======>resp:" + (urlBean == null ? null : urlBean.toString()));
//
//        //Base64
//        String fileBase64 = image2Base64("D:\\Downloads\\images\\f_2.jpg");
//        System.out.println(fileBase64);
//        FaceDetectBean base64Bean = faceDetect(API_KEY, API_SECRET, FACE_IMAGE_TYPE.BASE64, fileBase64);
//        System.out.println("======>resp:" + base64Bean == null ? null : base64Bean.toString());
//    }
//
//    private static void testCompareFace(){
//        //File
//        String file = "D:\\Downloads\\images\\f_2.jpg";
//        FaceCompareBean model = compareFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.FILE, file, FACE_IMAGE_TYPE.FILE, file);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//
//        //Url
//        String fileUrl = "https://www.faceplusplus.com.cn/images/detection/detection.png";
//        FaceCompareBean urlBean = compareFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.URL, fileUrl, FACE_IMAGE_TYPE.FILE, file);
//        System.out.println("======>resp:" + (urlBean == null ? null : urlBean.toString()));
//
//        //Base64
//        String fileBase64 = image2Base64("D:\\Downloads\\images\\f_2.jpg");
//        System.out.println(fileBase64);
//        FaceCompareBean base64Bean = compareFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.BASE64, fileBase64, FACE_IMAGE_TYPE.FILE, file);
//        System.out.println("======>resp:" + base64Bean == null ? null : base64Bean.toString());
//    }
//
//    private static void testSearchFace(){
//        String faceSetToken = "872d1fe47a1291f72904e5bf9dab5c22";
//        //File
//        String file = "D:\\Downloads\\images\\f_2.jpg";
//        FaceSearchBean model = searchFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.FILE, file, FACE_SET_TYPE.FACESETTOKEN, faceSetToken);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//
//        //Url
//        String fileUrl = "https://www.faceplusplus.com.cn/images/detection/detection.png";
//        FaceSearchBean urlBean = searchFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.URL, fileUrl, FACE_SET_TYPE.FACESETTOKEN, faceSetToken);
//        System.out.println("======>resp:" + (urlBean == null ? null : urlBean.toString()));
//
//        //Base64
//        String fileBase64 = image2Base64("D:\\Downloads\\images\\f_2.jpg");
//        System.out.println(fileBase64);
//        FaceSearchBean base64Bean = searchFace(API_KEY, API_SECRET, FACE_IMAGE_TYPE.BASE64, fileBase64, FACE_SET_TYPE.FACESETTOKEN, faceSetToken);
//        System.out.println("======>resp:" + base64Bean == null ? null : base64Bean.toString());
//    }
//
//    private static void testGetFaceSets(){
//        FaceSetListBean model = getFaceSets(API_KEY, API_SECRET);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
//
//    private static void testGetFaceSetDetail(){
//        String faceSetToken = "872d1fe47a1291f72904e5bf9dab5c22";
//        FaceSetDetailBean model = getFaceSetDetail(API_KEY, API_SECRET, FACE_SET_TYPE.FACESETTOKEN, faceSetToken);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
//
//    private static void testCreateFaceSet(){
//        FaceSetBean dataBean = new FaceSetBean();
//        dataBean.setFace_tokens("eb79eda7aca58526c8ee888c30909c95");
//
//        FaceSetCreateBean model = createFaceSet(API_KEY, API_SECRET, null);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
//
//    private static void testDeleteFaceSet() {
////        872d1fe47a1291f72904e5bf9dab5c22
////        64f63ec6014f9f40b8b7e61391b1b24d
////        33df5b2dc7a63561009ff5b0fed70ca0
//        String faceSetToken = "deb366a514d018bbac4b3c598abff57f";
//        FaceSetDeleteBean model = deleteFaceSet(API_KEY, API_SECRET, FACE_SET_TYPE.FACESETTOKEN, faceSetToken);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
//
//    private static void testAddFace(){
//        FaceBean faceBean = new FaceBean();
//        faceBean.setFace_tokens("eb79eda7aca58526c8ee888c30909c95");
//        String faceSetToken = "33df5b2dc7a63561009ff5b0fed70ca0";
//        FaceAddBean model = addFace(API_KEY, API_SECRET, FACE_SET_TYPE.FACESETTOKEN, faceSetToken, faceBean);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
//
//    private static void testRemoveFace(){
//        FaceBean faceBean = new FaceBean();
//        faceBean.setFace_tokens("eb79eda7aca58526c8ee888c30909c95");
//        String faceSetToken = "33df5b2dc7a63561009ff5b0fed70ca0";
//        FaceRemoveBean model = removeFace(API_KEY, API_SECRET, FACE_SET_TYPE.FACESETTOKEN, faceSetToken, faceBean);
//        System.out.println("======>resp:" + (model == null ? null : model.toString()));
//    }
}
