package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.AutoValue_UpdateProgressEvent;

/* loaded from: classes3.dex */
public abstract class UpdateProgressEvent {

    public static abstract class Builder {
        public abstract UpdateProgressEvent build();

        public abstract Builder setAudioDisabled(boolean audioDisabled);

        public abstract Builder setCurrentUtcInSeconds(long currentUtcInSeconds);

        public abstract Builder setPlaybackStatus(PlaybackStatus playbackStatus);

        public abstract Builder setSpeed(float speed);
    }

    public abstract boolean audioDisabled();

    public abstract long currentUtcInSeconds();

    public abstract PlaybackStatus playbackStatus();

    public abstract float speed();

    public static Builder builder() {
        return new AutoValue_UpdateProgressEvent.Builder();
    }
}
