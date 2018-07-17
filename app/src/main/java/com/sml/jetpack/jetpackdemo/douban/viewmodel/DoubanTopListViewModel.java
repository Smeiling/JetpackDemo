package com.sml.jetpack.jetpackdemo.douban.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;
import com.sml.jetpack.jetpackdemo.douban.factory.DoubanMovieListFactory;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class DoubanTopListViewModel extends ViewModel {

    public static final int PAGE_SIZE = 10;
    public static final boolean ENABLE_PLACEHOLDERS = false;

    private LiveData<PagedList<DoubanMovie>> movieList;

    public DoubanTopListViewModel() {

        movieList = new LivePagedListBuilder<>(
                new DoubanMovieListFactory(),
                new PagedList.Config.Builder()
                        .setPageSize(PAGE_SIZE)
                        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
                        .build()).build();
    }

    public LiveData<PagedList<DoubanMovie>> getMovieList() {
        return movieList;
    }
}
