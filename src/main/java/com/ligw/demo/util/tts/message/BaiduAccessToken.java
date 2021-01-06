package com.ligw.demo.util.tts.message;

/**
 * Description: BaiduAccessToken
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-04
 */
public class BaiduAccessToken extends BaseBaiduMessage {
    /**
     * access_token : 24.1f8790d07958d3ad1ccf4275b9c13de0.2592000.1514970010.282335-10477616
     * session_key : 9mzdCuKDupjSo0Z/n2/jTUHkskYQOsNhK+luUSwhu8K9T3M9Nhwhx4Pd6LHnTxW3XxCEzrr29GujToRQV+vdmYYnlLK9Yg==
     * scope : public brain_all_scope audio_voice_assistant_get audio_tts_post wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian ApsMisTest_Test权限 vis-classify_flower bnstest_fasf lpq_开放
     * refresh_token : 25.a83389c13e681b9432b1a33a90583135.315360000.1827738010.282335-10477616
     * session_secret : 12e059cdd13b433a46ac27dfd694ecb5
     * expires_in : 2592000
     */
    private String access_token;
    private String session_key;
    private String scope;
    private String refresh_token;
    private String session_secret;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getSession_secret() {
        return session_secret;
    }

    public void setSession_secret(String session_secret) {
        this.session_secret = session_secret;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
