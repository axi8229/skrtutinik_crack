package com.google.android.exoplayer2;

/* loaded from: classes2.dex */
public interface ControlDispatcher {
    boolean dispatchFastForward(Player player);

    boolean dispatchNext(Player player);

    boolean dispatchPrevious(Player player);

    boolean dispatchRewind(Player player);

    boolean dispatchSeekTo(Player player, int windowIndex, long positionMs);

    boolean dispatchSetPlayWhenReady(Player player, boolean playWhenReady);

    boolean dispatchSetRepeatMode(Player player, int repeatMode);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean shuffleModeEnabled);

    boolean isFastForwardEnabled();

    boolean isRewindEnabled();
}
