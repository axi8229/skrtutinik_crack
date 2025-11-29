package com.shopgun.android.zoomlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* loaded from: classes3.dex */
public abstract class ScrollerCompat {
    public abstract boolean computeScrollOffset();

    public abstract void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void forceFinished(boolean z);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();

    public static ScrollerCompat getScroller(Context context) {
        return new GingerScroller(context);
    }

    @TargetApi(9)
    private static class GingerScroller extends ScrollerCompat {
        OverScroller mScroller;

        public GingerScroller(Context context) {
            this.mScroller = new OverScroller(context);
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public boolean computeScrollOffset() {
            return this.mScroller.computeScrollOffset();
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public void forceFinished(boolean z) {
            this.mScroller.forceFinished(z);
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public boolean isFinished() {
            return this.mScroller.isFinished();
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public int getCurrX() {
            return this.mScroller.getCurrX();
        }

        @Override // com.shopgun.android.zoomlayout.ScrollerCompat
        public int getCurrY() {
            return this.mScroller.getCurrY();
        }
    }
}
