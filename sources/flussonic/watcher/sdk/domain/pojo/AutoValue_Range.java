package flussonic.watcher.sdk.domain.pojo;

/* loaded from: classes3.dex */
final class AutoValue_Range extends Range {
    private final long from;
    private final long to;

    AutoValue_Range(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Range
    public long from() {
        return this.from;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Range
    public long to() {
        return this.to;
    }

    public String toString() {
        return "Range{from=" + this.from + ", to=" + this.to + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Range)) {
            return false;
        }
        Range range = (Range) o;
        return this.from == range.from() && this.to == range.to();
    }

    public int hashCode() {
        long j = this.from;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.to;
        return i ^ ((int) ((j2 >>> 32) ^ j2));
    }
}
