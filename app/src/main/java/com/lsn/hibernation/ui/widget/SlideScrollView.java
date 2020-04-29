package com.lsn.hibernation.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Chris on 2018/6/6.
 */

public class SlideScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;
    private boolean mScrollable = true;
    public SlideScrollView(Context context) {
        this(context, null);
    }

    public SlideScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        // 滑动监听
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(x, y, oldx, oldy);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // if we can scroll pass the event to the superclass
                if (mScrollable) return super.onTouchEvent(ev);
                // only continue to handle the touch event if scrolling enabled
                return mScrollable; // mScrollable is always false at this point
            default:
                return super.onTouchEvent(ev);
        }
    }

    public void setScrollingEnabled(boolean enabled) {
        mScrollable = enabled;
    }

    public boolean isScrollable() {
        return mScrollable;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Don't do anything with intercepted touch events if
        // we are not scrollable
        if (!mScrollable) return false;
        else return super.onInterceptTouchEvent(ev);
    }



    public interface OnScrollChangedListener {
        void onScrollChanged(int x, int y, int oldx, int oldy);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

}
