package flussonic.watcher.sdk.presentation.timeline.animation;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;

/* loaded from: classes3.dex */
public class TimelineAnimator {
    public static final int DURATION = 150;
    private ObjectAnimator animator;
    private final int offsetY;

    public TimelineAnimator(int offsetY) {
        this.offsetY = offsetY;
    }

    public void expandTimeline(View timeline) {
        cancelAnimation();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(timeline, (Property<View, Float>) View.TRANSLATION_Y, this.offsetY, 0.0f);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimationListener(timeline, null));
        this.animator.setDuration(150L);
        this.animator.start();
    }

    public void collapseTimeline(View timeline, OnAnimationEndListener listener) {
        cancelAnimation();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(timeline, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, this.offsetY);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimationListener(timeline, listener));
        this.animator.setDuration(150L);
        this.animator.start();
    }

    public void cancelAnimation() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
