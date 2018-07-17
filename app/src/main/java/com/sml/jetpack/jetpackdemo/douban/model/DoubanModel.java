package com.sml.jetpack.jetpackdemo.douban.model;

import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;
import com.sml.jetpack.jetpackdemo.douban.entity.RequestEntity;
import com.sml.jetpack.jetpackdemo.douban.service.DoubanService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class DoubanModel {
    private String mBaseUrl = "https://api.douban.com";

    public DoubanService getService() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(DoubanService.class);
    }

    public void getMovieTop250(int start, int size, Observer<RequestEntity<DoubanMovie>> observer) {
        Observable<RequestEntity<DoubanMovie>> observable = getService().getMovieTop250(start, size);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
