package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bovink.butterknifesample.R;

import butterknife.ButterKnife;
import butterknife.OnFocusChange;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnFocusChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onfocuschange);
        ButterKnife.bind(this);
    }

    @OnFocusChange({R.id.et_test1, R.id.et_test2})
    void onFocusChanged(View view, boolean focused) {

        if (view.getId() == R.id.et_test1) {

            Toast.makeText(this, focused ? "1 focused" : "1 not focused", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.et_test2) {

            Toast.makeText(this, focused ? "2 focused" : "2 not focused", Toast.LENGTH_SHORT).show();
        }
    }
}
