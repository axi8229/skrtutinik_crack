package flussonic.watcher.sdk.domain.pojo;

import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_RangesResponse extends RangesResponse {
    private final List<Range> events;
    private final boolean isFailed;
    private final List<Range> ranges;
    private final Range requestedRange;
    private final boolean tooBigRange;

    AutoValue_RangesResponse(boolean isFailed, boolean tooBigRange, Range requestedRange, List<Range> ranges, List<Range> events) {
        this.isFailed = isFailed;
        this.tooBigRange = tooBigRange;
        if (requestedRange == null) {
            throw new NullPointerException("Null requestedRange");
        }
        this.requestedRange = requestedRange;
        if (ranges == null) {
            throw new NullPointerException("Null ranges");
        }
        this.ranges = ranges;
        if (events == null) {
            throw new NullPointerException("Null events");
        }
        this.events = events;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.RangesResponse
    public boolean isFailed() {
        return this.isFailed;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.RangesResponse
    public boolean tooBigRange() {
        return this.tooBigRange;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.RangesResponse
    public Range requestedRange() {
        return this.requestedRange;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.RangesResponse
    public List<Range> ranges() {
        return this.ranges;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.RangesResponse
    public List<Range> events() {
        return this.events;
    }

    public String toString() {
        return "RangesResponse{isFailed=" + this.isFailed + ", tooBigRange=" + this.tooBigRange + ", requestedRange=" + this.requestedRange + ", ranges=" + this.ranges + ", events=" + this.events + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RangesResponse)) {
            return false;
        }
        RangesResponse rangesResponse = (RangesResponse) o;
        return this.isFailed == rangesResponse.isFailed() && this.tooBigRange == rangesResponse.tooBigRange() && this.requestedRange.equals(rangesResponse.requestedRange()) && this.ranges.equals(rangesResponse.ranges()) && this.events.equals(rangesResponse.events());
    }

    public int hashCode() {
        return (((((((((this.isFailed ? 1231 : 1237) ^ 1000003) * 1000003) ^ (this.tooBigRange ? 1231 : 1237)) * 1000003) ^ this.requestedRange.hashCode()) * 1000003) ^ this.ranges.hashCode()) * 1000003) ^ this.events.hashCode();
    }
}
