package com.lsn.hibernation.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by Administrator on 2018/9/20.
 */

public class ScrollLinearLayoutManager extends LinearLayoutManager {

    private boolean isScrollEnabled = true;

    public ScrollLinearLayoutManager(Context context) {
        super(context);
    }

    public ScrollLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ScrollLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
