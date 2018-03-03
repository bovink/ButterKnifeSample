package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bovink.butterknifesample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onlongclick);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_test, R.id.tv_test, R.id.iv_test})
    void clickView(View view) {

        if (view.getId() == R.id.btn_test) {

            Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.tv_test) {

            Toast.makeText(this, "click text", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.iv_test) {

            Toast.makeText(this, "click image", Toast.LENGTH_SHORT).show();
        }
    }

    @OnLongClick({R.id.btn_test, R.id.tv_test, R.id.iv_test})
    boolean longClickView(View view) {

        if (view.getId() == R.id.btn_test) {

            Toast.makeText(this, "long click button", Toast.LENGTH_SHORT).show();
            // 阻止点击事件继续传递
            return true;
        } else if (view.getId() == R.id.tv_test) {

            Toast.makeText(this, "long click text", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.iv_test) {

            Toast.makeText(this, "long click image", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
