package com.sml.jetpack.jetpackdemo.cheese.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
@Entity
public class Cheese {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Cheese(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
