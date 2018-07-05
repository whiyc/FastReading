package com.fastreading.wh.fastreading.utils;

import android.content.Context;

import com.fastreading.wh.fastreading.MyApplication;

/**
 * author: "wjh"
 * Date: 2018/7/5
 */
public class CommonUtils {

    public static Context getContext(){

        return MyApplication.getContext();

    }

    public static int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
