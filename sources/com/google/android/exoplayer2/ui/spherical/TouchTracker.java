package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;

/* loaded from: classes2.dex */
class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {
    private final GestureDetector gestureDetector;
    private final Listener listener;
    private final float pxPerDegrees;
    private SingleTapListener singleTapListener;
    private final PointF previousTouchPointPx = new PointF();
    private final PointF accumulatedTouchOffsetDegrees = new PointF();
    private volatile float roll = 3.1415927f;

    interface Listener {
        void onScrollChange(PointF scrollOffsetDegrees);
    }

    public TouchTracker(Context context, Listener listener, float pxPerDegrees) {
        this.listener = listener;
        this.pxPerDegrees = pxPerDegrees;
        this.gestureDetector = new GestureDetector(context, this);
    }

    public void setSingleTapListener(SingleTapListener listener) {
        this.singleTapListener = listener;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        this.previousTouchPointPx.set(e.getX(), e.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = (e2.getX() - this.previousTouchPointPx.x) / this.pxPerDegrees;
        float y = e2.getY();
        PointF pointF = this.previousTouchPointPx;
        float f = (y - pointF.y) / this.pxPerDegrees;
        pointF.set(e2.getX(), e2.getY());
        double d = this.roll;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        PointF pointF2 = this.accumulatedTouchOffsetDegrees;
        pointF2.x -= (fCos * x) - (fSin * f);
        float f2 = pointF2.y + (fSin * x) + (fCos * f);
        pointF2.y = f2;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f2));
        this.listener.onScrollChange(this.accumulatedTouchOffsetDegrees);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        SingleTapListener singleTapListener = this.singleTapListener;
        if (singleTapListener != null) {
            return singleTapListener.onSingleTapUp(e);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
    public void onOrientationChange(float[] deviceOrientationMatrix, float roll) {
        this.roll = -roll;
    }
}
