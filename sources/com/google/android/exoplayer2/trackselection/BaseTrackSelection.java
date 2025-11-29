package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float playbackSpeed) {
    }

    public BaseTrackSelection(TrackGroup group, int... tracks) {
        int i = 0;
        Assertions.checkState(tracks.length > 0);
        this.group = (TrackGroup) Assertions.checkNotNull(group);
        int length = tracks.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i2 = 0; i2 < tracks.length; i2++) {
            this.formats[i2] = group.getFormat(tracks[i2]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.tracks[i] = group.indexOf(this.formats[i]);
                i++;
            } else {
                this.blacklistUntilTimes = new long[i3];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int index) {
        return this.formats[index];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int index) {
        return this.tracks[index];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.formats[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue) {
        return queue.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int index, long blacklistDurationMs) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(index, jElapsedRealtime);
        int i = 0;
        while (i < this.length && !zIsBlacklisted) {
            zIsBlacklisted = (i == index || isBlacklisted(i, jElapsedRealtime)) ? false : true;
            i++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[index] = Math.max(jArr[index], Util.addWithOverflowDefault(jElapsedRealtime, blacklistDurationMs, Long.MAX_VALUE));
        return true;
    }

    protected final boolean isBlacklisted(int index, long nowMs) {
        return this.blacklistUntilTimes[index] > nowMs;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Format a, Format b) {
            return b.bitrate - a.bitrate;
        }
    }
}
