package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private PlaybackStats finishedPlaybackStats;
    private boolean isSeeking;
    private boolean isSuppressed;
    private final boolean keepHistory;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private float playbackSpeed;
    private int playbackState;
    private final Map<String, PlaybackStatsTracker> playbackStatsTrackers;
    private final PlaybackSessionManager sessionManager;
    private final Map<String, AnalyticsListener.EventTime> sessionStartEventTimes;

    public interface Callback {
    }

    public PlaybackStatsListener(boolean keepHistory, Callback callback) {
        this.keepHistory = keepHistory;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        this.playbackStatsTrackers = new HashMap();
        this.sessionStartEventTimes = new HashMap();
        this.finishedPlaybackStats = PlaybackStats.EMPTY;
        this.playWhenReady = false;
        this.playbackState = 1;
        this.playbackSpeed = 1.0f;
        this.period = new Timeline.Period();
        defaultPlaybackSessionManager.setListener(this);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String contentSession, String adSession) {
        Assertions.checkState(((MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime.mediaPeriodId)).isAd());
        long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
        long positionInWindowUs = adGroupTimeUs != Long.MIN_VALUE ? this.period.getPositionInWindowUs() + adGroupTimeUs : Long.MIN_VALUE;
        long j = eventTime.realtimeMs;
        Timeline timeline = eventTime.timeline;
        int i = eventTime.windowIndex;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(contentSession))).onInterruptedByAd(new AnalyticsListener.EventTime(j, timeline, i, new MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber, mediaPeriodId.adGroupIndex), C.usToMs(positionInWindowUs), eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int state) {
        this.playbackState = state;
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(str).onPlaybackStateChanged(eventTime, this.playbackState, this.sessionManager.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean playWhenReady, int reason) {
        this.playWhenReady = playWhenReady;
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(str).onPlayWhenReadyChanged(eventTime, playWhenReady, this.sessionManager.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int playbackSuppressionReason) {
        this.isSuppressed = playbackSuppressionReason != 0;
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(str).onIsSuppressedChanged(eventTime, this.isSuppressed, this.sessionManager.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int reason) {
        this.sessionManager.handleTimelineUpdate(eventTime);
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onPositionDiscontinuity(eventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int reason) {
        this.sessionManager.handlePositionDiscontinuity(eventTime, reason);
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onPositionDiscontinuity(eventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(str).onSeekStarted(eventTime, this.sessionManager.belongsToSession(eventTime, str));
        }
        this.isSeeking = true;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(str).onSeekProcessed(eventTime, this.sessionManager.belongsToSession(eventTime, str));
        }
        this.isSeeking = false;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException error) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onFatalError(eventTime, error);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSpeedChanged(AnalyticsListener.EventTime eventTime, float playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
        this.sessionManager.updateSessions(eventTime);
        Iterator<PlaybackStatsTracker> it = this.playbackStatsTrackers.values().iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSpeedChanged(eventTime, playbackSpeed);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onTracksChanged(eventTime, trackSelections);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onLoadStarted(eventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onDownstreamFormatChanged(eventTime, mediaLoadData);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onVideoSizeChanged(eventTime, width, height);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int totalLoadTimeMs, long totalBytesLoaded, long bitrateEstimate) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onBandwidthData(totalLoadTimeMs, totalBytesLoaded);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onAudioUnderrun();
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int droppedFrames, long elapsedMs) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onDroppedVideoFrames(droppedFrames);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onNonFatalError(eventTime, error);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception error) {
        this.sessionManager.updateSessions(eventTime);
        for (String str : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, str)) {
                this.playbackStatsTrackers.get(str).onNonFatalError(eventTime, error);
            }
        }
    }

    private static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private boolean isFinished;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private boolean isSuppressed;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List<long[]> mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private boolean playWhenReady;
        private final long[] playbackStateDurationsMs;
        private final List<PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
        private int playerPlaybackState;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> videoFormatHistory;

        private static boolean isInvalidJoinTransition(int oldState, int newState) {
            return ((oldState != 1 && oldState != 2 && oldState != 14) || newState == 1 || newState == 2 || newState == 14 || newState == 3 || newState == 4 || newState == 9 || newState == 11) ? false : true;
        }

        private static boolean isPausedState(int state) {
            return state == 4 || state == 7;
        }

        private static boolean isReadyState(int state) {
            return state == 3 || state == 4 || state == 9;
        }

        private static boolean isRebufferingState(int state) {
            return state == 6 || state == 7 || state == 10;
        }

        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int state, boolean belongsToPlayback) {
            this.playerPlaybackState = state;
            if (state != 1) {
                this.hasFatalError = false;
            }
            if (state == 1 || state == 4) {
                this.isInterruptedByAd = false;
            }
            maybeUpdatePlaybackState(eventTime, belongsToPlayback);
        }

        public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean playWhenReady, boolean belongsToPlayback) {
            this.playWhenReady = playWhenReady;
            maybeUpdatePlaybackState(eventTime, belongsToPlayback);
        }

        public void onIsSuppressedChanged(AnalyticsListener.EventTime eventTime, boolean isSuppressed, boolean belongsToPlayback) {
            this.isSuppressed = isSuppressed;
            maybeUpdatePlaybackState(eventTime, belongsToPlayback);
        }

        public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime) {
            this.isInterruptedByAd = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onSeekStarted(AnalyticsListener.EventTime eventTime, boolean belongsToPlayback) {
            this.isSeeking = true;
            maybeUpdatePlaybackState(eventTime, belongsToPlayback);
        }

        public void onSeekProcessed(AnalyticsListener.EventTime eventTime, boolean belongsToPlayback) {
            this.isSeeking = false;
            maybeUpdatePlaybackState(eventTime, belongsToPlayback);
        }

        public void onFatalError(AnalyticsListener.EventTime eventTime, Exception error) {
            this.fatalErrorCount++;
            if (this.keepHistory) {
                this.fatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime, error));
            }
            this.hasFatalError = true;
            this.isInterruptedByAd = false;
            this.isSeeking = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onLoadStarted(AnalyticsListener.EventTime eventTime) {
            this.startedLoading = true;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onInterruptedByAd(AnalyticsListener.EventTime eventTime) {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackSelectionArray trackSelections) {
            boolean z = false;
            boolean z2 = false;
            for (TrackSelection trackSelection : trackSelections.getAll()) {
                if (trackSelection != null && trackSelection.length() > 0) {
                    int trackType = MimeTypes.getTrackType(trackSelection.getFormat(0).sampleMimeType);
                    if (trackType == 2) {
                        z = true;
                    } else if (trackType == 1) {
                        z2 = true;
                    }
                }
            }
            if (!z) {
                maybeUpdateVideoFormat(eventTime, null);
            }
            if (z2) {
                return;
            }
            maybeUpdateAudioFormat(eventTime, null);
        }

        public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            int i = mediaLoadData.trackType;
            if (i == 2 || i == 0) {
                maybeUpdateVideoFormat(eventTime, mediaLoadData.trackFormat);
            } else if (i == 1) {
                maybeUpdateAudioFormat(eventTime, mediaLoadData.trackFormat);
            }
        }

        public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int width, int height) {
            Format format = this.currentVideoFormat;
            if (format == null || format.height != -1) {
                return;
            }
            maybeUpdateVideoFormat(eventTime, format.buildUpon().setWidth(width).setHeight(height).build());
        }

        public void onPlaybackSpeedChanged(AnalyticsListener.EventTime eventTime, float playbackSpeed) {
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, eventTime.eventPlaybackPositionMs);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            this.currentPlaybackSpeed = playbackSpeed;
        }

        public void onAudioUnderrun() {
            this.audioUnderruns++;
        }

        public void onDroppedVideoFrames(int droppedFrames) {
            this.droppedFrames += droppedFrames;
        }

        public void onBandwidthData(long timeMs, long bytes) {
            this.bandwidthTimeMs += timeMs;
            this.bandwidthBytes += bytes;
        }

        public void onNonFatalError(AnalyticsListener.EventTime eventTime, Exception error) {
            this.nonFatalErrorCount++;
            if (this.keepHistory) {
                this.nonFatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime, error));
            }
        }

        private void maybeUpdatePlaybackState(AnalyticsListener.EventTime eventTime, boolean belongsToPlayback) {
            int iResolveNewPlaybackState = resolveNewPlaybackState();
            if (iResolveNewPlaybackState == this.currentPlaybackState) {
                return;
            }
            Assertions.checkArgument(eventTime.realtimeMs >= this.currentPlaybackStateStartTimeMs);
            long j = eventTime.realtimeMs;
            long j2 = j - this.currentPlaybackStateStartTimeMs;
            long[] jArr = this.playbackStateDurationsMs;
            int i = this.currentPlaybackState;
            jArr[i] = jArr[i] + j2;
            if (this.firstReportedTimeMs == -9223372036854775807L) {
                this.firstReportedTimeMs = j;
            }
            this.isJoinTimeInvalid |= isInvalidJoinTransition(i, iResolveNewPlaybackState);
            this.hasBeenReady |= isReadyState(iResolveNewPlaybackState);
            this.hasEnded |= iResolveNewPlaybackState == 11;
            if (!isPausedState(this.currentPlaybackState) && isPausedState(iResolveNewPlaybackState)) {
                this.pauseCount++;
            }
            if (iResolveNewPlaybackState == 5) {
                this.seekCount++;
            }
            if (!isRebufferingState(this.currentPlaybackState) && isRebufferingState(iResolveNewPlaybackState)) {
                this.rebufferCount++;
                this.lastRebufferStartTimeMs = eventTime.realtimeMs;
            }
            if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && iResolveNewPlaybackState == 7) {
                this.pauseBufferCount++;
            }
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, belongsToPlayback ? eventTime.eventPlaybackPositionMs : -9223372036854775807L);
            maybeUpdateMaxRebufferTimeMs(eventTime.realtimeMs);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            this.currentPlaybackState = iResolveNewPlaybackState;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            if (this.keepHistory) {
                this.playbackStateHistory.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, iResolveNewPlaybackState));
            }
        }

        private int resolveNewPlaybackState() {
            if (this.isFinished) {
                return this.currentPlaybackState == 11 ? 11 : 15;
            }
            if (this.isSeeking && this.isForeground) {
                return 5;
            }
            if (this.hasFatalError) {
                return 13;
            }
            if (!this.isForeground) {
                return this.startedLoading ? 1 : 0;
            }
            if (this.isInterruptedByAd) {
                return 14;
            }
            int i = this.playerPlaybackState;
            if (i == 4) {
                return 11;
            }
            if (i != 2) {
                if (i == 3) {
                    if (this.playWhenReady) {
                        return this.isSuppressed ? 9 : 3;
                    }
                    return 4;
                }
                if (i != 1 || this.currentPlaybackState == 0) {
                    return this.currentPlaybackState;
                }
                return 12;
            }
            int i2 = this.currentPlaybackState;
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 14) {
                return 2;
            }
            if (i2 == 5 || i2 == 8) {
                return 8;
            }
            if (this.playWhenReady) {
                return this.isSuppressed ? 10 : 6;
            }
            return 7;
        }

        private void maybeUpdateMaxRebufferTimeMs(long nowMs) {
            if (isRebufferingState(this.currentPlaybackState)) {
                long j = nowMs - this.lastRebufferStartTimeMs;
                long j2 = this.maxRebufferTimeMs;
                if (j2 == -9223372036854775807L || j > j2) {
                    this.maxRebufferTimeMs = j;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long realtimeMs, long mediaTimeMs) {
            if (this.keepHistory) {
                if (this.currentPlaybackState != 3) {
                    if (mediaTimeMs == -9223372036854775807L) {
                        return;
                    }
                    if (!this.mediaTimeHistory.isEmpty()) {
                        List<long[]> list = this.mediaTimeHistory;
                        long j = list.get(list.size() - 1)[1];
                        if (j != mediaTimeMs) {
                            this.mediaTimeHistory.add(new long[]{realtimeMs, j});
                        }
                    }
                }
                this.mediaTimeHistory.add(mediaTimeMs == -9223372036854775807L ? guessMediaTimeBasedOnElapsedRealtime(realtimeMs) : new long[]{realtimeMs, mediaTimeMs});
            }
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long realtimeMs) {
            List<long[]> list = this.mediaTimeHistory;
            return new long[]{realtimeMs, list.get(list.size() - 1)[1] + ((long) ((realtimeMs - r0[0]) * this.currentPlaybackSpeed))};
        }

        private void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, Format newFormat) {
            int i;
            int i2;
            if (Util.areEqual(this.currentVideoFormat, newFormat)) {
                return;
            }
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            if (newFormat != null) {
                if (this.initialVideoFormatHeight == -1 && (i2 = newFormat.height) != -1) {
                    this.initialVideoFormatHeight = i2;
                }
                if (this.initialVideoFormatBitrate == -1 && (i = newFormat.bitrate) != -1) {
                    this.initialVideoFormatBitrate = i;
                }
            }
            this.currentVideoFormat = newFormat;
            if (this.keepHistory) {
                this.videoFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, newFormat));
            }
        }

        private void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, Format newFormat) {
            int i;
            if (Util.areEqual(this.currentAudioFormat, newFormat)) {
                return;
            }
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            if (newFormat != null && this.initialAudioFormatBitrate == -1 && (i = newFormat.bitrate) != -1) {
                this.initialAudioFormatBitrate = i;
            }
            this.currentAudioFormat = newFormat;
            if (this.keepHistory) {
                this.audioFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, newFormat));
            }
        }

        private void maybeRecordVideoFormatTime(long nowMs) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j = (long) ((nowMs - this.lastVideoFormatStartTimeMs) * this.currentPlaybackSpeed);
                int i = format.height;
                if (i != -1) {
                    this.videoFormatHeightTimeMs += j;
                    this.videoFormatHeightTimeProduct += i * j;
                }
                int i2 = format.bitrate;
                if (i2 != -1) {
                    this.videoFormatBitrateTimeMs += j;
                    this.videoFormatBitrateTimeProduct += j * i2;
                }
            }
            this.lastVideoFormatStartTimeMs = nowMs;
        }

        private void maybeRecordAudioFormatTime(long nowMs) {
            Format format;
            int i;
            if (this.currentPlaybackState == 3 && (format = this.currentAudioFormat) != null && (i = format.bitrate) != -1) {
                long j = (long) ((nowMs - this.lastAudioFormatStartTimeMs) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j;
                this.audioFormatBitrateTimeProduct += j * i;
            }
            this.lastAudioFormatStartTimeMs = nowMs;
        }
    }
}
