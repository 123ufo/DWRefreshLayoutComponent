# DWRefreshLayoutComponent
DWRefreshLayout 常用组件

#### 基于[DWRefrshLayout][1]刷新布局定义的一组经典的刷新/加载头组件.
 [1]: https://github.com/123ufo/DWRefreshLayout

<img src="https://github.com/123ufo/DWRefreshLayoutComponent/blob/master/gif/a.gif?raw=true" width="280"/>


### Gradle compile dependency:

    compile 'com.ufo:dwrefreshlayout_classic_component:0.9.1'

### 代码：

    final DWRefreshLayout refreshLayout = (DWRefreshLayout) findViewById(R.id.refresh_layout);

        ClassicHeadView classicHeadView = new ClassicHeadView(this);
        //设置文本的颜色
        classicHeadView.setRefreshTextColor(R.color.colorAccent);
        refreshLayout.setHeadView(classicHeadView);

        ClassicFootView classicFootView = new ClassicFootView(this);
          //设置文本的颜色
        classicFootView.setRefreshTextColor(R.color.colorAccent);
        refreshLayout.setFootView(classicFootView);

        refreshLayout.setOnRefreshListener(new DWRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });




