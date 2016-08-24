package com.feicui.gqq.gitandroid.github.network;

import com.feicui.gqq.gitandroid.commons.LoggingInterceptor;
import com.feicui.gqq.gitandroid.github.hotrepo.repolist.model.RepoResult;
import com.feicui.gqq.gitandroid.github.login.model.AccessTokenResult;
import com.feicui.gqq.gitandroid.github.login.model.User;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class GithubClient implements GithubApi{

    private final GithubApi mGithubApi;
    private static GithubClient mGithubClient;

    public static GithubClient getInstance(){
        mGithubClient = new GithubClient();
        return mGithubClient;
    }

    private GithubClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .addInterceptor(new LoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mGithubApi = retrofit.create(GithubApi.class);

    }

    @Override
    public Call<AccessTokenResult> getOAuthToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("code") String code) {
        return mGithubApi.getOAuthToken(clientId, clientSecret, code);
    }

    @Override
    public Call<User> getUserInfo() {
        return mGithubApi.getUserInfo();
    }

    @Override
    public Call<RepoResult> searchRepo(@Query("q") String q, @Query("page") int pageId) {
        return mGithubApi.searchRepo(q, pageId);
    }
}
