package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object uid) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Window getWindow(int windowIndex, Window window, long defaultPositionProjectionUs) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int periodIndex, Period period, boolean setIds) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int periodIndex) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int getIndexOfPeriod(Object uid);

    public abstract Period getPeriod(int periodIndex, Period period, boolean setIds);

    public abstract int getPeriodCount();

    public abstract Object getUidOfPeriod(int periodIndex);

    public abstract Window getWindow(int windowIndex, Window window, long defaultPositionProjectionUs);

    public abstract int getWindowCount();

    public static final class Window {
        public static final Object SINGLE_WINDOW_UID = new Object();
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public Object manifest;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public Object uid = SINGLE_WINDOW_UID;
        public long windowStartTimeMs;

        public Window set(Object uid, Object tag, Object manifest, long presentationStartTimeMs, long windowStartTimeMs, long elapsedRealtimeEpochOffsetMs, boolean isSeekable, boolean isDynamic, boolean isLive, long defaultPositionUs, long durationUs, int firstPeriodIndex, int lastPeriodIndex, long positionInFirstPeriodUs) {
            this.uid = uid;
            this.tag = tag;
            this.manifest = manifest;
            this.presentationStartTimeMs = presentationStartTimeMs;
            this.windowStartTimeMs = windowStartTimeMs;
            this.elapsedRealtimeEpochOffsetMs = elapsedRealtimeEpochOffsetMs;
            this.isSeekable = isSeekable;
            this.isDynamic = isDynamic;
            this.isLive = isLive;
            this.defaultPositionUs = defaultPositionUs;
            this.durationUs = durationUs;
            this.firstPeriodIndex = firstPeriodIndex;
            this.lastPeriodIndex = lastPeriodIndex;
            this.positionInFirstPeriodUs = positionInFirstPeriodUs;
            this.isPlaceholder = false;
            return this;
        }

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            return Util.areEqual(this.uid, window.uid) && Util.areEqual(this.tag, window.tag) && Util.areEqual(this.manifest, window.manifest) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isLive == window.isLive && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int iHashCode = (217 + this.uid.hashCode()) * 31;
            Object obj = this.tag;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.manifest;
            int iHashCode3 = (iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
            long j = this.presentationStartTimeMs;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.windowStartTimeMs;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.elapsedRealtimeEpochOffsetMs;
            int i3 = (((((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isLive ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31;
            long j4 = this.defaultPositionUs;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.durationUs;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31;
            long j6 = this.positionInFirstPeriodUs;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }
    }

    public static final class Period {
        private AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        public long durationBySegmentsUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public Period set(Object id, Object uid, int windowIndex, long durationBySegmentsUs, long positionInWindowUs) {
            return set(id, uid, windowIndex, durationBySegmentsUs, positionInWindowUs, AdPlaybackState.NONE);
        }

        public Period set(Object id, Object uid, int windowIndex, long durationBySegmentsUs, long positionInWindowUs, AdPlaybackState adPlaybackState) {
            this.id = id;
            this.uid = uid;
            this.windowIndex = windowIndex;
            this.durationBySegmentsUs = durationBySegmentsUs;
            this.positionInWindowUs = positionInWindowUs;
            this.adPlaybackState = adPlaybackState;
            return this;
        }

        public long getDurationBySegmentsUs() {
            return this.durationBySegmentsUs;
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public long getAdGroupTimeUs(int adGroupIndex) {
            return this.adPlaybackState.adGroupTimesUs[adGroupIndex];
        }

        public int getFirstAdIndexToPlay(int adGroupIndex) {
            return this.adPlaybackState.adGroups[adGroupIndex].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int adGroupIndex, int lastPlayedAdIndex) {
            return this.adPlaybackState.adGroups[adGroupIndex].getNextAdIndexToPlay(lastPlayedAdIndex);
        }

        public boolean hasPlayedAdGroup(int adGroupIndex) {
            return !this.adPlaybackState.adGroups[adGroupIndex].hasUnplayedAds();
        }

        public int getAdGroupIndexForPositionUs(long positionUs) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(positionUs, this.durationBySegmentsUs);
        }

        public int getAdGroupIndexAfterPositionUs(long positionUs) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(positionUs, this.durationBySegmentsUs);
        }

        public int getAdCountInAdGroup(int adGroupIndex) {
            return this.adPlaybackState.adGroups[adGroupIndex].count;
        }

        public boolean isAdAvailable(int adGroupIndex, int adIndexInAdGroup) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[adGroupIndex];
            return (adGroup.count == -1 || adGroup.states[adIndexInAdGroup] == 0) ? false : true;
        }

        public long getAdDurationUs(int adGroupIndex, int adIndexInAdGroup) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[adGroupIndex];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[adIndexInAdGroup];
            }
            return -9223372036854775807L;
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            return Util.areEqual(this.id, period.id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationBySegmentsUs == period.durationBySegmentsUs && this.positionInWindowUs == period.positionInWindowUs && Util.areEqual(this.adPlaybackState, period.adPlaybackState);
        }

        public int hashCode() {
            Object obj = this.id;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.uid;
            int iHashCode2 = (((iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31) + this.windowIndex) * 31;
            long j = this.durationBySegmentsUs;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.positionInWindowUs;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            AdPlaybackState adPlaybackState = this.adPlaybackState;
            return i2 + (adPlaybackState != null ? adPlaybackState.hashCode() : 0);
        }
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public int getNextWindowIndex(int windowIndex, int repeatMode, boolean shuffleModeEnabled) {
        if (repeatMode == 0) {
            if (windowIndex == getLastWindowIndex(shuffleModeEnabled)) {
                return -1;
            }
            return windowIndex + 1;
        }
        if (repeatMode == 1) {
            return windowIndex;
        }
        if (repeatMode == 2) {
            return windowIndex == getLastWindowIndex(shuffleModeEnabled) ? getFirstWindowIndex(shuffleModeEnabled) : windowIndex + 1;
        }
        throw new IllegalStateException();
    }

    public int getPreviousWindowIndex(int windowIndex, int repeatMode, boolean shuffleModeEnabled) {
        if (repeatMode == 0) {
            if (windowIndex == getFirstWindowIndex(shuffleModeEnabled)) {
                return -1;
            }
            return windowIndex - 1;
        }
        if (repeatMode == 1) {
            return windowIndex;
        }
        if (repeatMode == 2) {
            return windowIndex == getFirstWindowIndex(shuffleModeEnabled) ? getLastWindowIndex(shuffleModeEnabled) : windowIndex - 1;
        }
        throw new IllegalStateException();
    }

    public int getLastWindowIndex(boolean shuffleModeEnabled) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public int getFirstWindowIndex(boolean shuffleModeEnabled) {
        return isEmpty() ? -1 : 0;
    }

    public final Window getWindow(int windowIndex, Window window) {
        return getWindow(windowIndex, window, 0L);
    }

    public final int getNextPeriodIndex(int periodIndex, Period period, Window window, int repeatMode, boolean shuffleModeEnabled) {
        int i = getPeriod(periodIndex, period).windowIndex;
        if (getWindow(i, window).lastPeriodIndex != periodIndex) {
            return periodIndex + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i, repeatMode, shuffleModeEnabled);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public final boolean isLastPeriod(int periodIndex, Period period, Window window, int repeatMode, boolean shuffleModeEnabled) {
        return getNextPeriodIndex(periodIndex, period, window, repeatMode, shuffleModeEnabled) == -1;
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int windowIndex, long windowPositionUs) {
        return (Pair) Assertions.checkNotNull(getPeriodPosition(window, period, windowIndex, windowPositionUs, 0L));
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int windowIndex, long windowPositionUs, long defaultPositionProjectionUs) {
        Assertions.checkIndex(windowIndex, 0, getWindowCount());
        getWindow(windowIndex, window, defaultPositionProjectionUs);
        if (windowPositionUs == -9223372036854775807L) {
            windowPositionUs = window.getDefaultPositionUs();
            if (windowPositionUs == -9223372036854775807L) {
                return null;
            }
        }
        int i = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + windowPositionUs;
        long durationBySegmentsUs = getPeriod(i, period, true).getDurationBySegmentsUs();
        while (durationBySegmentsUs != -9223372036854775807L && positionInFirstPeriodUs >= durationBySegmentsUs && i < window.lastPeriodIndex) {
            Log.d(getClass().getName(), String.format("Timeline: \n periodPosition %d \n periodDurationUs %d \n periodIndex %d \n window.lastPeriodIndex %d \n", Long.valueOf(positionInFirstPeriodUs), Long.valueOf(durationBySegmentsUs), Integer.valueOf(i), Integer.valueOf(window.lastPeriodIndex)));
            positionInFirstPeriodUs -= durationBySegmentsUs;
            i++;
            durationBySegmentsUs = getPeriod(i, period, true).getDurationBySegmentsUs();
        }
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(positionInFirstPeriodUs));
    }

    public Period getPeriodByUid(Object periodUid, Period period) {
        return getPeriod(getIndexOfPeriod(periodUid), period, true);
    }

    public final Period getPeriod(int periodIndex, Period period) {
        return getPeriod(periodIndex, period, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i = 0; i < getWindowCount(); i++) {
            if (!getWindow(i, window).equals(timeline.getWindow(i, window2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            if (!getPeriod(i2, period, true).equals(timeline.getPeriod(i2, period2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = 217 + getWindowCount();
        for (int i = 0; i < getWindowCount(); i++) {
            windowCount = (windowCount * 31) + getWindow(i, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            periodCount = (periodCount * 31) + getPeriod(i2, period, true).hashCode();
        }
        return periodCount;
    }
}
