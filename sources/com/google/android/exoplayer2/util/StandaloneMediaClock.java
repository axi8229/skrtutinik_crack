package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;

/* loaded from: classes2.dex */
public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private float playbackSpeed = 1.0f;
    private int scaledUsPerMs = getScaledUsPerMs(1.0f);
    private boolean started;

    public StandaloneMediaClock(Clock clock) {
        this.clock = clock;
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.baseElapsedMs = this.clock.elapsedRealtime();
        this.started = true;
    }

    public void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }

    public void resetPosition(long positionUs) {
        this.baseUs = positionUs;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long jMsToUs;
        long j = this.baseUs;
        if (!this.started) {
            return j;
        }
        long jElapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        if (this.playbackSpeed == 1.0f) {
            jMsToUs = C.msToUs(jElapsedRealtime);
        } else {
            jMsToUs = jElapsedRealtime * this.scaledUsPerMs;
        }
        return j + jMsToUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackSpeed(float playbackSpeed) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackSpeed = playbackSpeed;
        this.scaledUsPerMs = getScaledUsPerMs(playbackSpeed);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    private static int getScaledUsPerMs(float playbackSpeed) {
        return Math.round(playbackSpeed * 1000.0f);
    }
}
