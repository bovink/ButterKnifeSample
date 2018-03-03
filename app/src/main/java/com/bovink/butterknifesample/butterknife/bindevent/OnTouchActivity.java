package com.bovink.butterknifesample.butterknife.bindevent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnTouchActivity extends AppCompatActivity {

    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_ontouch);
        ButterKnife.bind(this);

        // 不设置可点击的话，就不会触发手指抬起事件
        testTextView.setClickable(true);
    }

    @OnTouch(R.id.tv_test)
    boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundColor(Color.parseColor("#66CCFF"));
                break;
            case MotionEvent.ACTION_UP:
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            default:
                break;
        }
        return false;
    }

}
