package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AdPlaybackState {
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private AdGroup(int count, int[] states, Uri[] uris, long[] durationsUs) {
            Assertions.checkArgument(states.length == uris.length);
            this.count = count;
            this.states = states;
            this.uris = uris;
            this.durationsUs = durationsUs;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int lastPlayedAdIndex) {
            int i;
            int i2 = lastPlayedAdIndex + 1;
            while (true) {
                int[] iArr = this.states;
                if (i2 >= iArr.length || (i = iArr[i2]) == 0 || i == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || AdGroup.class != o.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) o;
            return this.count == adGroup.count && Arrays.equals(this.uris, adGroup.uris) && Arrays.equals(this.states, adGroup.states) && Arrays.equals(this.durationsUs, adGroup.durationsUs);
        }

        public int hashCode() {
            return (((((this.count * 31) + Arrays.hashCode(this.uris)) * 31) + Arrays.hashCode(this.states)) * 31) + Arrays.hashCode(this.durationsUs);
        }
    }

    public AdPlaybackState(long... adGroupTimesUs) {
        int length = adGroupTimesUs.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(adGroupTimesUs, length);
        this.adGroups = new AdGroup[length];
        for (int i = 0; i < length; i++) {
            this.adGroups[i] = new AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = -9223372036854775807L;
    }

    public int getAdGroupIndexForPositionUs(long positionUs, long periodDurationUs) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && isPositionBeforeAdGroup(positionUs, periodDurationUs, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int getAdGroupIndexAfterPositionUs(long positionUs, long periodDurationUs) {
        if (positionUs == Long.MIN_VALUE) {
            return -1;
        }
        if (periodDurationUs != -9223372036854775807L && positionUs >= periodDurationUs) {
            return -1;
        }
        int i = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i >= jArr.length) {
                break;
            }
            long j = jArr[i];
            if (j == Long.MIN_VALUE || (positionUs < j && this.adGroups[i].hasUnplayedAds())) {
                break;
            }
            i++;
        }
        if (i < this.adGroupTimesUs.length) {
            return i;
        }
        return -1;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || AdPlaybackState.class != o.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) o;
        return this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && Arrays.equals(this.adGroups, adPlaybackState.adGroups);
    }

    public int hashCode() {
        return (((((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + Arrays.hashCode(this.adGroupTimesUs)) * 31) + Arrays.hashCode(this.adGroups);
    }

    private boolean isPositionBeforeAdGroup(long positionUs, long periodDurationUs, int adGroupIndex) {
        if (positionUs == Long.MIN_VALUE) {
            return false;
        }
        long j = this.adGroupTimesUs[adGroupIndex];
        return j == Long.MIN_VALUE ? periodDurationUs == -9223372036854775807L || positionUs < periodDurationUs : positionUs < j;
    }
}
