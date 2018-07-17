package com.sml.jetpack.jetpackdemo.cheese.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.sml.jetpack.jetpackdemo.cheese.dao.CheeseDao;
import com.sml.jetpack.jetpackdemo.cheese.db.CheeseDb;
import com.sml.jetpack.jetpackdemo.cheese.entity.Cheese;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CheeseViewModel extends AndroidViewModel {

    private static final int PAGE_SIZE = 30;
    private static final boolean ENABLE_PLACEHOLDERS = true;

    private static CheeseDao dao;

    private LiveData<PagedList<Cheese>> allCheeses;

    public CheeseViewModel(@NonNull Application application) {
        super(application);
        dao = CheeseDb.get(application).cheeseDao();
        allCheeses = new LivePagedListBuilder<>(
                dao.allCheesesByName(),
                new PagedList.Config.Builder()
                        .setPageSize(PAGE_SIZE)
                        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
                        .build()).build();

    }

    public LiveData<PagedList<Cheese>> getAllCheeses() {
        return allCheeses;
    }

    public void insert(String text) {
        dao.insert(new Cheese(0, text));
    }

    public void remove(Cheese cheese) {
        dao.delete(cheese);
    }
}
