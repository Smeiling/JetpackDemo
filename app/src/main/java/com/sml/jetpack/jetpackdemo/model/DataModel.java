package com.sml.jetpack.jetpackdemo.model;

import android.util.Log;

import com.sml.jetpack.jetpackdemo.entity.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class DataModel {

    private List<DataBean> list;
    private static DataModel instance;

    private DataModel() {
        this.list = new ArrayList<>();
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new DataBean("ITEM (" + i + ")"));
        }
    }

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public List<DataBean> loadData(int size) {
        Log.d("SMLSMLSML", "loadData size = " + size);
        if (size < list.size()) {
            return list.subList(0, size);
        } else {
            return list;
        }
    }

    public List<DataBean> loadData(int index, int size) {
        Log.d("SMLSMLSML", "loadData index = " + index + ", size = " + size);
        if (index >= list.size() || index < 0) {
            return null;
        }
        if (index + size > list.size()) {
            return list.subList(index + 1, list.size());
        }
        return list.subList(index + 1, index + size);
    }

    public List<DataBean> loadPageData(int page, int size) {
        int totalPage = list.size() % size == 0 ? list.size() / size : list.size() / size + 1;
        if (page > totalPage || page < 1) {
            return null;
        }
        if (page == totalPage) {
            return list.subList((page - 1) * size, list.size());
        }
        return list.subList((page - 1) * size, page * size);

    }

}
