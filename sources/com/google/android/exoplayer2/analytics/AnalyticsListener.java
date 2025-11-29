package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface AnalyticsListener {
    default void onAudioSessionId(EventTime eventTime, int audioSessionId) {
    }

    default void onAudioUnderrun(EventTime eventTime, int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
    }

    default void onBandwidthEstimate(EventTime eventTime, int totalLoadTimeMs, long totalBytesLoaded, long bitrateEstimate) {
    }

    default void onDecoderDisabled(EventTime eventTime, int trackType, DecoderCounters decoderCounters) {
    }

    default void onDecoderEnabled(EventTime eventTime, int trackType, DecoderCounters decoderCounters) {
    }

    default void onDecoderInitialized(EventTime eventTime, int trackType, String decoderName, long initializationDurationMs) {
    }

    default void onDecoderInputFormatChanged(EventTime eventTime, int trackType, Format format) {
    }

    default void onDownstreamFormatChanged(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void onDrmKeysLoaded(EventTime eventTime) {
    }

    default void onDrmKeysRestored(EventTime eventTime) {
    }

    default void onDrmSessionAcquired(EventTime eventTime) {
    }

    default void onDrmSessionManagerError(EventTime eventTime, Exception error) {
    }

    default void onDrmSessionReleased(EventTime eventTime) {
    }

    default void onDroppedVideoFrames(EventTime eventTime, int droppedFrames, long elapsedMs) {
    }

    default void onIsPlayingChanged(EventTime eventTime, boolean isPlaying) {
    }

    default void onLoadCanceled(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadCompleted(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadError(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
    }

    default void onLoadStarted(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Deprecated
    default void onLoadingChanged(EventTime eventTime, boolean isLoading) {
    }

    default void onMediaPeriodCreated(EventTime eventTime) {
    }

    default void onMediaPeriodReleased(EventTime eventTime) {
    }

    default void onMetadata(EventTime eventTime, Metadata metadata) {
    }

    default void onPlayWhenReadyChanged(EventTime eventTime, boolean playWhenReady, int reason) {
    }

    @Deprecated
    default void onPlaybackParametersChanged(EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    default void onPlaybackSpeedChanged(EventTime eventTime, float playbackSpeed) {
    }

    default void onPlaybackStateChanged(EventTime eventTime, int state) {
    }

    default void onPlaybackSuppressionReasonChanged(EventTime eventTime, int playbackSuppressionReason) {
    }

    default void onPlayerError(EventTime eventTime, ExoPlaybackException error) {
    }

    @Deprecated
    default void onPlayerStateChanged(EventTime eventTime, boolean playWhenReady, int playbackState) {
    }

    default void onPositionDiscontinuity(EventTime eventTime, int reason) {
    }

    default void onReadingStarted(EventTime eventTime) {
    }

    default void onRenderedFirstFrame(EventTime eventTime, Surface surface) {
    }

    default void onRepeatModeChanged(EventTime eventTime, int repeatMode) {
    }

    default void onSeekProcessed(EventTime eventTime) {
    }

    default void onSeekStarted(EventTime eventTime) {
    }

    default void onShuffleModeChanged(EventTime eventTime, boolean shuffleModeEnabled) {
    }

    default void onSkipSilenceEnabledChanged(EventTime eventTime, boolean skipSilenceEnabled) {
    }

    default void onSurfaceSizeChanged(EventTime eventTime, int width, int height) {
    }

    default void onTimelineChanged(EventTime eventTime, int reason) {
    }

    default void onTracksChanged(EventTime eventTime, TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
    }

    default void onUpstreamDiscarded(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void onVideoFrameProcessingOffset(EventTime eventTime, long totalProcessingOffsetUs, int frameCount, Format format) {
    }

    default void onVideoSizeChanged(EventTime eventTime, int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
    }

    default void onVolumeChanged(EventTime eventTime, float volume) {
    }

    public static final class EventTime {
        public final long currentPlaybackPositionMs;
        public final long eventPlaybackPositionMs;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long realtimeMs, Timeline timeline, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, long eventPlaybackPositionMs, long currentPlaybackPositionMs, long totalBufferedDurationMs) {
            this.realtimeMs = realtimeMs;
            this.timeline = timeline;
            this.windowIndex = windowIndex;
            this.mediaPeriodId = mediaPeriodId;
            this.eventPlaybackPositionMs = eventPlaybackPositionMs;
            this.currentPlaybackPositionMs = currentPlaybackPositionMs;
            this.totalBufferedDurationMs = totalBufferedDurationMs;
        }
    }

    default void onIsLoadingChanged(EventTime eventTime, boolean isLoading) {
        onLoadingChanged(eventTime, isLoading);
    }
}
