package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;

import com.bovink.butterknifesample.R;

import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnTextChangedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_ontextchanged);
        ButterKnife.bind(this);
    }

    /**
     * 默认callback是TEXT_CHANGED
     *
     * @param s      输入后的字符串
     * @param start  被替换的字符前面的字符数量
     * @param before 被替换的字符的数量
     * @param count  替换的字符的数量
     */
    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTextChanged(CharSequence s, int start, int before, int count) {

        System.out.println("OnTextChangedActivity.onTextChanged");
        System.out.println("s = " + s);
        System.out.println("start = " + start);
        System.out.println("before = " + before);
        System.out.println("count = " + count);
    }

    /**
     * @param s     字符串改变前的内容
     * @param start 被替换的字符前面的字符数量
     * @param count 被替换的字符的数量
     * @param after 替换的字符的数量
     */
    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s, int start, int count, int after) {

        System.out.println("OnTextChangedActivity.beforeTextChanged");
        System.out.println("s = " + s);
        System.out.println("start = " + start);
        System.out.println("count = " + count);
        System.out.println("after = " + after);
    }

    /**
     * @param s 输入后的字符串
     */
    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {

        System.out.println("OnTextChangedActivity.afterTextChanged");
        System.out.println("s.toString() = " + s.toString());
    }

}
