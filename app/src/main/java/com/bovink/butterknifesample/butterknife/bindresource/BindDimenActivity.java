package com.bovink.butterknifesample.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.butterknifesample.butterknife.bindresource
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindDimenActivity extends AppCompatActivity {

    @BindDimen(R.dimen.text_size)
    int textSize;
    @BindDimen(R.dimen.text_margin_top)
    int textMarginTop;
    @BindDimen(R.dimen.text_margin_left)
    float textMarginLeft;

    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_dimen);
        ButterKnife.bind(this);

        System.out.println("textSize = " + textSize);
        System.out.println("textMarginTop = " + textMarginTop);
        System.out.println("textMarginLeft = " + textMarginLeft);

        testBindDimen();
    }

    private void testBindDimen() {

        testTextView.setTextSize(textSize);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) testTextView.getLayoutParams();
        params.topMargin = textMarginTop;
        testTextView.setLayoutParams(params);
    }
}
