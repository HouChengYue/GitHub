package com.feicui.gqq.gitandroid.github.hotrepo.repolist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class RepoResult {


    /**
     * total_count : 2074901
     * incomplete_results : false
     * items : [{}]
     */

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("items")
    private List<Repo> repoList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Repo> getRepoList() {
        return repoList;
    }
}
