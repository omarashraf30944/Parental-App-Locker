package com.example.controllproject.locked_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.controllproject.R;
import com.example.controllproject.locked_app.data.AdapterLock;
import com.example.controllproject.locked_app.data.ClickItem;
import com.example.controllproject.locked_app.data.DataItem;

import java.util.ArrayList;
import java.util.List;

public class LockedAppActivity extends AppCompatActivity implements ClickItem {
    List<DataItem> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked_app);
        list = new ArrayList<>();
        list.add(new DataItem("instgram",R.drawable.ic_media1 , false));
        list.add(new DataItem("twitter",R.drawable.ic_media11 , false));
        list.add(new DataItem("PUGB",R.drawable.ic_media2 , false));
        list.add(new DataItem("facebook",R.drawable.ic_media3 , false));
        list.add(new DataItem("youtube",R.drawable.ic_media7 , true));
        list.add(new DataItem("files",R.drawable.ic_media9 , false));

        recyclerView = findViewById(R.id.recycler_locked_app);
        recyclerView.setAdapter(new AdapterLock(list , this , this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onclick(int position) {
        list.get(position).setLock(!list.get(position).isLock());
    }
}