package com.fastreading.wh.fastreading.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * author: "wjh"
 * date: 2018/7/5
 */
public class CommonToast {

    private static Toast mToast;

    public static void showToast(CharSequence message) {
        if (null == mToast) {
            mToast = Toast.makeText(CommonUtils.getContext(),message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);// 居中显示
        mToast.show();
    }

}
