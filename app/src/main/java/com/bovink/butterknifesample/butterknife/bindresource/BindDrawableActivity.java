package com.bovink.butterknifesample.butterknife.bindresource;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.butterknifesample.butterknife.bindresource
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindDrawableActivity extends AppCompatActivity {

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable iconDrawable;

    @BindDrawable(value = R.mipmap.ic_launcher, tint = R.attr.colorAccent)
    Drawable iconDrawable2;

    @BindView(R.id.tv_test)
    TextView testTextView;

    @BindView(R.id.iv_test)
    ImageView testImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_drawable);
        ButterKnife.bind(this);

        testBindDrawable();

    }

    private void testBindDrawable() {
        testTextView.setBackground(iconDrawable);
        testImageView.setBackground(iconDrawable2);
    }

}
