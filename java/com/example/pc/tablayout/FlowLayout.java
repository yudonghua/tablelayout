package com.example.pc.tablayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by PC on 2017/4/10.
 */
public class FlowLayout extends ViewGroup {
    private int curScreen;
    private int defaultScreen = 0;
    private Scroller mScroller;
    private float mLastMotionX = 0;

    private VelocityTracker mVelocityTracker;


    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int mViewGroupWidth = getMeasuredWidth();  //容器宽度

        int mPainterPosX = 0;  //当前绘图X
        int mPainterPosY = 0;  //当前绘图Y

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            //宽度大于容器宽度时，则移到下一行开始位置
            if (mPainterPosX + width > mViewGroupWidth) {
                mPainterPosX = 0;
                mPainterPosY += height;
            }
            //位置摆放
            childView.layout(mPainterPosX, mPainterPosY, mPainterPosX + width, mPainterPosY + height);
            //记录当前已经绘制到的横坐标位置
            mPainterPosX += width;
        }

    }
}