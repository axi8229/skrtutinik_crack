package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public interface VideoListener {
    default void onRenderedFirstFrame() {
    }

    default void onSurfaceSizeChanged(int width, int height) {
    }

    default void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
    }
}
