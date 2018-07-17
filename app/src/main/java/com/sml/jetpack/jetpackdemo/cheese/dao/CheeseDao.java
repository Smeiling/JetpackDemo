package com.sml.jetpack.jetpackdemo.cheese.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sml.jetpack.jetpackdemo.cheese.entity.Cheese;

import java.util.List;


/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
@Dao
public interface CheeseDao {
    @Query("SELECT * FROM Cheese ORDER BY name COLLATE NOCASE ASC")
    DataSource.Factory<Integer, Cheese> allCheesesByName();

    @Insert
    void insert(List<Cheese> cheeses);

    @Insert
    void insert(Cheese cheese);

    @Delete
    void delete(Cheese cheese);

}
