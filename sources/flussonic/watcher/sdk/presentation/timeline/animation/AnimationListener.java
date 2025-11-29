package flussonic.watcher.sdk.presentation.timeline.animation;

import android.animation.Animator;
import android.view.View;

/* loaded from: classes3.dex */
class AnimationListener implements Animator.AnimatorListener {
    private final OnAnimationEndListener onAnimationEndListener;
    private final View view;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
    }

    AnimationListener(View view, OnAnimationEndListener onAnimationEndListener) {
        this.view = view;
        this.onAnimationEndListener = onAnimationEndListener;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        OnAnimationEndListener onAnimationEndListener = this.onAnimationEndListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd();
        }
        animation.removeAllListeners();
        this.view.setTranslationY(0.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        animation.removeAllListeners();
        this.view.setTranslationY(0.0f);
    }
}
