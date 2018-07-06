package com.fastreading.wh.fastreading.ui.SchulteGrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.fastreading.wh.fastreading.R;
import com.fastreading.wh.fastreading.ui.BaseActivity;
import com.fastreading.wh.fastreading.utils.CommonToast;
import com.fastreading.wh.fastreading.widget.SchulteView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchulteGridActivity extends BaseActivity {

    @BindView(R.id.schulteview)
    SchulteView schulteView;

    @BindView(R.id.bt_schulte_reset)
    Button bt_reset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schulte);
        ButterKnife.bind(this);

        schulteView.setOnFormClickListener(new SchulteView.OnFormClickListener() {
            @Override
            public void onFormClickListener(int row, int col, int i) {

                CommonToast.showToast(i + "");

            }
        });

        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                schulteView.resetData();

            }
        });

    }
}
