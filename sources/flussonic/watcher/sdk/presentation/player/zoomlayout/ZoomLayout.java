package flussonic.watcher.sdk.presentation.player.zoomlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import flussonic.watcher.sdk.R$styleable;
import flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes3.dex */
public class ZoomLayout extends FrameLayout implements ZoomEngine.Listener {
    private static final String TAG = "ZoomLayout";
    private final RectF childRect;
    private final ZoomEngine engine;
    private boolean hasClickableChildren;
    private final Matrix matrix;
    private final float[] matrixValues;

    @Override // flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine.Listener
    public void onIdle(ZoomEngine engine) {
    }

    public ZoomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZoomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.matrix = new Matrix();
        this.matrixValues = new float[9];
        this.childRect = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R$styleable.ZoomEngine, defStyleAttr, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_overScrollHorizontal, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_overScrollVertical, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_horizontalPanEnabled, true);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_verticalPanEnabled, true);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_overPinchable, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_zoomEnabled, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ZoomEngine_hasClickableChildren, false);
        float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.ZoomEngine_minZoom, -1.0f);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R$styleable.ZoomEngine_maxZoom, -1.0f);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.ZoomEngine_minZoomType, 0);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(R$styleable.ZoomEngine_maxZoomType, 0);
        int integer3 = typedArrayObtainStyledAttributes.getInteger(R$styleable.ZoomEngine_transformation, 0);
        int i = typedArrayObtainStyledAttributes.getInt(R$styleable.ZoomEngine_transformationGravity, 17);
        typedArrayObtainStyledAttributes.recycle();
        this.engine = new ZoomEngine(context, this, this);
        setTransformation(integer3, i);
        setOverScrollHorizontal(z);
        setOverScrollVertical(z2);
        setHorizontalPanEnabled(z3);
        setVerticalPanEnabled(z4);
        setOverPinchable(z5);
        setZoomEnabled(z6);
        if (f > -1.0f) {
            setMinZoom(f, integer);
        }
        if (f2 > -1.0f) {
            setMaxZoom(f2, integer2);
        }
        setHasClickableChildren(z7);
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException(TAG + " must be used with fixed dimensions (e.g. match_parent)");
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(size, size2);
        measureChildren(View.MeasureSpec.makeMeasureSpec(size, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(size2, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH));
    }

    @Override // android.view.ViewGroup
    public void addView(final View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() == 0) {
            child.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomLayout$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$addView$0(child);
                }
            });
            super.addView(child, index, params);
        } else {
            throw new RuntimeException(TAG + " accepts only a single child.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addView$0(final View child) {
        this.childRect.set(0.0f, 0.0f, child.getWidth(), child.getHeight());
        this.engine.setContentSize(this.childRect);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.engine.onInterceptTouchEvent(ev) || (this.hasClickableChildren && super.onInterceptTouchEvent(ev));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent ev) {
        return this.engine.onTouchEvent(ev) || (this.hasClickableChildren && super.onTouchEvent(ev));
    }

    @Override // flussonic.watcher.sdk.presentation.player.zoomlayout.ZoomEngine.Listener
    public void onUpdate(ZoomEngine helper, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.hasClickableChildren) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                this.matrix.getValues(this.matrixValues);
                childAt.setPivotX(0.0f);
                childAt.setPivotY(0.0f);
                childAt.setTranslationX(this.matrixValues[2]);
                childAt.setTranslationY(this.matrixValues[5]);
                childAt.setScaleX(this.matrixValues[0]);
                childAt.setScaleY(this.matrixValues[4]);
            }
        } else {
            invalidate();
        }
        if ((isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled()) && !awakenScrollBars()) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return (int) (this.engine.getPanX() * (-1.0f) * this.engine.getRealZoom());
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) (this.childRect.width() * this.engine.getRealZoom());
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return (int) (this.engine.getPanY() * (-1.0f) * this.engine.getRealZoom());
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) (this.childRect.height() * this.engine.getRealZoom());
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (!this.hasClickableChildren) {
            int iSave = canvas.save();
            canvas.setMatrix(this.matrix);
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(iSave);
            return zDrawChild;
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    public void setHasClickableChildren(boolean hasClickableChildren) {
        if (this.hasClickableChildren && !hasClickableChildren && getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.setScaleX(1.0f);
            childAt.setScaleY(1.0f);
            childAt.setTranslationX(0.0f);
            childAt.setTranslationY(0.0f);
        }
        this.hasClickableChildren = hasClickableChildren;
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        if (this.hasClickableChildren) {
            onUpdate(this.engine, this.matrix);
        } else {
            invalidate();
        }
    }

    public ZoomEngine getEngine() {
        return this.engine;
    }

    public void setOverScrollHorizontal(boolean overScroll) {
        getEngine().setOverScrollHorizontal(overScroll);
    }

    public void setOverScrollVertical(boolean overScroll) {
        getEngine().setOverScrollVertical(overScroll);
    }

    public void setHorizontalPanEnabled(boolean enabled) {
        getEngine().setHorizontalPanEnabled(enabled);
    }

    public void setVerticalPanEnabled(boolean enabled) {
        getEngine().setVerticalPanEnabled(enabled);
    }

    public void setOverPinchable(boolean overPinchable) {
        getEngine().setOverPinchable(overPinchable);
    }

    public void setZoomEnabled(boolean enabled) {
        getEngine().setZoomEnabled(enabled);
    }

    public void setTransformation(int transformation, int gravity) {
        getEngine().setTransformation(transformation, gravity);
    }

    public void setMaxZoom(float maxZoom, int type) {
        getEngine().setMaxZoom(maxZoom, type);
    }

    public void setMinZoom(float minZoom, int type) {
        getEngine().setMinZoom(minZoom, type);
    }

    public float getZoom() {
        return getEngine().getZoom();
    }

    public float getRealZoom() {
        return getEngine().getRealZoom();
    }

    public float getPanX() {
        return getEngine().getPanX();
    }

    public float getPanY() {
        return getEngine().getPanY();
    }
}
