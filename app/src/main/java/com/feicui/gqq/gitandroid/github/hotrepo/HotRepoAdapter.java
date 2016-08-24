package com.feicui.gqq.gitandroid.github.hotrepo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.feicui.gqq.gitandroid.github.hotrepo.repolist.RepoListFragment;

import java.util.List;

/**
 * Created by gqq on 16/8/15.
 */
public class HotRepoAdapter extends FragmentPagerAdapter{

    private List<Language> languages;

    public HotRepoAdapter(FragmentManager fm, Context context) {
        super(fm);
        languages = Language.getDefaultLanguage(context);
    }

    @Override
    public Fragment getItem(int position) {
        return RepoListFragment.getInstance(languages.get(position));
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return languages.get(position).getName();
    }
}
