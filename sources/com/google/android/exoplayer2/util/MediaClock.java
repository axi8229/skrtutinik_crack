package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public interface MediaClock {
    float getPlaybackSpeed();

    long getPositionUs();

    void setPlaybackSpeed(float playbackSpeed);
}
