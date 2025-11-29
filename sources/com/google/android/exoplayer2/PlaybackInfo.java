package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

/* loaded from: classes2.dex */
final class PlaybackInfo {
    private static final MediaSource.MediaPeriodId DUMMY_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    public volatile long bufferedPositionUs;
    public final boolean isLoading;
    public final MediaSource.MediaPeriodId loadingMediaPeriodId;
    public final MediaSource.MediaPeriodId periodId;
    public final boolean playWhenReady;
    public final ExoPlaybackException playbackError;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public volatile long positionUs;
    public final long requestedContentPositionUs;
    public final Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    public static PlaybackInfo createDummy(TrackSelectorResult emptyTrackSelectorResult) {
        Timeline timeline = Timeline.EMPTY;
        MediaSource.MediaPeriodId mediaPeriodId = DUMMY_MEDIA_PERIOD_ID;
        return new PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 1, null, false, TrackGroupArray.EMPTY, emptyTrackSelectorResult, mediaPeriodId, false, 0, 0L, 0L, 0L);
    }

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId periodId, long requestedContentPositionUs, int playbackState, ExoPlaybackException playbackError, boolean isLoading, TrackGroupArray trackGroups, TrackSelectorResult trackSelectorResult, MediaSource.MediaPeriodId loadingMediaPeriodId, boolean playWhenReady, int playbackSuppressionReason, long bufferedPositionUs, long totalBufferedDurationUs, long positionUs) {
        this.timeline = timeline;
        this.periodId = periodId;
        this.requestedContentPositionUs = requestedContentPositionUs;
        this.playbackState = playbackState;
        this.playbackError = playbackError;
        this.isLoading = isLoading;
        this.trackGroups = trackGroups;
        this.trackSelectorResult = trackSelectorResult;
        this.loadingMediaPeriodId = loadingMediaPeriodId;
        this.playWhenReady = playWhenReady;
        this.playbackSuppressionReason = playbackSuppressionReason;
        this.bufferedPositionUs = bufferedPositionUs;
        this.totalBufferedDurationUs = totalBufferedDurationUs;
        this.positionUs = positionUs;
    }

    public static MediaSource.MediaPeriodId getDummyPeriodForEmptyTimeline() {
        return DUMMY_MEDIA_PERIOD_ID;
    }

    public PlaybackInfo copyWithNewPosition(MediaSource.MediaPeriodId periodId, long positionUs, long requestedContentPositionUs, long totalBufferedDurationUs, TrackGroupArray trackGroups, TrackSelectorResult trackSelectorResult) {
        return new PlaybackInfo(this.timeline, periodId, requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, trackGroups, trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, totalBufferedDurationUs, positionUs);
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline) {
        return new PlaybackInfo(timeline, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithPlaybackState(int playbackState) {
        return new PlaybackInfo(this.timeline, this.periodId, this.requestedContentPositionUs, playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithPlaybackError(ExoPlaybackException playbackError) {
        return new PlaybackInfo(this.timeline, this.periodId, this.requestedContentPositionUs, this.playbackState, playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithIsLoading(boolean isLoading) {
        return new PlaybackInfo(this.timeline, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithLoadingMediaPeriodId(MediaSource.MediaPeriodId loadingMediaPeriodId) {
        return new PlaybackInfo(this.timeline, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithPlayWhenReady(boolean playWhenReady, int playbackSuppressionReason) {
        return new PlaybackInfo(this.timeline, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, playWhenReady, playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }
}
