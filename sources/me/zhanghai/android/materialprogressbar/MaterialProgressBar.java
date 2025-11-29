package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TintTypedArray;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

/* loaded from: classes4.dex */
public class MaterialProgressBar extends ProgressBar {
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_DYNAMIC = 1;
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_NORMAL = 0;
    public static final int PROGRESS_STYLE_CIRCULAR = 0;
    public static final int PROGRESS_STYLE_HORIZONTAL = 1;
    private static final String TAG = "MaterialProgressBar";
    private int mProgressStyle;
    private final TintInfo mProgressTintInfo;
    private boolean mSuperInitialized;

    private void fixCanvasScalingAndColorFilterWhenHardwareAccelerated() {
    }

    public MaterialProgressBar(Context context) {
        super(context);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(null, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, i, i2);
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Context context = getContext();
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.MaterialProgressBar, i, i2);
        this.mProgressStyle = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
        boolean z2 = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
        boolean z3 = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_showProgressBackground, this.mProgressStyle == 1);
        int i3 = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.MaterialProgressBar_mpb_determinateCircularProgressStyle, 0);
        int i4 = R.styleable.MaterialProgressBar_mpb_progressTint;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i4)) {
            this.mProgressTintInfo.mProgressTint = tintTypedArrayObtainStyledAttributes.getColorStateList(i4);
            this.mProgressTintInfo.mHasProgressTint = true;
        }
        int i5 = R.styleable.MaterialProgressBar_mpb_progressTintMode;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i5)) {
            this.mProgressTintInfo.mProgressTintMode = DrawableCompat.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i5, -1), null);
            this.mProgressTintInfo.mHasProgressTintMode = true;
        }
        int i6 = R.styleable.MaterialProgressBar_mpb_secondaryProgressTint;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i6)) {
            this.mProgressTintInfo.mSecondaryProgressTint = tintTypedArrayObtainStyledAttributes.getColorStateList(i6);
            this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        }
        int i7 = R.styleable.MaterialProgressBar_mpb_secondaryProgressTintMode;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i7)) {
            this.mProgressTintInfo.mSecondaryProgressTintMode = DrawableCompat.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i7, -1), null);
            this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        }
        int i8 = R.styleable.MaterialProgressBar_mpb_progressBackgroundTint;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i8)) {
            this.mProgressTintInfo.mProgressBackgroundTint = tintTypedArrayObtainStyledAttributes.getColorStateList(i8);
            this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        }
        int i9 = R.styleable.MaterialProgressBar_mpb_progressBackgroundTintMode;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i9)) {
            this.mProgressTintInfo.mProgressBackgroundTintMode = DrawableCompat.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i9, -1), null);
            this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        }
        int i10 = R.styleable.MaterialProgressBar_mpb_indeterminateTint;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i10)) {
            this.mProgressTintInfo.mIndeterminateTint = tintTypedArrayObtainStyledAttributes.getColorStateList(i10);
            this.mProgressTintInfo.mHasIndeterminateTint = true;
        }
        int i11 = R.styleable.MaterialProgressBar_mpb_indeterminateTintMode;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i11)) {
            this.mProgressTintInfo.mIndeterminateTintMode = DrawableCompat.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i11, -1), null);
            this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        int i12 = this.mProgressStyle;
        if (i12 == 0) {
            if ((isIndeterminate() || z) && !isInEditMode()) {
                setIndeterminateDrawable(new AnimationScaleIndeterminateCircularProgressDrawable(context));
            }
            if (!isIndeterminate() || z) {
                setProgressDrawable(new CircularProgressDrawable(i3, context));
            }
        } else if (i12 == 1) {
            if ((isIndeterminate() || z) && !isInEditMode()) {
                setIndeterminateDrawable(new IndeterminateHorizontalProgressDrawable(context));
            }
            if (!isIndeterminate() || z) {
                setProgressDrawable(new HorizontalProgressDrawable(context));
            }
        } else {
            throw new IllegalArgumentException("Unknown progress style: " + this.mProgressStyle);
        }
        setUseIntrinsicPadding(z2);
        setShowProgressBackground(z3);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        super.setIndeterminate(z);
        if (this.mSuperInitialized && !(getCurrentDrawable() instanceof MaterialProgressDrawable)) {
            Log.w(TAG, "Current drawable is not a MaterialProgressDrawable, you may want to set app:mpb_setBothDrawables");
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fixCanvasScalingAndColorFilterWhenHardwareAccelerated();
    }

    public int getProgressStyle() {
        return this.mProgressStyle;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public boolean getUseIntrinsicPadding() {
        Object currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof IntrinsicPaddingDrawable) {
            return ((IntrinsicPaddingDrawable) currentDrawable).getUseIntrinsicPadding();
        }
        return false;
    }

    public void setUseIntrinsicPadding(boolean z) {
        Object currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable) currentDrawable).setUseIntrinsicPadding(z);
        }
        Object indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable) indeterminateDrawable).setUseIntrinsicPadding(z);
        }
    }

    public boolean getShowProgressBackground() {
        Object currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof ShowBackgroundDrawable) {
            return ((ShowBackgroundDrawable) currentDrawable).getShowBackground();
        }
        return false;
    }

    public void setShowProgressBackground(boolean z) {
        Object currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable) currentDrawable).setShowBackground(z);
        }
        Object indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable) indeterminateDrawable).setShowBackground(z);
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
        if (this.mProgressTintInfo != null) {
            applyProgressTints();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (this.mProgressTintInfo != null) {
            applyIndeterminateTint();
        }
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressTintList() {
        logProgressBarTintWarning();
        return getSupportProgressTintList();
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportProgressTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressTintMode() {
        logProgressBarTintWarning();
        return getSupportProgressTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportProgressTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getSecondaryProgressTintList() {
        logProgressBarTintWarning();
        return getSupportSecondaryProgressTintList();
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportSecondaryProgressTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getSecondaryProgressTintMode() {
        logProgressBarTintWarning();
        return getSupportSecondaryProgressTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportSecondaryProgressTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressBackgroundTintList() {
        logProgressBarTintWarning();
        return getSupportProgressBackgroundTintList();
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportProgressBackgroundTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressBackgroundTintMode() {
        logProgressBarTintWarning();
        return getSupportProgressBackgroundTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportProgressBackgroundTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getIndeterminateTintList() {
        logProgressBarTintWarning();
        return getSupportIndeterminateTintList();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportIndeterminateTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getIndeterminateTintMode() {
        logProgressBarTintWarning();
        return getSupportIndeterminateTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportIndeterminateTintMode(mode);
    }

    private void logProgressBarTintWarning() {
        Log.w(TAG, "Non-support version of tint method called, this is error-prone and will crash below Lollipop if you are calling it as a method of ProgressBar instead of MaterialProgressBar");
    }

    public ColorStateList getSupportProgressTintList() {
        return this.mProgressTintInfo.mProgressTint;
    }

    public void setSupportProgressTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressTint = colorStateList;
        tintInfo.mHasProgressTint = true;
        applyPrimaryProgressTint();
    }

    public PorterDuff.Mode getSupportProgressTintMode() {
        return this.mProgressTintInfo.mProgressTintMode;
    }

    public void setSupportProgressTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressTintMode = mode;
        tintInfo.mHasProgressTintMode = true;
        applyPrimaryProgressTint();
    }

    public ColorStateList getSupportSecondaryProgressTintList() {
        return this.mProgressTintInfo.mSecondaryProgressTint;
    }

    public void setSupportSecondaryProgressTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mSecondaryProgressTint = colorStateList;
        tintInfo.mHasSecondaryProgressTint = true;
        applySecondaryProgressTint();
    }

    public PorterDuff.Mode getSupportSecondaryProgressTintMode() {
        return this.mProgressTintInfo.mSecondaryProgressTintMode;
    }

    public void setSupportSecondaryProgressTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mSecondaryProgressTintMode = mode;
        tintInfo.mHasSecondaryProgressTintMode = true;
        applySecondaryProgressTint();
    }

    public ColorStateList getSupportProgressBackgroundTintList() {
        return this.mProgressTintInfo.mProgressBackgroundTint;
    }

    public void setSupportProgressBackgroundTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressBackgroundTint = colorStateList;
        tintInfo.mHasProgressBackgroundTint = true;
        applyProgressBackgroundTint();
    }

    public PorterDuff.Mode getSupportProgressBackgroundTintMode() {
        return this.mProgressTintInfo.mProgressBackgroundTintMode;
    }

    public void setSupportProgressBackgroundTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressBackgroundTintMode = mode;
        tintInfo.mHasProgressBackgroundTintMode = true;
        applyProgressBackgroundTint();
    }

    public ColorStateList getSupportIndeterminateTintList() {
        return this.mProgressTintInfo.mIndeterminateTint;
    }

    public void setSupportIndeterminateTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mIndeterminateTint = colorStateList;
        tintInfo.mHasIndeterminateTint = true;
        applyIndeterminateTint();
    }

    public PorterDuff.Mode getSupportIndeterminateTintMode() {
        return this.mProgressTintInfo.mIndeterminateTintMode;
    }

    public void setSupportIndeterminateTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mIndeterminateTintMode = mode;
        tintInfo.mHasIndeterminateTintMode = true;
        applyIndeterminateTint();
    }

    private void applyProgressTints() {
        if (getProgressDrawable() == null) {
            return;
        }
        applyPrimaryProgressTint();
        applyProgressBackgroundTint();
        applySecondaryProgressTint();
    }

    private void applyPrimaryProgressTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasProgressTint || tintInfo.mHasProgressTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(android.R.id.progress, true)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            applyTintForDrawable(tintTargetFromProgressDrawable, tintInfo2.mProgressTint, tintInfo2.mHasProgressTint, tintInfo2.mProgressTintMode, tintInfo2.mHasProgressTintMode);
        }
    }

    private void applySecondaryProgressTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasSecondaryProgressTint || tintInfo.mHasSecondaryProgressTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(android.R.id.secondaryProgress, false)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            applyTintForDrawable(tintTargetFromProgressDrawable, tintInfo2.mSecondaryProgressTint, tintInfo2.mHasSecondaryProgressTint, tintInfo2.mSecondaryProgressTintMode, tintInfo2.mHasSecondaryProgressTintMode);
        }
    }

    private void applyProgressBackgroundTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasProgressBackgroundTint || tintInfo.mHasProgressBackgroundTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(android.R.id.background, false)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            applyTintForDrawable(tintTargetFromProgressDrawable, tintInfo2.mProgressBackgroundTint, tintInfo2.mHasProgressBackgroundTint, tintInfo2.mProgressBackgroundTintMode, tintInfo2.mHasProgressBackgroundTintMode);
        }
    }

    private Drawable getTintTargetFromProgressDrawable(int i, boolean z) {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable == null) {
            return null;
        }
        progressDrawable.mutate();
        Drawable drawableFindDrawableByLayerId = progressDrawable instanceof LayerDrawable ? ((LayerDrawable) progressDrawable).findDrawableByLayerId(i) : null;
        return (drawableFindDrawableByLayerId == null && z) ? progressDrawable : drawableFindDrawableByLayerId;
    }

    private void applyIndeterminateTint() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if (tintInfo.mHasIndeterminateTint || tintInfo.mHasIndeterminateTintMode) {
            indeterminateDrawable.mutate();
            TintInfo tintInfo2 = this.mProgressTintInfo;
            applyTintForDrawable(indeterminateDrawable, tintInfo2.mIndeterminateTint, tintInfo2.mHasIndeterminateTint, tintInfo2.mIndeterminateTintMode, tintInfo2.mHasIndeterminateTintMode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    private void applyTintForDrawable(Drawable drawable, ColorStateList colorStateList, boolean z, PorterDuff.Mode mode, boolean z2) {
        if (z || z2) {
            if (z) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintList(colorStateList);
                } else {
                    logDrawableTintWarning();
                    drawable.setTintList(colorStateList);
                }
            }
            if (z2) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintMode(mode);
                } else {
                    logDrawableTintWarning();
                    drawable.setTintMode(mode);
                }
            }
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    private void logDrawableTintWarning() {
        Log.w(TAG, "Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
    }

    private static class TintInfo {
        public boolean mHasIndeterminateTint;
        public boolean mHasIndeterminateTintMode;
        public boolean mHasProgressBackgroundTint;
        public boolean mHasProgressBackgroundTintMode;
        public boolean mHasProgressTint;
        public boolean mHasProgressTintMode;
        public boolean mHasSecondaryProgressTint;
        public boolean mHasSecondaryProgressTintMode;
        public ColorStateList mIndeterminateTint;
        public PorterDuff.Mode mIndeterminateTintMode;
        public ColorStateList mProgressBackgroundTint;
        public PorterDuff.Mode mProgressBackgroundTintMode;
        public ColorStateList mProgressTint;
        public PorterDuff.Mode mProgressTintMode;
        public ColorStateList mSecondaryProgressTint;
        public PorterDuff.Mode mSecondaryProgressTintMode;

        private TintInfo() {
        }
    }
}
