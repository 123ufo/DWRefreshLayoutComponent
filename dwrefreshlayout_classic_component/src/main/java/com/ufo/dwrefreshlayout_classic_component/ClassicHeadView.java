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

import com.ufo.dwrefresh.view.interf.IRefreshHead;
import com.ufo.dwrefresh.view.utils.DensityUtils;

/**
 * 日期:2017/11/9
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述:经典型刷新头
 */

public class ClassicHeadView extends LinearLayout implements IRefreshHead {
    private static final String TAG = "ClassicHeadView";
    private ImageView mIvArrow;
    private TextView mTvText;
    private ProgressBar mPb;
    private String downText;
    private String refreshingText;
    private String upText;

    public ClassicHeadView(Context context) {
        this(context, null);
    }

    public ClassicHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_classic_head_view, this);
        mIvArrow = findViewById(R.id.iv_arrow);
        mTvText = findViewById(R.id.tv_text);
        mPb = findViewById(R.id.pb);

        downText = getResources().getString(R.string.downText);
        refreshingText = getResources().getString(R.string.refreshingText);
        upText = getResources().getString(R.string.upText);
    }

    @Override
    public void onStart() {
        mIvArrow.setVisibility(View.VISIBLE);
        mPb.setVisibility(View.GONE);
        mTvText.setText(downText);
        isDo = false;

    }

    boolean isDo = false;

    @Override
    public void onPullDown(int distance) {

        if (distance >= headViewHeight() && !isDo) {
            mTvText.setText(upText);
            mIvArrow.setRotation(180f);
            isDo = true;
        } else if (distance <= headViewHeight() && isDo) {
            mIvArrow.setRotation(360f);
            mTvText.setText(downText);
            isDo = false;
        }
    }

    @Override
    public void onBound() {
        mTvText.setText(upText);
    }

    @Override
    public void onFingerUp(int distance) {
        mIvArrow.setVisibility(View.GONE);
        mPb.setVisibility(View.VISIBLE);
        mTvText.setText(refreshingText);
    }

    @Override
    public void onStop() {
        mIvArrow.setRotation(0f);
    }

    /**
     * 设置刷新文本颜色
     *
     * @param color
     */
    public void setRefreshTextColor(@ColorRes int color) {
        mTvText.setTextColor(getResources().getColor(color));
    }

    @Override
    public int headViewHeight() {
        return (int) DensityUtils.dipToPx(getContext(), 60);
    }
}
