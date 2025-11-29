package com.shopgun.android.zoomlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.shopgun.android.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public class ZoomLayout extends FrameLayout {
    public boolean DEBUG;
    private boolean mAllowOverScale;
    boolean mAllowParentInterceptOnEdge;
    boolean mAllowParentInterceptOnScaled;
    private boolean mAllowZoom;
    private AnimatedZoomRunnable mAnimatedZoomRunnable;
    private Interpolator mAnimationInterpolator;
    private float[] mArray;
    RectF mDrawRect;
    private FlingRunnable mFlingRunnable;
    private float mFocusX;
    private float mFocusY;
    private GestureDetector mGestureDetector;
    private GestureListener mGestureListener;
    private float[] mMatrixValues;
    private float mMaxScale;
    private float mMinScale;
    private List<OnDoubleTapListener> mOnDoubleTapListeners;
    private List<OnLongTapListener> mOnLongTapListeners;
    private List<OnPanListener> mOnPanListeners;
    private List<OnTapListener> mOnTapListeners;
    private List<OnTouchListener> mOnTouchListeners;
    private List<OnZoomListener> mOnZoomListeners;
    private PanDispatcher mPanDispatcher;
    private ScaleGestureDetector mScaleDetector;
    private Matrix mScaleMatrix;
    private Matrix mScaleMatrixInverse;
    private SimpleOnGlobalLayoutChangedListener mSimpleOnGlobalLayoutChangedListener;
    private Matrix mTranslateMatrix;
    private Matrix mTranslateMatrixInverse;
    RectF mViewPortRect;
    private ZoomDispatcher mZoomDispatcher;
    private int mZoomDuration;

    public interface OnDoubleTapListener {
        boolean onDoubleTap(ZoomLayout zoomLayout, TapInfo tapInfo);
    }

    public interface OnLongTapListener {
        void onLongTap(ZoomLayout zoomLayout, TapInfo tapInfo);
    }

    public interface OnPanListener {
        void onPan(ZoomLayout zoomLayout);

        void onPanBegin(ZoomLayout zoomLayout);

        void onPanEnd(ZoomLayout zoomLayout);
    }

    public interface OnTapListener {
        boolean onTap(ZoomLayout zoomLayout, TapInfo tapInfo);
    }

    public interface OnTouchListener {
        boolean onTouch(ZoomLayout zoomLayout, int i, TapInfo tapInfo);
    }

    public interface OnZoomListener {
        void onZoom(ZoomLayout zoomLayout, float f);

        void onZoomBegin(ZoomLayout zoomLayout, float f);

        void onZoomEnd(ZoomLayout zoomLayout, float f);
    }

    public ZoomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEBUG = false;
        this.mScaleMatrix = new Matrix();
        this.mScaleMatrixInverse = new Matrix();
        this.mTranslateMatrix = new Matrix();
        this.mTranslateMatrixInverse = new Matrix();
        this.mMatrixValues = new float[9];
        this.mArray = new float[6];
        this.mAllowOverScale = true;
        this.mDrawRect = new RectF();
        this.mViewPortRect = new RectF();
        this.mAnimationInterpolator = new DecelerateInterpolator();
        this.mZoomDuration = 250;
        this.mAllowParentInterceptOnEdge = true;
        this.mAllowParentInterceptOnScaled = false;
        this.mMinScale = 1.0f;
        this.mMaxScale = 3.0f;
        this.mAllowZoom = true;
        this.mZoomDispatcher = new ZoomDispatcher();
        this.mPanDispatcher = new PanDispatcher();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mGestureListener = new GestureListener();
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, this.mGestureListener);
        this.mScaleDetector = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
        this.mSimpleOnGlobalLayoutChangedListener = new SimpleOnGlobalLayoutChangedListener();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mSimpleOnGlobalLayoutChangedListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeGlobal(this, this.mSimpleOnGlobalLayoutChangedListener);
        super.onDetachedFromWindow();
    }

    public static void removeGlobal(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(-getPosX(), -getPosY());
        float scale = getScale();
        canvas.scale(scale, scale, this.mFocusX, this.mFocusY);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        if (this.DEBUG) {
            ZoomUtils.debugDraw(canvas, getContext(), getPosX(), getPosY(), this.mFocusX, this.mFocusY, getMatrixValue(this.mScaleMatrixInverse, 0));
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        scaledPointsToScreenPoints(rect);
        float scale = getScale();
        iArr[0] = (int) (iArr[0] * scale);
        iArr[1] = (int) (iArr[1] * scale);
        return super.invalidateChildInParent(iArr, rect);
    }

    private void scaledPointsToScreenPoints(Rect rect) {
        ZoomUtils.setArray(this.mArray, rect);
        float[] fArrScaledPointsToScreenPoints = scaledPointsToScreenPoints(this.mArray);
        this.mArray = fArrScaledPointsToScreenPoints;
        ZoomUtils.setRect(rect, fArrScaledPointsToScreenPoints);
    }

    private void scaledPointsToScreenPoints(RectF rectF) {
        ZoomUtils.setArray(this.mArray, rectF);
        float[] fArrScaledPointsToScreenPoints = scaledPointsToScreenPoints(this.mArray);
        this.mArray = fArrScaledPointsToScreenPoints;
        ZoomUtils.setRect(rectF, fArrScaledPointsToScreenPoints);
    }

    private float[] scaledPointsToScreenPoints(float[] fArr) {
        this.mScaleMatrix.mapPoints(fArr);
        this.mTranslateMatrix.mapPoints(fArr);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] screenPointsToScaledPoints(float[] fArr) {
        this.mTranslateMatrixInverse.mapPoints(fArr);
        this.mScaleMatrixInverse.mapPoints(fArr);
        return fArr;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mArray[0] = motionEvent.getX();
        this.mArray[1] = motionEvent.getY();
        screenPointsToScaledPoints(this.mArray);
        float[] fArr = this.mArray;
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mAllowZoom;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mArray[0] = motionEvent.getX();
        this.mArray[1] = motionEvent.getY();
        scaledPointsToScreenPoints(this.mArray);
        float[] fArr = this.mArray;
        motionEvent.setLocation(fArr[0], fArr[1]);
        if (!this.mAllowZoom) {
            return false;
        }
        int action = motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        dispatchOnTouch(action, motionEvent);
        boolean z = this.mGestureDetector.onTouchEvent(motionEvent) || this.mScaleDetector.onTouchEvent(motionEvent);
        if (action == 1) {
            return this.mGestureListener.onUp(motionEvent) || z;
        }
        return z;
    }

    class GestureListener implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        private float mScaleOnActionDown;
        private boolean mScrolling = false;

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        GestureListener() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ZoomLayout.this.dispatchOnTab(motionEvent);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if ((motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE) != 1) {
                return false;
            }
            ZoomLayout.this.dispatchOnDoubleTap(motionEvent);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ZoomLayout.this.mScaleDetector.isInProgress()) {
                return;
            }
            ZoomLayout.this.dispatchOnLongTap(motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent2.getPointerCount() != 1 || ZoomLayout.this.mScaleDetector.isInProgress()) {
                return false;
            }
            if (!this.mScrolling) {
                ZoomLayout.this.mPanDispatcher.onPanBegin();
                this.mScrolling = true;
            }
            boolean zInternalMoveBy = ZoomLayout.this.internalMoveBy(f, f2, true);
            if (zInternalMoveBy) {
                ZoomLayout.this.mPanDispatcher.onPan();
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            if (zoomLayout.mAllowParentInterceptOnEdge && !zInternalMoveBy && (!zoomLayout.isScaled() || ZoomLayout.this.mAllowParentInterceptOnScaled)) {
                ZoomLayout.this.requestDisallowInterceptTouchEvent(false);
            }
            return zInternalMoveBy;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float scale = ZoomLayout.this.getScale();
            if (!NumberUtils.isEqual(NumberUtils.clamp(ZoomLayout.this.mMinScale, scale, ZoomLayout.this.mMaxScale), scale)) {
                return false;
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            zoomLayout.mFlingRunnable = zoomLayout.new FlingRunnable(zoomLayout.getContext());
            ZoomLayout.this.mFlingRunnable.fling((int) f, (int) f2);
            ZoomLayout zoomLayout2 = ZoomLayout.this;
            ViewCompat.postOnAnimation(zoomLayout2, zoomLayout2.mFlingRunnable);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.mScaleOnActionDown = ZoomLayout.this.getScale();
            ZoomLayout.this.requestDisallowInterceptTouchEvent(true);
            ZoomLayout.this.cancelFling();
            ZoomLayout.this.cancelZoom();
            return false;
        }

        boolean onUp(MotionEvent motionEvent) {
            boolean z;
            boolean z2 = true;
            if (this.mScrolling) {
                ZoomLayout.this.mPanDispatcher.onPanEnd();
                this.mScrolling = false;
                z = true;
            } else {
                z = false;
            }
            if (ZoomLayout.this.mAnimatedZoomRunnable != null && !ZoomLayout.this.mAnimatedZoomRunnable.mFinished) {
                return z;
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            zoomLayout.mAnimatedZoomRunnable = zoomLayout.new AnimatedZoomRunnable();
            if (!ZoomLayout.this.mAnimatedZoomRunnable.runValidation() && !z) {
                z2 = false;
            }
            return z2;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ZoomLayout.this.mZoomDispatcher.onZoomBegin(ZoomLayout.this.getScale());
            ZoomLayout.this.fixFocusPoint(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scale = ZoomLayout.this.getScale() * scaleGestureDetector.getScaleFactor();
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            zoomLayout.internalScale(scale, zoomLayout.mFocusX, ZoomLayout.this.mFocusY);
            ZoomLayout.this.mZoomDispatcher.onZoom(scale);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ZoomLayout zoomLayout = ZoomLayout.this;
            zoomLayout.mAnimatedZoomRunnable = zoomLayout.new AnimatedZoomRunnable();
            ZoomLayout.this.mAnimatedZoomRunnable.runValidation();
            ZoomLayout.this.mZoomDispatcher.onZoomEnd(ZoomLayout.this.getScale());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixFocusPoint(float f, float f2) {
        float[] fArr = this.mArray;
        fArr[0] = f;
        fArr[1] = f2;
        screenPointsToScaledPoints(fArr);
        float matrixValue = getMatrixValue(this.mScaleMatrix, 2);
        float matrixValue2 = getMatrixValue(this.mScaleMatrix, 5);
        float scale = getScale();
        float[] fArr2 = this.mArray;
        internalScale(scale, fArr2[0], fArr2[1]);
        internalMove((getMatrixValue(this.mScaleMatrix, 2) - matrixValue) + getPosX(), (getMatrixValue(this.mScaleMatrix, 5) - matrixValue2) + getPosY(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelFling() {
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelZoom() {
        AnimatedZoomRunnable animatedZoomRunnable = this.mAnimatedZoomRunnable;
        if (animatedZoomRunnable != null) {
            animatedZoomRunnable.cancel();
            this.mAnimatedZoomRunnable = null;
        }
    }

    public RectF getDrawRect() {
        return new RectF(this.mDrawRect);
    }

    public void setAllowOverScale(boolean z) {
        this.mAllowOverScale = z;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setAllowParentInterceptOnScaled(boolean z) {
        this.mAllowParentInterceptOnScaled = z;
    }

    public int getZoomDuration() {
        return this.mZoomDuration;
    }

    public void setZoomDuration(int i) {
        if (i < 0) {
            i = 250;
        }
        this.mZoomDuration = i;
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mAnimationInterpolator = interpolator;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public void setMaxScale(float f) {
        this.mMaxScale = f;
        if (f < this.mMinScale) {
            setMinScale(f);
        }
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public void setMinScale(float f) {
        this.mMinScale = f;
        if (f > this.mMaxScale) {
            setMaxScale(f);
        }
    }

    public void setAllowZoom(boolean z) {
        this.mAllowZoom = z;
    }

    public float getScale() {
        return getMatrixValue(this.mScaleMatrix, 0);
    }

    public void setScale(float f) {
        setScale(f, true);
    }

    public void setScale(float f, boolean z) {
        getChildAt(0);
        setScale(f, getRight() / 2, getBottom() / 2, z);
    }

    public boolean isScaled() {
        return !NumberUtils.isEqual(getScale(), 1.0f, 0.05f);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        if (this.mAllowZoom) {
            fixFocusPoint(f2, f3);
            if (!this.mAllowOverScale) {
                f = NumberUtils.clamp(this.mMinScale, f, this.mMaxScale);
            }
            float f4 = f;
            if (z) {
                AnimatedZoomRunnable animatedZoomRunnable = new AnimatedZoomRunnable();
                this.mAnimatedZoomRunnable = animatedZoomRunnable;
                animatedZoomRunnable.scale(getScale(), f4, this.mFocusX, this.mFocusY, true);
                ViewCompat.postOnAnimation(this, this.mAnimatedZoomRunnable);
                return;
            }
            this.mZoomDispatcher.onZoomBegin(getScale());
            internalScale(f4, this.mFocusX, this.mFocusY);
            this.mZoomDispatcher.onZoom(f4);
            this.mZoomDispatcher.onZoomEnd(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean internalMoveBy(float f, float f2, boolean z) {
        if (z) {
            RectF translateDeltaBounds = getTranslateDeltaBounds();
            f = NumberUtils.clamp(translateDeltaBounds.left, f, translateDeltaBounds.right);
            f2 = NumberUtils.clamp(translateDeltaBounds.top, f2, translateDeltaBounds.bottom);
        }
        float posX = f + getPosX();
        float posY = f2 + getPosY();
        if (NumberUtils.isEqual(posX, getPosX()) && NumberUtils.isEqual(posY, getPosY())) {
            return false;
        }
        this.mTranslateMatrix.setTranslate(-posX, -posY);
        matrixUpdated();
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean internalMove(float f, float f2, boolean z) {
        return internalMoveBy(f - getPosX(), f2 - getPosY(), z);
    }

    private RectF getTranslateDeltaBounds() {
        RectF rectF = new RectF();
        float fWidth = this.mDrawRect.width() - this.mViewPortRect.width();
        if (fWidth < 0.0f) {
            float fRound = Math.round((this.mViewPortRect.width() - this.mDrawRect.width()) / 2.0f);
            RectF rectF2 = this.mDrawRect;
            float f = rectF2.left;
            if (fRound > f) {
                rectF.left = 0.0f;
                rectF.right = fRound - rectF2.left;
            } else {
                rectF.left = fRound - f;
                rectF.right = 0.0f;
            }
        } else {
            float f2 = this.mDrawRect.left - this.mViewPortRect.left;
            rectF.left = f2;
            rectF.right = f2 + fWidth;
        }
        float fHeight = this.mDrawRect.height() - this.mViewPortRect.height();
        if (fHeight < 0.0f) {
            float fRound2 = Math.round((this.mViewPortRect.height() - this.mDrawRect.height()) / 2.0f);
            float f3 = this.mDrawRect.top;
            if (fRound2 > f3) {
                rectF.top = f3 - fRound2;
                rectF.bottom = 0.0f;
            } else {
                rectF.top = fRound2 - f3;
                rectF.bottom = 0.0f;
            }
        } else {
            float f4 = this.mDrawRect.top - this.mViewPortRect.top;
            rectF.top = f4;
            rectF.bottom = f4 + fHeight;
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF getClosestValidTranslationPoint() {
        PointF pointF = new PointF(getPosX(), getPosY());
        if (this.mDrawRect.width() < this.mViewPortRect.width()) {
            pointF.x += this.mDrawRect.centerX() - this.mViewPortRect.centerX();
        } else {
            RectF rectF = this.mDrawRect;
            float f = rectF.right;
            RectF rectF2 = this.mViewPortRect;
            float f2 = rectF2.right;
            if (f < f2) {
                pointF.x += f - f2;
            } else {
                float f3 = rectF.left;
                float f4 = rectF2.left;
                if (f3 > f4) {
                    pointF.x += f3 - f4;
                }
            }
        }
        if (this.mDrawRect.height() < this.mViewPortRect.height()) {
            pointF.y += this.mDrawRect.centerY() - this.mViewPortRect.centerY();
        } else {
            RectF rectF3 = this.mDrawRect;
            float f5 = rectF3.bottom;
            RectF rectF4 = this.mViewPortRect;
            float f6 = rectF4.bottom;
            if (f5 < f6) {
                pointF.y += f5 - f6;
            } else {
                float f7 = rectF3.top;
                float f8 = rectF4.top;
                if (f7 > f8) {
                    pointF.y += f7 - f8;
                }
            }
        }
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalScale(float f, float f2, float f3) {
        this.mFocusX = f2;
        this.mFocusY = f3;
        this.mScaleMatrix.setScale(f, f, f2, f3);
        matrixUpdated();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void matrixUpdated() {
        this.mScaleMatrix.invert(this.mScaleMatrixInverse);
        this.mTranslateMatrix.invert(this.mTranslateMatrixInverse);
        ZoomUtils.setRect(this.mViewPortRect, 0.0f, 0.0f, getWidth(), getHeight());
        if (getChildAt(0) != null) {
            ZoomUtils.setRect(this.mDrawRect, r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom());
            scaledPointsToScreenPoints(this.mDrawRect);
        } else {
            float fCenterX = this.mViewPortRect.centerX();
            float fCenterY = this.mViewPortRect.centerY();
            this.mDrawRect.set(fCenterX, fCenterY, fCenterX, fCenterY);
        }
    }

    public float getPosX() {
        return -getMatrixValue(this.mTranslateMatrix, 2);
    }

    public float getPosY() {
        return -getMatrixValue(this.mTranslateMatrix, 5);
    }

    private float getMatrixValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private class AnimatedZoomRunnable implements Runnable {
        private float mFocalX;
        private float mFocalY;
        private float mStartX;
        private float mStartY;
        private float mTargetX;
        private float mTargetY;
        private float mZoomEnd;
        private float mZoomStart;
        boolean mCancelled = false;
        boolean mFinished = false;
        private long mStartTime = System.currentTimeMillis();

        AnimatedZoomRunnable() {
        }

        boolean doScale() {
            return !NumberUtils.isEqual(this.mZoomStart, this.mZoomEnd);
        }

        boolean doTranslate() {
            return (NumberUtils.isEqual(this.mStartX, this.mTargetX) && NumberUtils.isEqual(this.mStartY, this.mTargetY)) ? false : true;
        }

        boolean runValidation() {
            float scale = ZoomLayout.this.getScale();
            scale(scale, NumberUtils.clamp(ZoomLayout.this.mMinScale, scale, ZoomLayout.this.mMaxScale), ZoomLayout.this.mFocusX, ZoomLayout.this.mFocusY, true);
            if (!ZoomLayout.this.mAnimatedZoomRunnable.doScale() && !ZoomLayout.this.mAnimatedZoomRunnable.doTranslate()) {
                return false;
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            ViewCompat.postOnAnimation(zoomLayout, zoomLayout.mAnimatedZoomRunnable);
            return true;
        }

        AnimatedZoomRunnable scale(float f, float f2, float f3, float f4, boolean z) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
            if (doScale()) {
                ZoomLayout.this.mZoomDispatcher.onZoomBegin(ZoomLayout.this.getScale());
            }
            if (z) {
                this.mStartX = ZoomLayout.this.getPosX();
                this.mStartY = ZoomLayout.this.getPosY();
                boolean zDoScale = doScale();
                if (zDoScale) {
                    Matrix matrix = ZoomLayout.this.mScaleMatrix;
                    float f5 = this.mZoomEnd;
                    matrix.setScale(f5, f5, this.mFocalX, this.mFocalY);
                    ZoomLayout.this.matrixUpdated();
                }
                PointF closestValidTranslationPoint = ZoomLayout.this.getClosestValidTranslationPoint();
                this.mTargetX = closestValidTranslationPoint.x;
                this.mTargetY = closestValidTranslationPoint.y;
                if (zDoScale) {
                    Matrix matrix2 = ZoomLayout.this.mScaleMatrix;
                    float f6 = this.mZoomStart;
                    matrix2.setScale(f6, f6, ZoomLayout.this.mFocusX, ZoomLayout.this.mFocusY);
                    ZoomLayout.this.matrixUpdated();
                }
                if (doTranslate()) {
                    ZoomLayout.this.mPanDispatcher.onPanBegin();
                }
            }
            return this;
        }

        void cancel() {
            this.mCancelled = true;
            finish();
        }

        private void finish() {
            if (!this.mFinished) {
                if (doScale()) {
                    ZoomLayout.this.mZoomDispatcher.onZoomEnd(ZoomLayout.this.getScale());
                }
                if (doTranslate()) {
                    ZoomLayout.this.mPanDispatcher.onPanEnd();
                }
            }
            this.mFinished = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCancelled) {
                return;
            }
            if (doScale() || doTranslate()) {
                float fInterpolate = interpolate();
                if (doScale()) {
                    float f = this.mZoomStart;
                    float f2 = f + ((this.mZoomEnd - f) * fInterpolate);
                    ZoomLayout.this.internalScale(f2, this.mFocalX, this.mFocalY);
                    ZoomLayout.this.mZoomDispatcher.onZoom(f2);
                }
                if (doTranslate()) {
                    float f3 = this.mStartX;
                    float f4 = f3 + ((this.mTargetX - f3) * fInterpolate);
                    float f5 = this.mStartY;
                    ZoomLayout.this.internalMove(f4, f5 + ((this.mTargetY - f5) * fInterpolate), false);
                    ZoomLayout.this.mPanDispatcher.onPan();
                }
                if (fInterpolate < 1.0f) {
                    ViewCompat.postOnAnimation(ZoomLayout.this, this);
                } else {
                    finish();
                }
            }
        }

        private float interpolate() {
            return ZoomLayout.this.mAnimationInterpolator.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.mStartTime) * 1.0f) / ZoomLayout.this.mZoomDuration));
        }
    }

    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private boolean mFinished = false;
        private final ScrollerCompat mScroller;

        FlingRunnable(Context context) {
            this.mScroller = ScrollerCompat.getScroller(context);
        }

        void fling(int i, int i2) {
            int iRound;
            int iRound2;
            int i3;
            int iRound3;
            int iRound4 = Math.round(ZoomLayout.this.mViewPortRect.left);
            if (ZoomLayout.this.mViewPortRect.width() < ZoomLayout.this.mDrawRect.width()) {
                iRound = Math.round(ZoomLayout.this.mDrawRect.left);
                iRound2 = Math.round(ZoomLayout.this.mDrawRect.width() - ZoomLayout.this.mViewPortRect.width());
            } else {
                iRound = iRound4;
                iRound2 = iRound;
            }
            int iRound5 = Math.round(ZoomLayout.this.mViewPortRect.top);
            if (ZoomLayout.this.mViewPortRect.height() < ZoomLayout.this.mDrawRect.height()) {
                int iRound6 = Math.round(ZoomLayout.this.mDrawRect.top);
                ZoomLayout zoomLayout = ZoomLayout.this;
                i3 = iRound6;
                iRound3 = Math.round(zoomLayout.mDrawRect.bottom - zoomLayout.mViewPortRect.bottom);
            } else {
                i3 = iRound5;
                iRound3 = i3;
            }
            this.mCurrentX = iRound4;
            this.mCurrentY = iRound5;
            if (iRound4 != iRound2 || iRound5 != iRound3) {
                this.mScroller.fling(iRound4, iRound5, i, i2, iRound, iRound2, i3, iRound3, 0, 0);
                ZoomLayout.this.mPanDispatcher.onPanBegin();
            } else {
                this.mFinished = true;
            }
        }

        void cancelFling() {
            this.mScroller.forceFinished(true);
            finish();
        }

        private void finish() {
            if (!this.mFinished) {
                ZoomLayout.this.mPanDispatcher.onPanEnd();
            }
            this.mFinished = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (ZoomLayout.this.internalMoveBy(this.mCurrentX - currX, this.mCurrentY - currY, true)) {
                    ZoomLayout.this.mPanDispatcher.onPan();
                }
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                ViewCompat.postOnAnimation(ZoomLayout.this, this);
                return;
            }
            finish();
        }
    }

    private void dispatchOnTouch(int i, MotionEvent motionEvent) {
        List<OnTouchListener> list = this.mOnTouchListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnTouchListener onTouchListener = this.mOnTouchListeners.get(i2);
                if (onTouchListener != null) {
                    onTouchListener.onTouch(this, i, new TapInfo(motionEvent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnTab(MotionEvent motionEvent) {
        List<OnTapListener> list = this.mOnTapListeners;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OnTapListener onTapListener = this.mOnTapListeners.get(i);
                if (onTapListener != null) {
                    onTapListener.onTap(this, new TapInfo(motionEvent));
                }
            }
        }
    }

    public void addOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        if (this.mOnDoubleTapListeners == null) {
            this.mOnDoubleTapListeners = new ArrayList();
        }
        this.mOnDoubleTapListeners.add(onDoubleTapListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnDoubleTap(MotionEvent motionEvent) {
        List<OnDoubleTapListener> list = this.mOnDoubleTapListeners;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OnDoubleTapListener onDoubleTapListener = this.mOnDoubleTapListeners.get(i);
                if (onDoubleTapListener != null) {
                    onDoubleTapListener.onDoubleTap(this, new TapInfo(motionEvent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnLongTap(MotionEvent motionEvent) {
        List<OnLongTapListener> list = this.mOnLongTapListeners;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OnLongTapListener onLongTapListener = this.mOnLongTapListeners.get(i);
                if (onLongTapListener != null) {
                    onLongTapListener.onLongTap(this, new TapInfo(motionEvent));
                }
            }
        }
    }

    public void addOnZoomListener(OnZoomListener onZoomListener) {
        if (this.mOnZoomListeners == null) {
            this.mOnZoomListeners = new ArrayList();
        }
        this.mOnZoomListeners.add(onZoomListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new IllegalStateException("Cannot set OnClickListener, please use OnTapListener.");
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        throw new IllegalStateException("Cannot set OnLongClickListener, please use OnLongTabListener.");
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        throw new IllegalStateException("Cannot set OnTouchListener.");
    }

    public static class TapInfo {
        float mAbsoluteX;
        float mAbsoluteY;
        boolean mContentClicked;
        float mPercentX;
        float mPercentY;
        float mRelativeX;
        float mRelativeY;
        View mView;

        private TapInfo(ZoomLayout zoomLayout, MotionEvent motionEvent) {
            this.mView = zoomLayout;
            this.mAbsoluteX = motionEvent.getX();
            this.mAbsoluteY = motionEvent.getY();
            zoomLayout.mArray[0] = this.mAbsoluteX;
            zoomLayout.mArray[1] = this.mAbsoluteY;
            zoomLayout.screenPointsToScaledPoints(zoomLayout.mArray);
            View childAt = zoomLayout.getChildAt(0);
            this.mRelativeX = zoomLayout.mArray[0] - childAt.getLeft();
            this.mRelativeY = zoomLayout.mArray[1] - childAt.getTop();
            this.mPercentX = this.mRelativeX / childAt.getWidth();
            this.mPercentY = this.mRelativeY / childAt.getHeight();
            this.mContentClicked = zoomLayout.mDrawRect.contains(this.mAbsoluteX, this.mAbsoluteY);
        }

        public float getX() {
            return this.mAbsoluteX;
        }

        public float getY() {
            return this.mAbsoluteY;
        }

        public String toString() {
            return String.format(Locale.US, "TapInfo[ absX:%.0f, absY:%.0f, relX:%.0f, relY:%.0f, percentX:%.2f, percentY:%.2f, contentClicked:%s ]", Float.valueOf(this.mAbsoluteX), Float.valueOf(this.mAbsoluteY), Float.valueOf(this.mRelativeX), Float.valueOf(this.mRelativeY), Float.valueOf(this.mPercentX), Float.valueOf(this.mPercentY), Boolean.valueOf(this.mContentClicked));
        }
    }

    private class ZoomDispatcher {
        int mCount;

        private ZoomDispatcher() {
            this.mCount = 0;
        }

        void onZoomBegin(float f) {
            int i = this.mCount;
            this.mCount = i + 1;
            if (i != 0 || ZoomLayout.this.mOnZoomListeners == null) {
                return;
            }
            int size = ZoomLayout.this.mOnZoomListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnZoomListener onZoomListener = (OnZoomListener) ZoomLayout.this.mOnZoomListeners.get(i2);
                if (onZoomListener != null) {
                    onZoomListener.onZoomBegin(ZoomLayout.this, f);
                }
            }
        }

        void onZoom(float f) {
            if (ZoomLayout.this.mOnZoomListeners != null) {
                int size = ZoomLayout.this.mOnZoomListeners.size();
                for (int i = 0; i < size; i++) {
                    OnZoomListener onZoomListener = (OnZoomListener) ZoomLayout.this.mOnZoomListeners.get(i);
                    if (onZoomListener != null) {
                        onZoomListener.onZoom(ZoomLayout.this, f);
                    }
                }
            }
        }

        void onZoomEnd(float f) {
            int i = this.mCount - 1;
            this.mCount = i;
            if (i != 0 || ZoomLayout.this.mOnZoomListeners == null) {
                return;
            }
            int size = ZoomLayout.this.mOnZoomListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnZoomListener onZoomListener = (OnZoomListener) ZoomLayout.this.mOnZoomListeners.get(i2);
                if (onZoomListener != null) {
                    onZoomListener.onZoomEnd(ZoomLayout.this, f);
                }
            }
        }
    }

    private class PanDispatcher {
        int mCount;

        private PanDispatcher() {
            this.mCount = 0;
        }

        void onPanBegin() {
            int i = this.mCount;
            this.mCount = i + 1;
            if (i != 0 || ZoomLayout.this.mOnPanListeners == null) {
                return;
            }
            int size = ZoomLayout.this.mOnPanListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPanListener onPanListener = (OnPanListener) ZoomLayout.this.mOnPanListeners.get(i2);
                if (onPanListener != null) {
                    onPanListener.onPanBegin(ZoomLayout.this);
                }
            }
        }

        void onPan() {
            if (ZoomLayout.this.mOnPanListeners != null) {
                int size = ZoomLayout.this.mOnPanListeners.size();
                for (int i = 0; i < size; i++) {
                    OnPanListener onPanListener = (OnPanListener) ZoomLayout.this.mOnPanListeners.get(i);
                    if (onPanListener != null) {
                        onPanListener.onPan(ZoomLayout.this);
                    }
                }
            }
        }

        void onPanEnd() {
            int i = this.mCount - 1;
            this.mCount = i;
            if (i != 0 || ZoomLayout.this.mOnPanListeners == null) {
                return;
            }
            int size = ZoomLayout.this.mOnPanListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPanListener onPanListener = (OnPanListener) ZoomLayout.this.mOnPanListeners.get(i2);
                if (onPanListener != null) {
                    onPanListener.onPanEnd(ZoomLayout.this);
                }
            }
        }
    }

    private class SimpleOnGlobalLayoutChangedListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private int mBottom;
        private int mLeft;
        private int mRight;
        private int mTop;

        private SimpleOnGlobalLayoutChangedListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i = this.mLeft;
            int i2 = this.mTop;
            int i3 = this.mRight;
            int i4 = this.mBottom;
            this.mLeft = ZoomLayout.this.getLeft();
            this.mTop = ZoomLayout.this.getTop();
            this.mRight = ZoomLayout.this.getRight();
            int bottom = ZoomLayout.this.getBottom();
            this.mBottom = bottom;
            if (i == this.mLeft && i2 == this.mTop && i3 == this.mRight && i4 == bottom) {
                return;
            }
            ZoomLayout.this.matrixUpdated();
            PointF closestValidTranslationPoint = ZoomLayout.this.getClosestValidTranslationPoint();
            ZoomLayout.this.internalMove(closestValidTranslationPoint.x, closestValidTranslationPoint.y, false);
        }
    }
}
