package com.example.controllproject.down_time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.controllproject.PreferenceManager;
import com.example.controllproject.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DowntimeActivity extends AppCompatActivity {

    private int duration = 120;
    String appName;
    String time = " ";
    String down_time2 = " ";
    private boolean timerRunning=false;
    PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downtime);
        EditText time_et = findViewById(R.id.time_et);
        TextView hour =findViewById(R.id.tv_hour);
        TextView min  =findViewById(R.id.tv_min);
        TextView second =findViewById(R.id.tv_sec);
        Button usageLimte =findViewById(R.id.bu_limte);
        preferenceManager = new PreferenceManager(getApplicationContext());
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            appName = extras.getString("appName");
        }



        usageLimte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = time_et.getText().toString();
                int time_2 = Integer.parseInt(time);


                if(!timerRunning){
                    timerRunning=true;
                    new CountDownTimer(time_2 * 1000L, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String time =  String.format(Locale.getDefault(),"%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)-
                                                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Locale.getDefault());
                                    final String[]hourMinSec =time.split(":");
                                    hour.setText(hourMinSec[0]);
                                    min.setText(hourMinSec[1]);
                                    second.setText(hourMinSec[2]);
                                }
                            });

                        }

                        @Override
                        public void onFinish() {
                            duration=120;
                            timerRunning=false;
                            preferenceManager.putBoolean(appName,false);
                            Toast.makeText(DowntimeActivity.this, "Timer done" + preferenceManager.getBoolean(appName), Toast.LENGTH_SHORT).show();
                        }
                    }.start();

                }else {
                    Toast.makeText(DowntimeActivity.this, "Timer is already running", Toast.LENGTH_SHORT).show();

                }




            }
        });


       }



   }




