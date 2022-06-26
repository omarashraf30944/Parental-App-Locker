package com.example.controllproject.locked_app;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controllproject.R;
import com.example.controllproject.databinding.ListLockedBinding;
import com.example.controllproject.locked_app.data.ClickItem;
import com.example.controllproject.locked_app.data.DataItem;

import java.util.List;

public class AdapterLock extends RecyclerView.Adapter<AdapterLock.Holder> {
    List<String> list;
    Context context;
    ClickItem clickItem;
    PreferenceManager preferenceManager;

    public AdapterLock(List<String> list,Context context, ClickItem clickItem) {
        this.list = list;
        this.context = context;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()) , R.layout.list_locked , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        String appName = list.get(position);
        holder.binding.tv.setText(appName);
        holder.binding.lockImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), appName + " lock icon clicked", Toast.LENGTH_SHORT).show();
                putApp(v.getContext(), appName);
            }
        });
    }
    private void putApp(Context context,String appName) {
        Toast.makeText(context.getApplicationContext(), appName + " locked ", Toast.LENGTH_SHORT).show();
        preferenceManager = new PreferenceManager(context.getApplicationContext());
        preferenceManager.putBoolean(appName,true);
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
