package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent;

/* loaded from: classes3.dex */
final class AutoValue_UpdateProgressEvent extends UpdateProgressEvent {
    private final boolean audioDisabled;
    private final long currentUtcInSeconds;
    private final PlaybackStatus playbackStatus;
    private final float speed;

    private AutoValue_UpdateProgressEvent(long currentUtcInSeconds, PlaybackStatus playbackStatus, float speed, boolean audioDisabled) {
        this.currentUtcInSeconds = currentUtcInSeconds;
        this.playbackStatus = playbackStatus;
        this.speed = speed;
        this.audioDisabled = audioDisabled;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent
    public long currentUtcInSeconds() {
        return this.currentUtcInSeconds;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent
    public PlaybackStatus playbackStatus() {
        return this.playbackStatus;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent
    public float speed() {
        return this.speed;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent
    public boolean audioDisabled() {
        return this.audioDisabled;
    }

    public String toString() {
        return "UpdateProgressEvent{currentUtcInSeconds=" + this.currentUtcInSeconds + ", playbackStatus=" + this.playbackStatus + ", speed=" + this.speed + ", audioDisabled=" + this.audioDisabled + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateProgressEvent)) {
            return false;
        }
        UpdateProgressEvent updateProgressEvent = (UpdateProgressEvent) o;
        return this.currentUtcInSeconds == updateProgressEvent.currentUtcInSeconds() && this.playbackStatus.equals(updateProgressEvent.playbackStatus()) && Float.floatToIntBits(this.speed) == Float.floatToIntBits(updateProgressEvent.speed()) && this.audioDisabled == updateProgressEvent.audioDisabled();
    }

    public int hashCode() {
        long j = this.currentUtcInSeconds;
        return ((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.playbackStatus.hashCode()) * 1000003) ^ Float.floatToIntBits(this.speed)) * 1000003) ^ (this.audioDisabled ? 1231 : 1237);
    }

    static final class Builder extends UpdateProgressEvent.Builder {
        private Boolean audioDisabled;
        private Long currentUtcInSeconds;
        private PlaybackStatus playbackStatus;
        private Float speed;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent.Builder
        public UpdateProgressEvent.Builder setCurrentUtcInSeconds(long currentUtcInSeconds) {
            this.currentUtcInSeconds = Long.valueOf(currentUtcInSeconds);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent.Builder
        public UpdateProgressEvent.Builder setPlaybackStatus(PlaybackStatus playbackStatus) {
            if (playbackStatus == null) {
                throw new NullPointerException("Null playbackStatus");
            }
            this.playbackStatus = playbackStatus;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent.Builder
        public UpdateProgressEvent.Builder setSpeed(float speed) {
            this.speed = Float.valueOf(speed);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent.Builder
        public UpdateProgressEvent.Builder setAudioDisabled(boolean audioDisabled) {
            this.audioDisabled = Boolean.valueOf(audioDisabled);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent.Builder
        public UpdateProgressEvent build() {
            Long l = this.currentUtcInSeconds;
            if (l == null || this.playbackStatus == null || this.speed == null || this.audioDisabled == null) {
                StringBuilder sb = new StringBuilder();
                if (this.currentUtcInSeconds == null) {
                    sb.append(" currentUtcInSeconds");
                }
                if (this.playbackStatus == null) {
                    sb.append(" playbackStatus");
                }
                if (this.speed == null) {
                    sb.append(" speed");
                }
                if (this.audioDisabled == null) {
                    sb.append(" audioDisabled");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_UpdateProgressEvent(l.longValue(), this.playbackStatus, this.speed.floatValue(), this.audioDisabled.booleanValue());
        }
    }
}
