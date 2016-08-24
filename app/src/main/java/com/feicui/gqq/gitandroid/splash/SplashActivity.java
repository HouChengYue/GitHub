package com.feicui.gqq.gitandroid.splash;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.feicui.gqq.gitandroid.github.MainActivity;
import com.feicui.gqq.gitandroid.R;
import com.feicui.gqq.gitandroid.commons.ActivityUtils;
import com.feicui.gqq.gitandroid.github.login.LoginActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends FragmentActivity {

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        activityUtils = new ActivityUtils(this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.splash_login)
    public void login() {
        activityUtils.startActivity(LoginActivity.class);
        finish();
    }


    @OnClick(R.id.splash_use)
    public void use() {
        activityUtils.startActivity(MainActivity.class);
        finish();
    }
}
