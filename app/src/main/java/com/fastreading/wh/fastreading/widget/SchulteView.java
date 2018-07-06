package com.fastreading.wh.fastreading.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fastreading.wh.fastreading.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchulteView extends LinearLayout {

    private Context mContext;
    private static final int NUM_COLUMNS = 5;
    private static final int NUM_ROWS = 5;
    private int mTextColor = Color.parseColor("#333333");
    private OnFormClickListener onFormClickListener;
    private List<Integer> normalList = new ArrayList<>();
    private List<Integer> shufflelList = new ArrayList<>();
    private int[][] numberArray;
    private int totalNum;
    private LinearLayout formContain;


    public SchulteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        init();

    }

    private void init() {

        formContain = new LinearLayout(getContext());
        formContain.setOrientation(LinearLayout.VERTICAL);
        formContain.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(formContain);

        drawFrame(formContain);
        setFormData();

    }

    private void setFormData() {

        int sum = 0;

        for (int x = 0; x < NUM_ROWS; x++) {

            for (int y = 0; y < NUM_COLUMNS; y++) {

                RelativeLayout group = getFormItem(x, y);
                group.setGravity(Gravity.TOP);
                TextView view = null;
                if (group.getChildCount() > 0) {
                    view = (TextView) group.getChildAt(group
                            .getChildCount() - 1);
                } else {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            -1, -1);
                    view = new TextView(getContext());
                    view.setLayoutParams(params);
                    view.setGravity(Gravity.CENTER);
                    group.addView(view);
                }
                view.setText(shufflelList.get(sum).toString());
                view.setTextColor(mTextColor);
                numberArray[x][y] = shufflelList.get(sum);
                sum ++;

            }

        }

    }

    private RelativeLayout getFormItem(int row,int col){

        return (RelativeLayout) ((LinearLayout) formContain
                .getChildAt(row)).getChildAt(col);

    }

    private void drawFrame(LinearLayout formContain) {

        // 添加日期TextView
        for (int i = 0; i < NUM_ROWS; i++) {
            LinearLayout row = new LinearLayout(getContext());
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT, 0, 1));
            formContain.addView(row);
            // 绘制日历上的列
            for (int j = 0; j < NUM_COLUMNS; j++) {
                RelativeLayout col = new RelativeLayout(getContext());
                col.setLayoutParams(new LinearLayout.LayoutParams(0,
                        FrameLayout.LayoutParams.MATCH_PARENT, 1));
                col.setBackgroundResource(R.drawable.bg_formitem);
                col.setClickable(false);
                row.addView(col);
                // 给每一个日子加上监听
                col.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parent = (ViewGroup) v.getParent();
                        int row = 0, col = 0;

                        // 获取列坐标
                        for (int i = 0; i < parent.getChildCount(); i++) {
                            if (v.equals(parent.getChildAt(i))) {
                                col = i;
                                break;
                            }
                        }
                        // 获取行坐标
                        ViewGroup pparent = (ViewGroup) parent.getParent();
                        for (int i = 0; i < pparent.getChildCount(); i++) {
                            if (parent.equals(pparent.getChildAt(i))) {
                                row = i;
                                break;
                            }
                        }
                        if (onFormClickListener != null) {
                            onFormClickListener.onFormClickListener(row, col,
                                    numberArray[row][col]);
                        }
                    }
                });
            }
        }

    }

    private void initData() {

        totalNum = NUM_COLUMNS * NUM_ROWS;

        for (int i = 1; i <= totalNum; i++) {

            normalList.add(i);
        }
        shufflelList.addAll(normalList);
        Collections.shuffle(shufflelList);

        numberArray = new int[NUM_COLUMNS][NUM_ROWS];

    }


    /**
     * 设置点击回调事件
     */
    public interface OnFormClickListener {
        public void onFormClickListener(int row, int col, int i);
    }

    /**
     * 设置日期点击事件
     *
     * @param onFormClickListener
     */
    public void setOnFormClickListener(OnFormClickListener onFormClickListener) {
        this.onFormClickListener = onFormClickListener;
    }

    /**
     * 重置表数据
     */
    public void resetData(){

        Collections.shuffle(shufflelList);
        setFormData();
    }

}
