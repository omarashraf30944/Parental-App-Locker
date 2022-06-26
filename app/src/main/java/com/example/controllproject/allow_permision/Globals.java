package com.example.controllproject.allow_permision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Globals {

    public static HashMap<String,String> lockedApps = new HashMap<>();
    //app name and app password

    public static List<String> appNames = new ArrayList<>();

    public Globals() {
        addApp("Facebook");

        addApp("WhatsApp");

    }

    static void addApp(String name){
        lockedApps.put(name,"123");
        appNames.add(name);
    }

    static void removeApp(String name, String password){
        lockedApps.remove(name);
        appNames.remove(name);
    }


    static void removeApp(String name){
        lockedApps.remove(name);
        appNames.remove(name);
    }

    static String getPassword(String appName){
        String x = lockedApps.get(appName);
        return x;
    }

    public static boolean isAppLocked(String appName){
        return appNames.contains(appName);
    }
}
