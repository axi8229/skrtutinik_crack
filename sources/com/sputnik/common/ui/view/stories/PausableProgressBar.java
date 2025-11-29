package com.sputnik.common.ui.view.stories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$drawable;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* compiled from: PausableProgressBar.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0000\u0018\u0000 &2\u00020\u0001:\u0003%&'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\u0015R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/sputnik/common/ui/view/stories/PausableProgressBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animation", "Lcom/sputnik/common/ui/view/stories/PausableProgressBar$PausableScaleAnimation;", "backProgressView", "Landroid/view/View;", "callback", "Lcom/sputnik/common/ui/view/stories/PausableProgressBar$Callback;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "frontProgressView", "maxProgressView", "clear", "", "finishProgress", "isMax", "", "pauseProgress", "resumeProgress", "setCallback", "setDuration", "setMax", "setMaxWithoutCallback", "setMin", "setMinWithoutCallback", "setProgressColor", RemoteMessageConst.Notification.COLOR, "setTrackColor", "startProgress", "Callback", "Companion", "PausableScaleAnimation", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PausableProgressBar extends FrameLayout {
    private PausableScaleAnimation animation;
    private View backProgressView;
    private Callback callback;
    private long duration;
    private View frontProgressView;
    private View maxProgressView;

    /* compiled from: PausableProgressBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/ui/view/stories/PausableProgressBar$Callback;", "", "onFinishProgress", "", "onStartProgress", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {
        void onFinishProgress();

        void onStartProgress();
    }

    public /* synthetic */ PausableProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausableProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.duration = YooProfilerImpl.TIMER_LIMIT;
        LayoutInflater.from(context).inflate(R$layout.pausable_progress, this);
        this.frontProgressView = findViewById(R$id.front_progress);
        this.maxProgressView = findViewById(R$id.max_progress);
        this.backProgressView = findViewById(R$id.back_progress);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PausableProgressBar(Context context) {
        this(context, null, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setTrackColor(int color) {
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R$drawable.background_progress_track);
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            Intrinsics.checkNotNullExpressionValue(drawableWrap, "wrap(...)");
            DrawableCompat.setTint(drawableWrap, color);
            View view = this.backProgressView;
            if (view == null) {
                return;
            }
            view.setBackground(drawableWrap);
        }
    }

    public final void setProgressColor(int color) {
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R$drawable.background_progress_fill);
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            Intrinsics.checkNotNullExpressionValue(drawableWrap, "wrap(...)");
            DrawableCompat.setTint(drawableWrap, color);
            View view = this.frontProgressView;
            if (view != null) {
                view.setBackground(drawableWrap);
            }
            View view2 = this.maxProgressView;
            if (view2 == null) {
                return;
            }
            view2.setBackground(drawableWrap);
        }
    }

    public final void setDuration(long duration) {
        this.duration = duration;
    }

    public final void setCallback(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public final void setMax() {
        finishProgress(true);
    }

    public final void setMin() {
        finishProgress(false);
    }

    public final void setMinWithoutCallback() {
        View view = this.maxProgressView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.setAnimationListener(null);
            PausableScaleAnimation pausableScaleAnimation2 = this.animation;
            Intrinsics.checkNotNull(pausableScaleAnimation2);
            pausableScaleAnimation2.cancel();
        }
    }

    public final void setMaxWithoutCallback() {
        View view = this.maxProgressView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.setAnimationListener(null);
            PausableScaleAnimation pausableScaleAnimation2 = this.animation;
            Intrinsics.checkNotNull(pausableScaleAnimation2);
            pausableScaleAnimation2.cancel();
        }
    }

    private final void finishProgress(boolean isMax) {
        View view = this.maxProgressView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(isMax ? 0 : 8);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.setAnimationListener(null);
            PausableScaleAnimation pausableScaleAnimation2 = this.animation;
            Intrinsics.checkNotNull(pausableScaleAnimation2);
            pausableScaleAnimation2.cancel();
            Callback callback = this.callback;
            if (callback != null) {
                Intrinsics.checkNotNull(callback);
                callback.onFinishProgress();
            }
        }
    }

    public final void startProgress() {
        View view = this.maxProgressView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
        PausableScaleAnimation pausableScaleAnimation = new PausableScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 0, 0.0f, 1, 0.0f);
        this.animation = pausableScaleAnimation;
        Intrinsics.checkNotNull(pausableScaleAnimation);
        pausableScaleAnimation.setDuration(this.duration);
        PausableScaleAnimation pausableScaleAnimation2 = this.animation;
        Intrinsics.checkNotNull(pausableScaleAnimation2);
        pausableScaleAnimation2.setInterpolator(new LinearInterpolator());
        PausableScaleAnimation pausableScaleAnimation3 = this.animation;
        Intrinsics.checkNotNull(pausableScaleAnimation3);
        pausableScaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.sputnik.common.ui.view.stories.PausableProgressBar.startProgress.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                View view2 = PausableProgressBar.this.frontProgressView;
                Intrinsics.checkNotNull(view2);
                view2.setVisibility(0);
                if (PausableProgressBar.this.callback != null) {
                    Callback callback = PausableProgressBar.this.callback;
                    Intrinsics.checkNotNull(callback);
                    callback.onStartProgress();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (PausableProgressBar.this.callback != null) {
                    Callback callback = PausableProgressBar.this.callback;
                    Intrinsics.checkNotNull(callback);
                    callback.onFinishProgress();
                }
            }
        });
        PausableScaleAnimation pausableScaleAnimation4 = this.animation;
        Intrinsics.checkNotNull(pausableScaleAnimation4);
        pausableScaleAnimation4.setFillAfter(true);
        View view2 = this.frontProgressView;
        Intrinsics.checkNotNull(view2);
        view2.startAnimation(this.animation);
    }

    public final void pauseProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.pause();
        }
    }

    public final void resumeProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.resume();
        }
    }

    public final void clear() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            Intrinsics.checkNotNull(pausableScaleAnimation);
            pausableScaleAnimation.setAnimationListener(null);
            PausableScaleAnimation pausableScaleAnimation2 = this.animation;
            Intrinsics.checkNotNull(pausableScaleAnimation2);
            pausableScaleAnimation2.cancel();
            this.animation = null;
        }
    }

    /* compiled from: PausableProgressBar.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001BG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/ui/view/stories/PausableProgressBar$PausableScaleAnimation;", "Landroid/view/animation/ScaleAnimation;", "fromX", "", "toX", "fromY", "toY", "pivotXType", "", "pivotXValue", "pivotYType", "pivotYValue", "(Lcom/sputnik/common/ui/view/stories/PausableProgressBar;FFFFIFIF)V", "mElapsedAtPause", "", "mPaused", "", "getTransformation", "currentTime", "outTransformation", "Landroid/view/animation/Transformation;", "scale", "pause", "", "resume", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class PausableScaleAnimation extends ScaleAnimation {
        private long mElapsedAtPause;
        private boolean mPaused;

        public PausableScaleAnimation(float f, float f2, float f3, float f4, int i, float f5, int i2, float f6) {
            super(f, f2, f3, f4, i, f5, i2, f6);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            Intrinsics.checkNotNullParameter(outTransformation, "outTransformation");
            if (this.mPaused && this.mElapsedAtPause == 0) {
                this.mElapsedAtPause = currentTime - getStartTime();
            }
            if (this.mPaused) {
                setStartTime(currentTime - this.mElapsedAtPause);
            }
            return super.getTransformation(currentTime, outTransformation, scale);
        }

        public final void pause() {
            if (this.mPaused) {
                return;
            }
            this.mElapsedAtPause = 0L;
            this.mPaused = true;
        }

        public final void resume() {
            this.mPaused = false;
        }
    }
}
