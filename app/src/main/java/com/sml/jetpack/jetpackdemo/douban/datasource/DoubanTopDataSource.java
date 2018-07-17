package com.sml.jetpack.jetpackdemo.douban.datasource;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;
import com.sml.jetpack.jetpackdemo.douban.entity.RequestEntity;
import com.sml.jetpack.jetpackdemo.douban.model.DoubanModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class DoubanTopDataSource extends PositionalDataSource<DoubanMovie> {

    private DoubanModel doubanModel;

    public DoubanTopDataSource() {
        this.doubanModel = new DoubanModel();
    }

    @Override
    public void loadInitial(@NonNull final LoadInitialParams params, @NonNull final LoadInitialCallback<DoubanMovie> callback) {
        doubanModel.getMovieTop250(params.requestedStartPosition, params.pageSize, new Observer<RequestEntity<DoubanMovie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RequestEntity<DoubanMovie> doubanMovieRequestEntity) {
                callback.onResult(doubanMovieRequestEntity.getSubjects(), doubanMovieRequestEntity.getStart(), doubanMovieRequestEntity.getCount());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("SMLSMLSML", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull final LoadRangeCallback<DoubanMovie> callback) {
        doubanModel.getMovieTop250(params.startPosition, params.loadSize, new Observer<RequestEntity<DoubanMovie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RequestEntity<DoubanMovie> doubanMovieRequestEntity) {
                callback.onResult(doubanMovieRequestEntity.getSubjects());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("SMLSMLSML", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
