package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;

/* loaded from: classes3.dex */
final class AutoValue_VisibleRangeChangedEvent extends VisibleRangeChangedEvent {
    private final VisibleRangeChangedEvent.EventType eventType;
    private final Range range;
    private final long secondsInScreen;

    private AutoValue_VisibleRangeChangedEvent(Range range, VisibleRangeChangedEvent.EventType eventType, long secondsInScreen) {
        this.range = range;
        this.eventType = eventType;
        this.secondsInScreen = secondsInScreen;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent
    public Range range() {
        return this.range;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent
    public VisibleRangeChangedEvent.EventType eventType() {
        return this.eventType;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent
    public long secondsInScreen() {
        return this.secondsInScreen;
    }

    public String toString() {
        return "VisibleRangeChangedEvent{range=" + this.range + ", eventType=" + this.eventType + ", secondsInScreen=" + this.secondsInScreen + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VisibleRangeChangedEvent)) {
            return false;
        }
        VisibleRangeChangedEvent visibleRangeChangedEvent = (VisibleRangeChangedEvent) o;
        return this.range.equals(visibleRangeChangedEvent.range()) && this.eventType.equals(visibleRangeChangedEvent.eventType()) && this.secondsInScreen == visibleRangeChangedEvent.secondsInScreen();
    }

    public int hashCode() {
        int iHashCode = (((this.range.hashCode() ^ 1000003) * 1000003) ^ this.eventType.hashCode()) * 1000003;
        long j = this.secondsInScreen;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    static final class Builder extends VisibleRangeChangedEvent.Builder {
        private VisibleRangeChangedEvent.EventType eventType;
        private Range range;
        private Long secondsInScreen;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent.Builder
        public VisibleRangeChangedEvent.Builder setRange(Range range) {
            if (range == null) {
                throw new NullPointerException("Null range");
            }
            this.range = range;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent.Builder
        public VisibleRangeChangedEvent.Builder setEventType(VisibleRangeChangedEvent.EventType eventType) {
            if (eventType == null) {
                throw new NullPointerException("Null eventType");
            }
            this.eventType = eventType;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent.Builder
        public VisibleRangeChangedEvent.Builder setSecondsInScreen(long secondsInScreen) {
            this.secondsInScreen = Long.valueOf(secondsInScreen);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent.Builder
        public VisibleRangeChangedEvent build() {
            VisibleRangeChangedEvent.EventType eventType;
            Long l;
            Range range = this.range;
            if (range == null || (eventType = this.eventType) == null || (l = this.secondsInScreen) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.range == null) {
                    sb.append(" range");
                }
                if (this.eventType == null) {
                    sb.append(" eventType");
                }
                if (this.secondsInScreen == null) {
                    sb.append(" secondsInScreen");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_VisibleRangeChangedEvent(range, eventType, l.longValue());
        }
    }
}
