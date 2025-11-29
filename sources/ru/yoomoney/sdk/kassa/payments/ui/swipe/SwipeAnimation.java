package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation.AnimationConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\b \u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001\u0018B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\b\u0010\u0016\u001a\u00020\tH&J\u0006\u0010\u0017\u001a\u00020\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation;", "T", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;", "Landroid/animation/AnimatorListenerAdapter;", "swipeItem", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "config", "(Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;)V", "animator", "Landroid/animation/Animator;", "getConfig", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;", "getSwipeItem", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "cancel", "", "onAnimationCancel", "animation", "onAnimationEnd", "onAnimationStart", "onPostAnimation", "prepareAnimator", "start", "AnimationConfig", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SwipeAnimation<T extends AnimationConfig> extends AnimatorListenerAdapter {
    public static final int $stable = 8;
    private Animator animator;
    private final T config;
    private final SwipeItem swipeItem;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;", "", "animationDuration", "", "getAnimationDuration", "()I", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnimationConfig {
        int getAnimationDuration();
    }

    public SwipeAnimation(SwipeItem swipeItem, T t) {
        Intrinsics.checkNotNullParameter(swipeItem, "swipeItem");
        this.swipeItem = swipeItem;
        this.config = t;
    }

    public final void cancel() {
        Animator animator = this.animator;
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.cancel();
    }

    public final T getConfig() {
        return this.config;
    }

    public final SwipeItem getSwipeItem() {
        return this.swipeItem;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        onPostAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        onPostAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.swipeItem.getViewHolder().setIsRecyclable(false);
    }

    public void onPostAnimation() {
        this.swipeItem.getViewHolder().setIsRecyclable(true);
    }

    public abstract Animator prepareAnimator();

    public final void start() {
        cancel();
        Animator animatorPrepareAnimator = prepareAnimator();
        Intrinsics.checkNotNull(this.config);
        animatorPrepareAnimator.setDuration(r1.getAnimationDuration());
        animatorPrepareAnimator.addListener(this);
        animatorPrepareAnimator.start();
        this.animator = animatorPrepareAnimator;
    }
}
