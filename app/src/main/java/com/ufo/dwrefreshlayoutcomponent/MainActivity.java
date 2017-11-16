package com.ufo.dwrefreshlayoutcomponent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.ufo.dwrefresh.view.DWRefreshLayout;
import com.ufo.dwrefreshlayout_classic_component.ClassicFootView;
import com.ufo.dwrefreshlayout_classic_component.ClassicHeadView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DWRefreshLayout refreshLayout = (DWRefreshLayout) findViewById(R.id.refresh_layout);

        ClassicHeadView classicHeadView = new ClassicHeadView(this);
//        classicHeadView.setRefreshTestColor(R.color.colorAccent);
        refreshLayout.setHeadView(classicHeadView);

        ClassicFootView classicFootView = new ClassicFootView(this);
//        classicFootView.setRefreshTestColor(R.color.colorAccent);
        refreshLayout.setFootView(classicFootView);

        refreshLayout.setOnRefreshListener(new DWRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefresh(false);

                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefresh(false);

                    }
                }, 1000);
            }
        });

    }

}
