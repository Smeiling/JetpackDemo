package com.sml.jetpack.jetpackdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sml.jetpack.jetpackdemo.adapter.CustomAdapter;
import com.sml.jetpack.jetpackdemo.entity.DataBean;
import com.sml.jetpack.jetpackdemo.factory.CustomPageDataSourceFactory;
import com.sml.jetpack.jetpackdemo.model.DataModel;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CustomActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataModel.getInstance();
        recyclerView = findViewById(R.id.recycler_view);

        final CustomAdapter customAdapter = new CustomAdapter(this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .build();

        LiveData<PagedList<DataBean>> data = new LivePagedListBuilder<>(new CustomPageDataSourceFactory(), config).build();
        data.observe(this, new Observer<PagedList<DataBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<DataBean> dataBeans) {
                customAdapter.submitList(dataBeans);
            }
        });

    }
}
