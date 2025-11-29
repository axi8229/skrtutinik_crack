package flussonic.watcher.sdk.domain.pojo;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Ranges {
    public abstract List<Range> events();

    public abstract List<Range> loadingRanges();

    public abstract List<Range> ranges();

    public static Ranges create(List<Range> ranges, List<Range> events, List<Range> loadingRanges) {
        return new AutoValue_Ranges(Collections.unmodifiableList(ranges), Collections.unmodifiableList(events), Collections.unmodifiableList(loadingRanges));
    }
}
