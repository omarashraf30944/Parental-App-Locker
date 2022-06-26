package com.example.controllproject;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityService";

    PreferenceManager preferenceManager;
    CountDownTimer countDownTimer;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, "onAccessibilityEvent: ");

        String packageName = event.getPackageName().toString();
        PackageManager packageManager = this.getPackageManager();
        try {
//            new CountDownTimer(60000, 1000) {
//
//                public void onTick(long millisUntilFinished) {
//                    Log.i(TAG, "onTick:" + millisUntilFinished / 1000);
//                }
//                public void onFinish() {
//                    Log.i(TAG, "onFinish: finished timer");
//                }
//            }.start();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName,0);
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
//            applicationLabel.equals("WhatsApp")
            Log.e(TAG, "app name is: " + applicationLabel);

//            if(applicationLabel.equals("WhatsApp")){
            Intent intent = new Intent(MyAccessibilityService.this,key_lock.class);
            intent.putExtra("appName",applicationLabel);

            preferenceManager = new PreferenceManager(getApplicationContext());

            Log.i(TAG, "onAccessibilityEvent: " + preferenceManager.getBoolean(applicationLabel.toString()));
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            if((!preferenceManager.getBoolean(applicationLabel.toString()))){
                System.out.println(applicationLabel.toString() + " is unlocked");
            }else if ((preferenceManager.getBoolean(applicationLabel.toString()))){
                System.out.println(applicationLabel + " is locked");
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
//        }

//            if(Globals.isAppLocked((String) applicationLabel)){
//                Intent intent = new Intent(MyAccessibilityService.this,Lock.class);
//                intent.putExtra("appName",applicationLabel);
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onInterrupt() {
        Log.e(TAG, "onInterrupt: something went wrong");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED |
                AccessibilityEvent.TYPE_VIEW_FOCUSED;
        
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        
        info.notificationTimeout = 100;

        this.setServiceInfo(info);

        Log.e(TAG, "onServiceConnected: ");
    }
}
