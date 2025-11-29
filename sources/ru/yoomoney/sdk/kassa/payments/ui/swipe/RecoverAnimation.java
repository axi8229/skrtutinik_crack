package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationConfig;", "item", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "config", "(Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationConfig;)V", "animationListener", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onPostAnimation", "prepareAnimator", "AnimationConfig", "AnimationListener", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecoverAnimation extends SwipeAnimation<AnimationConfig> {
    public static final int $stable = 8;
    private final AnimationListener animationListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationConfig;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeAnimation$AnimationConfig;", "targetTranslation", "", "getTargetTranslation", "()F", "getAnimationListener", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationListener;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnimationConfig extends SwipeAnimation.AnimationConfig {
        AnimationListener getAnimationListener();

        float getTargetTranslation();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationListener;", "", "onPostAnimation", "", "onPreAnimation", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnimationListener {
        void onPostAnimation();

        void onPreAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoverAnimation(SwipeItem item, AnimationConfig config) {
        super(item, config);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(config, "config");
        this.animationListener = config.getAnimationListener();
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        AnimationListener animationListener = this.animationListener;
        if (animationListener != null) {
            animationListener.onPreAnimation();
        }
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation
    public void onPostAnimation() {
        super.onPostAnimation();
        AnimationListener animationListener = this.animationListener;
        if (animationListener != null) {
            animationListener.onPostAnimation();
        }
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation
    public Animator prepareAnimator() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getSwipeItem(), SwipeItem.INSTANCE.getCONTENT_TRANSLATION_X(), getConfig().getTargetTranslation());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }
}
