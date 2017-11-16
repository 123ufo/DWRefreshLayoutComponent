package com.ufo.dwrefreshlayoutcomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 日期:2017/11/9
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述:贝塞尔View
 */

public class BezierView extends View {
    private static final String TAG = "BezierView";
    private Paint mPaint;


    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        //二阶
//        twoDraw(canvas);
        //三阶
//        threeDraw(canvas);

        //水波
        waterDraw(canvas);

    }

    private void waterDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100,400);
        path.quadTo(200,300,300,400);
        path.quadTo(400,500,500,400);
        canvas.drawPath(path,mPaint);
    }

    private void threeDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100,400);
        path.cubicTo(100,200,400,200,400,400);
        canvas.drawPath(path,mPaint);
    }

    private void twoDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100,400);
        path.quadTo(500,100,1000,400);
        canvas.drawPath(path,mPaint);
    }
}
