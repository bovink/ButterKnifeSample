package com.bovink.butterknifesample.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindAnimActivity extends AppCompatActivity {

    @BindAnim(R.anim.anim_text_in)
    Animation animation;

    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_anim);
        ButterKnife.bind(this);

        testBindAnim();
    }

    private void testBindAnim() {

        testTextView.startAnimation(animation);
    }

}
