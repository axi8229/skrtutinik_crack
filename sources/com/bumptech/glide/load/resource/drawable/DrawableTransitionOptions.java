package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

/* loaded from: classes.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transition(drawableCrossFadeFactory);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        return crossFade(builder.build());
    }
}
