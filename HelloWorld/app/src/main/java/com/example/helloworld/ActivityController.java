package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    public static List<AppCompatActivity> list = new ArrayList<>();

    public static void addActivity(AppCompatActivity activity) {
        list.add(activity);
    }

    public static void removeActivity(AppCompatActivity activity) {
        list.remove(activity);
    }

    public static void finishedAllActivity() {
        for (AppCompatActivity activity: ActivityController.list) {
            activity.finish();
        }

        list.clear();
    }
}
