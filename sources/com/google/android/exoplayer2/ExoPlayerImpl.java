package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
final class ExoPlayerImpl extends BasePlayer implements Player {
    final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingDiscontinuity;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private final MediaSourceFactory mediaSourceFactory;
    private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
    private int pendingDiscontinuityReason;
    private final ArrayDeque<Runnable> pendingListenerNotifications;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private int pendingSetPlaybackSpeedAcks;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private float playbackSpeed;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    @Override // com.google.android.exoplayer2.Player
    public Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.VideoComponent getVideoComponent() {
        return null;
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] renderers, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean useLazyPreparation, Clock clock, Looper looper) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.4] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(renderers.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(renderers);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.mediaSourceFactory = mediaSourceFactory;
        this.useLazyPreparation = useLazyPreparation;
        this.repeatMode = 0;
        this.listeners = new CopyOnWriteArrayList<>();
        this.mediaSourceHolders = new ArrayList();
        this.shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[renderers.length], new TrackSelection[renderers.length], null);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.period = new Timeline.Period();
        this.playbackSpeed = 1.0f;
        this.seekParameters = SeekParameters.DEFAULT;
        this.maskingWindowIndex = -1;
        Handler handler = new Handler(looper) { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                ExoPlayerImpl.this.handleEvent(msg);
            }
        };
        this.eventHandler = handler;
        this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
        this.pendingListenerNotifications = new ArrayDeque<>();
        if (analyticsCollector != null) {
            analyticsCollector.setPlayer(this);
        }
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(renderers, trackSelector, trackSelectorResult, loadControl, bandwidthMeter, this.repeatMode, this.shuffleModeEnabled, analyticsCollector, handler, clock);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.eventHandler.getLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener listener) {
        this.listeners.addIfAbsent(new BasePlayer.ListenerHolder(listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener listener) {
        Iterator<BasePlayer.ListenerHolder> it = this.listeners.iterator();
        while (it.hasNext()) {
            BasePlayer.ListenerHolder next = it.next();
            if (next.listener.equals(listener)) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    @Override // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    public void prepare() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != 1) {
            return;
        }
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(false, true, playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.pendingOperationAcks++;
        this.internalPlayer.prepare();
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> mediaItems, int startWindowIndex, long startPositionMs) {
        setMediaSources(createMediaSources(mediaItems), startWindowIndex, startPositionMs);
    }

    public void setMediaSource(MediaSource mediaSource) {
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public void setMediaSources(List<MediaSource> mediaSources) {
        setMediaSources(mediaSources, true);
    }

    public void setMediaSources(List<MediaSource> mediaSources, boolean resetPosition) {
        setMediaSourcesInternal(mediaSources, -1, -9223372036854775807L, resetPosition);
    }

    public void setMediaSources(List<MediaSource> mediaSources, int startWindowIndex, long startPositionMs) {
        setMediaSourcesInternal(mediaSources, startWindowIndex, startPositionMs, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean playWhenReady) {
        setPlayWhenReady(playWhenReady, 0, 1);
    }

    public void setPlayWhenReady(boolean playWhenReady, int playbackSuppressionReason, int playWhenReadyChangeReason) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playWhenReady == playWhenReady && playbackInfo.playbackSuppressionReason == playbackSuppressionReason) {
            return;
        }
        maskWithCurrentPosition();
        this.pendingOperationAcks++;
        PlaybackInfo playbackInfoCopyWithPlayWhenReady = this.playbackInfo.copyWithPlayWhenReady(playWhenReady, playbackSuppressionReason);
        this.internalPlayer.setPlayWhenReady(playWhenReady, playbackSuppressionReason);
        updatePlaybackInfo(playbackInfoCopyWithPlayWhenReady, false, 4, 0, playWhenReadyChangeReason, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(final int repeatMode) {
        if (this.repeatMode != repeatMode) {
            this.repeatMode = repeatMode;
            this.internalPlayer.setRepeatMode(repeatMode);
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda4
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onRepeatModeChanged(repeatMode);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(final boolean shuffleModeEnabled) {
        if (this.shuffleModeEnabled != shuffleModeEnabled) {
            this.shuffleModeEnabled = shuffleModeEnabled;
            this.internalPlayer.setShuffleModeEnabled(shuffleModeEnabled);
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda5
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onShuffleModeEnabledChanged(shuffleModeEnabled);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int windowIndex, long positionMs) {
        Timeline timeline = this.playbackInfo.timeline;
        if (windowIndex < 0 || (!timeline.isEmpty() && windowIndex >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, windowIndex, positionMs);
        }
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
        } else {
            maskWindowIndexAndPositionForSeek(timeline, windowIndex, positionMs);
            PlaybackInfo playbackInfoCopyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(getPlaybackState() != 1 ? 2 : 1);
            this.internalPlayer.seekTo(timeline, windowIndex, C.msToUs(positionMs));
            updatePlaybackInfo(playbackInfoCopyWithPlaybackState, true, 1, 0, 1, true);
        }
    }

    public void setPlaybackSpeed(final float playbackSpeed) {
        Assertions.checkState(playbackSpeed > 0.0f);
        if (this.playbackSpeed == playbackSpeed) {
            return;
        }
        this.pendingSetPlaybackSpeedAcks++;
        this.playbackSpeed = playbackSpeed;
        final PlaybackParameters playbackParameters = new PlaybackParameters(playbackSpeed);
        this.internalPlayer.setPlaybackSpeed(playbackSpeed);
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda3
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                ExoPlayerImpl.lambda$setPlaybackSpeed$2(playbackParameters, playbackSpeed, eventListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setPlaybackSpeed$2(final PlaybackParameters playbackParameters, final float playbackSpeed, Player.EventListener listener) {
        listener.onPlaybackParametersChanged(playbackParameters);
        listener.onPlaybackSpeedChanged(playbackSpeed);
    }

    @Override // com.google.android.exoplayer2.Player
    public float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean reset) {
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(reset, reset, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(reset);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 0, 1, false);
    }

    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.4] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        if (!this.internalPlayer.release()) {
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    ExoPlayerImpl.lambda$release$3(eventListener);
                }
            });
        }
        this.eventHandler.removeCallbacksAndMessages(null);
        this.playbackInfo = getResetPlaybackInfo(false, false, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$release$3(Player.EventListener listener) {
        listener.onPlayerError(ExoPlaybackException.createForUnexpected(new RuntimeException(new TimeoutException("Player release timed out."))));
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
            playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
            return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
        }
        return getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.periodId.isAd()) {
            return C.usToMs(this.playbackInfo.positionUs);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return periodPositionUsToWindowPositionMs(playbackInfo.periodId, playbackInfo.positionUs);
    }

    public long getPlaybackTimeUtc() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return -9223372036854775807L;
        }
        Timeline.Window window = new Timeline.Window();
        this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), window);
        return window.windowStartTimeMs + getCurrentPosition();
    }

    public long getBufferedPosition() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (playbackInfo.loadingMediaPeriodId.equals(playbackInfo.periodId)) {
                return C.usToMs(this.playbackInfo.bufferedPositionUs);
            }
            return getDuration();
        }
        return getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period);
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.requestedContentPositionUs == -9223372036854775807L) {
                return playbackInfo2.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
            }
            return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.requestedContentPositionUs);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.loadingMediaPeriodId.windowSequenceNumber != playbackInfo.periodId.windowSequenceNumber) {
            return playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j = playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            Timeline.Period periodByUid = playbackInfo2.timeline.getPeriodByUid(playbackInfo2.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationBySegmentsUs : adGroupTimeUs;
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, j);
    }

    public int getRendererCount() {
        return this.renderers.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int index) {
        return this.renderers[index].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    void handleEvent(Message msg) {
        int i = msg.what;
        if (i == 0) {
            handlePlaybackInfo((ExoPlayerImplInternal.PlaybackInfoUpdate) msg.obj);
            return;
        }
        if (i == 1) {
            handlePlaybackSpeed(((Float) msg.obj).floatValue(), msg.arg1 != 0);
        } else {
            if (i == 3) {
                handleSelectTrack((TrackSelectorResult) msg.obj);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private int getCurrentWindowIndexInternal() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    private List<MediaSource> createMediaSources(List<MediaItem> mediaItems) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mediaItems.size(); i++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(mediaItems.get(i)));
        }
        return arrayList;
    }

    private void handlePlaybackSpeed(final float playbackSpeed, boolean operationAck) {
        if (operationAck) {
            this.pendingSetPlaybackSpeedAcks--;
        }
        if (this.pendingSetPlaybackSpeedAcks != 0 || this.playbackSpeed == playbackSpeed) {
            return;
        }
        this.playbackSpeed = playbackSpeed;
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda2
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                ExoPlayerImpl.lambda$handlePlaybackSpeed$4(playbackSpeed, eventListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handlePlaybackSpeed$4(final float playbackSpeed, Player.EventListener listener) {
        listener.onPlaybackParametersChanged(new PlaybackParameters(playbackSpeed));
        listener.onPlaybackSpeedChanged(playbackSpeed);
    }

    private void handleSelectTrack(final TrackSelectorResult trackSelectorResult) {
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                eventListener.onTrackSelected(trackSelectorResult);
            }
        });
    }

    private void handlePlaybackInfo(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        int i = this.pendingOperationAcks - playbackInfoUpdate.operationAcks;
        this.pendingOperationAcks = i;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.hasPendingDiscontinuity = true;
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (i == 0) {
            if (!this.playbackInfo.timeline.isEmpty() && playbackInfoUpdate.playbackInfo.timeline.isEmpty()) {
                resetMaskingPosition();
            }
            boolean z = this.hasPendingDiscontinuity;
            this.hasPendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, z, this.pendingDiscontinuityReason, 1, this.pendingPlayWhenReadyChangeReason, false);
        }
    }

    private PlaybackInfo getResetPlaybackInfo(boolean clearPlaylist, boolean resetError, int playbackState) {
        if (clearPlaylist) {
            removeMediaSourceHolders(0, this.mediaSourceHolders.size());
            resetMaskingPosition();
        } else {
            maskWithCurrentPosition();
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        Timeline timeline = playbackInfo.timeline;
        MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = playbackInfo.periodId;
        long j = playbackInfo.requestedContentPositionUs;
        long j2 = playbackInfo.positionUs;
        if (clearPlaylist) {
            timeline = Timeline.EMPTY;
            dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            j = -9223372036854775807L;
            j2 = 0;
        }
        Timeline timeline2 = timeline;
        MediaSource.MediaPeriodId mediaPeriodId = dummyPeriodForEmptyTimeline;
        long j3 = j;
        long j4 = j2;
        ExoPlaybackException exoPlaybackException = resetError ? null : this.playbackInfo.playbackError;
        TrackGroupArray trackGroupArray = clearPlaylist ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult = clearPlaylist ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return new PlaybackInfo(timeline2, mediaPeriodId, j3, playbackState, exoPlaybackException, false, trackGroupArray, trackSelectorResult, mediaPeriodId, playbackInfo2.playWhenReady, playbackInfo2.playbackSuppressionReason, j4, 0L, j4);
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, int playWhenReadyChangeReason, boolean seekProcessed) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo;
        notifyListeners(new PlaybackInfoUpdate(playbackInfo, playbackInfo2, this.listeners, this.trackSelector, positionDiscontinuity, positionDiscontinuityReason, timelineChangeReason, playWhenReadyChangeReason, seekProcessed));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setMediaSourcesInternal(java.util.List<com.google.android.exoplayer2.source.MediaSource> r17, int r18, long r19, boolean r21) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r1 = r18
            r2 = 0
            r3 = r2
        L8:
            int r4 = r17.size()
            r5 = 1
            if (r3 >= r4) goto L1d
            java.lang.Object r4 = r0.get(r3)
            if (r4 == 0) goto L16
            goto L17
        L16:
            r5 = r2
        L17:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r5)
            int r3 = r3 + 1
            goto L8
        L1d:
            int r3 = r16.getCurrentWindowIndexInternal()
            long r8 = r16.getCurrentPosition()
            int r4 = r7.pendingOperationAcks
            int r4 = r4 + r5
            r7.pendingOperationAcks = r4
            java.util.List<com.google.android.exoplayer2.MediaSourceList$MediaSourceHolder> r4 = r7.mediaSourceHolders
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L3b
            java.util.List<com.google.android.exoplayer2.MediaSourceList$MediaSourceHolder> r4 = r7.mediaSourceHolders
            int r4 = r4.size()
            r7.removeMediaSourceHolders(r2, r4)
        L3b:
            java.util.List r11 = r7.addMediaSourceHolders(r2, r0)
            com.google.android.exoplayer2.PlaybackInfo r0 = r16.maskTimeline()
            com.google.android.exoplayer2.Timeline r4 = r0.timeline
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L51
            int r6 = r4.getWindowCount()
            if (r1 >= r6) goto L54
        L51:
            r12 = r19
            goto L5c
        L54:
            com.google.android.exoplayer2.IllegalSeekPositionException r0 = new com.google.android.exoplayer2.IllegalSeekPositionException
            r12 = r19
            r0.<init>(r4, r1, r12)
            throw r0
        L5c:
            r6 = -1
            if (r21 == 0) goto L6c
            boolean r1 = r7.shuffleModeEnabled
            int r1 = r4.getFirstWindowIndex(r1)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L6a:
            r12 = r1
            goto L72
        L6c:
            if (r1 != r6) goto L70
            r12 = r3
            goto L72
        L70:
            r8 = r12
            goto L6a
        L72:
            if (r12 != r6) goto L75
            goto L76
        L75:
            r2 = r12
        L76:
            r7.maskWindowIndexAndPositionForSeek(r4, r2, r8)
            int r1 = r0.playbackState
            if (r12 == r6) goto L8f
            if (r1 == r5) goto L8f
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L8e
            int r1 = r4.getWindowCount()
            if (r12 < r1) goto L8c
            goto L8e
        L8c:
            r1 = 2
            goto L8f
        L8e:
            r1 = 4
        L8f:
            com.google.android.exoplayer2.PlaybackInfo r1 = r0.copyWithPlaybackState(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal r10 = r7.internalPlayer
            long r13 = com.google.android.exoplayer2.C.msToUs(r8)
            com.google.android.exoplayer2.source.ShuffleOrder r15 = r7.shuffleOrder
            r10.setMediaSources(r11, r12, r13, r15)
            r5 = 1
            r6 = 0
            r2 = 0
            r3 = 4
            r4 = 0
            r0 = r16
            r0.updatePlaybackInfo(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.setMediaSourcesInternal(java.util.List, int, long, boolean):void");
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int index, List<MediaSource> mediaSources) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mediaSources.size(); i++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(mediaSources.get(i), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolders.add(i + index, mediaSourceHolder);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(index, arrayList.size());
        return arrayList;
    }

    private List<MediaSourceList.MediaSourceHolder> removeMediaSourceHolders(int fromIndex, int toIndexExclusive) {
        ArrayList arrayList = new ArrayList();
        for (int i = toIndexExclusive - 1; i >= fromIndex; i--) {
            arrayList.add(this.mediaSourceHolders.remove(i));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(fromIndex, toIndexExclusive);
        return arrayList;
    }

    private PlaybackInfo maskTimeline() {
        return this.playbackInfo.copyWithTimeline(this.mediaSourceHolders.isEmpty() ? Timeline.EMPTY : new MediaSourceList.PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder));
    }

    private void maskWindowIndexAndPositionForSeek(Timeline timeline, int windowIndex, long positionMs) {
        long jMsToUs;
        this.maskingWindowIndex = windowIndex;
        if (timeline.isEmpty()) {
            if (positionMs == -9223372036854775807L) {
                positionMs = 0;
            }
            this.maskingWindowPositionMs = positionMs;
            this.maskingPeriodIndex = 0;
            return;
        }
        if (windowIndex >= timeline.getWindowCount()) {
            maskWithDefaultPosition(timeline);
            return;
        }
        if (positionMs == -9223372036854775807L) {
            jMsToUs = timeline.getWindow(windowIndex, this.window).getDefaultPositionUs();
        } else {
            jMsToUs = C.msToUs(positionMs);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, windowIndex, jMsToUs);
        this.maskingWindowPositionMs = C.usToMs(jMsToUs);
        this.maskingPeriodIndex = timeline.getIndexOfPeriod(periodPosition.first);
    }

    private void maskWithCurrentPosition() {
        this.maskingWindowIndex = getCurrentWindowIndexInternal();
        this.maskingPeriodIndex = getCurrentPeriodIndex();
        this.maskingWindowPositionMs = getCurrentPosition();
    }

    private void maskWithDefaultPosition(Timeline timeline) {
        if (timeline.isEmpty()) {
            resetMaskingPosition();
            return;
        }
        int firstWindowIndex = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
        this.maskingWindowIndex = firstWindowIndex;
        timeline.getWindow(firstWindowIndex, this.window);
        this.maskingWindowPositionMs = this.window.getDefaultPositionMs();
        this.maskingPeriodIndex = this.window.firstPeriodIndex;
    }

    private void resetMaskingPosition() {
        this.maskingWindowIndex = -1;
        this.maskingWindowPositionMs = 0L;
        this.maskingPeriodIndex = 0;
    }

    private void notifyListeners(final BasePlayer.ListenerInvocation listenerInvocation) {
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.listeners);
        notifyListeners(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerImpl.invokeAll(copyOnWriteArrayList, listenerInvocation);
            }
        });
    }

    private void notifyListeners(Runnable listenerNotificationRunnable) {
        boolean zIsEmpty = this.pendingListenerNotifications.isEmpty();
        this.pendingListenerNotifications.addLast(listenerNotificationRunnable);
        if (zIsEmpty) {
            while (!this.pendingListenerNotifications.isEmpty()) {
                this.pendingListenerNotifications.peekFirst().run();
                this.pendingListenerNotifications.removeFirst();
            }
        }
    }

    private long periodPositionUsToWindowPositionMs(MediaSource.MediaPeriodId periodId, long positionUs) {
        long jUsToMs = C.usToMs(positionUs);
        this.playbackInfo.timeline.getPeriodByUid(periodId.periodUid, this.period);
        return jUsToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class PlaybackInfoUpdate implements Runnable {
        private final boolean isLoadingChanged;
        private final boolean isPlayingChanged;
        private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listenerSnapshot;
        private final int playWhenReadyChangeReason;
        private final boolean playWhenReadyChanged;
        private final boolean playbackErrorChanged;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateChanged;
        private final boolean playbackSuppressionReasonChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo, PlaybackInfo previousPlaybackInfo, CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners, TrackSelector trackSelector, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, int playWhenReadyChangeReason, boolean seekProcessed) {
            this.playbackInfo = playbackInfo;
            this.listenerSnapshot = new CopyOnWriteArrayList<>(listeners);
            this.trackSelector = trackSelector;
            this.positionDiscontinuity = positionDiscontinuity;
            this.positionDiscontinuityReason = positionDiscontinuityReason;
            this.timelineChangeReason = timelineChangeReason;
            this.playWhenReadyChangeReason = playWhenReadyChangeReason;
            this.seekProcessed = seekProcessed;
            this.playbackStateChanged = previousPlaybackInfo.playbackState != playbackInfo.playbackState;
            ExoPlaybackException exoPlaybackException = previousPlaybackInfo.playbackError;
            ExoPlaybackException exoPlaybackException2 = playbackInfo.playbackError;
            this.playbackErrorChanged = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.isLoadingChanged = previousPlaybackInfo.isLoading != playbackInfo.isLoading;
            this.timelineChanged = !previousPlaybackInfo.timeline.equals(playbackInfo.timeline);
            this.trackSelectorResultChanged = previousPlaybackInfo.trackSelectorResult != playbackInfo.trackSelectorResult;
            this.playWhenReadyChanged = previousPlaybackInfo.playWhenReady != playbackInfo.playWhenReady;
            this.playbackSuppressionReasonChanged = previousPlaybackInfo.playbackSuppressionReason != playbackInfo.playbackSuppressionReason;
            this.isPlayingChanged = isPlaying(previousPlaybackInfo) != isPlaying(playbackInfo);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.timelineChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda0
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$0(eventListener);
                    }
                });
            }
            if (this.positionDiscontinuity) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda2
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$1(eventListener);
                    }
                });
            }
            if (this.playbackErrorChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda3
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$2(eventListener);
                    }
                });
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda4
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$3(eventListener);
                    }
                });
            }
            if (this.isLoadingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda5
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$4(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged || this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda6
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$5(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda7
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$6(eventListener);
                    }
                });
            }
            if (this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda8
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$7(eventListener);
                    }
                });
            }
            if (this.playbackSuppressionReasonChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda9
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$8(eventListener);
                    }
                });
            }
            if (this.isPlayingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda10
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$9(eventListener);
                    }
                });
            }
            if (this.seekProcessed) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda1
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        eventListener.onSeekProcessed();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Player.EventListener listener) {
            listener.onTimelineChanged(this.playbackInfo.timeline, this.timelineChangeReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(Player.EventListener listener) {
            listener.onPositionDiscontinuity(this.positionDiscontinuityReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2(Player.EventListener listener) {
            listener.onPlayerError(this.playbackInfo.playbackError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$3(Player.EventListener listener) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            listener.onTracksChanged(playbackInfo.trackGroups, playbackInfo.trackSelectorResult.selections);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$4(Player.EventListener listener) {
            listener.onIsLoadingChanged(this.playbackInfo.isLoading);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$5(Player.EventListener listener) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            listener.onPlayerStateChanged(playbackInfo.playWhenReady, playbackInfo.playbackState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$6(Player.EventListener listener) {
            listener.onPlaybackStateChanged(this.playbackInfo.playbackState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$7(Player.EventListener listener) {
            listener.onPlayWhenReadyChanged(this.playbackInfo.playWhenReady, this.playWhenReadyChangeReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$8(Player.EventListener listener) {
            listener.onPlaybackSuppressionReasonChanged(this.playbackInfo.playbackSuppressionReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$9(Player.EventListener listener) {
            listener.onIsPlayingChanged(isPlaying(this.playbackInfo));
        }

        private static boolean isPlaying(PlaybackInfo playbackInfo) {
            return playbackInfo.playbackState == 3 && playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeAll(CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners, BasePlayer.ListenerInvocation listenerInvocation) {
        Iterator<BasePlayer.ListenerHolder> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }
}
