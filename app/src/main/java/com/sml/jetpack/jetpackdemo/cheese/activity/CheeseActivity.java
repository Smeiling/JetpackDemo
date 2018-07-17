package com.sml.jetpack.jetpackdemo.cheese.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sml.jetpack.jetpackdemo.R;
import com.sml.jetpack.jetpackdemo.cheese.adapter.CheeseAdapter;
import com.sml.jetpack.jetpackdemo.cheese.entity.Cheese;
import com.sml.jetpack.jetpackdemo.cheese.viewmodel.CheeseViewModel;

public class CheeseActivity extends AppCompatActivity {

    private CheeseAdapter adapter;
    private CheeseViewModel viewModel;// = ViewModelProviders.of(this).get(CheeseViewModel.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);
        viewModel = ViewModelProviders.of(this).get(CheeseViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.cheese_list);
        // Create adapter for the RecyclerView
        adapter = new CheeseAdapter();
        recyclerView.setAdapter(adapter);

        // Subscribe the adapter to the ViewModel, so the items in the adapter are refreshed
        // when the list changes
        viewModel.getAllCheeses().observe(this, new Observer<PagedList<Cheese>>() {
            @Override
            public void onChanged(@Nullable PagedList<Cheese> cheeses) {
                adapter.submitList(cheeses);
            }
        });
    }
}
