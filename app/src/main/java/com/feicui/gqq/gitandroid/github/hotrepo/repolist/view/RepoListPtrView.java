package com.feicui.gqq.gitandroid.github.hotrepo.repolist.view;

import com.feicui.gqq.gitandroid.github.hotrepo.repolist.model.Repo;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16 0016.
 */
public interface RepoListPtrView {

    //显示刷新视图
    void showContent();

//    显示加载错误的视图
    void showError();

//    显示没有数据的视图
    void showEmpty();

    void refreshData(List<Repo> list);

//    停止刷新
    void stopRefre();

    void showMessage(String msg);

}
