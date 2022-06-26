package com.example.controllproject.locked_app.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controllproject.R;
import com.example.controllproject.databinding.ListLockedBinding;

import java.util.List;

public class AdapterLock extends RecyclerView.Adapter<AdapterLock.Holder> {
    List<DataItem> list;
    Context context;
    ClickItem clickItem;

    public AdapterLock(List<DataItem> list, Context context, ClickItem clickItem) {
        this.list = list;
        this.context = context;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(DataBindingUtil.inflate(LayoutInflater.from(context) , R.layout.list_locked , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
    DataItem dataItem = list.get(position);
    holder.binding.img.setImageResource(dataItem.getImg());
    holder.binding.tv.setText(dataItem.getText());
    if (dataItem.isLock) {
        holder.binding.lock.setImageResource(R.drawable.ic_lock_open);
    } else {
        holder.binding.lock.setImageResource(R.drawable.ic_lock_24);
    }

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clickItem.onclick(position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ListLockedBinding binding;
        public Holder(@NonNull ListLockedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
