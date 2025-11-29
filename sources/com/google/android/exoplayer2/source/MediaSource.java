package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface MediaSource {

    public interface MediaSourceCaller {
        void onSourceInfoRefreshed(MediaSource source, Timeline timeline);
    }

    void addDrmEventListener(Handler handler, DrmSessionEventListener eventListener);

    void addEventListener(Handler handler, MediaSourceEventListener eventListener);

    MediaPeriod createPeriod(MediaPeriodId id, Allocator allocator, long startPositionUs);

    void disable(MediaSourceCaller caller);

    void enable(MediaSourceCaller caller);

    default Timeline getInitialTimeline() {
        return null;
    }

    default Object getTag() {
        return null;
    }

    default boolean isSingleWindow() {
        return true;
    }

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(MediaSourceCaller caller, TransferListener mediaTransferListener);

    void releasePeriod(MediaPeriod mediaPeriod);

    void releaseSource(MediaSourceCaller caller);

    void removeEventListener(MediaSourceEventListener eventListener);

    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int nextAdGroupIndex;
        public final Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(Object periodUid) {
            this(periodUid, -1L);
        }

        public MediaPeriodId(Object periodUid, long windowSequenceNumber) {
            this(periodUid, -1, -1, windowSequenceNumber, -1);
        }

        public MediaPeriodId(Object periodUid, long windowSequenceNumber, int nextAdGroupIndex) {
            this(periodUid, -1, -1, windowSequenceNumber, nextAdGroupIndex);
        }

        public MediaPeriodId(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long windowSequenceNumber) {
            this(periodUid, adGroupIndex, adIndexInAdGroup, windowSequenceNumber, -1);
        }

        private MediaPeriodId(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long windowSequenceNumber, int nextAdGroupIndex) {
            this.periodUid = periodUid;
            this.adGroupIndex = adGroupIndex;
            this.adIndexInAdGroup = adIndexInAdGroup;
            this.windowSequenceNumber = windowSequenceNumber;
            this.nextAdGroupIndex = nextAdGroupIndex;
        }

        public MediaPeriodId copyWithPeriodUid(Object newPeriodUid) {
            return this.periodUid.equals(newPeriodUid) ? this : new MediaPeriodId(newPeriodUid, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MediaPeriodId.class != obj.getClass()) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            return this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.nextAdGroupIndex == mediaPeriodId.nextAdGroupIndex;
        }

        public int hashCode() {
            return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + this.nextAdGroupIndex;
        }
    }
}
