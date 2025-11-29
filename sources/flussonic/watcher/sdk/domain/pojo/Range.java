package flussonic.watcher.sdk.domain.pojo;

/* loaded from: classes3.dex */
public abstract class Range {
    private static final Range EMPTY = createFromTo(0, 0);

    public abstract long from();

    public abstract long to();

    public static Range empty() {
        return EMPTY;
    }

    public static Range createFromTo(long from, long to) {
        Range range;
        return (from == 0 && to == 0 && (range = EMPTY) != null) ? range : new AutoValue_Range(from, to);
    }

    public static Range createFromDuration(long from, long duration) {
        Range range;
        return (from == 0 && duration == 0 && (range = EMPTY) != null) ? range : new AutoValue_Range(from, duration + from);
    }

    public long duration() {
        return to() - from();
    }

    public boolean isValid() {
        return 0 < from() && from() < to();
    }
}
