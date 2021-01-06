package com.ligw.demo.util.tts;

/**
 * Description: TTSConstants
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-04
 */
public class TTSConstants {
//    public final static String BAIDU_TTS_API_ID = "10477616";
//    public final static String BAIDU_TTS_API_KEY= "K0NVYF5SGuDGTu3SwDQSlrjG";
//    public final static String BAIDU_TTS_SECRET_KEY = "Kbyu1yBsLhLfRl4Fk3xSP9U2GbXAeFE4";

    public final static String BAIDU_TTS_API_ID = "10491590";
    public final static String BAIDU_TTS_API_KEY= "6Rl4WVLkrdDGKvtNn4uYGgSx";
    public final static String BAIDU_TTS_SECRET_KEY = "pILzawwjevinIapIk7G8GrjvgMoYXkHR";

    public final static String URL_BAIDU_OAUTH = "https://openapi.baidu.com/oauth/2.0/token";
    public final static String URL_SPEECH_TTS = "http://tsn.baidu.com/text2audio";

    //语音片段大小
    public final static int MAX_CHUNK_SIZE = 255;

    //region 语音合成选项
    //客户端类型(1:web端)
    public final static String SPEECH_CONFIG_CTP = "1";
    //语言(zh:中英混合)
    public final static String SPEECH_CONFIG_LAN = "zh";
    //语速(范围0-15)
    public final static String SPEECH_CONFIG_SPD = "5";
    //语调(范围0-15)
    public final static String SPEECH_CONFIG_PIT = "5";
    //语音(范围0-15)
    public final static String SPEECH_CONFIG_VOL = "5";
    //声音(0:普通女生;1:普通男生;3:感情男声;4:感情女声)
    public final static String SPEECH_CONFIG_PER = "0";
    //endregion
}
