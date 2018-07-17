package com.sml.jetpack.jetpackdemo.viewmodel;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.sml.jetpack.jetpackdemo.entity.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Smeiling
 * @Date 2018-07-01
 * @Description 用于加载数据的数据源，为PagedList提供数据
 */
public class ItemDataSource extends PositionalDataSource<DataBean> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<DataBean> callback) {
        int totalCount = computeCount();
        int position = computeInitialLoadPosition(params, totalCount);
        int loadSize = computeInitialLoadSize(params, position, totalCount);
        callback.onResult(loadRangeInternal(position, loadSize), position, totalCount);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<DataBean> callback) {
        callback.onResult(loadRangeInternal(params.startPosition, params.loadSize));
    }

    /**
     * 加载数据
     *
     * @param position
     * @param loadSize
     * @return
     */
    private List<DataBean> loadRangeInternal(int position, int loadSize) {
        //TODO: Actual load code here
        List<DataBean> list = new ArrayList<>();
        for (int i = position + 1; i <= position + loadSize; i++) {
            list.add(new DataBean("LOADED ITEM (" + i + ")"));
        }
        return list;
    }

    /**
     * 要加载的数据总数
     *
     * @return
     */
    private int computeCount() {
        return 300;
    }

}
