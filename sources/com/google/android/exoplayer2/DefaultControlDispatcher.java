package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;
import com.google.android.gms.location.DeviceOrientationRequest;

/* loaded from: classes2.dex */
public class DefaultControlDispatcher implements ControlDispatcher {
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline.Window window;

    public DefaultControlDispatcher() {
        this(15000L, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    public DefaultControlDispatcher(long fastForwardIncrementMs, long rewindIncrementMs) {
        this.fastForwardIncrementMs = fastForwardIncrementMs;
        this.rewindIncrementMs = rewindIncrementMs;
        this.window = new Timeline.Window();
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(Player player, boolean playWhenReady) {
        player.setPlayWhenReady(playWhenReady);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(Player player, int windowIndex, long positionMs) {
        player.seekTo(windowIndex, positionMs);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    @Override // com.google.android.exoplayer2.ControlDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchPrevious(com.google.android.exoplayer2.Player r8) {
        /*
            r7 = this;
            com.google.android.exoplayer2.Timeline r0 = r8.getCurrentTimeline()
            boolean r1 = r0.isEmpty()
            r2 = 1
            if (r1 != 0) goto L44
            boolean r1 = r8.isPlayingAd()
            if (r1 == 0) goto L12
            goto L44
        L12:
            int r1 = r8.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r3 = r7.window
            r0.getWindow(r1, r3)
            int r0 = r8.getPreviousWindowIndex()
            r3 = -1
            if (r0 == r3) goto L3f
            long r3 = r8.getCurrentPosition()
            r5 = 3000(0xbb8, double:1.482E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L36
            com.google.android.exoplayer2.Timeline$Window r3 = r7.window
            boolean r4 = r3.isDynamic
            if (r4 == 0) goto L3f
            boolean r3 = r3.isSeekable
            if (r3 != 0) goto L3f
        L36:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.seekTo(r0, r3)
            goto L44
        L3f:
            r3 = 0
            r8.seekTo(r1, r3)
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultControlDispatcher.dispatchPrevious(com.google.android.exoplayer2.Player):boolean");
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, -9223372036854775807L);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.window).isLive) {
                player.seekTo(currentWindowIndex, -9223372036854775807L);
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, -this.rewindIncrementMs);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, this.fastForwardIncrementMs);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(Player player, int repeatMode) {
        player.setRepeatMode(repeatMode);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(Player player, boolean shuffleModeEnabled) {
        player.setShuffleModeEnabled(shuffleModeEnabled);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isRewindEnabled() {
        return this.rewindIncrementMs > 0;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isFastForwardEnabled() {
        return this.fastForwardIncrementMs > 0;
    }

    @Deprecated
    public void setRewindIncrementMs(long rewindMs) {
        this.rewindIncrementMs = rewindMs;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long fastForwardMs) {
        this.fastForwardIncrementMs = fastForwardMs;
    }

    private static void seekToOffset(Player player, long offsetMs) {
        long currentPosition = player.getCurrentPosition() + offsetMs;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0L));
    }
}
