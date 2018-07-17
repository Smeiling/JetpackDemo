package com.sml.jetpack.jetpackdemo.cheese.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sml.jetpack.jetpackdemo.R;
import com.sml.jetpack.jetpackdemo.cheese.entity.Cheese;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CheeseAdapter extends PagedListAdapter<Cheese, CheeseAdapter.CheeseViewHolder> {

    private static DiffUtil.ItemCallback<Cheese> diffCallback = new DiffUtil.ItemCallback<Cheese>() {
        @Override
        public boolean areItemsTheSame(Cheese oldItem, Cheese newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Cheese oldItem, Cheese newItem) {
            return oldItem == newItem;
        }
    };

    public CheeseAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CheeseAdapter.CheeseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheeseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_list, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CheeseAdapter.CheeseViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    class CheeseViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView textView;
        private Cheese cheese;

        public CheeseViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bindTo(Cheese cheese) {
            this.cheese = cheese;
            textView.setText(cheese.getName());
        }
    }
}
