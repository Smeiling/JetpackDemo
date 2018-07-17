package com.sml.jetpack.jetpackdemo.viewmodel;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.sml.jetpack.jetpackdemo.entity.DataBean;
import com.sml.jetpack.jetpackdemo.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CustomPageDataSource extends PageKeyedDataSource<Integer, DataBean> {


    /**
     * 初始加载数据
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, DataBean> callback) {
        callback.onResult(DataModel.getInstance().loadData(params.requestedLoadSize), null, 2);
    }

    /**
     * 向后分页加载数据
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DataBean> callback) {
        callback.onResult(DataModel.getInstance().loadData(params.key, params.requestedLoadSize), params.key + 2);
    }

    /**
     * 向前分页加载数据
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DataBean> callback) {
        callback.onResult(DataModel.getInstance().loadData(params.key, params.requestedLoadSize), params.key - 1);
    }
}
