package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final long continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource dataSource;
    private final DrmSessionManager drmSessionManager;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private boolean haveAudioVideoTracks;
    private IcyHeaders icyHeaders;
    private boolean isLive;
    private long lastSeekPositionUs;
    private final Listener listener;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean loadingFinished;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    private boolean pendingDeferredRetry;
    private boolean prepared;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private boolean released;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private TrackState trackState;
    private final Uri uri;
    private static final Map<String, String> ICY_METADATA_HEADERS = createIcyMetadataHeaders();
    private static final Format ICY_FORMAT = new Format.Builder().setId("icy").setSampleMimeType("application/x-icy").build();
    private final Loader loader = new Loader("Loader:ProgressiveMediaPeriod");
    private final ConditionVariable loadCondition = new ConditionVariable();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ProgressiveMediaPeriod$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.maybeFinishPrepare();
        }
    };
    private final Runnable onContinueLoadingRequestedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ProgressiveMediaPeriod$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private final Handler handler = Util.createHandler();
    private TrackId[] sampleQueueTrackIds = new TrackId[0];
    private SampleQueue[] sampleQueues = new SampleQueue[0];
    private long pendingResetPositionUs = -9223372036854775807L;
    private long length = -1;
    private long durationUs = -9223372036854775807L;
    private int dataType = 1;

    interface Listener {
        void onSourceInfoRefreshed(long durationUs, boolean isSeekable, boolean isLive);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long positionUs) {
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractors, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, Listener listener, Allocator allocator, String customCacheKey, int continueLoadingCheckIntervalBytes) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = customCacheKey;
        this.continueLoadingCheckIntervalBytes = continueLoadingCheckIntervalBytes;
        this.progressiveMediaExtractor = new BundledExtractorsAdapter(extractors);
        eventDispatcher.mediaPeriodCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (this.released) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void release() {
        if (this.prepared) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.release();
        }
        this.progressiveMediaExtractor.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long positionUs) {
        this.callback = callback;
        this.loadCondition.open();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        assertPrepared();
        return this.trackState.tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] selections, boolean[] mayRetainStreamFlags, SampleStream[] streams, boolean[] streamResetFlags, long positionUs) {
        TrackSelection trackSelection;
        assertPrepared();
        TrackState trackState = this.trackState;
        TrackGroupArray trackGroupArray = trackState.tracks;
        boolean[] zArr = trackState.trackEnabledStates;
        int i = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < selections.length; i3++) {
            SampleStream sampleStream = streams[i3];
            if (sampleStream != null && (selections[i3] == null || !mayRetainStreamFlags[i3])) {
                int i4 = ((SampleStreamImpl) sampleStream).track;
                Assertions.checkState(zArr[i4]);
                this.enabledTrackCount--;
                zArr[i4] = false;
                streams[i3] = null;
            }
        }
        boolean z = !this.seenFirstTrackSelection ? positionUs == 0 : i != 0;
        for (int i5 = 0; i5 < selections.length; i5++) {
            if (streams[i5] == null && (trackSelection = selections[i5]) != null) {
                Assertions.checkState(trackSelection.length() == 1);
                Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int iIndexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!zArr[iIndexOf]);
                this.enabledTrackCount++;
                zArr[iIndexOf] = true;
                streams[i5] = new SampleStreamImpl(iIndexOf);
                streamResetFlags[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.sampleQueues[iIndexOf];
                    z = (sampleQueue.seekTo(positionUs, true) || sampleQueue.getReadIndex() == 0) ? false : true;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            positionUs = seekToUs(positionUs);
            while (i2 < streams.length) {
                if (streams[i2] != null) {
                    streamResetFlags[i2] = true;
                }
                i2++;
            }
        }
        this.seenFirstTrackSelection = true;
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long positionUs, boolean toKeyframe) {
        assertPrepared();
        if (isPendingReset()) {
            return;
        }
        boolean[] zArr = this.trackState.trackEnabledStates;
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            this.sampleQueues[i].discardTo(positionUs, toKeyframe, zArr[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long playbackPositionUs) {
        if (this.loadingFinished || this.loader.hasFatalError() || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean zOpen = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return zOpen;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.loader.isLoading() && this.loadCondition.isOpen();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if (!this.notifyDiscontinuity) {
            return -9223372036854775807L;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return -9223372036854775807L;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long largestQueuedTimestampUs;
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length = this.sampleQueues.length;
            largestQueuedTimestampUs = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.sampleQueues[i].isLastSampleQueued()) {
                    largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.sampleQueues[i].getLargestQueuedTimestampUs());
                }
            }
        } else {
            largestQueuedTimestampUs = Long.MAX_VALUE;
        }
        if (largestQueuedTimestampUs == Long.MAX_VALUE) {
            largestQueuedTimestampUs = getLargestQueuedTimestampUs();
        }
        return largestQueuedTimestampUs == Long.MIN_VALUE ? this.lastSeekPositionUs : largestQueuedTimestampUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long positionUs) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (!this.seekMap.isSeekable()) {
            positionUs = 0;
        }
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = positionUs;
        if (isPendingReset()) {
            this.pendingResetPositionUs = positionUs;
            return positionUs;
        }
        if (this.dataType != 7 && seekInsideBufferUs(zArr, positionUs)) {
            return positionUs;
        }
        this.pendingDeferredRetry = false;
        this.pendingResetPositionUs = positionUs;
        this.loadingFinished = false;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            this.loader.clearFatalError();
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
        }
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters) {
        assertPrepared();
        if (!this.seekMap.isSeekable()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(positionUs);
        return seekParameters.resolveSeekPositionUs(positionUs, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    boolean isReady(int track) {
        return !suppressRead() && this.sampleQueues[track].isReady(this.loadingFinished);
    }

    void maybeThrowError(int sampleQueueIndex) throws IOException {
        this.sampleQueues[sampleQueueIndex].maybeThrowError();
        maybeThrowError();
    }

    void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }

    int readData(int sampleQueueIndex, FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(sampleQueueIndex);
        int i = this.sampleQueues[sampleQueueIndex].read(formatHolder, buffer, formatRequired, this.loadingFinished, this.lastSeekPositionUs);
        if (i == -3) {
            maybeStartDeferredRetry(sampleQueueIndex);
        }
        return i;
    }

    int skipData(int track, long positionUs) {
        int iAdvanceTo;
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(track);
        SampleQueue sampleQueue = this.sampleQueues[track];
        if (this.loadingFinished && positionUs > sampleQueue.getLargestQueuedTimestampUs()) {
            iAdvanceTo = sampleQueue.advanceToEnd();
        } else {
            iAdvanceTo = sampleQueue.advanceTo(positionUs);
        }
        if (iAdvanceTo == 0) {
            maybeStartDeferredRetry(track);
        }
        return iAdvanceTo;
    }

    private void maybeNotifyDownstreamFormat(int track) {
        assertPrepared();
        TrackState trackState = this.trackState;
        boolean[] zArr = trackState.trackNotifiedDownstreamFormats;
        if (zArr[track]) {
            return;
        }
        Format format = trackState.tracks.get(track).getFormat(0);
        this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.lastSeekPositionUs);
        zArr[track] = true;
    }

    private void maybeStartDeferredRetry(int track) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[track]) {
            if (this.sampleQueues[track].isReady(false)) {
                return;
            }
            this.pendingResetPositionUs = 0L;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable loadable, long elapsedRealtimeMs, long loadDurationMs) {
        SeekMap seekMap;
        if (this.durationUs == -9223372036854775807L && (seekMap = this.seekMap) != null) {
            boolean zIsSeekable = seekMap.isSeekable();
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            long j = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.durationUs = j;
            this.listener.onSourceInfoRefreshed(j, zIsSeekable, this.isLive);
        }
        this.eventDispatcher.loadCompleted(loadable.dataSpec, loadable.dataSource.getLastOpenedUri(), loadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, loadable.seekTimeUs, this.durationUs, elapsedRealtimeMs, loadDurationMs, loadable.dataSource.getBytesRead());
        copyLengthFromLoader(loadable);
        this.loadingFinished = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.eventDispatcher.loadCanceled(loadable.dataSpec, loadable.dataSource.getLastOpenedUri(), loadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, loadable.seekTimeUs, this.durationUs, elapsedRealtimeMs, loadDurationMs, loadable.dataSource.getBytesRead());
        if (released) {
            return;
        }
        copyLengthFromLoader(loadable);
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        if (this.enabledTrackCount > 0) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ExtractingLoadable loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        boolean z;
        ExtractingLoadable extractingLoadable;
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        copyLengthFromLoader(loadable);
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(this.dataType, loadDurationMs, error, errorCount);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
                extractingLoadable = loadable;
                z = true;
            } else {
                z = false;
                extractingLoadable = loadable;
            }
            loadErrorActionCreateRetryAction = configureRetry(extractingLoadable, extractedSamplesCount) ? Loader.createRetryAction(z, retryDelayMsFor) : Loader.DONT_RETRY;
        }
        this.eventDispatcher.loadError(loadable.dataSpec, loadable.dataSource.getLastOpenedUri(), loadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, loadable.seekTimeUs, this.durationUs, elapsedRealtimeMs, loadDurationMs, loadable.dataSource.getBytesRead(), error, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int id, int type) {
        return prepareTrackOutput(new TrackId(id, false));
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(final SeekMap seekMap) {
        this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ProgressiveMediaPeriod$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$seekMap$1(seekMap);
            }
        });
    }

    TrackOutput icyTrack() {
        return prepareTrackOutput(new TrackId(0, true));
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    private TrackOutput prepareTrackOutput(TrackId id) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (id.equals(this.sampleQueueTrackIds[i])) {
                return this.sampleQueues[i];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator, this.drmSessionManager, this.eventDispatcher);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i2 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.sampleQueueTrackIds, i2);
        trackIdArr[length] = id;
        this.sampleQueueTrackIds = (TrackId[]) Util.castNonNullTypeArray(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i2);
        sampleQueueArr[length] = sampleQueue;
        this.sampleQueues = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setSeekMap, reason: merged with bridge method [inline-methods] */
    public void lambda$seekMap$1(SeekMap seekMap) {
        this.seekMap = this.icyHeaders == null ? seekMap : new SeekMap.Unseekable(-9223372036854775807L);
        if (!this.prepared) {
            maybeFinishPrepare();
        }
        this.durationUs = seekMap.getDurationUs();
        boolean z = this.length == -1 && seekMap.getDurationUs() == -9223372036854775807L;
        this.isLive = z;
        this.dataType = z ? 7 : 1;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap.isSeekable(), this.isLive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Metadata metadataCopyWithAppendedEntries;
        if (this.released || this.prepared || !this.sampleQueuesBuilt || this.seekMap == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        this.loadCondition.close();
        int length = this.sampleQueues.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            Format formatBuild = (Format) Assertions.checkNotNull(this.sampleQueues[i].getUpstreamFormat());
            String str = formatBuild.sampleMimeType;
            boolean zIsAudio = MimeTypes.isAudio(str);
            boolean z = zIsAudio || MimeTypes.isVideo(str);
            zArr[i] = z;
            this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
            IcyHeaders icyHeaders = this.icyHeaders;
            if (icyHeaders != null) {
                if (zIsAudio || this.sampleQueueTrackIds[i].isIcyTrack) {
                    Metadata metadata = formatBuild.metadata;
                    if (metadata == null) {
                        metadataCopyWithAppendedEntries = new Metadata(icyHeaders);
                    } else {
                        metadataCopyWithAppendedEntries = metadata.copyWithAppendedEntries(icyHeaders);
                    }
                    formatBuild = formatBuild.buildUpon().setMetadata(metadataCopyWithAppendedEntries).build();
                }
                if (zIsAudio && formatBuild.averageBitrate == -1 && formatBuild.peakBitrate == -1 && icyHeaders.bitrate != -1) {
                    formatBuild = formatBuild.buildUpon().setAverageBitrate(icyHeaders.bitrate).build();
                }
            }
            trackGroupArr[i] = new TrackGroup(formatBuild);
        }
        this.trackState = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
        this.prepared = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    private void copyLengthFromLoader(ExtractingLoadable loadable) {
        if (this.length == -1) {
            this.length = loadable.length;
        }
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.progressiveMediaExtractor, this, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j = this.durationUs;
            if (j != -9223372036854775807L && this.pendingResetPositionUs > j) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            } else {
                extractingLoadable.setLoadPosition(((SeekMap) Assertions.checkNotNull(this.seekMap)).getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = -9223372036854775807L;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, this.loader.startLoading(extractingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType)));
    }

    private boolean configureRetry(ExtractingLoadable loadable, int currentExtractedSampleCount) {
        SeekMap seekMap;
        if (this.length != -1 || ((seekMap = this.seekMap) != null && seekMap.getDurationUs() != -9223372036854775807L)) {
            this.extractedSamplesCountAtStartOfLoad = currentExtractedSampleCount;
            return true;
        }
        if (this.prepared && !suppressRead()) {
            this.pendingDeferredRetry = true;
            return false;
        }
        this.notifyDiscontinuity = this.prepared;
        this.lastSeekPositionUs = 0L;
        this.extractedSamplesCountAtStartOfLoad = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        loadable.setLoadPosition(0L, 0L);
        return true;
    }

    private boolean seekInsideBufferUs(boolean[] trackIsAudioVideoFlags, long positionUs) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (!this.sampleQueues[i].seekTo(positionUs, false) && (trackIsAudioVideoFlags[i] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    private int getExtractedSamplesCount() {
        int writeIndex = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            writeIndex += sampleQueue.getWriteIndex();
        }
        return writeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLargestQueuedTimestampUs() {
        long jMax = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            jMax = Math.max(jMax, sampleQueue.getLargestQueuedTimestampUs());
        }
        return jMax;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void assertPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackState);
        Assertions.checkNotNull(this.seekMap);
    }

    private final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int track) {
            this.track = track;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ProgressiveMediaPeriod.this.isReady(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            ProgressiveMediaPeriod.this.maybeThrowError(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) {
            return ProgressiveMediaPeriod.this.readData(this.track, formatHolder, buffer, formatRequired);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long positionUs) {
            return ProgressiveMediaPeriod.this.skipData(this.track, positionUs);
        }
    }

    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        private final StatsDataSource dataSource;
        private final ExtractorOutput extractorOutput;
        private TrackOutput icyTrackOutput;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private final ProgressiveMediaExtractor progressiveMediaExtractor;
        private long seekTimeUs;
        private boolean seenIcyMetadata;
        private final Uri uri;
        private final PositionHolder positionHolder = new PositionHolder();
        private boolean pendingExtractorSeek = true;
        private long length = -1;
        private DataSpec dataSpec = buildDataSpec(0);

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable loadCondition) {
            this.uri = uri;
            this.dataSource = new StatsDataSource(dataSource);
            this.progressiveMediaExtractor = progressiveMediaExtractor;
            this.extractorOutput = extractorOutput;
            this.loadCondition = loadCondition;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                try {
                    long j = this.positionHolder.position;
                    DataSpec dataSpecBuildDataSpec = buildDataSpec(j);
                    this.dataSpec = dataSpecBuildDataSpec;
                    long jOpen = this.dataSource.open(dataSpecBuildDataSpec);
                    this.length = jOpen;
                    if (jOpen != -1) {
                        this.length = jOpen + j;
                    }
                    ProgressiveMediaPeriod.this.icyHeaders = IcyHeaders.parse(this.dataSource.getResponseHeaders());
                    DataReader icyDataSource = this.dataSource;
                    if (ProgressiveMediaPeriod.this.icyHeaders != null && ProgressiveMediaPeriod.this.icyHeaders.metadataInterval != -1) {
                        icyDataSource = new IcyDataSource(this.dataSource, ProgressiveMediaPeriod.this.icyHeaders.metadataInterval, this);
                        TrackOutput trackOutputIcyTrack = ProgressiveMediaPeriod.this.icyTrack();
                        this.icyTrackOutput = trackOutputIcyTrack;
                        trackOutputIcyTrack.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    long currentInputPosition = j;
                    this.progressiveMediaExtractor.init(icyDataSource, this.uri, j, this.length, this.extractorOutput);
                    if (ProgressiveMediaPeriod.this.icyHeaders != null) {
                        this.progressiveMediaExtractor.disableSeekingOnMp3Streams();
                    }
                    if (this.pendingExtractorSeek) {
                        this.progressiveMediaExtractor.seek(currentInputPosition, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    while (true) {
                        long j2 = currentInputPosition;
                        while (i == 0 && !this.loadCanceled) {
                            try {
                                this.loadCondition.block();
                                i = this.progressiveMediaExtractor.read(this.positionHolder);
                                currentInputPosition = this.progressiveMediaExtractor.getCurrentInputPosition();
                                if (currentInputPosition > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + j2) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.loadCondition.close();
                        ProgressiveMediaPeriod.this.handler.post(ProgressiveMediaPeriod.this.onContinueLoadingRequestedRunnable);
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly(this.dataSource);
                } catch (Throwable th) {
                    if (i != 1 && this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.IcyDataSource.Listener
        public void onIcyMetadata(ParsableByteArray metadata) {
            long jMax = !this.seenIcyMetadata ? this.seekTimeUs : Math.max(ProgressiveMediaPeriod.this.getLargestQueuedTimestampUs(), this.seekTimeUs);
            int iBytesLeft = metadata.bytesLeft();
            TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.icyTrackOutput);
            trackOutput.sampleData(metadata, iBytesLeft);
            trackOutput.sampleMetadata(jMax, 1, iBytesLeft, 0, null);
            this.seenIcyMetadata = true;
        }

        private DataSpec buildDataSpec(long position) {
            return new DataSpec.Builder().setUri(this.uri).setPosition(position).setKey(ProgressiveMediaPeriod.this.customCacheKey).setFlags(6).setHttpRequestHeaders(ProgressiveMediaPeriod.ICY_METADATA_HEADERS).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoadPosition(long position, long timeUs) {
            this.positionHolder.position = position;
            this.seekTimeUs = timeUs;
            this.pendingExtractorSeek = true;
            this.seenIcyMetadata = false;
        }
    }

    private static final class TrackState {
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public TrackState(TrackGroupArray tracks, boolean[] trackIsAudioVideoFlags) {
            this.tracks = tracks;
            this.trackIsAudioVideoFlags = trackIsAudioVideoFlags;
            int i = tracks.length;
            this.trackEnabledStates = new boolean[i];
            this.trackNotifiedDownstreamFormats = new boolean[i];
        }
    }

    private static final class TrackId {
        public final int id;
        public final boolean isIcyTrack;

        public TrackId(int id, boolean isIcyTrack) {
            this.id = id;
            this.isIcyTrack = isIcyTrack;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            return this.id == trackId.id && this.isIcyTrack == trackId.isIcyTrack;
        }

        public int hashCode() {
            return (this.id * 31) + (this.isIcyTrack ? 1 : 0);
        }
    }

    private static Map<String, String> createIcyMetadataHeaders() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }
}
