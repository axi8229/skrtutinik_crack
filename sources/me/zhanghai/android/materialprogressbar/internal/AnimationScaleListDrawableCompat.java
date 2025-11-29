package me.zhanghai.android.materialprogressbar.internal;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat;

/* loaded from: classes4.dex */
public class AnimationScaleListDrawableCompat extends DrawableContainerCompat implements Animatable {
    private static final String TAG = "AnimationScaleListDrawableCompat";
    private AnimationScaleListState mAnimationScaleListState;
    private boolean mMutated;

    public AnimationScaleListDrawableCompat(Drawable[] drawableArr) {
        setConstantState(new AnimationScaleListState(null, this, null));
        for (Drawable drawable : drawableArr) {
            this.mAnimationScaleListState.addDrawable(drawable);
        }
        onStateChange(getState());
    }

    private AnimationScaleListDrawableCompat(AnimationScaleListState animationScaleListState, Resources resources) {
        setConstantState(new AnimationScaleListState(animationScaleListState, this, resources));
        onStateChange(getState());
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return selectDrawable(this.mAnimationScaleListState.getCurrentDrawableIndexBasedOnScale()) || super.onStateChange(iArr);
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mAnimationScaleListState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return;
        }
        ((Animatable) current).start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return;
        }
        ((Animatable) current).stop();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Object current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return false;
        }
        return ((Animatable) current).isRunning();
    }

    static class AnimationScaleListState extends DrawableContainerCompat.DrawableContainerState {
        int mAnimatableDrawableIndex;
        int mStaticDrawableIndex;
        int[] mThemeAttrs;

        AnimationScaleListState(AnimationScaleListState animationScaleListState, AnimationScaleListDrawableCompat animationScaleListDrawableCompat, Resources resources) {
            super(animationScaleListState, animationScaleListDrawableCompat, resources);
            this.mThemeAttrs = null;
            this.mStaticDrawableIndex = -1;
            this.mAnimatableDrawableIndex = -1;
            if (animationScaleListState != null) {
                this.mThemeAttrs = animationScaleListState.mThemeAttrs;
                this.mStaticDrawableIndex = animationScaleListState.mStaticDrawableIndex;
                this.mAnimatableDrawableIndex = animationScaleListState.mAnimatableDrawableIndex;
            }
        }

        @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            int[] iArr = this.mThemeAttrs;
            this.mThemeAttrs = iArr != null ? (int[]) iArr.clone() : null;
        }

        int addDrawable(Drawable drawable) {
            int iAddChild = addChild(drawable);
            if (drawable instanceof Animatable) {
                this.mAnimatableDrawableIndex = iAddChild;
            } else {
                this.mStaticDrawableIndex = iAddChild;
            }
            return iAddChild;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimationScaleListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimationScaleListDrawableCompat(this, resources);
        }

        @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat.DrawableContainerState, android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null || super.canApplyTheme();
        }

        public int getCurrentDrawableIndexBasedOnScale() {
            if (!ValueAnimatorCompat.areAnimatorsEnabled()) {
                return this.mStaticDrawableIndex;
            }
            return this.mAnimatableDrawableIndex;
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat
    protected void setConstantState(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimationScaleListState) {
            this.mAnimationScaleListState = (AnimationScaleListState) drawableContainerState;
        }
    }
}
