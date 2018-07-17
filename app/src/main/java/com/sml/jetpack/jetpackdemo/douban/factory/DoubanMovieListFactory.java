package com.sml.jetpack.jetpackdemo.douban.factory;

import android.arch.paging.DataSource;

import com.sml.jetpack.jetpackdemo.douban.datasource.DoubanTopDataSource;
import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class DoubanMovieListFactory extends DataSource.Factory<Integer, DoubanMovie> {
    @Override
    public DataSource<Integer, DoubanMovie> create() {
        return new DoubanTopDataSource();
    }
}
