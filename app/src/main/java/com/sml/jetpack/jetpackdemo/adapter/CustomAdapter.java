package com.sml.jetpack.jetpackdemo.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sml.jetpack.jetpackdemo.R;
import com.sml.jetpack.jetpackdemo.entity.DataBean;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
public class CustomAdapter extends PagedListAdapter<DataBean, CustomAdapter.ItemViewHolder> {

    private Context mContext;

    private static DiffUtil.ItemCallback<DataBean> diffCallback = new DiffUtil.ItemCallback<DataBean>() {
        @Override
        public boolean areItemsTheSame(DataBean oldItem, DataBean newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(DataBean oldItem, DataBean newItem) {
            return oldItem.getCurItem().equals(newItem.getCurItem());
        }
    };

    public CustomAdapter(Context context) {
        super(diffCallback);
        mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_test_list, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.mTextView.setText(getItem(position).getCurItem());
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView mTextView;

        ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }
    }
}
