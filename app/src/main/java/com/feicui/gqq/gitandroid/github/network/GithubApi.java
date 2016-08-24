package com.feicui.gqq.gitandroid.github.network;

import com.feicui.gqq.gitandroid.github.hotrepo.repolist.model.RepoResult;
import com.feicui.gqq.gitandroid.github.login.model.AccessTokenResult;
import com.feicui.gqq.gitandroid.github.login.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public interface GithubApi {

    String CALL_BACK = "feicui";

    // GitHub开发者，申请就行
    String CLIENT_ID = "aa7a3fb1b42f8c07a232";
    String CLIENT_SECRET = "841a9cfd15ded1abb9d75ba51d2d8dd0189ebb77";

    // 授权时申请的可访问域
    String AUTH_SCOPE = "user,public_repo,repo";
    // 授权登陆页面(用WebView来加载)
    String AUTH_RUL = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&scope=" + AUTH_SCOPE;
//    String AUTH_RUL = "https://github.com/login/oauth/authorize?client_id=aa7a3fb1b42f8c07a232&scope=user,public_repo,repo;

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("https://github.com/login/oauth/access_token")
    Call<AccessTokenResult> getOAuthToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("code") String code);

    @GET("user")
    Call<User> getUserInfo();

    @GET("search/repositories")
    Call<RepoResult> searchRepo(@Query("q") String q,@Query("page") int pageId);


}
