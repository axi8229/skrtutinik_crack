package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;

/* loaded from: classes2.dex */
public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] renderers, TrackGroupArray trackGroups, TrackSelectionArray trackSelections);

    boolean retainBackBufferFromKeyframe();

    @Deprecated
    default boolean shouldContinueLoading(long bufferedDurationUs, float playbackSpeed) {
        return false;
    }

    boolean shouldStartPlayback(long bufferedDurationUs, float playbackSpeed, boolean rebuffering);

    default boolean shouldContinueLoading(long playbackPositionUs, long bufferedDurationUs, float playbackSpeed) {
        return shouldContinueLoading(bufferedDurationUs, playbackSpeed);
    }
}
