package com.example.administrator.svn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/11.
 */

public class Myview extends View {

    private Path mPath;
    private Paint mPaint;

    public Myview(Context context) {
        super(context);
        init();
    }

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Myview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    //初始化画笔
    private void init() {
        mPath = new Path();
        mPaint = new Paint();   //初始化画笔
        mPaint.setAntiAlias(true);          //抗锯齿
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));//画笔颜色
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);  //画笔风格
        mPaint.setTextSize(36);             //绘制文字大小，单位px
        mPaint.setStrokeWidth(10);           //画笔粗细


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 110, 100, mPaint);           //画实心圆
    }
}
