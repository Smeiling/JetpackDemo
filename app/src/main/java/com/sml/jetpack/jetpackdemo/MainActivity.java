package com.sml.jetpack.jetpackdemo;

import android.arch.paging.PagedList;
import android.arch.paging.PositionalDataSource;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.sml.jetpack.jetpackdemo.adapter.ItemPagedAdapter;
import com.sml.jetpack.jetpackdemo.entity.DataBean;
import com.sml.jetpack.jetpackdemo.viewmodel.ItemDataSource;

import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private PagedList<DataBean> mPagedList;
    private ItemDataSource mDataSource;

    private RecyclerView mRecyclerView;
    private ItemPagedAdapter mAdapter;

    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPagedList.loadAround(30);
                mAdapter.submitList(mPagedList);
            }
        });
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        initPagedList();
        mAdapter = new ItemPagedAdapter(this, new DiffUtil.ItemCallback<DataBean>() {
            @Override
            public boolean areItemsTheSame(DataBean oldItem, DataBean newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(DataBean oldItem, DataBean newItem) {
                return oldItem.getCurItem().equals(newItem.getCurItem());
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPos = mLayoutManager.findLastVisibleItemPosition();
                mPagedList.loadAround(lastPos);
                mAdapter.submitList(mPagedList);
            }
        });
        mAdapter.submitList(mPagedList);
    }

    private void initPagedList() {
        mDataSource = new ItemDataSource();
        PagedList.Config mPagedListConfig = new PagedList.Config.Builder()
                .setPageSize(10) // 分页数据的数量，DataSource中的count即为这个值
                .setPrefetchDistance(5) // 初始化时，预取数据数量
                .setEnablePlaceholders(false)
                .build();


        mPagedList = new PagedList.Builder<>(mDataSource, mPagedListConfig)
                .setInitialKey(0)
                .setFetchExecutor(new Executor() {
                    @Override
                    public void execute(@NonNull Runnable command) {
                        Log.d("SMLSMLSML", "BackgroundThreadTask run");
                    }
                })
                .setNotifyExecutor(new Executor() {
                    @Override
                    public void execute(@NonNull Runnable command) {
                        Log.d("SMLSMLSML", "MainThreadTask run");
                    }
                })
                .setBoundaryCallback(new PagedList.BoundaryCallback() {
                    @Override
                    public void onZeroItemsLoaded() {
                        super.onZeroItemsLoaded();
                    }
                }).build();
    }
}
