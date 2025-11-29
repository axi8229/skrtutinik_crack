package com.sputnik.common.ui.view.onboarding.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationFactory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/animation/AnimationFactory;", "", "()V", "animateFadeIn", "", "view", "Landroid/view/View;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "onAnimationStartListener", "Lkotlin/Function0;", "animateFadeOut", "onAnimationEndListener", "Lcom/sputnik/common/ui/view/onboarding/animation/AnimationListener;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnimationFactory {
    public static final AnimationFactory INSTANCE = new AnimationFactory();

    private AnimationFactory() {
    }

    public final void animateFadeIn(View view, long duration, final Function0<Unit> onAnimationStartListener) {
        Intrinsics.checkNotNullParameter(onAnimationStartListener, "onAnimationStartListener");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.sputnik.common.ui.view.onboarding.animation.AnimationFactory.animateFadeIn.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                onAnimationStartListener.invoke();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public final void animateFadeOut(View view, long duration, final AnimationListener onAnimationEndListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.sputnik.common.ui.view.onboarding.animation.AnimationFactory.animateFadeOut.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimationListener animationListener = onAnimationEndListener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }
}
