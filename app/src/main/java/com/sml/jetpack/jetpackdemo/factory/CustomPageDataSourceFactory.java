package com.sml.jetpack.jetpackdemo.factory;

import android.arch.paging.DataSource;

import com.sml.jetpack.jetpackdemo.entity.DataBean;
import com.sml.jetpack.jetpackdemo.viewmodel.CustomPageDataSource;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CustomPageDataSourceFactory extends DataSource.Factory<Integer, DataBean> {
    @Override
    public DataSource<Integer, DataBean> create() {
        return new CustomPageDataSource();
    }
}
