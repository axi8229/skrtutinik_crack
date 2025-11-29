package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID = new Object();
    private final long elapsedRealtimeEpochOffsetMs;
    private final boolean isDynamic;
    private final boolean isLive;
    private final boolean isSeekable;
    private final Object manifest;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long durationUs, boolean isSeekable, boolean isDynamic, boolean isLive, Object manifest, Object tag) {
        this(durationUs, durationUs, 0L, 0L, isSeekable, isDynamic, isLive, manifest, tag);
    }

    public SinglePeriodTimeline(long periodDurationUs, long windowDurationUs, long windowPositionInPeriodUs, long windowDefaultStartPositionUs, boolean isSeekable, boolean isDynamic, boolean isLive, Object manifest, Object tag) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, periodDurationUs, windowDurationUs, windowPositionInPeriodUs, windowDefaultStartPositionUs, isSeekable, isDynamic, isLive, manifest, tag);
    }

    public SinglePeriodTimeline(long presentationStartTimeMs, long windowStartTimeMs, long elapsedRealtimeEpochOffsetMs, long periodDurationUs, long windowDurationUs, long windowPositionInPeriodUs, long windowDefaultStartPositionUs, boolean isSeekable, boolean isDynamic, boolean isLive, Object manifest, Object tag) {
        this.presentationStartTimeMs = presentationStartTimeMs;
        this.windowStartTimeMs = windowStartTimeMs;
        this.elapsedRealtimeEpochOffsetMs = elapsedRealtimeEpochOffsetMs;
        this.periodDurationUs = periodDurationUs;
        this.windowDurationUs = windowDurationUs;
        this.windowPositionInPeriodUs = windowPositionInPeriodUs;
        this.windowDefaultStartPositionUs = windowDefaultStartPositionUs;
        this.isSeekable = isSeekable;
        this.isDynamic = isDynamic;
        this.isLive = isLive;
        this.manifest = manifest;
        this.tag = tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[PHI: r1
  0x002a: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0013, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.Timeline.Window getWindow(int r25, com.google.android.exoplayer2.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.Assertions.checkIndex(r3, r1, r2)
            long r1 = r0.windowDefaultStartPositionUs
            boolean r14 = r0.isDynamic
            if (r14 == 0) goto L2a
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2a
            long r3 = r0.windowDurationUs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L23
        L20:
            r16 = r5
            goto L2c
        L23:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2a
            goto L20
        L2a:
            r16 = r1
        L2c:
            java.lang.Object r4 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            java.lang.Object r5 = r0.tag
            java.lang.Object r6 = r0.manifest
            long r7 = r0.presentationStartTimeMs
            long r9 = r0.windowStartTimeMs
            long r11 = r0.elapsedRealtimeEpochOffsetMs
            boolean r13 = r0.isSeekable
            boolean r15 = r0.isLive
            long r1 = r0.windowDurationUs
            r18 = r1
            r21 = 0
            long r1 = r0.windowPositionInPeriodUs
            r22 = r1
            r20 = 0
            r3 = r26
            com.google.android.exoplayer2.Timeline$Window r1 = r3.set(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.getWindow(int, com.google.android.exoplayer2.Timeline$Window, long):com.google.android.exoplayer2.Timeline$Window");
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int periodIndex, Timeline.Period period, boolean setIds) {
        Assertions.checkIndex(periodIndex, 0, 1);
        return period.set(null, setIds ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object uid) {
        return UID.equals(uid) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int periodIndex) {
        Assertions.checkIndex(periodIndex, 0, 1);
        return UID;
    }
}
