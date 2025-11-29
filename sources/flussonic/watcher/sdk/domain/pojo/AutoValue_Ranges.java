package flussonic.watcher.sdk.domain.pojo;

import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_Ranges extends Ranges {
    private final List<Range> events;
    private final List<Range> loadingRanges;
    private final List<Range> ranges;

    AutoValue_Ranges(List<Range> ranges, List<Range> events, List<Range> loadingRanges) {
        if (ranges == null) {
            throw new NullPointerException("Null ranges");
        }
        this.ranges = ranges;
        if (events == null) {
            throw new NullPointerException("Null events");
        }
        this.events = events;
        if (loadingRanges == null) {
            throw new NullPointerException("Null loadingRanges");
        }
        this.loadingRanges = loadingRanges;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Ranges
    public List<Range> ranges() {
        return this.ranges;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Ranges
    public List<Range> events() {
        return this.events;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Ranges
    public List<Range> loadingRanges() {
        return this.loadingRanges;
    }

    public String toString() {
        return "Ranges{ranges=" + this.ranges + ", events=" + this.events + ", loadingRanges=" + this.loadingRanges + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Ranges)) {
            return false;
        }
        Ranges ranges = (Ranges) o;
        return this.ranges.equals(ranges.ranges()) && this.events.equals(ranges.events()) && this.loadingRanges.equals(ranges.loadingRanges());
    }

    public int hashCode() {
        return ((((this.ranges.hashCode() ^ 1000003) * 1000003) ^ this.events.hashCode()) * 1000003) ^ this.loadingRanges.hashCode();
    }
}
