package flussonic.watcher.sdk.domain.pojo;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RangesResponse {
    public abstract List<Range> events();

    public abstract boolean isFailed();

    public abstract List<Range> ranges();

    public abstract Range requestedRange();

    public abstract boolean tooBigRange();

    public static RangesResponse createSucceeded(boolean tooBigRange, List<Range> ranges, List<Range> events) {
        return new AutoValue_RangesResponse(false, tooBigRange, Range.empty(), Collections.unmodifiableList(ranges), Collections.unmodifiableList(events));
    }

    public static RangesResponse createFailed() {
        return new AutoValue_RangesResponse(true, false, Range.empty(), Collections.emptyList(), Collections.emptyList());
    }

    public RangesResponse withRequestedRange(Range requestedRange) {
        return new AutoValue_RangesResponse(isFailed(), tooBigRange(), requestedRange, ranges(), events());
    }
}
