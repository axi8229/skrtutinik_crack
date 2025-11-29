package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class DashManifest implements FilterableManifest<DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List<Period> periods;
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final UtcTimingElement utcTiming;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ DashManifest copy(List streamKeys) {
        return copy((List<StreamKey>) streamKeys);
    }

    public DashManifest(long availabilityStartTimeMs, long durationMs, long minBufferTimeMs, boolean dynamic, long minUpdatePeriodMs, long timeShiftBufferDepthMs, long suggestedPresentationDelayMs, long publishTimeMs, ProgramInformation programInformation, UtcTimingElement utcTiming, Uri location, List<Period> periods) {
        this.availabilityStartTimeMs = availabilityStartTimeMs;
        this.durationMs = durationMs;
        this.minBufferTimeMs = minBufferTimeMs;
        this.dynamic = dynamic;
        this.minUpdatePeriodMs = minUpdatePeriodMs;
        this.timeShiftBufferDepthMs = timeShiftBufferDepthMs;
        this.suggestedPresentationDelayMs = suggestedPresentationDelayMs;
        this.publishTimeMs = publishTimeMs;
        this.programInformation = programInformation;
        this.utcTiming = utcTiming;
        this.location = location;
        this.periods = periods == null ? Collections.emptyList() : periods;
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final Period getPeriod(int index) {
        return this.periods.get(index);
    }

    public final long getPeriodDurationBySegmentsUs(int index) {
        return C.msToUs(getPeriodDurationBySegmentsMs(index));
    }

    public final long getPeriodDurationUs(int index) {
        return C.msToUs(getPeriodDurationMs(index));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final DashManifest copy(List<StreamKey> streamKeys) {
        LinkedList linkedList = new LinkedList(streamKeys);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= getPeriodCount()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long periodDurationBySegmentsMs = getPeriodDurationBySegmentsMs(i);
                if (periodDurationBySegmentsMs != -9223372036854775807L) {
                    j += periodDurationBySegmentsMs;
                }
            } else {
                Period period = getPeriod(i);
                arrayList.add(new Period(period.id, period.startMs - j, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            i++;
        }
        long j2 = this.durationMs;
        return new DashManifest(this.availabilityStartTimeMs, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.location, arrayList);
    }

    private long getPeriodDurationBySegmentsMs(int index) {
        if (this.durationMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long durationUs = 0;
        for (AdaptationSet adaptationSet : this.periods.get(index).adaptationSets) {
            if (adaptationSet.representations.size() > 0) {
                Representation.MultiSegmentRepresentation multiSegmentRepresentation = (Representation.MultiSegmentRepresentation) adaptationSet.representations.get(0);
                int segmentCount = multiSegmentRepresentation.getSegmentCount(-9223372036854775807L);
                if (segmentCount > 0) {
                    for (int i = 0; i < segmentCount; i++) {
                        durationUs += multiSegmentRepresentation.getDurationUs(i, -9223372036854775807L) / 1000;
                    }
                }
            }
        }
        return durationUs;
    }

    private long getPeriodDurationMs(int index) {
        long j;
        long j2;
        if (index == this.periods.size() - 1) {
            j = this.durationMs;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.periods.get(index).startMs;
        } else {
            j = this.periods.get(index + 1).startMs;
            j2 = this.periods.get(index).startMs;
        }
        return j - j2;
    }

    private static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> adaptationSets, LinkedList<StreamKey> keys) {
        StreamKey streamKeyPoll = keys.poll();
        int i = streamKeyPoll.periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i2 = streamKeyPoll.groupIndex;
            AdaptationSet adaptationSet = adaptationSets.get(i2);
            List<Representation> list = adaptationSet.representations;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list.get(streamKeyPoll.trackIndex));
                streamKeyPoll = keys.poll();
                if (streamKeyPoll.periodIndex != i) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i2);
            arrayList.add(new AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
        } while (streamKeyPoll.periodIndex == i);
        keys.addFirst(streamKeyPoll);
        return arrayList;
    }
}
