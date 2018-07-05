package com.fastreading.wh.fastreading.ui.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fastreading.wh.fastreading.R;
import com.fastreading.wh.fastreading.ui.SchulteGrid.SchulteGridActivity;
import com.fastreading.wh.fastreading.utils.CommonToast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_main_mine)
    Button bt_mine;

    @BindView(R.id.bt_main_vision)
    Button bt_vision;

    @BindView(R.id.bt_main_pic)
    Button bt_pic;

    @BindView(R.id.bt_main_schulte)
    Button bt_schulte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {

        bt_mine.setOnClickListener(this);
        bt_vision.setOnClickListener(this);
        bt_pic.setOnClickListener(this);
        bt_schulte.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_main_mine:

                CommonToast.showToast("敬请期待~");

                break;

            case R.id.bt_main_vision:

                CommonToast.showToast("敬请期待~");

                break;

            case R.id.bt_main_pic:

                CommonToast.showToast("敬请期待~");

                break;

            case R.id.bt_main_schulte:

                Intent schulteIntent = new Intent(this, SchulteGridActivity.class);

                startActivity(schulteIntent);

                break;

        }

    }
}
