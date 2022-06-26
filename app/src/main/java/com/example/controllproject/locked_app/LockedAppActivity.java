package com.example.controllproject.locked_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;
import java.util.List;

import com.example.controllproject.R;
import com.example.controllproject.locked_app.AdapterLock;
import com.example.controllproject.locked_app.data.ClickItem;
import com.example.controllproject.locked_app.data.DataItem;


public class LockedAppActivity extends AppCompatActivity implements ClickItem {
    List<String> list;
    RecyclerView recyclerView;
    PreferenceManager preferenceManager;
    private static final String TAG = "Cannot invoke method length() on null object";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked_app);



        list = new ArrayList<>();
        list = getApps();


        recyclerView = findViewById(R.id.recycler_locked_app);
        recyclerView.setAdapter(new AdapterLock(list, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private List<String> getApps(){
        @SuppressLint("QueryPermissionsNeeded")
        List<PackageInfo> tmpApps = getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES);
        @SuppressLint("WrongConstant") List<ApplicationInfo> applicationInfos = getPackageManager()
                .getInstalledApplications(PackageManager.GET_ACTIVITIES);

        List<String> tmpApps2 = new ArrayList<>();

        for (int i = 0; i < applicationInfos.size(); i++) {
//            tmpApps2.add(applicationInfos.get(i).toString());
            if(applicationInfos.get(i).loadLabel(getApplicationContext().getPackageManager()).toString().length() <= 20){
                tmpApps2.add(applicationInfos.get(i).loadLabel(getApplicationContext().getPackageManager()).toString());
//            Log.e("getApps: ", tmpApps2.get(i).toString());
                Log.e("getApps: ", applicationInfos.get(i).loadLabel(getApplicationContext().getPackageManager()).toString());
            }

        }

        return tmpApps2;
    }
    @Override
    public void onclick(int position) {
        Toast.makeText(this, list.get(position), Toast.LENGTH_SHORT).show();



    }
}
