package com.ligw.demo.util.tts;

import com.alibaba.fastjson.JSON;
import com.ligw.demo.util.CommonUtil;
import com.ligw.demo.util.http.HttpUtil;
import com.ligw.demo.util.tts.message.BaiduAccessToken;
import okhttp3.Response;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.ligw.demo.util.tts.TTSConstants.*;

/**
 * Description: TTS Utility
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-04
 */
public class TTSUtil {
    /**
     * 文字转语音
     * @param filePath 保存文件路径
     * @param text 转换的文本
     * @return boolean
     */
    public static boolean text2Speech(String filePath, String text) {
        boolean result = true;
        BaiduAccessToken baiduAccessToken = getBaiduAccessToken();
        String token = baiduAccessToken.getAccess_token();
        String cuid = CommonUtil.getUUID();
        SortedMap<Integer, String> chunks = splitChunks(text);
        byte[] voiceData;
        File voiceFile = new File(filePath);
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            if (!voiceFile.exists()) {
                if (!voiceFile.getParentFile().exists()) {
                    voiceFile.getParentFile().mkdirs();
                }
                voiceFile.createNewFile();
            }
            fos = new FileOutputStream(voiceFile);
            bos = new BufferedOutputStream(fos);
            for (Map.Entry<Integer, String> entry : chunks.entrySet()) {
                voiceData = synthesis(token, entry.getValue(), cuid);
                if (voiceData == null || voiceData.length == 0){
                    result = false;
                    break;
                }
                bos.write(voiceData);
            }
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                if (bos != null)
                    bos.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取百度语音合成API的token
     * @return BaiduAccessToken
     */
    private static BaiduAccessToken getBaiduAccessToken(){
        BaiduAccessToken baiduAccessToken = null;
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("grant_type", "client_credentials");
        requestParams.put("client_id", BAIDU_TTS_API_KEY);
        requestParams.put("client_secret", BAIDU_TTS_SECRET_KEY);
        try {
            String response = HttpUtil.httpGetString(URL_BAIDU_OAUTH, null, requestParams);
            baiduAccessToken = JSON.parseObject(response, BaiduAccessToken.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baiduAccessToken;
    }

    /**
     * 获取在线生成语音文件
     * @param token access token
     * @param tex 文本内容(中英混合长度小于255)
     * @param cuid 用户唯一标识
     * @return 字节数组
     */
    private static byte[] synthesis(String token, String tex, String cuid){
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("tok", token);
        requestParams.put("tex", tex);
        requestParams.put("cuid", cuid);
        requestParams.put("ctp", SPEECH_CONFIG_CTP);
        requestParams.put("lan", SPEECH_CONFIG_LAN);
        requestParams.put("spd", SPEECH_CONFIG_SPD);
        requestParams.put("pit", SPEECH_CONFIG_PIT);
        requestParams.put("vol", SPEECH_CONFIG_VOL);
        requestParams.put("per", SPEECH_CONFIG_PER);
        try {
            Response response= HttpUtil.httpGetResponse(URL_SPEECH_TTS, null, requestParams);
            if (response.isSuccessful() && response.header("Content-type").contains("audio/mp3")) {
                return response.body().bytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分割文本分块
     * @param text 文本
     * @return SortedMap
     */
    private static SortedMap<Integer, String> splitChunks(String text){
        SortedMap<Integer, String> chunks = new TreeMap<>();
        int chunkIndex = 0;
        String chunkText = text;
        String sizedChunk;
        String chunk;
        int separatorPos;
        while (chunkText.length() > MAX_CHUNK_SIZE){
            sizedChunk = chunkText.substring(0, MAX_CHUNK_SIZE);
            separatorPos = sizedChunk.lastIndexOf(',');
            if (separatorPos < 0){
                chunk = sizedChunk;
                chunkText = chunkText.substring(chunk.length());
                chunks.put(++chunkIndex, chunk);
            } else if (separatorPos > 0){
                chunk = sizedChunk.substring(0, separatorPos);
                chunkText = chunkText.substring(chunk.length() + 1);
                chunks.put(++chunkIndex, chunk);
            } else {
                chunkText = chunkText.substring(1);
            }
        }
        if (chunkText.length() > 0){
            chunks.put(++chunkIndex, chunkText);
        }
        return chunks;
    }
}
