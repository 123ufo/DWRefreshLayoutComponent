package com.ufo.dwrefreshlayout_classic_component;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ufo.dwrefresh.view.interf.ILoadMoreFoot;
import com.ufo.dwrefresh.view.utils.DensityUtils;

/**
 * 日期:2017/11/9
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述:经典型刷新头
 */

public class ClassicFootView extends LinearLayout implements ILoadMoreFoot {
    private static final String TAG = "ClassicFootView";
    private ImageView mIvArrow;
    private TextView mTvText;
    private ProgressBar mPb;
    private String loadMoreText;

    public ClassicFootView(Context context) {
        this(context, null);
    }

    public ClassicFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_classic_head_view, this);
        mIvArrow = findViewById(R.id.iv_arrow);
        mTvText = findViewById(R.id.tv_text);
        mPb = findViewById(R.id.pb);

        loadMoreText = getResources().getString(R.string.loadMoreText);

    }

    @Override
    public void onStart() {
        mIvArrow.setVisibility(View.VISIBLE);
        mPb.setVisibility(View.GONE);
        isDo = false;
        mTvText.setText(loadMoreText);
    }

    @Override
    public void onPullUp(int distance) {
        if (distance >= footViewHeight() && !isDo) {
            mIvArrow.setRotation(360f);
            isDo = true;
        } else if (distance <= footViewHeight() && isDo) {
            mIvArrow.setRotation(180f);
            isDo = false;
        }
    }

    boolean isDo = false;


    @Override
    public void onBound() {
    }

    @Override
    public void onFingerUp(int distance) {
        mIvArrow.setVisibility(View.GONE);
        mPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStop() {
        mIvArrow.setRotation(0f);
    }

    @Override
    public int footViewHeight() {
        return (int) DensityUtils.dipToPx(getContext(), 60);
    }

    /**
     * 设置刷新文本颜色
     *
     * @param color
     */
    public void setRefreshTestColor(@ColorRes int color) {
        mTvText.setTextColor(getResources().getColor(color));
    }


}
