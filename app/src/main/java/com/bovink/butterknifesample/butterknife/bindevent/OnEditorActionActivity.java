package com.bovink.butterknifesample.butterknife.bindevent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.ButterKnife;
import butterknife.OnEditorAction;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnEditorActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_oneditoraction);
        ButterKnife.bind(this);
    }

    @OnEditorAction(R.id.et_test)
    boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE) {
            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            return true;
        }
        return false;
    }
}
