package com.sml.jetpack.jetpackdemo.douban.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sml.jetpack.jetpackdemo.R;
import com.sml.jetpack.jetpackdemo.douban.entity.DoubanMovie;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class MovieListPagerAdapter extends PagedListAdapter<DoubanMovie, MovieListPagerAdapter.ItemViewHolder> {

    private static DiffUtil.ItemCallback<DoubanMovie> diffCallback = new DiffUtil.ItemCallback<DoubanMovie>() {
        @Override
        public boolean areItemsTheSame(DoubanMovie oldItem, DoubanMovie newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(DoubanMovie oldItem, DoubanMovie newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    };

    public MovieListPagerAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_list, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.mTextView.setText(getItem(position).getTitle());
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView mTextView;

        ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }
    }
}
