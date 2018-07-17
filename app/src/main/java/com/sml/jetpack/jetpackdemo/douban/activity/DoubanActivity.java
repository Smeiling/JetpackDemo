package com.sml.jetpack.jetpackdemo.douban.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sml.jetpack.jetpackdemo.R;
import com.sml.jetpack.jetpackdemo.douban.adapter.MovieListPagerAdapter;
import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;
import com.sml.jetpack.jetpackdemo.douban.viewmodel.DoubanTopListViewModel;

public class DoubanActivity extends AppCompatActivity {

    private DoubanTopListViewModel viewModel;
    private RecyclerView movieRecyclerView;
    private Button button;
    private MovieListPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        movieRecyclerView = findViewById(R.id.movie_list);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MovieListPagerAdapter();
        movieRecyclerView.setAdapter(mAdapter);
        initViewModel();
        viewModel.getMovieList().observe(this, new Observer<PagedList<DoubanMovie>>() {
            @Override
            public void onChanged(@Nullable PagedList<DoubanMovie> doubanMovies) {
                mAdapter.submitList(doubanMovies);
            }
        });

    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(DoubanTopListViewModel.class);
    }
}
