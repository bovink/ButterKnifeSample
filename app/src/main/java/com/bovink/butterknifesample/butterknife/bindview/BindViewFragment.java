package com.bovink.butterknifesample.butterknife.bindview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class BindViewFragment extends Fragment {

    @BindView(R.id.iv_test)
    ImageView testImageView;

    public static BindViewFragment newInstance() {
        return new BindViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bindview, container, false);

        ButterKnife.bind(this, root);

        testImageView.setImageResource(R.drawable.all);

        ActivityView activityView = new ActivityView();

        ButterKnife.bind(activityView, getActivity());

        activityView.testTextView.setText("bind from fragment");

        return root;
    }

    public class ActivityView {

        @BindView(R.id.tv_test2)
        TextView testTextView;

    }
}
