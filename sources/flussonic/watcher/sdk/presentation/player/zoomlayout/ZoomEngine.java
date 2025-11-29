package flussonic.watcher.sdk.presentation.player.zoomlayout;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* loaded from: classes3.dex */
public final class ZoomEngine implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final Interpolator INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private float baseZoom;
    private boolean clearAnimation;
    private final GestureDetector flingDragDetector;
    private final OverScroller flingScroller;
    private boolean initialized;
    private final Listener listener;
    private final ScaleGestureDetector scaleDetector;
    private final View view;
    private float viewHeight;
    private float viewWidth;
    private final int[] temp = new int[3];
    private final Matrix outMatrix = new Matrix();
    private Matrix matrix = new Matrix();
    private int mode = 0;
    private RectF contentRect = new RectF();
    private RectF contentBaseRect = new RectF();
    private float minZoom = 0.8f;
    private int minZoomMode = 0;
    private float maxZoom = 2.5f;
    private int maxZoomMode = 0;
    private float zoom = 1.0f;
    private int transformation = 0;
    private int transformationGravity = 17;
    private boolean overScrollHorizontal = true;
    private boolean overScrollVertical = true;
    private boolean horizontalPanEnabled = true;
    private boolean verticalPanEnabled = true;
    private boolean overPinchable = true;
    private boolean zoomEnabled = true;

    interface Listener {
        void onIdle(ZoomEngine engine);

        void onUpdate(ZoomEngine engine, Matrix matrix);
    }

    private float getTranslationCorrection(float value, float viewSize, float contentSize, float overScroll) {
        float f;
        float f2;
        int i = (int) overScroll;
        if (contentSize <= viewSize) {
            f = (viewSize - contentSize) / 2.0f;
            f2 = f;
        } else {
            f = viewSize - contentSize;
            f2 = 0.0f;
        }
        float f3 = i;
        float f4 = f - f3;
        float f5 = f2 + f3;
        if (value >= f4) {
            f4 = value;
        }
        if (f4 <= f5) {
            f5 = f4;
        }
        return f5 - value;
    }

    public ZoomEngine(Context context, View container, Listener listener) {
        this.view = container;
        this.listener = listener;
        this.flingScroller = new OverScroller(context);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, new PinchListener());
        this.scaleDetector = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        GestureDetector gestureDetector = new GestureDetector(context, new FlingScrollListener());
        this.flingDragDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(null);
        container.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public Matrix getMatrix() {
        this.outMatrix.set(this.matrix);
        return this.outMatrix;
    }

    public void setOverScrollHorizontal(boolean overScroll) {
        this.overScrollHorizontal = overScroll;
    }

    public void setOverScrollVertical(boolean overScroll) {
        this.overScrollVertical = overScroll;
    }

    public void setHorizontalPanEnabled(boolean enabled) {
        this.horizontalPanEnabled = enabled;
    }

    public void setVerticalPanEnabled(boolean enabled) {
        this.verticalPanEnabled = enabled;
    }

    public void setOverPinchable(boolean overPinchable) {
        this.overPinchable = overPinchable;
    }

    private int getCurrentOverScroll() {
        float f = this.viewWidth / 20.0f;
        float f2 = this.zoom;
        return (int) Math.min(f * f2, (this.viewHeight / 20.0f) * f2);
    }

    private float getCurrentOverPinch() {
        return (resolveZoom(this.maxZoom, this.maxZoomMode) - resolveZoom(this.minZoom, this.minZoomMode)) * 0.1f;
    }

    public void setZoomEnabled(boolean enabled) {
        this.zoomEnabled = enabled;
    }

    public void setTransformation(int transformation, int gravity) {
        this.transformation = transformation;
        this.transformationGravity = gravity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        float f = width;
        if (f == this.viewWidth && height == this.viewHeight) {
            return;
        }
        RectF rectF = this.contentBaseRect;
        rectF.right = f;
        float f2 = height;
        rectF.bottom = f2;
        init(f, f2, rectF);
    }

    public void setContentSize(RectF rect) {
        if (rect.width() <= 0.0f || rect.height() <= 0.0f || rect.equals(this.contentBaseRect)) {
            return;
        }
        init(this.viewWidth, this.viewHeight, rect);
    }

    private void init(float viewWidth, float viewHeight, RectF rect) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        this.contentBaseRect.set(rect);
        this.contentRect.set(rect);
        if (rect.width() <= 0.0f || rect.height() <= 0.0f || viewWidth <= 0.0f || viewHeight <= 0.0f) {
            return;
        }
        if (this.initialized) {
            setState(0);
            float realZoom = getRealZoom();
            float fComputeBaseZoom = computeBaseZoom();
            this.baseZoom = fComputeBaseZoom;
            this.zoom = realZoom / fComputeBaseZoom;
            this.matrix.mapRect(this.contentRect, this.contentBaseRect);
            float fEnsureScaleBounds = ensureScaleBounds(this.zoom, false);
            if (fEnsureScaleBounds != this.zoom) {
                applyZoom(fEnsureScaleBounds, false);
            }
            ensureCurrentTranslationBounds(false);
            dispatchOnMatrix();
            return;
        }
        float fComputeBaseZoom2 = computeBaseZoom();
        this.baseZoom = fComputeBaseZoom2;
        this.matrix.setScale(fComputeBaseZoom2, fComputeBaseZoom2);
        this.matrix.mapRect(this.contentRect, this.contentBaseRect);
        this.zoom = 1.0f;
        float fEnsureScaleBounds2 = ensureScaleBounds(1.0f, false);
        if (fEnsureScaleBounds2 != this.zoom) {
            applyZoom(fEnsureScaleBounds2, false);
        }
        float[] fArrComputeBasePan = computeBasePan();
        float scaledPanX = fArrComputeBasePan[0] - getScaledPanX();
        float scaledPanY = fArrComputeBasePan[1] - getScaledPanY();
        if (scaledPanX != 0.0f || scaledPanY != 0.0f) {
            applyScaledPan(scaledPanX, scaledPanY, false);
        }
        ensureCurrentTranslationBounds(false);
        dispatchOnMatrix();
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setState(int mode) {
        if (!this.initialized) {
            return false;
        }
        int i = this.mode;
        if (mode == i) {
            return true;
        }
        if (mode == 0) {
            dispatchOnIdle();
        } else if (mode != 1) {
            if (mode != 2) {
                if (mode == 4 && i == 3) {
                    return false;
                }
            } else if (i == 3) {
                return false;
            }
        } else if (i == 2 || i == 3) {
            return false;
        }
        if (i == 3) {
            this.clearAnimation = true;
        } else if (i == 4) {
            this.flingScroller.forceFinished(true);
        }
        this.mode = mode;
        return true;
    }

    private float computeBaseZoom() {
        int i = this.transformation;
        if (i == 0) {
            return Math.min(this.viewWidth / this.contentRect.width(), this.viewHeight / this.contentRect.height());
        }
        if (i != 1) {
            return 1.0f;
        }
        return Math.max(this.viewWidth / this.contentRect.width(), this.viewHeight / this.contentRect.height());
    }

    private float[] computeBasePan() {
        float[] fArr = {0.0f, 0.0f};
        float fWidth = this.contentRect.width() - this.viewWidth;
        float fHeight = this.contentRect.height() - this.viewHeight;
        if (fWidth > 0.0f) {
            int i = this.transformationGravity & 7;
            if (i == 1) {
                fArr[0] = fWidth * (-0.5f);
            } else if (i == 3) {
                fArr[0] = 0.0f;
            } else if (i == 5) {
                fArr[0] = -fWidth;
            }
        }
        if (fHeight > 0.0f) {
            int i2 = this.transformationGravity & 112;
            if (i2 == 16) {
                fArr[1] = fHeight * (-0.5f);
            } else if (i2 == 48) {
                fArr[1] = 0.0f;
            } else if (i2 == 80) {
                fArr[1] = -fHeight;
            }
        }
        return fArr;
    }

    private void dispatchOnMatrix() {
        Listener listener = this.listener;
        if (listener != null) {
            listener.onUpdate(this, getMatrix());
        }
    }

    private void dispatchOnIdle() {
        Listener listener = this.listener;
        if (listener != null) {
            listener.onIdle(this);
        }
    }

    private float ensureScaleBounds(float value, boolean allowOverPinch) {
        float fResolveZoom = resolveZoom(this.minZoom, this.minZoomMode);
        float fResolveZoom2 = resolveZoom(this.maxZoom, this.maxZoomMode);
        if (allowOverPinch && this.overPinchable) {
            fResolveZoom -= getCurrentOverPinch();
            fResolveZoom2 += getCurrentOverPinch();
        }
        if (value < fResolveZoom) {
            value = fResolveZoom;
        }
        return value > fResolveZoom2 ? fResolveZoom2 : value;
    }

    private void ensureCurrentTranslationBounds(boolean allowOverScroll) {
        float fEnsureTranslationBounds = ensureTranslationBounds(0.0f, true, allowOverScroll);
        float fEnsureTranslationBounds2 = ensureTranslationBounds(0.0f, false, allowOverScroll);
        if (fEnsureTranslationBounds == 0.0f && fEnsureTranslationBounds2 == 0.0f) {
            return;
        }
        this.matrix.postTranslate(fEnsureTranslationBounds, fEnsureTranslationBounds2);
        this.matrix.mapRect(this.contentRect, this.contentBaseRect);
    }

    private float ensureTranslationBounds(float delta, boolean horizontal, boolean allowOverScroll) {
        float scaledPanX = horizontal ? getScaledPanX() : getScaledPanY();
        float f = horizontal ? this.viewWidth : this.viewHeight;
        RectF rectF = this.contentRect;
        return getTranslationCorrection(scaledPanX + delta, f, horizontal ? rectF.width() : rectF.height(), ((horizontal ? this.overScrollHorizontal : this.overScrollVertical) && allowOverScroll) ? getCurrentOverScroll() : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float resolveZoom(float zoom, int mode) {
        if (mode == 0) {
            return zoom;
        }
        if (mode != 1) {
            return -1.0f;
        }
        return zoom / this.baseZoom;
    }

    private float resolvePan(float pan) {
        return pan * getRealZoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float unresolvePan(float pan) {
        return pan / getRealZoom();
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return processTouchEvent(ev) > 1;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return processTouchEvent(ev) > 0;
    }

    private int processTouchEvent(MotionEvent event) {
        int actionMasked;
        if (this.mode == 3) {
            return 2;
        }
        boolean zOnTouchEvent = this.scaleDetector.onTouchEvent(event);
        if (this.mode != 2) {
            zOnTouchEvent |= this.flingDragDetector.onTouchEvent(event);
        }
        if (this.mode == 1 && ((actionMasked = event.getActionMasked()) == 1 || actionMasked == 3)) {
            onScrollEnd();
        }
        if (zOnTouchEvent && this.mode != 0) {
            return 2;
        }
        if (zOnTouchEvent) {
            return 1;
        }
        setState(0);
        return 0;
    }

    private void onScrollEnd() {
        if (this.overScrollHorizontal || this.overScrollVertical) {
            float fEnsureTranslationBounds = ensureTranslationBounds(0.0f, true, false);
            float fEnsureTranslationBounds2 = ensureTranslationBounds(0.0f, false, false);
            if (fEnsureTranslationBounds != 0.0f || fEnsureTranslationBounds2 != 0.0f) {
                animateScaledPan(fEnsureTranslationBounds, fEnsureTranslationBounds2, true);
                return;
            }
        }
        setState(0);
    }

    public void zoomTo(float zoom, boolean animate) {
        if (this.initialized) {
            if (animate) {
                animateZoom(zoom, false);
            } else {
                applyZoom(zoom, false);
            }
        }
    }

    public void setMaxZoom(float maxZoom, int type) {
        if (maxZoom < 0.0f) {
            throw new IllegalArgumentException("Max zoom should be >= 0.");
        }
        this.maxZoom = maxZoom;
        this.maxZoomMode = type;
        if (this.zoom > resolveZoom(maxZoom, type)) {
            zoomTo(resolveZoom(maxZoom, type), true);
        }
    }

    public void setMinZoom(float minZoom, int type) {
        if (minZoom < 0.0f) {
            throw new IllegalArgumentException("Min zoom should be >= 0");
        }
        this.minZoom = minZoom;
        this.minZoomMode = type;
        if (this.zoom <= resolveZoom(minZoom, type)) {
            zoomTo(resolveZoom(minZoom, type), true);
        }
    }

    public float getZoom() {
        return this.zoom;
    }

    public float getRealZoom() {
        return this.zoom * this.baseZoom;
    }

    public float getPanX() {
        return getScaledPanX() / getRealZoom();
    }

    public float getPanY() {
        return getScaledPanY() / getRealZoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getScaledPanX() {
        return this.contentRect.left;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getScaledPanY() {
        return this.contentRect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateZoom(float newZoom, final boolean allowOverPinch) {
        final float fEnsureScaleBounds = ensureScaleBounds(newZoom, allowOverPinch);
        if (setState(3)) {
            this.clearAnimation = false;
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final float f = this.zoom;
            this.view.post(new Runnable() { // from class: flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ZoomEngine.this.clearAnimation) {
                        return;
                    }
                    float fInterpolateAnimationTime = ZoomEngine.this.interpolateAnimationTime(System.currentTimeMillis() - jCurrentTimeMillis);
                    float f2 = f;
                    ZoomEngine.this.applyZoom(f2 + ((fEnsureScaleBounds - f2) * fInterpolateAnimationTime), allowOverPinch);
                    if (fInterpolateAnimationTime >= 1.0f) {
                        ZoomEngine.this.setState(0);
                    } else {
                        ZoomEngine.this.view.postOnAnimation(this);
                    }
                }
            });
        }
    }

    private void animateScaledPan(float deltaX, float deltaY, final boolean allowOverScroll) {
        if (setState(3)) {
            this.clearAnimation = false;
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final float scaledPanX = getScaledPanX();
            final float scaledPanY = getScaledPanY();
            final float f = scaledPanX + deltaX;
            final float f2 = scaledPanY + deltaY;
            this.view.post(new Runnable() { // from class: flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ZoomEngine.this.clearAnimation) {
                        return;
                    }
                    float fInterpolateAnimationTime = ZoomEngine.this.interpolateAnimationTime(System.currentTimeMillis() - jCurrentTimeMillis);
                    float f3 = scaledPanX;
                    float f4 = f3 + ((f - f3) * fInterpolateAnimationTime);
                    float f5 = scaledPanY;
                    float f6 = f5 + ((f2 - f5) * fInterpolateAnimationTime);
                    ZoomEngine zoomEngine = ZoomEngine.this;
                    zoomEngine.applyScaledPan(f4 - zoomEngine.getScaledPanX(), f6 - ZoomEngine.this.getScaledPanY(), allowOverScroll);
                    if (fInterpolateAnimationTime >= 1.0f) {
                        ZoomEngine.this.setState(0);
                    } else {
                        ZoomEngine.this.view.postOnAnimation(this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float interpolateAnimationTime(long delta) {
        return INTERPOLATOR.getInterpolation(Math.min(1.0f, delta / 280.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyZoom(float newZoom, boolean allowOverPinch) {
        float fEnsureScaleBounds = ensureScaleBounds(newZoom, allowOverPinch);
        float f = fEnsureScaleBounds / this.zoom;
        this.matrix.postScale(f, f, this.viewWidth / 2.0f, this.viewHeight / 2.0f);
        this.matrix.mapRect(this.contentRect, this.contentBaseRect);
        this.zoom = fEnsureScaleBounds;
        ensureCurrentTranslationBounds(false);
        dispatchOnMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyScaledPan(float deltaX, float deltaY, boolean allowOverScroll) {
        this.matrix.postTranslate(deltaX, deltaY);
        this.matrix.mapRect(this.contentRect, this.contentBaseRect);
        ensureCurrentTranslationBounds(allowOverScroll);
        dispatchOnMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyPinch(float newZoom, float targetX, float targetY, boolean allowOverPinch) {
        float fResolvePan = resolvePan(targetX);
        float fResolvePan2 = resolvePan(targetY);
        float fEnsureScaleBounds = ensureScaleBounds(newZoom, allowOverPinch);
        float f = fEnsureScaleBounds / this.zoom;
        this.matrix.postScale(f, f, getScaledPanX() - fResolvePan, getScaledPanY() - fResolvePan2);
        this.matrix.mapRect(this.contentRect, this.contentBaseRect);
        this.zoom = fEnsureScaleBounds;
        ensureCurrentTranslationBounds(false);
        dispatchOnMatrix();
    }

    private boolean computeScrollerValues(boolean horizontal) {
        int scaledPanX = (int) (horizontal ? getScaledPanX() : getScaledPanY());
        int i = (int) (horizontal ? this.viewWidth : this.viewHeight);
        RectF rectF = this.contentRect;
        int iWidth = (int) (horizontal ? rectF.width() : rectF.height());
        int iEnsureTranslationBounds = (int) ensureTranslationBounds(0.0f, horizontal, false);
        if (i >= iWidth) {
            int[] iArr = this.temp;
            int i2 = scaledPanX + iEnsureTranslationBounds;
            iArr[0] = i2;
            iArr[1] = scaledPanX;
            iArr[2] = i2;
        } else {
            int[] iArr2 = this.temp;
            iArr2[0] = -(iWidth - i);
            iArr2[1] = scaledPanX;
            iArr2[2] = 0;
        }
        return iEnsureTranslationBounds != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startFling(int velocityX, int velocityY) {
        if (!setState(4)) {
            return false;
        }
        boolean zComputeScrollerValues = computeScrollerValues(true);
        int[] iArr = this.temp;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        boolean zComputeScrollerValues2 = zComputeScrollerValues | computeScrollerValues(false);
        int[] iArr2 = this.temp;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        int i6 = iArr2[2];
        if (!zComputeScrollerValues2 && !this.overScrollHorizontal && !this.overScrollVertical && i >= i3 && i4 >= i6) {
            setState(0);
            return false;
        }
        this.flingScroller.fling(i2, i5, velocityX, velocityY, i, i3, i4, i6, this.overScrollHorizontal ? getCurrentOverScroll() : 0, this.overScrollVertical ? getCurrentOverScroll() : 0);
        this.view.post(new Runnable() { // from class: flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine.4
            @Override // java.lang.Runnable
            public void run() {
                if (ZoomEngine.this.flingScroller.isFinished()) {
                    ZoomEngine.this.setState(0);
                    return;
                }
                if (ZoomEngine.this.flingScroller.computeScrollOffset()) {
                    int currX = ZoomEngine.this.flingScroller.getCurrX();
                    int currY = ZoomEngine.this.flingScroller.getCurrY();
                    ZoomEngine zoomEngine = ZoomEngine.this;
                    zoomEngine.applyScaledPan(currX - zoomEngine.getScaledPanX(), currY - ZoomEngine.this.getScaledPanY(), true);
                    ZoomEngine.this.view.postOnAnimation(this);
                }
            }
        });
        return true;
    }

    private class PinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private float mAbsTargetX;
        private float mAbsTargetY;

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        private PinchListener() {
            this.mAbsTargetX = 0.0f;
            this.mAbsTargetY = 0.0f;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            if (!ZoomEngine.this.zoomEnabled || !ZoomEngine.this.setState(2)) {
                return false;
            }
            if (Math.abs(this.mAbsTargetX) < 1.0E-4f || Math.abs(this.mAbsTargetY) < 1.0E-4f) {
                float f = -detector.getFocusX();
                float f2 = -detector.getFocusY();
                float scaledPanX = f + ZoomEngine.this.getScaledPanX();
                float scaledPanY = f2 + ZoomEngine.this.getScaledPanY();
                this.mAbsTargetX = ZoomEngine.this.unresolvePan(scaledPanX);
                this.mAbsTargetY = ZoomEngine.this.unresolvePan(scaledPanY);
            }
            ZoomEngine.this.applyPinch(ZoomEngine.this.zoom * detector.getScaleFactor(), this.mAbsTargetX, this.mAbsTargetY, true);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            this.mAbsTargetX = 0.0f;
            this.mAbsTargetY = 0.0f;
            if (ZoomEngine.this.overPinchable) {
                ZoomEngine zoomEngine = ZoomEngine.this;
                float fResolveZoom = zoomEngine.resolveZoom(zoomEngine.maxZoom, ZoomEngine.this.maxZoomMode);
                ZoomEngine zoomEngine2 = ZoomEngine.this;
                float fResolveZoom2 = zoomEngine2.resolveZoom(zoomEngine2.minZoom, ZoomEngine.this.minZoomMode);
                if (ZoomEngine.this.getZoom() >= fResolveZoom2) {
                    fResolveZoom2 = 0.0f;
                }
                if (ZoomEngine.this.getZoom() <= fResolveZoom) {
                    fResolveZoom = fResolveZoom2;
                }
                if (fResolveZoom > 0.0f) {
                    ZoomEngine.this.animateZoom(fResolveZoom, true);
                    return;
                }
            }
            ZoomEngine.this.setState(0);
        }
    }

    private class FlingScrollListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            return true;
        }

        private FlingScrollListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (!ZoomEngine.this.horizontalPanEnabled) {
                velocityX = 0.0f;
            }
            int i = (int) velocityX;
            if (!ZoomEngine.this.verticalPanEnabled) {
                velocityY = 0.0f;
            }
            return ZoomEngine.this.startFling(i, (int) velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (!ZoomEngine.this.setState(1)) {
                return false;
            }
            ZoomEngine.this.applyScaledPan(ZoomEngine.this.horizontalPanEnabled ? -distanceX : 0.0f, ZoomEngine.this.verticalPanEnabled ? -distanceY : 0.0f, true);
            return true;
        }
    }
}
