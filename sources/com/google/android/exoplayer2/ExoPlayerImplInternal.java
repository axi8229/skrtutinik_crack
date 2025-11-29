package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackSpeedListener, PlayerMessage.Sender {
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndex;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private boolean rebuffering;
    private long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private boolean[] rendererWasEnabledFlags;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private boolean throwWhenStuckBuffering;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private SeekParameters seekParameters = SeekParameters.DEFAULT;

    private static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;
    }

    public ExoPlayerImplInternal(Renderer[] renderers, TrackSelector trackSelector, TrackSelectorResult emptyTrackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int repeatMode, boolean shuffleModeEnabled, AnalyticsCollector analyticsCollector, Handler eventHandler, Clock clock) {
        this.renderers = renderers;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = emptyTrackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = repeatMode;
        this.shuffleModeEnabled = shuffleModeEnabled;
        this.eventHandler = eventHandler;
        this.clock = clock;
        this.rendererWasEnabledFlags = new boolean[renderers.length];
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(emptyTrackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new RendererCapabilities[renderers.length];
        for (int i = 0; i < renderers.length; i++) {
            renderers[i].setIndex(i);
            this.rendererCapabilities[i] = renderers[i].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.internalPlaybackThread = handlerThread;
        handlerThread.start();
        this.handler = clock.createHandler(handlerThread.getLooper(), this);
        this.deliverPendingMessageAtStartPositionRequired = true;
        MediaSourceList mediaSourceList = new MediaSourceList(this);
        this.mediaSourceList = mediaSourceList;
        if (analyticsCollector != null) {
            mediaSourceList.setAnalyticsCollector(eventHandler, analyticsCollector);
        }
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public void setRepeatMode(int repeatMode) {
        this.handler.obtainMessage(11, repeatMode, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline, int windowIndex, long positionUs) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, windowIndex, positionUs)).sendToTarget();
    }

    public void setPlaybackSpeed(float playbackSpeed) {
        this.handler.obtainMessage(4, Float.valueOf(playbackSpeed)).sendToTarget();
    }

    public void stop(boolean z) {
        this.handler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> mediaSources, int windowIndex, long positionUs, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(mediaSources, shuffleOrder, windowIndex, positionUs)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage message) {
        if (!this.released && this.internalPlaybackThread.isAlive()) {
            this.handler.obtainMessage(14, message).sendToTarget();
            return;
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        message.markAsProcessed(false);
    }

    public synchronized boolean release() {
        try {
            if (!this.released && this.internalPlaybackThread.isAlive()) {
                this.handler.sendEmptyMessage(7);
                try {
                    long j = this.releaseTimeoutMs;
                    if (j > 0) {
                        waitUntilReleased(j);
                    } else {
                        waitUntilReleased();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                return this.released;
            }
            return true;
        } finally {
        }
    }

    public Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    @Override // com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(final MediaPeriod source) {
        if (this.queue.isLoading(source)) {
            try {
                this.eventHandler.obtainMessage(3, this.queue.getLoadingPeriod().getTrackSelection(this.playbackInfo.timeline)).sendToTarget();
            } catch (ExoPlaybackException e) {
                Log.e("ExoPlayerImplInternal", "onPrepared error: ", e);
            }
        }
        if (this.rendererWasEnabledFlags[1]) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPrepared$0(source);
                }
            });
        } else {
            this.handler.obtainMessage(8, source).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepared$0(final MediaPeriod source) {
        this.handler.obtainMessage(8, source).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod source) {
        this.handler.obtainMessage(9, source).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackSpeedListener
    public void onPlaybackSpeedChanged(float playbackSpeed) {
        sendPlaybackSpeedChangedInternal(playbackSpeed, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleMessage(android.os.Message):boolean");
    }

    private synchronized void waitUntilReleased() throws InterruptedException {
        InterruptedException e = null;
        while (!this.released) {
            try {
                wait();
            } catch (InterruptedException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private synchronized void waitUntilReleased(long timeoutMs) throws InterruptedException {
        long jElapsedRealtime = this.clock.elapsedRealtime() + timeoutMs;
        InterruptedException interruptedException = null;
        while (!this.released && timeoutMs > 0) {
            try {
                wait(timeoutMs);
            } catch (InterruptedException e) {
                interruptedException = e;
            }
            timeoutMs = jElapsedRealtime - this.clock.elapsedRealtime();
        }
        if (interruptedException != null) {
            throw interruptedException;
        }
    }

    private void setState(int state) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != state) {
            this.playbackInfo = playbackInfo.copyWithPlaybackState(state);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.eventHandler.obtainMessage(0, this.playbackInfoUpdate).sendToTarget();
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new MediaSourceList.PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder));
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage addMessage, int insertionIndex) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (insertionIndex == -1) {
            insertionIndex = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(insertionIndex, addMessage.mediaSourceHolders, addMessage.shuffleOrder));
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder));
    }

    private void removeMediaItemsInternal(int fromIndex, int toIndex, ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(fromIndex, toIndex, shuffleOrder));
    }

    private void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline());
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder));
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.rebuffering = false;
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i3 = this.playbackInfo.playbackState;
        if (i3 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean pauseAtEndOfWindow) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = pauseAtEndOfWindow;
        if (this.queue.getReadingPeriod() != this.queue.getPlayingPeriod()) {
            seekToCurrentPosition(true);
        }
        resetPendingPauseAtEndOfPeriod();
        handleLoadingMediaPeriodChanged(false);
    }

    private void setRepeatModeInternal(int repeatMode) throws ExoPlaybackException {
        this.repeatMode = repeatMode;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, repeatMode)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean shuffleModeEnabled) throws ExoPlaybackException {
        this.shuffleModeEnabled = shuffleModeEnabled;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, shuffleModeEnabled)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean sendDiscontinuity) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, this.playbackInfo.requestedContentPositionUs);
            if (sendDiscontinuity) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long discontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            resetRendererPosition(discontinuity);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs);
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        } else {
            long jSyncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = jSyncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(jSyncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            this.playbackInfo.positionUs = periodTime;
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0198 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131 A[LOOP:1: B:91:0x0131->B:98:0x0153, LOOP_START, PHI: r12
  0x0131: PHI (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:90:0x012f, B:98:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doSomeWork() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.doSomeWork():void");
    }

    private void scheduleNextWork(long thisOperationStartTimeMs, long intervalMs) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, thisOperationStartTimeMs + intervalMs);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9 A[Catch: all -> 0x00ac, TryCatch #0 {all -> 0x00ac, blocks: (B:23:0x009f, B:25:0x00a9, B:30:0x00b2, B:32:0x00b8, B:33:0x00bb, B:35:0x00c8, B:37:0x00d2, B:39:0x00da, B:43:0x00e2, B:45:0x00ec, B:47:0x00fe, B:51:0x0107, B:58:0x011f, B:62:0x0128), top: B:76:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r22) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId periodId, long periodPositionUs, boolean forceBufferingState) throws ExoPlaybackException {
        return seekToPeriodPosition(periodId, periodPositionUs, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), forceBufferingState);
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId periodId, long periodPositionUs, boolean forceDisableRenderers, boolean forceBufferingState) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        if (forceBufferingState || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod;
        while (next != null && !periodId.equals(next.info.id)) {
            next = next.getNext();
        }
        if (forceDisableRenderers || playingPeriod != next || (next != null && next.toRendererTime(periodPositionUs) < 0)) {
            for (Renderer renderer : this.renderers) {
                disableRenderer(renderer);
            }
            if (next != null) {
                while (this.queue.getPlayingPeriod() != next) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(next);
                next.setRendererOffset(0L);
                enableRenderers();
            }
        }
        if (next != null) {
            this.queue.removeAfter(next);
            if (!next.prepared) {
                next.info = next.info.copyWithStartPositionUs(periodPositionUs);
            } else {
                long j = next.info.durationUs;
                if (j != -9223372036854775807L && periodPositionUs >= j) {
                    periodPositionUs = Math.max(0L, j - 1);
                }
                if (next.hasEnabledTracks) {
                    periodPositionUs = next.mediaPeriod.seekToUs(periodPositionUs);
                    next.mediaPeriod.discardBuffer(periodPositionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                }
            }
            resetRendererPosition(periodPositionUs);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(periodPositionUs);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return periodPositionUs;
    }

    private void resetRendererPosition(long periodPositionUs) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            periodPositionUs = playingPeriod.toRendererTime(periodPositionUs);
        }
        this.rendererPositionUs = periodPositionUs;
        this.mediaClock.resetPosition(periodPositionUs);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackSpeedInternal(float playbackSpeed) {
        this.mediaClock.setPlaybackSpeed(playbackSpeed);
        sendPlaybackSpeedChangedInternal(this.mediaClock.getPlaybackSpeed(), true);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setForegroundModeInternal(boolean foregroundMode, AtomicBoolean processedFlag) {
        if (this.foregroundMode != foregroundMode) {
            this.foregroundMode = foregroundMode;
            if (!foregroundMode) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (processedFlag != null) {
            synchronized (this) {
                processedFlag.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2, boolean z3) {
        resetInternal(z || !this.foregroundMode, z2, true, z2, z2);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z3 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, true, true, true, false);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void resetInternal(boolean resetRenderers, boolean resetPosition, boolean releaseMediaSourceList, boolean clearMediaSourceList, boolean resetError) {
        Timeline timeline;
        boolean z;
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j;
        long j2;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0L;
        for (Renderer renderer : this.renderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Disable renderer failed.", e);
            }
        }
        if (resetRenderers) {
            for (Renderer renderer2 : this.renderers) {
                try {
                    renderer2.reset();
                } catch (RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.enabledRendererCount = 0;
        Timeline timeline2 = this.playbackInfo.timeline;
        if (clearMediaSourceList) {
            Timeline timelineClear = this.mediaSourceList.clear(null);
            Iterator<PendingMessageInfo> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                it.next().message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
            timeline = timelineClear;
            z = true;
        } else {
            timeline = timeline2;
            z = resetPosition;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.periodId;
        long j3 = playbackInfo.positionUs;
        long j4 = shouldUseRequestedContentPosition(this.playbackInfo, this.period, this.window) ? this.playbackInfo.requestedContentPositionUs : this.playbackInfo.positionUs;
        if (z) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> dummyFirstMediaPeriodPosition = getDummyFirstMediaPeriodPosition(timeline);
            MediaSource.MediaPeriodId mediaPeriodId3 = (MediaSource.MediaPeriodId) dummyFirstMediaPeriodPosition.first;
            long jLongValue = ((Long) dummyFirstMediaPeriodPosition.second).longValue();
            z2 = mediaPeriodId3.equals(this.playbackInfo.periodId) ? clearMediaSourceList : true;
            mediaPeriodId = mediaPeriodId3;
            j = jLongValue;
            j2 = -9223372036854775807L;
        } else {
            z2 = clearMediaSourceList;
            mediaPeriodId = mediaPeriodId2;
            j = j3;
            j2 = j4;
        }
        this.queue.clear();
        this.shouldContinueLoading = false;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = new PlaybackInfo(timeline, mediaPeriodId, j2, playbackInfo2.playbackState, resetError ? null : playbackInfo2.playbackError, false, z2 ? TrackGroupArray.EMPTY : playbackInfo2.trackGroups, z2 ? this.emptyTrackSelectorResult : playbackInfo2.trackSelectorResult, mediaPeriodId, playbackInfo2.playWhenReady, playbackInfo2.playbackSuppressionReason, j, 0L, j);
        if (releaseMediaSourceList) {
            this.mediaSourceList.release();
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getDummyFirstMediaPeriodPosition(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(timeline, periodPosition.first, 0L);
        long jLongValue = ((Long) periodPosition.second).longValue();
        if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, this.period);
            jLongValue = mediaPeriodIdResolveMediaPeriodIdForAds.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(mediaPeriodIdResolveMediaPeriodIdForAds, Long.valueOf(jLongValue));
    }

    private void sendMessageInternal(PlayerMessage message) throws ExoPlaybackException {
        if (message.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(message);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(message));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(message);
        Timeline timeline = this.playbackInfo.timeline;
        if (resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        } else {
            message.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage message) throws ExoPlaybackException {
        if (message.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(message);
            int i = this.playbackInfo.playbackState;
            if (i == 3 || i == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, message).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage message) {
        Handler handler = message.getHandler();
        if (!handler.getLooper().getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            message.markAsProcessed(false);
        } else {
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendMessageToTargetThread$1(message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageToTargetThread$1(final PlayerMessage message) {
        try {
            deliverMessage(message);
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage message) throws ExoPlaybackException {
        if (message.isCanceled()) {
            return;
        }
        try {
            message.getTarget().handleMessage(message.getType(), message.getPayload());
        } finally {
            message.markAsProcessed(true);
        }
    }

    private void resolvePendingMessagePositions(Timeline newTimeline, Timeline previousTimeline) {
        if (newTimeline.isEmpty() && previousTimeline.isEmpty()) {
            return;
        }
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), newTimeline, previousTimeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x003b, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0072, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void maybeTriggerPendingMessages(long r7, long r9) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float playbackSpeed = this.mediaClock.getPlaybackSpeed();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult trackSelectorResultSelectTracks = playingPeriod.selectTracks(playbackSpeed, this.playbackInfo.timeline);
            int i = 0;
            if (trackSelectorResultSelectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (playingPeriod == readingPeriod) {
                    z = false;
                }
            } else {
                if (z) {
                    this.eventHandler.obtainMessage(3, trackSelectorResultSelectTracks).sendToTarget();
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long jApplyTrackSelection = playingPeriod2.applyTrackSelection(trackSelectorResultSelectTracks, this.playbackInfo.positionUs, zRemoveAfter, zArr);
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    PlaybackInfo playbackInfoHandlePositionDiscontinuity = handlePositionDiscontinuity(playbackInfo.periodId, jApplyTrackSelection, playbackInfo.requestedContentPositionUs);
                    this.playbackInfo = playbackInfoHandlePositionDiscontinuity;
                    if (playbackInfoHandlePositionDiscontinuity.playbackState != 4 && jApplyTrackSelection != playbackInfoHandlePositionDiscontinuity.positionUs) {
                        this.playbackInfoUpdate.setPositionDiscontinuity(4);
                        resetRendererPosition(jApplyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        boolean zIsRendererEnabled = isRendererEnabled(renderer);
                        zArr2[i] = zIsRendererEnabled;
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i];
                        if (zIsRendererEnabled) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    enableRenderers(zArr2);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(trackSelectorResultSelectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float playbackSpeed) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (TrackSelection trackSelection : playingPeriod.getTrackSelectorResult().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onPlaybackSpeed(playbackSpeed);
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (TrackSelection trackSelection : playingPeriod.getTrackSelectorResult().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onDiscontinuity();
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean renderersReadyOrEnded) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!renderersReadyOrEnded) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackSpeed(), this.rebuffering);
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady());
    }

    private void maybeThrowSourceInfoRefreshError() throws IOException {
        if (this.queue.getLoadingPeriod() != null) {
            for (Renderer renderer : this.renderers) {
                if (isRendererEnabled(renderer) && !renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
        }
        this.mediaSourceList.maybeThrowSourceInfoRefreshError();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[Catch: all -> 0x005b, TryCatch #2 {all -> 0x005b, blocks: (B:12:0x003d, B:20:0x0057, B:25:0x0063, B:27:0x0073, B:29:0x0079), top: B:73:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #2 {all -> 0x005b, blocks: (B:12:0x003d, B:20:0x0057, B:25:0x0063, B:27:0x0073, B:29:0x0079), top: B:73:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline):void");
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0L;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            this.mediaSourceList.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException, IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                maybeThrowSourceInfoRefreshError();
            } else {
                MediaPeriodHolder mediaPeriodHolderEnqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
                mediaPeriodHolderEnqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
                if (this.queue.getPlayingPeriod() == mediaPeriodHolderEnqueueNextMediaPeriodHolder) {
                    resetRendererPosition(mediaPeriodHolderEnqueueNextMediaPeriodHolder.getStartPositionRendererTime());
                }
                handleLoadingMediaPeriodChanged(false);
            }
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
        } else {
            maybeContinueLoading();
        }
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i = 0;
        if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
            if (!readingPeriod.info.isFinal && !this.pendingPauseAtEndOfPeriod) {
                return;
            }
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i >= rendererArr.length) {
                    return;
                }
                Renderer renderer = rendererArr[i];
                SampleStream sampleStream = readingPeriod.sampleStreams[i];
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    renderer.setCurrentStreamFinal();
                }
                i++;
            }
        } else if (hasReadingPeriodFinishedReading()) {
            if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.getTrackSelectorResult();
                if (mediaPeriodHolderAdvanceReadingPeriod.prepared && mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
                    setAllRendererStreamsFinal();
                    return;
                }
                for (int i2 = 0; i2 < this.renderers.length; i2++) {
                    boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                    boolean zIsRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                    if (zIsRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                        boolean z = this.rendererCapabilities[i2].getTrackType() == 6;
                        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                        RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                        if (!zIsRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                            this.renderers[i2].setCurrentStreamFinal();
                        }
                    }
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersEnabled || !replaceStreamsOrDisableRendererForTransition()) {
            return;
        }
        enableRenderers();
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections.get(i)), readingPeriod.sampleStreams[i], readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodInfo mediaPeriodInfo = this.queue.advancePlayingPeriod().info;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodInfo.id, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(playingPeriod.info.isLastInTimelinePeriod ? 0 : 3);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z = true;
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersEnabled;
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd())) {
                break;
            }
            i++;
        }
        return false;
    }

    private void setAllRendererStreamsFinal() {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                renderer.setCurrentStreamFinal();
            }
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackSpeed(), this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, loadingPeriod.info.startPositionUs, playbackInfo.requestedContentPositionUs);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackSpeed(float f, boolean z) throws ExoPlaybackException {
        this.eventHandler.obtainMessage(1, z ? 1 : 0, 0, Float.valueOf(f)).sendToTarget();
        updateTrackSelectionPlaybackSpeed(f);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setOperatingRate(f);
            }
        }
    }

    private void maybeContinueLoading() {
        boolean zShouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private boolean shouldContinueLoading() {
        long periodTime;
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        if (loadingPeriod == this.queue.getPlayingPeriod()) {
            periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs);
        } else {
            periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        }
        return this.loadControl.shouldContinueLoading(periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackSpeed());
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z);
        }
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long positionUs, long contentPositionUs) {
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && positionUs == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroups = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroups = TrackGroupArray.EMPTY;
            } else {
                trackGroups = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
        } else {
            if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
                trackGroupArray = TrackGroupArray.EMPTY;
                trackSelectorResult = this.emptyTrackSelectorResult;
            }
            return this.playbackInfo.copyWithNewPosition(mediaPeriodId, positionUs, contentPositionUs, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult);
        }
        trackSelectorResult = trackSelectorResult2;
        trackGroupArray = trackGroups;
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, positionUs, contentPositionUs, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult);
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(this.rendererWasEnabledFlags);
    }

    private void enableRenderers(boolean[] rendererWasEnabledFlags) throws ExoPlaybackException {
        Renderer[] rendererArr;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        while (true) {
            rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                break;
            }
            if (!trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].reset();
            }
            i++;
        }
        boolean[] zArr = new boolean[rendererArr.length];
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
            if (zIsRendererEnabled) {
                enableRenderer(i2, rendererWasEnabledFlags[i2]);
            }
            zArr[i2] = zIsRendererEnabled;
        }
        this.rendererWasEnabledFlags = zArr;
        readingPeriod.allRenderersEnabled = true;
    }

    private void enableRenderer(int rendererIndex, boolean wasRendererEnabled) throws ExoPlaybackException {
        Renderer renderer = this.renderers[rendererIndex];
        if (isRendererEnabled(renderer)) {
            return;
        }
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = readingPeriod == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[rendererIndex];
        Format[] formats = getFormats(trackSelectorResult.selections.get(rendererIndex));
        boolean z2 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z3 = !wasRendererEnabled && z2;
        this.enabledRendererCount++;
        renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[rendererIndex], this.rendererPositionUs, z3, z, readingPeriod.getRendererOffset());
        this.mediaClock.onRendererEnabled(renderer);
        if (z2) {
            renderer.start();
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean loadingTrackSelectionChanged) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean zEquals = this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (!zEquals) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((!zEquals || loadingTrackSelectionChanged) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long bufferedPositionInLoadingPeriodUs) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, bufferedPositionInLoadingPeriodUs - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroups, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroups, trackSelectorResult.selections);
    }

    private void sendPlaybackSpeedChangedInternal(float f, boolean z) {
        this.handler.obtainMessage(16, z ? 1 : 0, 0, Float.valueOf(f)).sendToTarget();
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(com.google.android.exoplayer2.Timeline r22, com.google.android.exoplayer2.PlaybackInfo r23, com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r24, com.google.android.exoplayer2.MediaPeriodQueue r25, int r26, boolean r27, com.google.android.exoplayer2.Timeline.Window r28, com.google.android.exoplayer2.Timeline.Period r29) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.resolvePositionForPlaylistChange(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.PlaybackInfo, com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition, com.google.android.exoplayer2.MediaPeriodQueue, int, boolean, com.google.android.exoplayer2.Timeline$Window, com.google.android.exoplayer2.Timeline$Period):com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange");
    }

    private static boolean shouldUseRequestedContentPosition(PlaybackInfo playbackInfo, Timeline.Period period, Timeline.Window window) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, period).windowIndex, window).isPlaceholder;
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline newTimeline, Timeline previousTimeline, int repeatMode, boolean shuffleModeEnabled, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(newTimeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : C.msToUs(pendingMessageInfo.message.getPositionMs())), false, repeatMode, shuffleModeEnabled, window, period);
            if (pairResolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(newTimeline.getIndexOfPeriod(pairResolveSeekPosition.first), ((Long) pairResolveSeekPosition.second).longValue(), pairResolveSeekPosition.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(newTimeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = newTimeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(newTimeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        previousTimeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (previousTimeline.getWindow(period.windowIndex, window).isPlaceholder) {
            Pair<Object, Long> periodPosition = newTimeline.getPeriodPosition(window, period, newTimeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(newTimeline.getIndexOfPeriod(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo messageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(messageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i, period, true).uid;
        long j = period.durationBySegmentsUs;
        messageInfo.setResolvedPosition(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    private static Pair<Object, Long> resolveSeekPosition(Timeline timeline, SeekPosition seekPosition, boolean trySubsequentPeriods, int repeatMode, boolean shuffleModeEnabled, Timeline.Window window, Timeline.Period period) {
        Object objResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            Pair<Object, Long> periodPosition = timeline3.getPeriodPosition(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline.equals(timeline3)) {
                return periodPosition;
            }
            if (timeline.getIndexOfPeriod(periodPosition.first) != -1) {
                timeline3.getPeriodByUid(periodPosition.first, period);
                return timeline3.getWindow(period.windowIndex, window).isPlaceholder ? timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(periodPosition.first, period).windowIndex, seekPosition.windowPositionUs) : periodPosition;
            }
            if (!trySubsequentPeriods || (objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, repeatMode, shuffleModeEnabled, periodPosition.first, timeline3, timeline)) == null) {
                return null;
            }
            return timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex, -9223372036854775807L);
        } catch (IndexOutOfBoundsException e) {
            Log.e("ExoPlayerImplInternal", "getPeriodPosition error: ", e);
            return null;
        }
    }

    static Object resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int repeatMode, boolean shuffleModeEnabled, Object oldPeriodUid, Timeline oldTimeline, Timeline newTimeline) {
        int indexOfPeriod = oldTimeline.getIndexOfPeriod(oldPeriodUid);
        int periodCount = oldTimeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i = 0; i < periodCount && indexOfPeriod2 == -1; i++) {
            nextPeriodIndex = oldTimeline.getNextPeriodIndex(nextPeriodIndex, period, window, repeatMode, shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = newTimeline.getIndexOfPeriod(oldTimeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return null;
        }
        return newTimeline.getUidOfPeriod(indexOfPeriod2);
    }

    private static Format[] getFormats(TrackSelection newSelection) {
        int length = newSelection != null ? newSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = newSelection.getFormat(i);
        }
        return formatArr;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int windowIndex, long windowPositionUs) {
            this.timeline = timeline;
            this.windowIndex = windowIndex;
            this.windowPositionUs = windowPositionUs;
        }
    }

    private static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId periodId, long periodPositionUs, long requestedContentPositionUs, boolean forceBufferingState, boolean endPlayback) {
            this.periodId = periodId;
            this.periodPositionUs = periodPositionUs;
            this.requestedContentPositionUs = requestedContentPositionUs;
            this.forceBufferingState = forceBufferingState;
            this.endPlayback = endPlayback;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage message) {
            this.message = message;
        }

        public void setResolvedPosition(int periodIndex, long periodTimeUs, Object periodUid) {
            this.resolvedPeriodIndex = periodIndex;
            this.resolvedPeriodTimeUs = periodTimeUs;
            this.resolvedPeriodUid = periodUid;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo other) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (other.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - other.resolvedPeriodIndex;
            return i != 0 ? i : Util.compareLong(this.resolvedPeriodTimeUs, other.resolvedPeriodTimeUs);
        }
    }

    private static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> mediaSourceHolders, ShuffleOrder shuffleOrder, int windowIndex, long positionUs) {
            this.mediaSourceHolders = mediaSourceHolders;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = windowIndex;
            this.positionUs = positionUs;
        }
    }

    static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int operationAcks) {
            this.hasPendingChange |= operationAcks > 0;
            this.operationAcks += operationAcks;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int discontinuityReason) {
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                Assertions.checkArgument(discontinuityReason == 4);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = discontinuityReason;
        }

        public void setPlayWhenReadyChangeReason(int playWhenReadyChangeReason) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = playWhenReadyChangeReason;
        }
    }
}
