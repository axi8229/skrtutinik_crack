package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public interface DrmSessionEventListener {
    default void onDrmKeysLoaded() {
    }

    default void onDrmKeysRestored() {
    }

    default void onDrmSessionAcquired() {
    }

    default void onDrmSessionManagerError(Exception error) {
    }

    default void onDrmSessionReleased() {
    }
}
