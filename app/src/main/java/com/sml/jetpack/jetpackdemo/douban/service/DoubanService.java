package com.sml.jetpack.jetpackdemo.douban.service;

import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;
import com.sml.jetpack.jetpackdemo.douban.entity.RequestEntity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public interface DoubanService {

    @GET("/v2/movie/top250")
    Observable<RequestEntity<DoubanMovie>> getMovieTop250(@Query("start") int start, @Query("count") int count);

}
