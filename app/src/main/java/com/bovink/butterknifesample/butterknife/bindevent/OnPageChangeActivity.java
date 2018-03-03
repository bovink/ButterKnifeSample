package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bovink.butterknifesample.R;
import com.bovink.butterknifesample.TextFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnPageChange;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnPageChangeActivity extends AppCompatActivity {

    private List<TextFragment> textFragments = new ArrayList<>();

    @BindView(R.id.vp_test)
    ViewPager testViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onpagechange);
        ButterKnife.bind(this);

        TextFragment textFragment;
        textFragment = TextFragment.newInstance("one");
        textFragments.add(textFragment);
        textFragment = TextFragment.newInstance("two");
        textFragments.add(textFragment);
        textFragment = TextFragment.newInstance("three");
        textFragments.add(textFragment);

        testViewPager.setAdapter(new ImageViewPageAdapter(getSupportFragmentManager()));

    }

    private class ImageViewPageAdapter extends FragmentPagerAdapter {

        public ImageViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return textFragments.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @OnPageChange(value = R.id.vp_test, callback = OnPageChange.Callback.PAGE_SELECTED)
    void onPageSelected(int position) {

        System.out.println("position = " + position);
    }

    @OnPageChange(value = R.id.vp_test, callback = OnPageChange.Callback.PAGE_SCROLLED)
    void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        System.out.println("position = " + position);
        System.out.println("positionOffset = " + positionOffset);
        System.out.println("positionOffsetPixels = " + positionOffsetPixels);
    }

    @OnPageChange(value = R.id.vp_test, callback = OnPageChange.Callback.PAGE_SCROLL_STATE_CHANGED)
    void onPageScrollStateChanged(int state) {

        if (state == ViewPager.SCROLL_STATE_IDLE) {

            System.out.println("SCROLL_STATE_IDLE");
        } else if (state == ViewPager.SCROLL_STATE_DRAGGING) {

            System.out.println("SCROLL_STATE_DRAGGING");
        } else if (state == ViewPager.SCROLL_STATE_SETTLING) {

            System.out.println("SCROLL_STATE_SETTLING");
        }
    }
}
