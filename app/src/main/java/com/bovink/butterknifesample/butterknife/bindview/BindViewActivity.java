package com.bovink.butterknifesample.butterknife.bindview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * com.bovink.butterknifesample.butterknife.bindview
 *
 * @author bovink
 * @since 2018/01/29
 */

public class BindViewActivity extends AppCompatActivity {

    @BindView(R.id.tv_test1)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindview);

        ButterKnife.bind(this);

        testTextView.setText("bind view from activity");

        BindViewFragment fragment = BindViewFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_fragment, fragment)
                .commit();
    }
}
