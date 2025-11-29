package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri initialization, long timescale, long presentationTimeOffset) {
        this.initialization = initialization;
        this.timescale = timescale;
        this.presentationTimeOffset = presentationTimeOffset;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000L, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(RangedUri initialization, long timescale, long presentationTimeOffset, long indexStart, long indexLength) {
            super(initialization, timescale, presentationTimeOffset);
            this.indexStart = indexStart;
            this.indexLength = indexLength;
        }

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public RangedUri getIndex() {
            long j = this.indexLength;
            if (j <= 0) {
                return null;
            }
            return new RangedUri(null, this.indexStart, j);
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final long duration;
        final List<SegmentTimelineElement> segmentTimeline;
        final long startNumber;

        public abstract int getSegmentCount(long periodDurationUs);

        public abstract RangedUri getSegmentUrl(Representation representation, long index);

        public MultiSegmentBase(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long duration, List<SegmentTimelineElement> segmentTimeline) {
            super(initialization, timescale, presentationTimeOffset);
            this.startNumber = startNumber;
            this.duration = duration;
            this.segmentTimeline = segmentTimeline;
        }

        public long getSegmentNum(long timeUs, long periodDurationUs) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(periodDurationUs);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j = this.startNumber + (timeUs / ((this.duration * 1000000) / this.timescale));
                return j < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? j : Math.min(j, (firstSegmentNum + segmentCount) - 1);
            }
            long j2 = (segmentCount + firstSegmentNum) - 1;
            long j3 = firstSegmentNum;
            while (j3 <= j2) {
                long j4 = ((j2 - j3) / 2) + j3;
                long segmentTimeUs = getSegmentTimeUs(j4);
                if (segmentTimeUs < timeUs) {
                    j3 = j4 + 1;
                } else {
                    if (segmentTimeUs <= timeUs) {
                        return j4;
                    }
                    j2 = j4 - 1;
                }
            }
            return j3 == firstSegmentNum ? j3 : j2;
        }

        public final long getSegmentDurationUs(long sequenceNumber, long periodDurationUs) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (sequenceNumber - this.startNumber)).duration * 1000000) / this.timescale;
            }
            int segmentCount = getSegmentCount(periodDurationUs);
            return (segmentCount == -1 || sequenceNumber != (getFirstSegmentNum() + ((long) segmentCount)) - 1) ? (this.duration * 1000000) / this.timescale : periodDurationUs - getSegmentTimeUs(sequenceNumber);
        }

        public final long getSegmentTimeUs(long sequenceNumber) {
            long j;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j = list.get((int) (sequenceNumber - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j = (sequenceNumber - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j, 1000000L, this.timescale);
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {
        final List<RangedUri> mediaSegments;

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }

        public SegmentList(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long duration, List<SegmentTimelineElement> segmentTimeline, List<RangedUri> mediaSegments) {
            super(initialization, timescale, presentationTimeOffset, startNumber, duration, segmentTimeline);
            this.mediaSegments = mediaSegments;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long sequenceNumber) {
            return this.mediaSegments.get((int) (sequenceNumber - this.startNumber));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long periodDurationUs) {
            return this.mediaSegments.size();
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {
        final long endNumber;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public SegmentTemplate(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long endNumber, long duration, List<SegmentTimelineElement> segmentTimeline, UrlTemplate initializationTemplate, UrlTemplate mediaTemplate) {
            super(initialization, timescale, presentationTimeOffset, startNumber, duration, segmentTimeline);
            this.initializationTemplate = initializationTemplate;
            this.mediaTemplate = mediaTemplate;
            this.endNumber = endNumber;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                Format format = representation.format;
                return new RangedUri(urlTemplate.buildUri(format.id, 0L, format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long sequenceNumber) {
            long j;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j = list.get((int) (sequenceNumber - this.startNumber)).startTime;
            } else {
                j = (sequenceNumber - this.startNumber) * this.duration;
            }
            long j2 = j;
            UrlTemplate urlTemplate = this.mediaTemplate;
            Format format = representation.format;
            return new RangedUri(urlTemplate.buildUri(format.id, sequenceNumber, format.bitrate, j2), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long periodDurationUs) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return list.size();
            }
            long j = this.endNumber;
            if (j != -1) {
                return (int) ((j - this.startNumber) + 1);
            }
            if (periodDurationUs != -9223372036854775807L) {
                return (int) Util.ceilDivide(periodDurationUs, (this.duration * 1000000) / this.timescale);
            }
            return -1;
        }
    }

    public static final class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long startTime, long duration) {
            this.startTime = startTime;
            this.duration = duration;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || SegmentTimelineElement.class != o.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) o;
            return this.startTime == segmentTimelineElement.startTime && this.duration == segmentTimelineElement.duration;
        }

        public int hashCode() {
            return (((int) this.startTime) * 31) + ((int) this.duration);
        }
    }
}
