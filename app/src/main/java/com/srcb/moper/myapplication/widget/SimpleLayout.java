package com.srcb.moper.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gjj on 2018/12/18.
 */
public class SimpleLayout extends ViewGroup {
    public SimpleLayout(Context context) {
        super(context);
    }

    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(getChildCount() > 0){
            View view = getChildAt(0);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0){
            View view = getChildAt(0);
            view.layout(0,0,view.getMeasuredWidth(),view.getMeasuredHeight());
        }
    }
}
