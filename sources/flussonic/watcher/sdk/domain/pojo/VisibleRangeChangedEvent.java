package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.AutoValue_VisibleRangeChangedEvent;

/* loaded from: classes3.dex */
public abstract class VisibleRangeChangedEvent {

    public static abstract class Builder {
        public abstract VisibleRangeChangedEvent build();

        public abstract Builder setEventType(EventType eventType);

        public abstract Builder setRange(Range range);

        public abstract Builder setSecondsInScreen(long secondsInScreen);
    }

    public enum EventType {
        SCROLL,
        SCROLL_LEFT,
        SCROLL_RIGHT,
        ZOOM,
        CONFIGURATION_CHANGED
    }

    public abstract EventType eventType();

    public abstract Range range();

    public abstract long secondsInScreen();

    public static Builder builder() {
        return new AutoValue_VisibleRangeChangedEvent.Builder();
    }
}
