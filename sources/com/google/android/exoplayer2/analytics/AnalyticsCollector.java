package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class AnalyticsCollector implements Player.EventListener, MetadataOutput, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener, VideoListener, AudioListener {
    private final Clock clock;
    private boolean isSeeking;
    private Player player;
    private final CopyOnWriteArraySet<AnalyticsListener> listeners = new CopyOnWriteArraySet<>();
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker = new MediaPeriodQueueTracker();
    private final Timeline.Window window = new Timeline.Window();

    @Override // com.google.android.exoplayer2.video.VideoListener
    public final void onRenderedFirstFrame() {
    }

    public AnalyticsCollector(Clock clock) {
        this.clock = (Clock) Assertions.checkNotNull(clock);
    }

    public void addListener(AnalyticsListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(AnalyticsListener listener) {
        this.listeners.remove(listener);
    }

    public void setPlayer(Player player) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodInfoQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player);
    }

    public final void notifySeekStarted() {
        if (this.isSeeking) {
            return;
        }
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.isSeeking = true;
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekStarted(eventTimeGenerateCurrentPlayerMediaPeriodEventTime);
        }
    }

    public final void resetForNewPlaylist() {
        for (MediaPeriodInfo mediaPeriodInfo : new ArrayList(this.mediaPeriodQueueTracker.mediaPeriodInfoQueue)) {
            onMediaPeriodReleased(mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, metadata);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(DecoderCounters counters) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(eventTimeGenerateReadingMediaPeriodEventTime, 1, counters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTimeGenerateReadingMediaPeriodEventTime, 1, decoderName, initializationDurationMs);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(Format format) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(eventTimeGenerateReadingMediaPeriodEventTime, 1, format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(eventTimeGenerateReadingMediaPeriodEventTime, bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(DecoderCounters counters) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(eventTimeGeneratePlayingMediaPeriodEventTime, 1, counters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSessionId(int audioSessionId) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(eventTimeGenerateReadingMediaPeriodEventTime, audioSessionId);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(eventTimeGenerateReadingMediaPeriodEventTime, skipSilenceEnabled);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onVolumeChanged(float audioVolume) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(eventTimeGenerateReadingMediaPeriodEventTime, audioVolume);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters counters) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(eventTimeGenerateReadingMediaPeriodEventTime, 2, counters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTimeGenerateReadingMediaPeriodEventTime, 2, decoderName, initializationDurationMs);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(Format format) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(eventTimeGenerateReadingMediaPeriodEventTime, 2, format);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int count, long elapsedMs) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(eventTimeGeneratePlayingMediaPeriodEventTime, count, elapsedMs);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters counters) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(eventTimeGeneratePlayingMediaPeriodEventTime, 2, counters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(Surface surface) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(eventTimeGenerateReadingMediaPeriodEventTime, surface);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoFrameProcessingOffset(long totalProcessingOffsetUs, int frameCount, Format format) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoFrameProcessingOffset(eventTimeGeneratePlayingMediaPeriodEventTime, totalProcessingOffsetUs, frameCount, format);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(eventTimeGenerateReadingMediaPeriodEventTime, width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int width, int height) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(eventTimeGenerateReadingMediaPeriodEventTime, width, height);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onMediaPeriodCreated(windowIndex, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(eventTimeGenerateMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodReleased(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        if (this.mediaPeriodQueueTracker.onMediaPeriodReleased(mediaPeriodId, (Player) Assertions.checkNotNull(this.player))) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onMediaPeriodReleased(eventTimeGenerateMediaPeriodEventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, error, wasCanceled);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onReadingStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onReadingStarted(mediaPeriodId);
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(eventTimeGenerateMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(eventTimeGenerateMediaPeriodEventTime, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(windowIndex, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(eventTimeGenerateMediaPeriodEventTime, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(Timeline timeline, int reason) {
        this.mediaPeriodQueueTracker.onTimelineChanged(timeline, (Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, reason);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, trackGroups, trackSelections);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onIsLoadingChanged(boolean isLoading) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onIsLoadingChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, isLoading);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playWhenReady, playbackState);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(int state) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackStateChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, state);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayWhenReadyChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playWhenReady, reason);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSuppressionReasonChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playbackSuppressionReason);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean isPlaying) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onIsPlayingChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, isPlaying);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(int repeatMode) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, repeatMode);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, shuffleModeEnabled);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(ExoPlaybackException error) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, error);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int reason) {
        if (reason == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, reason);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    @Deprecated
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackSpeedChanged(float playbackSpeed) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSpeedChanged(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playbackSpeed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekProcessed(eventTimeGenerateCurrentPlayerMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(int elapsedMs, long bytes, long bitrate) {
        AnalyticsListener.EventTime eventTimeGenerateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(eventTimeGenerateLoadingMediaPeriodEventTime, elapsedMs, bytes, bitrate);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired() {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionAcquired(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded() {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(Exception error) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(eventTimeGenerateReadingMediaPeriodEventTime, error);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored() {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased() {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionReleased(eventTimeGeneratePlayingMediaPeriodEventTime);
        }
    }

    protected AnalyticsListener.EventTime generateEventTime(Timeline timeline, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        if (timeline.isEmpty()) {
            mediaPeriodId = null;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        boolean z = timeline.equals(this.player.getCurrentTimeline()) && windowIndex == this.player.getCurrentWindowIndex();
        long defaultPositionMs = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.isAd()) {
            if (z) {
                defaultPositionMs = this.player.getContentPosition();
            } else if (!timeline.isEmpty()) {
                defaultPositionMs = timeline.getWindow(windowIndex, this.window).getDefaultPositionMs();
            }
        } else if (z && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
            defaultPositionMs = this.player.getCurrentPosition();
        }
        return new AnalyticsListener.EventTime(jElapsedRealtime, timeline, windowIndex, mediaPeriodId2, defaultPositionMs, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private AnalyticsListener.EventTime generateEventTime(MediaPeriodInfo mediaPeriodInfo) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodInfo == null) {
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (currentWindowIndex >= currentTimeline.getWindowCount()) {
                currentTimeline = Timeline.EMPTY;
            }
            return generateEventTime(currentTimeline, currentWindowIndex, null);
        }
        return generateEventTime(mediaPeriodInfo.timeline, mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
    }

    private AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId != null) {
            MediaPeriodInfo mediaPeriodInfo = this.mediaPeriodQueueTracker.getMediaPeriodInfo(mediaPeriodId);
            if (mediaPeriodInfo != null) {
                return generateEventTime(mediaPeriodInfo);
            }
            return generateEventTime(Timeline.EMPTY, windowIndex, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (windowIndex >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, windowIndex, null);
    }

    private static final class MediaPeriodQueueTracker {
        private MediaPeriodInfo currentPlayerMediaPeriod;
        private MediaPeriodInfo playingMediaPeriod;
        private MediaPeriodInfo readingMediaPeriod;
        private final ArrayList<MediaPeriodInfo> mediaPeriodInfoQueue = new ArrayList<>();
        private final HashMap<MediaSource.MediaPeriodId, MediaPeriodInfo> mediaPeriodIdToInfo = new HashMap<>();
        private final Timeline.Period period = new Timeline.Period();
        private Timeline timeline = Timeline.EMPTY;

        public MediaPeriodInfo getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaPeriodInfo getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaPeriodInfo getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public MediaPeriodInfo getLoadingMediaPeriod() {
            if (this.mediaPeriodInfoQueue.isEmpty()) {
                return null;
            }
            return this.mediaPeriodInfoQueue.get(r0.size() - 1);
        }

        public MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodIdToInfo.get(mediaPeriodId);
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findMatchingMediaPeriodInQueue(player);
        }

        public void onTimelineChanged(Timeline timeline, Player player) {
            for (int i = 0; i < this.mediaPeriodInfoQueue.size(); i++) {
                MediaPeriodInfo mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline = updateMediaPeriodInfoToNewTimeline(this.mediaPeriodInfoQueue.get(i), timeline);
                this.mediaPeriodInfoQueue.set(i, mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline);
                this.mediaPeriodIdToInfo.put(mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline.mediaPeriodId, mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline);
            }
            if (!this.mediaPeriodInfoQueue.isEmpty()) {
                this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            } else {
                MediaPeriodInfo mediaPeriodInfo = this.playingMediaPeriod;
                if (mediaPeriodInfo != null) {
                    this.playingMediaPeriod = updateMediaPeriodInfoToNewTimeline(mediaPeriodInfo, timeline);
                }
            }
            MediaPeriodInfo mediaPeriodInfo2 = this.readingMediaPeriod;
            if (mediaPeriodInfo2 != null) {
                this.readingMediaPeriod = updateMediaPeriodInfoToNewTimeline(mediaPeriodInfo2, timeline);
            } else {
                MediaPeriodInfo mediaPeriodInfo3 = this.playingMediaPeriod;
                if (mediaPeriodInfo3 != null) {
                    this.readingMediaPeriod = mediaPeriodInfo3;
                }
            }
            this.timeline = timeline;
            this.currentPlayerMediaPeriod = findMatchingMediaPeriodInQueue(player);
        }

        public void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
            boolean z = indexOfPeriod != -1;
            Timeline timeline = z ? this.timeline : Timeline.EMPTY;
            if (z) {
                windowIndex = this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex;
            }
            MediaPeriodInfo mediaPeriodInfo = new MediaPeriodInfo(mediaPeriodId, timeline, windowIndex);
            this.mediaPeriodInfoQueue.add(mediaPeriodInfo);
            this.mediaPeriodIdToInfo.put(mediaPeriodId, mediaPeriodInfo);
            this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            if (this.currentPlayerMediaPeriod == null && isMatchingPlayingMediaPeriod(player)) {
                this.currentPlayerMediaPeriod = this.playingMediaPeriod;
            }
            if (this.mediaPeriodInfoQueue.size() == 1) {
                this.readingMediaPeriod = this.playingMediaPeriod;
            }
        }

        public boolean onMediaPeriodReleased(MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            MediaPeriodInfo mediaPeriodInfo;
            MediaPeriodInfo mediaPeriodInfoRemove = this.mediaPeriodIdToInfo.remove(mediaPeriodId);
            if (mediaPeriodInfoRemove == null) {
                return false;
            }
            this.mediaPeriodInfoQueue.remove(mediaPeriodInfoRemove);
            MediaPeriodInfo mediaPeriodInfo2 = this.readingMediaPeriod;
            if (mediaPeriodInfo2 != null && mediaPeriodId.equals(mediaPeriodInfo2.mediaPeriodId)) {
                if (this.mediaPeriodInfoQueue.isEmpty()) {
                    mediaPeriodInfo = (MediaPeriodInfo) Assertions.checkNotNull(this.playingMediaPeriod);
                } else {
                    mediaPeriodInfo = this.mediaPeriodInfoQueue.get(0);
                }
                this.readingMediaPeriod = mediaPeriodInfo;
            }
            if (!this.mediaPeriodInfoQueue.isEmpty()) {
                this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            }
            if (this.currentPlayerMediaPeriod != null || !isMatchingPlayingMediaPeriod(player)) {
                return true;
            }
            this.currentPlayerMediaPeriod = this.playingMediaPeriod;
            return true;
        }

        public void onReadingStarted(MediaSource.MediaPeriodId mediaPeriodId) {
            MediaPeriodInfo mediaPeriodInfo = this.mediaPeriodIdToInfo.get(mediaPeriodId);
            if (mediaPeriodInfo == null) {
                return;
            }
            this.readingMediaPeriod = mediaPeriodInfo;
        }

        private MediaPeriodInfo findMatchingMediaPeriodInQueue(Player player) {
            MediaPeriodInfo mediaPeriodInfo;
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, this.period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - this.period.getPositionInWindowUs());
            for (int i = 0; i < this.mediaPeriodInfoQueue.size(); i++) {
                MediaPeriodInfo mediaPeriodInfo2 = this.mediaPeriodInfoQueue.get(i);
                if (isMatchingMediaPeriod(mediaPeriodInfo2, currentTimeline, player.getCurrentWindowIndex(), uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodInfo2;
                }
            }
            if (this.mediaPeriodInfoQueue.isEmpty() && (mediaPeriodInfo = this.playingMediaPeriod) != null) {
                if (isMatchingMediaPeriod(mediaPeriodInfo, currentTimeline, player.getCurrentWindowIndex(), uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return this.playingMediaPeriod;
                }
            }
            return null;
        }

        private boolean isMatchingPlayingMediaPeriod(Player player) {
            if (this.playingMediaPeriod == null) {
                return false;
            }
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            return isMatchingMediaPeriod(this.playingMediaPeriod, currentTimeline, player.getCurrentWindowIndex(), currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex), player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, this.period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - this.period.getPositionInWindowUs()));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean isMatchingMediaPeriod(com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo r2, com.google.android.exoplayer2.Timeline r3, int r4, java.lang.Object r5, boolean r6, int r7, int r8, int r9) {
            /*
                com.google.android.exoplayer2.Timeline r0 = r2.timeline
                boolean r0 = r0.isEmpty()
                r1 = 0
                if (r0 != 0) goto L3a
                com.google.android.exoplayer2.Timeline r0 = r2.timeline
                boolean r3 = r0.equals(r3)
                if (r3 == 0) goto L3a
                int r3 = r2.windowIndex
                if (r3 != r4) goto L3a
                com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.mediaPeriodId
                java.lang.Object r3 = r3.periodUid
                boolean r3 = r3.equals(r5)
                if (r3 != 0) goto L20
                goto L3a
            L20:
                if (r6 == 0) goto L2c
                com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.mediaPeriodId
                int r4 = r3.adGroupIndex
                if (r4 != r7) goto L2c
                int r3 = r3.adIndexInAdGroup
                if (r3 == r8) goto L39
            L2c:
                if (r6 != 0) goto L3a
                com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.mediaPeriodId
                int r3 = r2.adGroupIndex
                r4 = -1
                if (r3 != r4) goto L3a
                int r2 = r2.nextAdGroupIndex
                if (r2 != r9) goto L3a
            L39:
                r1 = 1
            L3a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodQueueTracker.isMatchingMediaPeriod(com.google.android.exoplayer2.analytics.AnalyticsCollector$MediaPeriodInfo, com.google.android.exoplayer2.Timeline, int, java.lang.Object, boolean, int, int, int):boolean");
        }

        private MediaPeriodInfo updateMediaPeriodInfoToNewTimeline(MediaPeriodInfo info, Timeline newTimeline) {
            int indexOfPeriod = newTimeline.getIndexOfPeriod(info.mediaPeriodId.periodUid);
            if (indexOfPeriod == -1) {
                return info;
            }
            return new MediaPeriodInfo(info.mediaPeriodId, newTimeline, newTimeline.getPeriod(indexOfPeriod, this.period).windowIndex);
        }
    }

    private static final class MediaPeriodInfo {
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final Timeline timeline;
        public final int windowIndex;

        public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline, int windowIndex) {
            this.mediaPeriodId = mediaPeriodId;
            this.timeline = timeline;
            this.windowIndex = windowIndex;
        }
    }
}
