package com.bovink.butterknifesample.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnItemSelectedActivity extends AppCompatActivity {

    @BindView(R.id.spinner_test)
    Spinner testSpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onitemselected);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.week, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        testSpinner.setAdapter(arrayAdapter);
    }

    @OnItemSelected(value = R.id.spinner_test, callback = OnItemSelected.Callback.ITEM_SELECTED)
    void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView textView = (TextView) view;

        System.out.println("textView.getText() = " + textView.getText());
        System.out.println("position = " + position);
        System.out.println("id = " + id);
    }

    @OnItemSelected(value = R.id.spinner_test, callback = OnItemSelected.Callback.NOTHING_SELECTED)
    void onNothingSelected(AdapterView<?> parent) {

        System.out.println("OnItemSelectedActivity.onNothingSelected");
    }

}
