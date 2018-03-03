package com.bovink.butterknifesample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * com.bovink.butterknifesample
 *
 * @author bovink
 * @since 2018/01/29
 */

public class MainActivity extends ListActivity {
    /**
     * 包名
     */
    private String mPackageName;
    List<Map<String, String>> mapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int type = getIntent().getIntExtra("type", 0);

        if (type == 1) {// 绑定资源

            mapList = generateResourceList();
            mPackageName = "com.bovink.butterknifesample.butterknife.bindresource.";
        } else if (type == 2) {// 绑定事件

            mapList = generateEventList();
            mPackageName = "com.bovink.butterknifesample.butterknife.bindevent.";
        } else if (type == 3) {// 绑定单个视图

            mapList = generateViewList();
            mPackageName = "com.bovink.butterknifesample.butterknife.bindview.";
        } else if (type == 4) {// 绑定多个视图

            mapList = generateViewsList();
            mPackageName = "com.bovink.butterknifesample.butterknife.bindviews.";
        } else {// 选择绑定资源或是绑定事件

            mapList = generateBindList();
            mPackageName = "com.bovink.butterknifesample.";
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                mapList,
                R.layout.list_item_activity,
                new String[]{"name"},
                new int[]{R.id.tv_name}
        );

        setListAdapter(simpleAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String activityName = mapList.get(position).get("name");
        if (activityName.contains(".")) {
            System.out.println("activityName = " + activityName);
            activityName = activityName.split("\\.")[0];
        }

        try {
            Class clazz = Class.forName(mPackageName + activityName);
            Intent intent = new Intent(this, clazz);
            if (activityName.equals("MainActivity")) {
                intent.putExtra("type", position + 1);
            }
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成绑定列表
     */
    private List<Map<String, String>> generateBindList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "MainActivity.BindResource");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.BindEvent");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.BindView");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.BindViews");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定资源列表
     */
    private List<Map<String, String>> generateResourceList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindAnimActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindArrayActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindBitmapActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindBoolActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindColorActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindDimenActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindDrawableActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindFloatActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindFontActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindIntActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindStringActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定事件列表
     */
    private List<Map<String, String>> generateEventList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "OnCheckedChangedActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnClickActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnEditorActionActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnFocusChangeActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnItemClickActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnItemLongClickActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnItemSelectedActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnLongClickActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnPageChangeActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnTextChangedActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "OnTouchActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定单个视图列表
     */
    private List<Map<String, String>> generateViewList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindViewActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定多个视图列表
     */
    private List<Map<String, String>> generateViewsList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindViewsActivity");
        mapList.add(map);

        return mapList;
    }
}
