package com.bovink.butterknifesample.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindFloat;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.butterknifesample.butterknife.bindresource
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindFloatActivity extends AppCompatActivity {

    @BindFloat(R.dimen.text_size_float)
    float textSize;

    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_float);
        ButterKnife.bind(this);

        testBindFloat();
    }

    private void testBindFloat() {

        testTextView.setTextSize(textSize);
    }
}
