package com.bovink.butterknifesample.butterknife.bindresource;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.butterknifesample.butterknife.bindresource
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindColorActivity extends AppCompatActivity {

    @BindColor(R.color.colorAccent)
    int accentColor;
    @BindColor(R.color.text_click)
    ColorStateList textClickColorStateList;

    @BindView(R.id.tv_test1)
    TextView testTextView1;
    @BindView(R.id.tv_test2)
    TextView testTextView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_color);
        ButterKnife.bind(this);

        testTextView1.setTextColor(accentColor);

        // 设置可点击才会有点击变色效果
        testTextView2.setClickable(true);
        testTextView2.setTextColor(textClickColorStateList);
    }
}
