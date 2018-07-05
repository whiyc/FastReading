package com.fastreading.wh.fastreading;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context myContext;

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = getApplicationContext();
    }

    public static Context getContext(){

        return myContext;
    }

}
