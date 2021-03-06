package com.feicui.gqq.gitandroid.github.login.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class AccessTokenResult {
    /**
     * access_token : e72e16c7e42f292c6912e7710c838347ae178b4a
     * scope : repo,gist
     * token_type : bearer
     */

    @SerializedName("access_token")
    private String accessToken;

    private String scope;
    @SerializedName("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public String getScope() {
        return scope;
    }

    public String getTokenType() {
        return tokenType;
    }

}
