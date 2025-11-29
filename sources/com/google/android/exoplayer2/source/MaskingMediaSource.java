package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private MediaSourceEventListener.EventDispatcher unpreparedMaskingMediaPeriodEventDispatcher;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean useLazyPreparation) {
        this.mediaSource = mediaSource;
        this.useLazyPreparation = useLazyPreparation && mediaSource.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline != null) {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
        } else {
            this.timeline = MaskingTimeline.createWithDummyTimeline(mediaSource.getTag());
        }
    }

    public synchronized Timeline getTimeline() {
        return this.timeline;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener mediaTransferListener) {
        super.prepareSourceInternal(mediaTransferListener);
        if (this.useLazyPreparation) {
            return;
        }
        this.hasStartedPreparing = true;
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.mediaSource, id, allocator, startPositionUs);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(id.copyWithPeriodUid(getInternalPeriodUid(id.periodUid)));
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            MediaSourceEventListener.EventDispatcher eventDispatcherCreateEventDispatcher = createEventDispatcher(0, id, 0L);
            this.unpreparedMaskingMediaPeriodEventDispatcher = eventDispatcherCreateEventDispatcher;
            eventDispatcherCreateEventDispatcher.mediaPeriodCreated();
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource(null, this.mediaSource);
            }
        }
        return maskingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            ((MediaSourceEventListener.EventDispatcher) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriodEventDispatcher)).mediaPeriodReleased();
            this.unpreparedMaskingMediaPeriodEventDispatcher = null;
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0011, B:31:0x0092, B:33:0x009e, B:10:0x001d, B:12:0x0023, B:14:0x0027, B:16:0x0036, B:15:0x002e, B:17:0x0039, B:19:0x0049, B:23:0x0056, B:25:0x0070, B:27:0x007b, B:29:0x0081, B:26:0x0077), top: B:38:0x0001 }] */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void lambda$prepareChildSource$0(java.lang.Void r7, com.google.android.exoplayer2.source.MediaSource r8, com.google.android.exoplayer2.Timeline r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r7 = r6.isPrepared     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto L1d
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r6.timeline     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r7.cloneWithUpdatedTimeline(r9)     // Catch: java.lang.Throwable -> L1a
            r6.timeline = r7     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaPeriod r7 = r6.unpreparedMaskingMediaPeriod     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto L91
            long r7 = r7.getPreparePositionOverrideUs()     // Catch: java.lang.Throwable -> L1a
            r6.setPreparePositionOverrideToUnpreparedMaskingPeriod(r7)     // Catch: java.lang.Throwable -> L1a
            goto L91
        L1a:
            r7 = move-exception
            goto Lab
        L1d:
            boolean r7 = r9.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto L39
            boolean r7 = r6.hasRealTimeline     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto L2e
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r6.timeline     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r7.cloneWithUpdatedTimeline(r9)     // Catch: java.lang.Throwable -> L1a
            goto L36
        L2e:
            java.lang.Object r7 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r9, r7, r8)     // Catch: java.lang.Throwable -> L1a
        L36:
            r6.timeline = r7     // Catch: java.lang.Throwable -> L1a
            goto L91
        L39:
            com.google.android.exoplayer2.Timeline$Window r7 = r6.window     // Catch: java.lang.Throwable -> L1a
            r8 = 0
            r9.getWindow(r8, r7)     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.Timeline$Window r7 = r6.window     // Catch: java.lang.Throwable -> L1a
            long r7 = r7.getDefaultPositionUs()     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r6.unpreparedMaskingMediaPeriod     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L55
            long r0 = r0.getPreparePositionUs()     // Catch: java.lang.Throwable -> L1a
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L55
            r4 = r0
            goto L56
        L55:
            r4 = r7
        L56:
            com.google.android.exoplayer2.Timeline$Window r1 = r6.window     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r7 = r1.uid     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.Timeline$Period r2 = r6.period     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            r0 = r9
            android.util.Pair r8 = r0.getPeriodPosition(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r0 = r8.first     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = r8.second     // Catch: java.lang.Throwable -> L1a
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L1a
            long r1 = r8.longValue()     // Catch: java.lang.Throwable -> L1a
            boolean r8 = r6.hasRealTimeline     // Catch: java.lang.Throwable -> L1a
            if (r8 == 0) goto L77
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r6.timeline     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = r7.cloneWithUpdatedTimeline(r9)     // Catch: java.lang.Throwable -> L1a
            goto L7b
        L77:
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r7 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r9, r7, r0)     // Catch: java.lang.Throwable -> L1a
        L7b:
            r6.timeline = r7     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaPeriod r7 = r6.unpreparedMaskingMediaPeriod     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto L91
            r6.setPreparePositionOverrideToUnpreparedMaskingPeriod(r1)     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r7.id     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = r7.periodUid     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = r6.getInternalPeriodUid(r8)     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r7.copyWithPeriodUid(r8)     // Catch: java.lang.Throwable -> L1a
            goto L92
        L91:
            r7 = 0
        L92:
            r8 = 1
            r6.hasRealTimeline = r8     // Catch: java.lang.Throwable -> L1a
            r6.isPrepared = r8     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r8 = r6.timeline     // Catch: java.lang.Throwable -> L1a
            r6.refreshSourceInfo(r8)     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto La9
            com.google.android.exoplayer2.source.MaskingMediaPeriod r8 = r6.unpreparedMaskingMediaPeriod     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r8)     // Catch: java.lang.Throwable -> L1a
            com.google.android.exoplayer2.source.MaskingMediaPeriod r8 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r8     // Catch: java.lang.Throwable -> L1a
            r8.createPeriod(r7)     // Catch: java.lang.Throwable -> L1a
        La9:
            monitor-exit(r6)
            return
        Lab:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L1a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.lambda$prepareChildSource$0(java.lang.Void, com.google.android.exoplayer2.source.MediaSource, com.google.android.exoplayer2.Timeline):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void id, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    protected boolean shouldDispatchCreateOrReleaseEvent(MediaSource.MediaPeriodId mediaPeriodId) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        return maskingMediaPeriod == null || !mediaPeriodId.equals(maskingMediaPeriod.id);
    }

    private Object getInternalPeriodUid(Object externalPeriodUid) {
        return (this.timeline.replacedInternalPeriodUid == null || !externalPeriodUid.equals(MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID)) ? externalPeriodUid : this.timeline.replacedInternalPeriodUid;
    }

    private Object getExternalPeriodUid(Object internalPeriodUid) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(internalPeriodUid)) ? internalPeriodUid : MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
    }

    private void setPreparePositionOverrideToUnpreparedMaskingPeriod(long preparePositionOverrideUs) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod == -1) {
            return;
        }
        long j = this.timeline.getPeriod(indexOfPeriod, this.period).durationBySegmentsUs;
        if (j != -9223372036854775807L && preparePositionOverrideUs >= j) {
            preparePositionOverrideUs = Math.max(0L, j - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(preparePositionOverrideUs);
    }

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object DUMMY_EXTERNAL_PERIOD_UID = new Object();
        private final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        public static MaskingTimeline createWithDummyTimeline(Object windowTag) {
            return new MaskingTimeline(new DummyTimeline(windowTag), Timeline.Window.SINGLE_WINDOW_UID, DUMMY_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object firstWindowUid, Object firstPeriodUid) {
            return new MaskingTimeline(timeline, firstWindowUid, firstPeriodUid);
        }

        private MaskingTimeline(Timeline timeline, Object replacedInternalWindowUid, Object replacedInternalPeriodUid) {
            super(timeline);
            this.replacedInternalWindowUid = replacedInternalWindowUid;
            this.replacedInternalPeriodUid = replacedInternalPeriodUid;
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int windowIndex, Timeline.Window window, long defaultPositionProjectionUs) {
            this.timeline.getWindow(windowIndex, window, defaultPositionProjectionUs);
            if (Util.areEqual(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int periodIndex, Timeline.Period period, boolean setIds) {
            this.timeline.getPeriod(periodIndex, period, setIds);
            if (Util.areEqual(period.uid, this.replacedInternalPeriodUid) && setIds) {
                period.uid = DUMMY_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object uid) {
            Object obj;
            Timeline timeline = this.timeline;
            if (DUMMY_EXTERNAL_PERIOD_UID.equals(uid) && (obj = this.replacedInternalPeriodUid) != null) {
                uid = obj;
            }
            return timeline.getIndexOfPeriod(uid);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int periodIndex) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(periodIndex);
            return Util.areEqual(uidOfPeriod, this.replacedInternalPeriodUid) ? DUMMY_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }
    }

    public static final class DummyTimeline extends Timeline {
        private final Object tag;

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public DummyTimeline(Object tag) {
            this.tag = tag;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int windowIndex, Timeline.Window window, long defaultPositionProjectionUs) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.tag, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, false, 0L, -9223372036854775807L, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int periodIndex, Timeline.Period period, boolean setIds) {
            return period.set(setIds ? 0 : null, setIds ? MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID : null, 0, -9223372036854775807L, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object uid) {
            return uid == MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int periodIndex) {
            return MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
        }
    }
}
