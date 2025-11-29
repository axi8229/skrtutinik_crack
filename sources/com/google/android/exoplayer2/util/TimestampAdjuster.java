package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class TimestampAdjuster {
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long firstSampleTimestampUs) {
        setFirstSampleTimestampUs(firstSampleTimestampUs);
    }

    public synchronized void setFirstSampleTimestampUs(long firstSampleTimestampUs) {
        Assertions.checkState(this.lastSampleTimestampUs == -9223372036854775807L);
        this.firstSampleTimestampUs = firstSampleTimestampUs;
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            return this.timestampOffsetUs + this.lastSampleTimestampUs;
        }
        long j = this.firstSampleTimestampUs;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    public long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.lastSampleTimestampUs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.timestampOffsetUs;
    }

    public void reset() {
        this.lastSampleTimestampUs = -9223372036854775807L;
    }

    public long adjustTsTimestamp(long pts90Khz) {
        if (pts90Khz == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            long jUsToPts = usToPts(this.lastSampleTimestampUs);
            long j = (4294967296L + jUsToPts) / 8589934592L;
            long j2 = ((j - 1) * 8589934592L) + pts90Khz;
            pts90Khz += j * 8589934592L;
            if (Math.abs(j2 - jUsToPts) < Math.abs(pts90Khz - jUsToPts)) {
                pts90Khz = j2;
            }
        }
        return adjustSampleTimestamp(ptsToUs(pts90Khz));
    }

    public long adjustSampleTimestamp(long timeUs) {
        if (timeUs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            this.lastSampleTimestampUs = timeUs;
        } else {
            long j = this.firstSampleTimestampUs;
            if (j != Long.MAX_VALUE) {
                this.timestampOffsetUs = j - timeUs;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = timeUs;
                notifyAll();
            }
        }
        return timeUs + this.timestampOffsetUs;
    }

    public static long ptsToUs(long pts) {
        return (pts * 1000000) / 90000;
    }

    public static long usToPts(long us) {
        return (us * 90000) / 1000000;
    }
}
