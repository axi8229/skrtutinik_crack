package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
final class MediaPeriodQueue {
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Period period = new Timeline.Period();
    private final Timeline.Window window = new Timeline.Window();

    private boolean areDurationsCompatible(long previousDurationUs, long newDurationUs) {
        return previousDurationUs == -9223372036854775807L || previousDurationUs == newDurationUs;
    }

    public boolean updateRepeatMode(Timeline timeline, int repeatMode) {
        this.repeatMode = repeatMode;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean updateShuffleModeEnabled(Timeline timeline, boolean shuffleModeEnabled) {
        this.shuffleModeEnabled = shuffleModeEnabled;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long rendererPositionUs) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(rendererPositionUs);
        }
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered() && this.loading.info.durationUs != -9223372036854775807L && this.length < 100);
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long rendererPositionUs, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(playbackInfo.timeline, mediaPeriodHolder, rendererPositionUs);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.MediaPeriodHolder enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[] r12, com.google.android.exoplayer2.trackselection.TrackSelector r13, com.google.android.exoplayer2.upstream.Allocator r14, com.google.android.exoplayer2.MediaSourceList r15, com.google.android.exoplayer2.MediaPeriodInfo r16, com.google.android.exoplayer2.trackselection.TrackSelectorResult r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 != 0) goto L1f
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.id
            boolean r1 = r1.isAd()
            if (r1 == 0) goto L1c
            long r1 = r8.requestedContentPositionUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L1c
        L1a:
            r3 = r1
            goto L2e
        L1c:
            r1 = 0
            goto L1a
        L1f:
            long r1 = r1.getRendererOffset()
            com.google.android.exoplayer2.MediaPeriodHolder r3 = r0.loading
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r3.info
            long r3 = r3.durationUs
            long r1 = r1 + r3
            long r3 = r8.startPositionUs
            long r1 = r1 - r3
            goto L1a
        L2e:
            com.google.android.exoplayer2.MediaPeriodHolder r10 = new com.google.android.exoplayer2.MediaPeriodHolder
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 == 0) goto L44
            r1.setNext(r10)
            goto L48
        L44:
            r0.playing = r10
            r0.reading = r10
        L48:
            r1 = 0
            r0.oldFrontPeriodUid = r1
            r0.loading = r10
            int r1 = r0.length
            int r1 = r1 + 1
            r0.length = r1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[], com.google.android.exoplayer2.trackselection.TrackSelector, com.google.android.exoplayer2.upstream.Allocator, com.google.android.exoplayer2.MediaSourceList, com.google.android.exoplayer2.MediaPeriodInfo, com.google.android.exoplayer2.trackselection.TrackSelectorResult):com.google.android.exoplayer2.MediaPeriodHolder");
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) ? false : true);
        MediaPeriodHolder next = this.reading.getNext();
        this.reading = next;
        return next;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        int i = this.length - 1;
        this.length = i;
        if (i == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.id.windowSequenceNumber;
        }
        MediaPeriodHolder next = this.playing.getNext();
        this.playing = next;
        return next;
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z = false;
        Assertions.checkState(mediaPeriodHolder != null);
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext(null);
        return z;
    }

    public void clear() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            this.oldFrontPeriodUid = mediaPeriodHolder.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.id.windowSequenceNumber;
            removeAfter(mediaPeriodHolder);
            mediaPeriodHolder.release();
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public boolean updateQueuedPeriods(Timeline timeline, long rendererPositionUs, long maxRendererReadPositionUs) {
        MediaPeriodInfo updatedMediaPeriodInfo;
        MediaPeriodHolder next = this.playing;
        MediaPeriodHolder mediaPeriodHolder = null;
        while (next != null) {
            MediaPeriodInfo mediaPeriodInfo = next.info;
            if (mediaPeriodHolder == null) {
                updatedMediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder, rendererPositionUs);
                if (followingMediaPeriodInfo == null) {
                    return !removeAfter(mediaPeriodHolder);
                }
                if (!canKeepMediaPeriodHolder(mediaPeriodInfo, followingMediaPeriodInfo)) {
                    return !removeAfter(mediaPeriodHolder);
                }
                updatedMediaPeriodInfo = followingMediaPeriodInfo;
            }
            next.info = updatedMediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo.durationUs, updatedMediaPeriodInfo.durationUs)) {
                long j = updatedMediaPeriodInfo.durationUs;
                return (removeAfter(next) || (next == this.reading && ((maxRendererReadPositionUs > Long.MIN_VALUE ? 1 : (maxRendererReadPositionUs == Long.MIN_VALUE ? 0 : -1)) == 0 || (maxRendererReadPositionUs > ((j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(j)) ? 1 : (maxRendererReadPositionUs == ((j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(j)) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder = next;
            next = next.getNext();
        }
        return true;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline timeline, MediaPeriodInfo info) {
        long durationBySegmentsUs;
        MediaSource.MediaPeriodId mediaPeriodId = info.id;
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, zIsLastInPeriod);
        timeline.getPeriodByUid(info.id.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            durationBySegmentsUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            durationBySegmentsUs = info.endPositionUs;
            if (durationBySegmentsUs == -9223372036854775807L || durationBySegmentsUs == Long.MIN_VALUE) {
                durationBySegmentsUs = this.period.getDurationBySegmentsUs();
            }
        }
        return new MediaPeriodInfo(mediaPeriodId, info.startPositionUs, info.requestedContentPositionUs, info.endPositionUs, durationBySegmentsUs, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object periodUid, long positionUs) {
        return resolveMediaPeriodIdForAds(timeline, periodUid, positionUs, resolvePeriodIndexToWindowSequenceNumber(timeline, periodUid), this.period);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object periodUid, long positionUs, long windowSequenceNumber, Timeline.Period period) {
        timeline.getPeriodByUid(periodUid, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(positionUs);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(periodUid, windowSequenceNumber, period.getAdGroupIndexAfterPositionUs(positionUs));
        }
        return new MediaSource.MediaPeriodId(periodUid, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), windowSequenceNumber);
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline timeline, Object periodUid) {
        int indexOfPeriod;
        int i = timeline.getPeriodByUid(periodUid, this.period).windowIndex;
        Object obj = this.oldFrontPeriodUid;
        if (obj != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            if (next.uid.equals(periodUid)) {
                return next.info.id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder next2 = this.playing; next2 != null; next2 = next2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(next2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i) {
                return next2.info.id.windowSequenceNumber;
            }
        }
        long j = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j;
        if (this.playing == null) {
            this.oldFrontPeriodUid = periodUid;
            this.oldFrontPeriodWindowSequenceNumber = j;
        }
        return j;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo oldInfo, MediaPeriodInfo newInfo) {
        return oldInfo.startPositionUs == newInfo.startPositionUs && oldInfo.id.equals(newInfo.id);
    }

    private boolean updateForPlaybackModeChange(Timeline timeline) {
        MediaPeriodHolder next = this.playing;
        if (next == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(next.uid);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (next.getNext() != null && !next.info.isLastInTimelinePeriod) {
                next = next.getNext();
            }
            MediaPeriodHolder next2 = next.getNext();
            if (indexOfPeriod == -1 || next2 == null || timeline.getIndexOfPeriod(next2.uid) != indexOfPeriod) {
                break;
            }
            next = next2;
        }
        boolean zRemoveAfter = removeAfter(next);
        next.info = getUpdatedMediaPeriodInfo(timeline, next.info);
        return !zRemoveAfter;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long rendererPositionUs) {
        long j;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - rendererPositionUs;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            long j2 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(mediaPeriodInfo.id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj = this.period.uid;
            long j3 = mediaPeriodInfo.id.windowSequenceNumber;
            if (timeline.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPosition == null) {
                    return null;
                }
                obj = periodPosition.first;
                long jLongValue = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder next = mediaPeriodHolder.getNext();
                if (next != null && next.uid.equals(obj)) {
                    j3 = next.info.id.windowSequenceNumber;
                } else {
                    j3 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j3;
                }
                j = jLongValue;
                j2 = -9223372036854775807L;
            } else {
                j = 0;
            }
            return getMediaPeriodInfo(timeline, resolveMediaPeriodIdForAds(timeline, obj, j, j3, this.period), j2, j);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                if (this.period.isAdAvailable(i2, nextAdIndexToPlay)) {
                    return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
                }
                return null;
            }
            long jLongValue2 = mediaPeriodInfo.requestedContentPositionUs;
            if (jLongValue2 == -9223372036854775807L) {
                Timeline.Window window = this.window;
                Timeline.Period period = this.period;
                Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window, period, period.windowIndex, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPosition2 == null) {
                    return null;
                }
                jLongValue2 = ((Long) periodPosition2.second).longValue();
            }
            return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, jLongValue2, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
        }
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(mediaPeriodInfo.endPositionUs);
        if (adGroupIndexForPositionUs == -1) {
            Object obj2 = mediaPeriodId.periodUid;
            long j4 = mediaPeriodInfo.durationUs;
            return getMediaPeriodInfoForContent(timeline, obj2, j4, j4, mediaPeriodId.windowSequenceNumber);
        }
        int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
        if (this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
        }
        return null;
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId id, long requestedContentPositionUs, long startPositionUs) {
        timeline.getPeriodByUid(id.periodUid, this.period);
        if (id.isAd()) {
            if (this.period.isAdAvailable(id.adGroupIndex, id.adIndexInAdGroup)) {
                return getMediaPeriodInfoForAd(timeline, id.periodUid, id.adGroupIndex, id.adIndexInAdGroup, requestedContentPositionUs, id.windowSequenceNumber);
            }
            return null;
        }
        return getMediaPeriodInfoForContent(timeline, id.periodUid, startPositionUs, requestedContentPositionUs, id.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object periodUid, int adGroupIndex, int adIndexInAdGroup, long contentPositionUs, long windowSequenceNumber) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(periodUid, adGroupIndex, adIndexInAdGroup, windowSequenceNumber);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = adIndexInAdGroup == this.period.getFirstAdIndexToPlay(adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        return new MediaPeriodInfo(mediaPeriodId, (adDurationUs == -9223372036854775807L || adResumePositionUs < adDurationUs) ? adResumePositionUs : Math.max(0L, adDurationUs - 1), contentPositionUs, -9223372036854775807L, adDurationUs, false, false, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object periodUid, long startPositionUs, long requestedContentPositionUs, long windowSequenceNumber) {
        long jMax = startPositionUs;
        timeline.getPeriodByUid(periodUid, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(jMax);
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(periodUid, windowSequenceNumber, adGroupIndexAfterPositionUs);
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, zIsLastInPeriod);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        long durationBySegmentsUs = (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) ? this.period.getDurationBySegmentsUs() : adGroupTimeUs;
        if (durationBySegmentsUs != -9223372036854775807L && jMax >= durationBySegmentsUs) {
            jMax = Math.max(0L, durationBySegmentsUs - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, jMax, requestedContentPositionUs, adGroupTimeUs, durationBySegmentsUs, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId id) {
        return !id.isAd() && id.nextAdGroupIndex == -1;
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId id) {
        if (isLastInPeriod(id)) {
            return timeline.getWindow(timeline.getPeriodByUid(id.periodUid, this.period).windowIndex, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(id.periodUid);
        }
        return false;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId id, boolean isLastMediaPeriodInPeriod) {
        int indexOfPeriod = timeline.getIndexOfPeriod(id.periodUid);
        return !timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic && timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && isLastMediaPeriodInPeriod;
    }
}
