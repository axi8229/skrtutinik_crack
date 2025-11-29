package flussonic.watcher.sdk.presentation.timeline.animation;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;

/* loaded from: classes3.dex */
public class ToolbarAnimator {
    private static final int DURATION = 150;
    private ObjectAnimator animator;
    private final int toolbarHeight;

    public ToolbarAnimator(int toolbarHeight) {
        this.toolbarHeight = toolbarHeight;
    }

    public void expandToolbar(View toolbar) {
        cancelAnimation();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(toolbar, (Property<View, Float>) View.TRANSLATION_Y, -this.toolbarHeight, 0.0f);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimationListener(toolbar, null));
        this.animator.setDuration(150L);
        this.animator.start();
    }

    public void collapseToolbar(View toolbar, OnAnimationEndListener listener) {
        cancelAnimation();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(toolbar, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.toolbarHeight);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimationListener(toolbar, listener));
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
