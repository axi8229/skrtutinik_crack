package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes2.dex */
final class MediaPeriodHolder {
    public boolean allRenderersEnabled;
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSourceList mediaSourceList;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilities, long rendererPositionOffsetUs, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo info, TrackSelectorResult emptyTrackSelectorResult) {
        this.rendererCapabilities = rendererCapabilities;
        this.rendererPositionOffsetUs = rendererPositionOffsetUs;
        this.trackSelector = trackSelector;
        this.mediaSourceList = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = info.id;
        this.uid = mediaPeriodId.periodUid;
        this.info = info;
        this.trackGroups = TrackGroupArray.EMPTY;
        this.trackSelectorResult = emptyTrackSelectorResult;
        this.sampleStreams = new SampleStream[rendererCapabilities.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilities.length];
        this.mediaPeriod = createMediaPeriod(mediaPeriodId, mediaSourceList, allocator, info.startPositionUs, info.endPositionUs);
    }

    public long toRendererTime(long periodTimeUs) {
        return periodTimeUs + getRendererOffset();
    }

    public long toPeriodTime(long rendererTimeUs) {
        return rendererTimeUs - getRendererOffset();
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public void setRendererOffset(long rendererPositionOffsetUs) {
        this.rendererPositionOffsetUs = rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public long getNextLoadPositionUs() {
        if (this.prepared) {
            return this.mediaPeriod.getNextLoadPositionUs();
        }
        return 0L;
    }

    public void handlePrepared(float playbackSpeed, Timeline timeline) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult trackSelectorResultSelectTracks = selectTracks(playbackSpeed, timeline);
        MediaPeriodInfo mediaPeriodInfo = this.info;
        long jMax = mediaPeriodInfo.startPositionUs;
        long j = mediaPeriodInfo.durationUs;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jApplyTrackSelection = applyTrackSelection(trackSelectorResultSelectTracks, jMax, false);
        long j2 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo2 = this.info;
        this.rendererPositionOffsetUs = j2 + (mediaPeriodInfo2.startPositionUs - jApplyTrackSelection);
        this.info = mediaPeriodInfo2.copyWithStartPositionUs(jApplyTrackSelection);
    }

    public void reevaluateBuffer(long rendererPositionUs) {
        Assertions.checkState(isLoadingMediaPeriod());
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(rendererPositionUs));
        }
    }

    public void continueLoading(long rendererPositionUs) {
        Assertions.checkState(isLoadingMediaPeriod());
        this.mediaPeriod.continueLoading(toPeriodTime(rendererPositionUs));
    }

    public TrackSelectorResult selectTracks(float playbackSpeed, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult trackSelectorResultSelectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, getTrackGroups(), this.info.id, timeline);
        for (TrackSelection trackSelection : trackSelectorResultSelectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(playbackSpeed);
            }
        }
        return trackSelectorResultSelectTracks;
    }

    TrackSelectorResult getTrackSelection(Timeline timeline) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult trackSelectorResultSelectTracks = selectTracks(0.04f, timeline);
        this.prepared = false;
        return trackSelectorResultSelectTracks;
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult, long positionUs, boolean forceRecreateStreams) {
        return applyTrackSelection(trackSelectorResult, positionUs, forceRecreateStreams, new boolean[this.rendererCapabilities.length]);
    }

    public long applyTrackSelection(TrackSelectorResult newTrackSelectorResult, long positionUs, boolean forceRecreateStreams, boolean[] streamResetFlags) {
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= newTrackSelectorResult.length) {
                break;
            }
            boolean[] zArr = this.mayRetainStreamFlags;
            if (forceRecreateStreams || !newTrackSelectorResult.isEquivalent(this.trackSelectorResult, i)) {
                z = false;
            }
            zArr[i] = z;
            i++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        disableTrackSelectionsInResult();
        this.trackSelectorResult = newTrackSelectorResult;
        enableTrackSelectionsInResult();
        TrackSelectionArray trackSelectionArray = newTrackSelectorResult.selections;
        long jSelectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, streamResetFlags, positionUs);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return jSelectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(newTrackSelectorResult.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public void release() {
        disableTrackSelectionsInResult();
        releaseMediaPeriod(this.info.endPositionUs, this.mediaSourceList, this.mediaPeriod);
    }

    public void setNext(MediaPeriodHolder nextMediaPeriodHolder) {
        if (nextMediaPeriodHolder == this.next) {
            return;
        }
        disableTrackSelectionsInResult();
        this.next = nextMediaPeriodHolder;
        enableTrackSelectionsInResult();
    }

    public MediaPeriodHolder getNext() {
        return this.next;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public TrackSelectorResult getTrackSelectorResult() {
        return this.trackSelectorResult;
    }

    private void enableTrackSelectionsInResult() {
        if (!isLoadingMediaPeriod()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            TrackSelection trackSelection = this.trackSelectorResult.selections.get(i);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
            i++;
        }
    }

    private void disableTrackSelectionsInResult() {
        if (!isLoadingMediaPeriod()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            TrackSelection trackSelection = this.trackSelectorResult.selections.get(i);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
            i++;
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreams) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 6) {
                sampleStreams[i] = null;
            }
            i++;
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreams) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 6 && this.trackSelectorResult.isRendererEnabled(i)) {
                sampleStreams[i] = new EmptySampleStream();
            }
            i++;
        }
    }

    private boolean isLoadingMediaPeriod() {
        return this.next == null;
    }

    private static MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId id, MediaSourceList mediaSourceList, Allocator allocator, long startPositionUs, long endPositionUs) {
        MediaPeriod mediaPeriodCreatePeriod = mediaSourceList.createPeriod(id, allocator, startPositionUs);
        return (endPositionUs == -9223372036854775807L || endPositionUs == Long.MIN_VALUE) ? mediaPeriodCreatePeriod : new ClippingMediaPeriod(mediaPeriodCreatePeriod, true, 0L, endPositionUs);
    }

    private static void releaseMediaPeriod(long endPositionUs, MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (endPositionUs != -9223372036854775807L && endPositionUs != Long.MIN_VALUE) {
                mediaSourceList.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
            } else {
                mediaSourceList.releasePeriod(mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log.e("MediaPeriodHolder", "Period release failed.", e);
        }
    }
}
