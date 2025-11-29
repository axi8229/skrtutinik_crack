package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final BaseMediaChunkOutput chunkOutput;
    private final T chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    private final Format[] embeddedTrackFormats;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    boolean loadingFinished;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    private final ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;
    private ReleaseCallback<T> releaseCallback;

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int primaryTrackType, int[] embeddedTrackTypes, Format[] embeddedTrackFormats, T chunkSource, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long positionUs, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.primaryTrackType = primaryTrackType;
        int i = 0;
        embeddedTrackTypes = embeddedTrackTypes == null ? new int[0] : embeddedTrackTypes;
        this.embeddedTrackTypes = embeddedTrackTypes;
        this.embeddedTrackFormats = embeddedTrackFormats == null ? new Format[0] : embeddedTrackFormats;
        this.chunkSource = chunkSource;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.loader = new Loader("Loader:ChunkSampleStream");
        this.nextChunkHolder = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        int length = embeddedTrackTypes.length;
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i2 = length + 1;
        int[] iArr = new int[i2];
        SampleQueue[] sampleQueueArr = new SampleQueue[i2];
        SampleQueue sampleQueue = new SampleQueue(allocator, drmSessionManager, eventDispatcher);
        this.primarySampleQueue = sampleQueue;
        iArr[0] = primaryTrackType;
        sampleQueueArr[0] = sampleQueue;
        while (i < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator, DrmSessionManager.getDummyDrmSessionManager(), eventDispatcher);
            this.embeddedSampleQueues[i] = sampleQueue2;
            int i3 = i + 1;
            sampleQueueArr[i3] = sampleQueue2;
            iArr[i3] = this.embeddedTrackTypes[i];
            i = i3;
        }
        this.chunkOutput = new BaseMediaChunkOutput(iArr, sampleQueueArr);
        this.pendingResetPositionUs = positionUs;
        this.lastSeekPositionUs = positionUs;
    }

    public void discardBuffer(long positionUs, boolean toKeyframe) {
        if (isPendingReset()) {
            return;
        }
        int firstIndex = this.primarySampleQueue.getFirstIndex();
        this.primarySampleQueue.discardTo(positionUs, toKeyframe, true);
        int firstIndex2 = this.primarySampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
            int i = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                if (i >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i].discardTo(firstTimestampUs, toKeyframe, this.embeddedTracksSelected[i]);
                i++;
            }
        }
        discardDownstreamMediaChunks(firstIndex2);
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long positionUs, int trackType) {
        for (int i = 0; i < this.embeddedSampleQueues.length; i++) {
            if (this.embeddedTrackTypes[i] == trackType) {
                Assertions.checkState(!this.embeddedTracksSelected[i]);
                this.embeddedTracksSelected[i] = true;
                this.embeddedSampleQueues[i].seekTo(positionUs, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i], i);
            }
        }
        throw new IllegalStateException();
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long jMax = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                lastMediaChunk = this.mediaChunks.get(r2.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            jMax = Math.max(jMax, lastMediaChunk.endTimeUs);
        }
        return Math.max(jMax, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(positionUs, seekParameters);
    }

    public void seekToUs(long positionUs) {
        BaseMediaChunk baseMediaChunk;
        boolean zSeekTo;
        this.lastSeekPositionUs = positionUs;
        if (isPendingReset()) {
            this.pendingResetPositionUs = positionUs;
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mediaChunks.size(); i2++) {
            baseMediaChunk = this.mediaChunks.get(i2);
            long j = baseMediaChunk.startTimeUs;
            if (j == positionUs && baseMediaChunk.clippedStartTimeUs == -9223372036854775807L) {
                break;
            } else {
                if (j > positionUs) {
                    break;
                }
            }
        }
        baseMediaChunk = null;
        if (baseMediaChunk != null) {
            zSeekTo = this.primarySampleQueue.seekTo(baseMediaChunk.getFirstSampleIndex(0));
            this.decodeOnlyUntilPositionUs = 0L;
        } else {
            zSeekTo = this.primarySampleQueue.seekTo(positionUs, positionUs < getNextLoadPositionUs());
            this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
        }
        if (zSeekTo) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), 0);
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].seekTo(positionUs, true);
                i++;
            }
            return;
        }
        this.pendingResetPositionUs = positionUs;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.loader.clearFatalError();
        this.primarySampleQueue.reset();
        SampleQueue[] sampleQueueArr2 = this.embeddedSampleQueues;
        int length2 = sampleQueueArr2.length;
        while (i < length2) {
            sampleQueueArr2[i].reset();
            i++;
        }
    }

    public void release(ReleaseCallback<T> callback) {
        this.releaseCallback = callback;
        this.primarySampleQueue.preRelease();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.preRelease();
        }
        this.loader.release(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.release();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.release();
        }
        ReleaseCallback<T> releaseCallback = this.releaseCallback;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !isPendingReset() && this.primarySampleQueue.isReady(this.loadingFinished);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.primarySampleQueue.maybeThrowError();
        if (this.loader.isLoading()) {
            return;
        }
        this.chunkSource.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) {
        if (isPendingReset()) {
            return -3;
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return this.primarySampleQueue.read(formatHolder, buffer, formatRequired, this.loadingFinished, this.decodeOnlyUntilPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long positionUs) {
        int iAdvanceTo;
        if (isPendingReset()) {
            return 0;
        }
        if (this.loadingFinished && positionUs > this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            iAdvanceTo = this.primarySampleQueue.advanceToEnd();
        } else {
            iAdvanceTo = this.primarySampleQueue.advanceTo(positionUs);
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return iAdvanceTo;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.chunkSource.onChunkLoadCompleted(loadable);
        this.eventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.primaryTrackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.eventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.primaryTrackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        if (released) {
            return;
        }
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long jBytesLoaded = loadable.bytesLoaded();
        boolean zIsMediaChunk = isMediaChunk(loadable);
        int size = this.mediaChunks.size() - 1;
        boolean z = (jBytesLoaded != 0 && zIsMediaChunk && haveReadFromMediaChunk(size)) ? false : true;
        if (!this.chunkSource.onChunkLoadError(loadable, z, error, z ? this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadable.type, loadDurationMs, error, errorCount) : -9223372036854775807L)) {
            loadErrorActionCreateRetryAction = null;
        } else if (z) {
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY;
            if (zIsMediaChunk) {
                Assertions.checkState(discardUpstreamMediaChunksFromIndex(size) == loadable);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
        } else {
            Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            loadErrorActionCreateRetryAction = null;
        }
        if (loadErrorActionCreateRetryAction == null) {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadable.type, loadDurationMs, error, errorCount);
            loadErrorActionCreateRetryAction = retryDelayMsFor != -9223372036854775807L ? Loader.createRetryAction(false, retryDelayMsFor) : Loader.DONT_RETRY_FATAL;
        }
        boolean zIsRetry = loadErrorActionCreateRetryAction.isRetry();
        this.eventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.primaryTrackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, jBytesLoaded, error, !zIsRetry);
        if (!zIsRetry) {
            this.callback.onContinueLoadingRequested(this);
        }
        return loadErrorActionCreateRetryAction;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long positionUs) {
        List<BaseMediaChunk> listEmptyList;
        long j;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        boolean zIsPendingReset = isPendingReset();
        if (zIsPendingReset) {
            listEmptyList = Collections.emptyList();
            j = this.pendingResetPositionUs;
        } else {
            listEmptyList = this.readOnlyMediaChunks;
            j = getLastMediaChunk().endTimeUs;
        }
        this.chunkSource.getNextChunk(positionUs, j, listEmptyList, this.nextChunkHolder);
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        if (isMediaChunk(chunk)) {
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
            if (zIsPendingReset) {
                long j2 = baseMediaChunk.startTimeUs;
                long j3 = this.pendingResetPositionUs;
                if (j2 == j3) {
                    j3 = 0;
                }
                this.decodeOnlyUntilPositionUs = j3;
                this.pendingResetPositionUs = -9223372036854775807L;
            }
            baseMediaChunk.init(this.chunkOutput);
            this.mediaChunks.add(baseMediaChunk);
        } else if (chunk instanceof InitializationChunk) {
            ((InitializationChunk) chunk).init(this.chunkOutput);
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type)));
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.loader.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long positionUs) {
        int size;
        int preferredQueueSize;
        if (this.loader.isLoading() || this.loader.hasFatalError() || isPendingReset() || (size = this.mediaChunks.size()) <= (preferredQueueSize = this.chunkSource.getPreferredQueueSize(positionUs, this.readOnlyMediaChunks))) {
            return;
        }
        while (true) {
            if (preferredQueueSize >= size) {
                preferredQueueSize = size;
                break;
            } else if (!haveReadFromMediaChunk(preferredQueueSize)) {
                break;
            } else {
                preferredQueueSize++;
            }
        }
        if (preferredQueueSize == size) {
            return;
        }
        long j = getLastMediaChunk().endTimeUs;
        BaseMediaChunk baseMediaChunkDiscardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(preferredQueueSize);
        if (this.mediaChunks.isEmpty()) {
            this.pendingResetPositionUs = this.lastSeekPositionUs;
        }
        this.loadingFinished = false;
        this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, baseMediaChunkDiscardUpstreamMediaChunksFromIndex.startTimeUs, j);
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private boolean haveReadFromMediaChunk(int mediaChunkIndex) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(mediaChunkIndex);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i].getReadIndex();
            i++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i));
        return true;
    }

    boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void discardDownstreamMediaChunks(int discardToSampleIndex) {
        int iMin = Math.min(primarySampleIndexToMediaChunkIndex(discardToSampleIndex, 0), this.nextNotifyPrimaryFormatMediaChunkIndex);
        if (iMin > 0) {
            Util.removeRange(this.mediaChunks, 0, iMin);
            this.nextNotifyPrimaryFormatMediaChunkIndex -= iMin;
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        int iPrimarySampleIndexToMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), this.nextNotifyPrimaryFormatMediaChunkIndex - 1);
        while (true) {
            int i = this.nextNotifyPrimaryFormatMediaChunkIndex;
            if (i > iPrimarySampleIndexToMediaChunkIndex) {
                return;
            }
            this.nextNotifyPrimaryFormatMediaChunkIndex = i + 1;
            maybeNotifyPrimaryTrackFormatChanged(i);
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int mediaChunkReadIndex) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(mediaChunkReadIndex);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }

    private int primarySampleIndexToMediaChunkIndex(int primarySampleIndex, int minChunkIndex) {
        do {
            minChunkIndex++;
            if (minChunkIndex >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(minChunkIndex).getFirstSampleIndex(0) <= primarySampleIndex);
        return minChunkIndex - 1;
    }

    private BaseMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r0.size() - 1);
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int chunkIndex) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(chunkIndex);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, chunkIndex, arrayList.size());
        this.nextNotifyPrimaryFormatMediaChunkIndex = Math.max(this.nextNotifyPrimaryFormatMediaChunkIndex, this.mediaChunks.size());
        int i = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i];
            i++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i));
        }
    }

    public final class EmbeddedSampleStream implements SampleStream {
        private final int index;
        private boolean notifiedDownstreamFormat;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        public EmbeddedSampleStream(ChunkSampleStream<T> parent, SampleQueue sampleQueue, int index) {
            this.parent = parent;
            this.sampleQueue = sampleQueue;
            this.index = index;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ChunkSampleStream.this.isPendingReset() && this.sampleQueue.isReady(ChunkSampleStream.this.loadingFinished);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long positionUs) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return 0;
            }
            maybeNotifyDownstreamFormat();
            if (ChunkSampleStream.this.loadingFinished && positionUs > this.sampleQueue.getLargestQueuedTimestampUs()) {
                return this.sampleQueue.advanceToEnd();
            }
            return this.sampleQueue.advanceTo(positionUs);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            maybeNotifyDownstreamFormat();
            SampleQueue sampleQueue = this.sampleQueue;
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            return sampleQueue.read(formatHolder, buffer, formatRequired, chunkSampleStream.loadingFinished, chunkSampleStream.decodeOnlyUntilPositionUs);
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        private void maybeNotifyDownstreamFormat() {
            if (this.notifiedDownstreamFormat) {
                return;
            }
            ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, null, ChunkSampleStream.this.lastSeekPositionUs);
            this.notifiedDownstreamFormat = true;
        }
    }
}
