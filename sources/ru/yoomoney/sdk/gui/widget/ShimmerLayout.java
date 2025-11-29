package ru.yoomoney.sdk.gui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;

/* loaded from: classes3.dex */
public class ShimmerLayout extends FrameLayout {
    private boolean autoStart;
    private int backgroundTint;
    private Canvas canvasForShimmerMask;
    private float gradientCenterColorWidth;
    private Paint gradientTexturePaint;
    private boolean isAnimationReversed;
    private boolean isAnimationStarted;
    private Bitmap localMaskBitmap;
    private ValueAnimator maskAnimator;
    private Bitmap maskBitmap;
    private int maskOffsetX;
    private Rect maskRect;
    private float maskWidth;
    private int shimmerAngle;
    private int shimmerAnimationDuration;
    private int shimmerColor;
    private ViewTreeObserver.OnPreDrawListener startAnimationPreDrawListener;

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ShimmerLayout, 0, 0);
        try {
            this.shimmerAngle = typedArrayObtainStyledAttributes.getInteger(R$styleable.ym_ShimmerLayout_ym_shimmer_angle, 20);
            this.shimmerAnimationDuration = typedArrayObtainStyledAttributes.getInteger(R$styleable.ym_ShimmerLayout_ym_shimmer_animation_duration, 1250);
            this.shimmerColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ym_ShimmerLayout_ym_shimmer_color, getColor(R$color.color_ripple));
            this.backgroundTint = typedArrayObtainStyledAttributes.getColor(R$styleable.ym_ShimmerLayout_ym_shimmer_background_tint, -1);
            this.autoStart = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ShimmerLayout_ym_shimmer_auto_start, false);
            this.maskWidth = typedArrayObtainStyledAttributes.getFloat(R$styleable.ym_ShimmerLayout_ym_shimmer_mask_width, 0.5f);
            this.gradientCenterColorWidth = typedArrayObtainStyledAttributes.getFloat(R$styleable.ym_ShimmerLayout_ym_shimmer_gradient_center_color_width, 0.1f);
            this.isAnimationReversed = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ShimmerLayout_ym_shimmer_reverse_animation, false);
            typedArrayObtainStyledAttributes.recycle();
            setMaskWidth(this.maskWidth);
            setGradientCenterColorWidth(this.gradientCenterColorWidth);
            setShimmerAngle(this.shimmerAngle);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.autoStart && getVisibility() == 0) {
            startShimmerAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.backgroundTint;
        if (i != -1) {
            tintBackground(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        stopShimmerAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.isAnimationStarted || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawShimmer(canvas);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.autoStart) {
                startShimmerAnimation();
                return;
            }
            return;
        }
        stopShimmerAnimation();
    }

    public void startShimmerAnimation() {
        if (this.isAnimationStarted) {
            return;
        }
        if (getWidth() == 0) {
            this.startAnimationPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: ru.yoomoney.sdk.gui.widget.ShimmerLayout.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    ShimmerLayout.this.startShimmerAnimation();
                    return true;
                }
            };
            getViewTreeObserver().addOnPreDrawListener(this.startAnimationPreDrawListener);
        } else {
            getShimmerAnimation().start();
            this.isAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.startAnimationPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.startAnimationPreDrawListener);
        }
        resetShimmering();
    }

    public void setShimmerColor(int i) {
        this.shimmerColor = i;
        resetIfStarted();
    }

    public void setShimmerAnimationDuration(int i) {
        this.shimmerAnimationDuration = i;
        resetIfStarted();
    }

    public void setAnimationReversed(boolean z) {
        this.isAnimationReversed = z;
        resetIfStarted();
    }

    public void tintBackground(int i) {
        Drawable background = getBackground();
        if (background != null) {
            DrawableExtensions.tint(background, i);
        }
    }

    private void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, (byte) 45));
        }
        this.shimmerAngle = i;
        resetIfStarted();
    }

    private void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
        this.maskWidth = f;
        resetIfStarted();
    }

    private void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
        this.gradientCenterColorWidth = f;
        resetIfStarted();
    }

    private void resetIfStarted() {
        if (this.isAnimationStarted) {
            resetShimmering();
            startShimmerAnimation();
        }
    }

    private void dispatchDrawShimmer(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.localMaskBitmap = maskBitmap;
        if (maskBitmap == null) {
            return;
        }
        if (this.canvasForShimmerMask == null) {
            this.canvasForShimmerMask = new Canvas(this.localMaskBitmap);
        }
        this.canvasForShimmerMask.drawColor(0, PorterDuff.Mode.CLEAR);
        this.canvasForShimmerMask.save();
        this.canvasForShimmerMask.translate(-this.maskOffsetX, 0.0f);
        super.dispatchDraw(this.canvasForShimmerMask);
        this.canvasForShimmerMask.restore();
        drawShimmer(canvas);
        this.localMaskBitmap = null;
    }

    private void drawShimmer(Canvas canvas) {
        createShimmerPaint();
        canvas.save();
        canvas.translate(this.maskOffsetX, 0.0f);
        Rect rect = this.maskRect;
        canvas.drawRect(rect.left, 0.0f, rect.width(), this.maskRect.height(), this.gradientTexturePaint);
        canvas.restore();
    }

    private void resetShimmering() {
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.maskAnimator.removeAllUpdateListeners();
        }
        this.maskAnimator = null;
        this.gradientTexturePaint = null;
        this.isAnimationStarted = false;
        releaseBitMaps();
    }

    private void releaseBitMaps() {
        this.canvasForShimmerMask = null;
        Bitmap bitmap = this.maskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.maskBitmap = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.maskBitmap == null) {
            this.maskBitmap = createBitmap(this.maskRect.width(), getHeight());
        }
        return this.maskBitmap;
    }

    private void createShimmerPaint() {
        if (this.gradientTexturePaint != null) {
            return;
        }
        int iReduceColorAlphaValueToZero = reduceColorAlphaValueToZero(this.shimmerColor);
        float width = (getWidth() / 2.0f) * this.maskWidth;
        float height = this.shimmerAngle >= 0 ? getHeight() : 0.0f;
        float fCos = ((float) Math.cos(Math.toRadians(this.shimmerAngle))) * width;
        float fSin = height + (((float) Math.sin(Math.toRadians(this.shimmerAngle))) * width);
        int i = this.shimmerColor;
        int[] iArr = {iReduceColorAlphaValueToZero, i, i, iReduceColorAlphaValueToZero};
        float[] gradientColorDistribution = getGradientColorDistribution();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, fCos, fSin, iArr, gradientColorDistribution, tileMode), new BitmapShader(this.localMaskBitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
        Paint paint = new Paint();
        this.gradientTexturePaint = paint;
        paint.setAntiAlias(true);
        this.gradientTexturePaint.setDither(true);
        this.gradientTexturePaint.setFilterBitmap(true);
        this.gradientTexturePaint.setShader(composeShader);
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.maskRect == null) {
            this.maskRect = calculateBitmapMaskRect();
        }
        int width = getWidth();
        final int i = getWidth() > this.maskRect.width() ? -width : -this.maskRect.width();
        final int iWidth = this.maskRect.width();
        int i2 = width - i;
        ValueAnimator valueAnimatorOfInt = this.isAnimationReversed ? ValueAnimator.ofInt(i2, 0) : ValueAnimator.ofInt(0, i2);
        this.maskAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.shimmerAnimationDuration);
        this.maskAnimator.setRepeatCount(-1);
        this.maskAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.yoomoney.sdk.gui.widget.ShimmerLayout$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$getShimmerAnimation$0(i, iWidth, valueAnimator2);
            }
        });
        return this.maskAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getShimmerAnimation$0(int i, int i2, ValueAnimator valueAnimator) {
        int iIntValue = i + ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.maskOffsetX = iIntValue;
        if (iIntValue + i2 >= 0) {
            invalidate();
        }
    }

    private Bitmap createBitmap(int i, int i2) {
        return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
    }

    private int getColor(int i) {
        return getContext().getColor(i);
    }

    private int reduceColorAlphaValueToZero(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    private Rect calculateBitmapMaskRect() {
        return new Rect(0, 0, calculateMaskWidth(), getHeight());
    }

    private int calculateMaskWidth() {
        return (int) ((((getWidth() / 2.0d) * this.maskWidth) / Math.cos(Math.toRadians(Math.abs(this.shimmerAngle)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.shimmerAngle)))));
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = {0.0f, 0.5f - (f / 2.0f), (f / 2.0f) + 0.5f, 1.0f};
        float f = this.gradientCenterColorWidth;
        return fArr;
    }
}
