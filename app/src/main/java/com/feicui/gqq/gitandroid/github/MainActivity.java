package com.feicui.gqq.gitandroid.github;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.feicui.gqq.gitandroid.R;
import com.feicui.gqq.gitandroid.github.hotrepo.HotRepoFragment;
import com.feicui.gqq.gitandroid.github.hotuser.HotUserFragment;
import com.feicui.gqq.gitandroid.github.login.model.UserRepo;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigationView)
    NavigationView navigation;
    @BindView(R.id.main_drawerlayout)
    DrawerLayout drawerlayout;

    private Button mBtnLogin;
    private ImageView mIvIcon;


    private HotRepoFragment hotRepoFragment;
    private HotUserFragment hotUserFragment;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        navigation.setNavigationItemSelectedListener(itemSelectedListener);
        //Ctrl+Alt+F 局部变量变成员变量
        toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawerlayout.addDrawerListener(toggle);

        mBtnLogin = ButterKnife.findById(navigation.getHeaderView(0), R.id.btnLogin);
        mIvIcon = ButterKnife.findById(navigation.getHeaderView(0), R.id.ivIcon);


        hotRepoFragment = new HotRepoFragment();
        replaceFragment(hotRepoFragment);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (UserRepo.isEmpty()) {
            mBtnLogin.setText(R.string.login_github);
        } else {
            mBtnLogin.setText(R.string.switch_account);
            getSupportActionBar().setTitle(UserRepo.getUser().getName());

            ImageLoader.getInstance().displayImage(UserRepo.getUser().getAvatarUrl(), mIvIcon);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();
    }

    private NavigationView.OnNavigationItemSelectedListener itemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            if (item.isChecked()) {
                item.setCheckable(false);
            }
            switch (item.getItemId()) {

//                热门仓库
                case R.id.github_hot_repo: {
                    if (!hotRepoFragment.isAdded()) {
                        replaceFragment(hotRepoFragment);
                    }
                }
                break;

//                热门开发者
                case R.id.github_hot_user: {
                    if (hotUserFragment == null) {
                        hotUserFragment = new HotUserFragment();
                    }
                    replaceFragment(hotUserFragment);
                }

                break;

//                我的收藏
                case R.id.arsenal_my_repo: {

                }
                break;

//                每日干货
                case R.id.tips_daily: {

                }
                break;

            }


//            drawerlayout.closeDrawer(GravityCompat.START);
            return true;
//           return ture; 将选择的东西设置为选择状态
        }
    };
}
