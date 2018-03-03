package com.bovink.butterknifesample.butterknife.bindevent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bovink.butterknifesample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * com.bovink.butterknifesample.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnItemClickActivity extends AppCompatActivity {

    private Context mContext;
    private List<String> stringList = new ArrayList<>();

    @BindView(R.id.lv_test)
    ListView testListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onitemclick);
        ButterKnife.bind(this);

        mContext = this;
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");

        testListView.setAdapter(new TextAdapter());
    }

    private class TextAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return stringList.size();
        }

        @Override
        public String getItem(int position) {
            return stringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position + 100;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();

                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_activity, null);
                viewHolder.nameTextView = convertView.findViewById(R.id.tv_name);

                convertView.setTag(viewHolder);
            } else {

                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.nameTextView.setText(stringList.get(position));

            return convertView;
        }

        private class ViewHolder {
            TextView nameTextView;
        }
    }

    @OnItemClick(R.id.lv_test)
    void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView textView = view.findViewById(R.id.tv_name);

        System.out.println("textView.getText() = " + textView.getText());
        System.out.println("position = " + position);
        System.out.println("id = " + id);
    }
}
