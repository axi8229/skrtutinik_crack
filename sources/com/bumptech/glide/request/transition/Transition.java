package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface Transition<R> {

    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        void setDrawable(Drawable drawable);
    }

    boolean transition(R r, ViewAdapter viewAdapter);
}
