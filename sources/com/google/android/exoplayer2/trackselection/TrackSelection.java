package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

/* loaded from: classes2.dex */
public interface TrackSelection {

    public interface Factory {
        TrackSelection[] createTrackSelections(Definition[] definitions, BandwidthMeter bandwidthMeter);
    }

    boolean blacklist(int index, long blacklistDurationMs);

    void disable();

    void enable();

    int evaluateQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue);

    Format getFormat(int index);

    int getIndexInTrackGroup(int index);

    Format getSelectedFormat();

    int getSelectedIndex();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(Format format);

    int length();

    default void onDiscontinuity() {
    }

    void onPlaybackSpeed(float speed);

    void updateSelectedTrack(long playbackPositionUs, long bufferedDurationUs, long availableDurationUs, List<? extends MediaChunk> queue, MediaChunkIterator[] mediaChunkIterators);

    public static final class Definition {
        public final Object data;
        public final TrackGroup group;
        public final int reason;
        public final int[] tracks;

        public Definition(TrackGroup group, int... tracks) {
            this(group, tracks, 0, null);
        }

        public Definition(TrackGroup group, int[] tracks, int reason, Object data) {
            this.group = group;
            this.tracks = tracks;
            this.reason = reason;
            this.data = data;
        }
    }
}
