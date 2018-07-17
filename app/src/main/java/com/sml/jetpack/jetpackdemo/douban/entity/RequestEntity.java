package com.sml.jetpack.jetpackdemo.douban.entity;

import java.util.List;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class RequestEntity<T> {
    private int count;
    private int start;
    private int total;
    private List<T> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<T> subjects) {
        this.subjects = subjects;
    }
}
