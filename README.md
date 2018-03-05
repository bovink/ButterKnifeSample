# 概述

我的博客 http://bovink.com/

---
介绍ButterKnife的使用，并提供使用样例项目。

# 介绍ButterKnife

ButterKnfie是JakeWharton大神发布的一个第三方库。

这个库主要使用注释将Android的视图和事件绑定到参数和方法上。

ButterKnife的好处：

* 通过注释消除findViewById代码。
* 将多个视图绑定成一个列表或数组。可一次对它们执行方法。
* 通过注释消除资源的查找代码。

# 使用ButterKnife

接下来介绍如何使用ButterKnife。

## 绑定单个视图

在Activity中绑定视图。

```java
    @BindView(R.id.tv_test1)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindview);

        ButterKnife.bind(this);
    }
```

这样就不需要在Activity中使用findViewById方法了。

```java
    private TextView testTextView; 

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindview);

        testTextView = (TextView) findViewById(R.id.tv_test1);
    }
```

在Fragment中绑定视图。

```java
    @BindView(R.id.iv_test)
    ImageView testImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bindview, container, false);

        ButterKnife.bind(this, root);
    }
```

在Fragment中绑定Activity的视图。

```java
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bindview, container, false);

        ActivityView activityView = new ActivityView();

        ButterKnife.bind(activityView, getActivity());

        return root;
    }

    public class ActivityView {

        @BindView(R.id.tv_test2)
        TextView testTextView;

    }
```

## 绑定多个视图

将多个视图绑定成列表或数组。

```java
    @BindViews({R.id.tv_test1, R.id.tv_test2, R.id.tv_test3})
    List<TextView> textViewList;

    @BindViews({R.id.tv_test4, R.id.tv_test5, R.id.tv_test6})
    TextView[] textViewArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindviews);
        ButterKnife.bind(this);
    }
```

对列表中的视图执行方法。

```java
    ButterKnife.apply(textViewList, SET_TEXT_SIZE_TO_20);//执行一个action
    ButterKnife.apply(textViewList, SET_TEXT_COLOR_TO_BLACK, SET_TEXT_SIZE_TO_20);//执行多个action
    ButterKnife.apply(textViewList, SET_TEXT_COLOR, blue);//执行setter
    ButterKnife.apply(textViewList, View.SCALE_Y, 2.0f);//执行property
```

这样能一次对大量视图执行方法，减少重复的代码量。

可执行的方法有ButterKnife定义的两个接口action和setter以及Android自带的一些属性方法。

```java
    static final ButterKnife.Action<TextView> SET_TEXT_SIZE_TO_20 = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {

            view.setTextSize(20);
        }
    };

    static final ButterKnife.Action<TextView> SET_TEXT_COLOR_TO_BLACK = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {

            int black = Color.parseColor("#000000");
            view.setTextColor(black);
        }
    };

    static final ButterKnife.Setter<TextView, Integer> SET_TEXT_COLOR = new ButterKnife.Setter<TextView, Integer>() {
        @Override
        public void set(@NonNull TextView view, Integer color, int index) {

            view.setTextColor(color);
        }
    };
```

## 绑定事件

给Button添加点击事件监听。

```java
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindevent_onclick);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test)
    void clickView(View view) {
        Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
    }
```

方法的参数是可以省掉。

```java
    @OnClick(R.id.btn_test)
    void clickView() {
        Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
    }
```

方法的参数类型可以自动转换。

```java
    @OnClick(R.id.btn_test)
    void clickView(Button button) {
        button.setText("clicked");
    }
```

可以给多个视图绑定同一个方法。

```java
    @OnClick({R.id.btn_test, R.id.tv_test, R.id.iv_test})
    void clickView(View view) {

        if (view.getId() == R.id.btn_test) {

            Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.tv_test) {

            Toast.makeText(this, "click text", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.iv_test) {

            Toast.makeText(this, "click image", Toast.LENGTH_SHORT).show();
        }
    }
```

对于事件中有多个方法的，可以自由选择想要绑定的方法。

如EditText的addTextChangedListener接口有三个方法。

默认绑定onTextChanged方法。

```java
    @OnTextChanged(R.id.et_test)
    void onTextChanged(CharSequence s, int start, int before, int count) {
    }
```

用callback参数绑定afterTextChanged方法。

```java
    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {

    }
```

ButterKnife还提供了其他事件的绑定:

* OnCheckedChanged
* OnEditorAction
* OnFocusChange
* OnItemClick
* OnItemLongClick
* OnItemSelected
* OnLongClick
* OnPageChange
* OnTouch

具体的使用可以查看样例项目中的代码。


## 绑定资源

绑定字符串。

```java
    @BindString(R.string.app_name)
    String mAppName;

    testTextView.setText(mAppName);
```

绑定颜色。

```java
    @BindColor(R.color.colorAccent)
    int accentColor;
    @BindColor(R.color.text_click)
    ColorStateList textClickColorStateList;

    testTextView1.setTextColor(accentColor);
    testTextView2.setTextColor(textClickColorStateList);
```

ButterKnife还提供了其他资源的绑定:

* BindAnim
* BindArray
* BindBitmap
* BindBool
* BindDimen
* BindDrawable
* BindFloat
* BindFont
* BindInt

具体的使用可以查看样例项目中的代码。


# 样例项目

https://github.com/bovink/ButterKnifeSample

# 参考

* http://jakewharton.github.io/butterknife/
* https://github.com/JakeWharton/butterknife
