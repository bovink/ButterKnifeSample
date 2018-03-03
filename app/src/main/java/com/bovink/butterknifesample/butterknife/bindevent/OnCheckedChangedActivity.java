package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bovink.butterknifesample.R;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnCheckedChangedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_oncheckedchanged);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged(R.id.tb_test)
    void checkToggle(boolean checked) {

        Toast.makeText(this, checked ? "toggle checked" : "toggle not checked", Toast.LENGTH_SHORT).show();
    }

    /**
     * 由于是判断CheckBox的Check状态，所以不论选中还是取消选中都会触发事件
     */
    @OnCheckedChanged({R.id.rb_test1, R.id.rb_test2})
    void checkRadio(RadioButton rb, boolean checked) {

        if (rb.getId() == R.id.rb_test1) {

            Toast.makeText(this, checked ? "rb1 checked" : "rb1 not checked", Toast.LENGTH_SHORT).show();
        } else if (rb.getId() == R.id.rb_test2) {

            Toast.makeText(this, checked ? "rb2 checked" : "rb2 not checked", Toast.LENGTH_SHORT).show();
        }

    }

    @OnCheckedChanged(R.id.cb_test)
    void checkBox(boolean checked) {

        Toast.makeText(this, checked ? "box checked" : "box not checked", Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.switch_test)
    void checkSwitch(boolean checked) {

        Toast.makeText(this, checked ? "switch checked" : "switch not checked", Toast.LENGTH_SHORT).show();
    }
}
