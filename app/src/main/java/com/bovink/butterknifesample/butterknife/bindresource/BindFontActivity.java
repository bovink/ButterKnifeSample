package com.bovink.butterknifesample.butterknife.bindresource;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindFont;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.butterknifesample.butterknife.bindresource
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindFontActivity extends AppCompatActivity {

    @BindFont(R.font.pianpianti)
    Typeface typeface1;

    @BindFont(value = R.font.pianpianti, style = Typeface.ITALIC)
    Typeface typeface2;

    @BindView(R.id.tv_test1)
    TextView testTextView1;

    @BindView(R.id.tv_test2)
    TextView testTextView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_font);
        ButterKnife.bind(this);

        testBindFont();
    }

    private void testBindFont() {

        testTextView1.setTypeface(typeface1);
        testTextView2.setTypeface(typeface2);
    }

}
