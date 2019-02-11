package com.srcb.moper.myapplication.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import io.reactivex.Flowable;

/**
 * Created by Gjj on 2018/12/13.
 */
public class TestView extends View {
    private static final String TAG = "TestView";

    Paint mPaint;

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        canvas.drawColor(Color.GRAY);
        canvas.drawCircle(0,0,40.0f,mPaint);
    }
}
