package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

/* loaded from: classes2.dex */
final class DefaultMediaClock implements MediaClock {
    private boolean isUsingStandaloneClock = true;
    private final PlaybackSpeedListener listener;
    private MediaClock rendererClock;
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneClock;
    private boolean standaloneClockIsStarted;

    public interface PlaybackSpeedListener {
        void onPlaybackSpeedChanged(float newPlaybackSpeed);
    }

    public DefaultMediaClock(PlaybackSpeedListener listener, Clock clock) {
        this.listener = listener;
        this.standaloneClock = new StandaloneMediaClock(clock);
    }

    public void start() {
        this.standaloneClockIsStarted = true;
        this.standaloneClock.start();
    }

    public void stop() {
        this.standaloneClockIsStarted = false;
        this.standaloneClock.stop();
    }

    public void resetPosition(long positionUs) {
        this.standaloneClock.resetPosition(positionUs);
    }

    public void onRendererEnabled(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 == null || mediaClock2 == (mediaClock = this.rendererClock)) {
            return;
        }
        if (mediaClock != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.rendererClock = mediaClock2;
        this.rendererClockSource = renderer;
        mediaClock2.setPlaybackSpeed(this.standaloneClock.getPlaybackSpeed());
    }

    public void onRendererDisabled(Renderer renderer) {
        if (renderer == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
            this.isUsingStandaloneClock = true;
        }
    }

    public long syncAndGetPositionUs(boolean isReadingAhead) {
        syncClocks(isReadingAhead);
        return getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.isUsingStandaloneClock ? this.standaloneClock.getPositionUs() : this.rendererClock.getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackSpeed(float playbackSpeed) {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            mediaClock.setPlaybackSpeed(playbackSpeed);
            playbackSpeed = this.rendererClock.getPlaybackSpeed();
        }
        this.standaloneClock.setPlaybackSpeed(playbackSpeed);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public float getPlaybackSpeed() {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            return mediaClock.getPlaybackSpeed();
        }
        return this.standaloneClock.getPlaybackSpeed();
    }

    private void syncClocks(boolean isReadingAhead) {
        if (shouldUseStandaloneClock(isReadingAhead)) {
            this.isUsingStandaloneClock = true;
            if (this.standaloneClockIsStarted) {
                this.standaloneClock.start();
                return;
            }
            return;
        }
        long positionUs = this.rendererClock.getPositionUs();
        if (this.isUsingStandaloneClock) {
            if (positionUs < this.standaloneClock.getPositionUs()) {
                this.standaloneClock.stop();
                return;
            } else {
                this.isUsingStandaloneClock = false;
                if (this.standaloneClockIsStarted) {
                    this.standaloneClock.start();
                }
            }
        }
        this.standaloneClock.resetPosition(positionUs);
        float playbackSpeed = this.rendererClock.getPlaybackSpeed();
        if (playbackSpeed != this.standaloneClock.getPlaybackSpeed()) {
            this.standaloneClock.setPlaybackSpeed(playbackSpeed);
            this.listener.onPlaybackSpeedChanged(playbackSpeed);
        }
    }

    private boolean shouldUseStandaloneClock(boolean isReadingAhead) {
        Renderer renderer = this.rendererClockSource;
        return renderer == null || renderer.isEnded() || (!this.rendererClockSource.isReady() && (isReadingAhead || this.rendererClockSource.hasReadStreamToEnd()));
    }
}
