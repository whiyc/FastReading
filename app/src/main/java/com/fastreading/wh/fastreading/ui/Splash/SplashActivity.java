package com.fastreading.wh.fastreading.ui.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fastreading.wh.fastreading.ui.BaseActivity;
import com.fastreading.wh.fastreading.ui.Main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{

            Thread.sleep(1000);

        }catch (Exception e){}

        startMain();

    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
