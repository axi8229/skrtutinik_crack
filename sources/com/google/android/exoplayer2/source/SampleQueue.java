package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes2.dex */
public class SampleQueue implements TrackOutput {
    private int absoluteFirstIndex;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionManager drmSessionManager;
    private final MediaSourceEventDispatcher eventDispatcher;
    private boolean isLastSampleQueued;
    private int length;
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private Format unadjustedUpstreamFormat;
    private Format upstreamCommittedFormat;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private int upstreamSourceId;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int capacity = 1000;
    private int[] sourceIds = new int[1000];
    private long[] offsets = new long[1000];
    private long[] timesUs = new long[1000];
    private int[] flags = new int[1000];
    private int[] sizes = new int[1000];
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private Format[] formats = new Format[1000];
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, MediaSourceEventDispatcher eventDispatcher) {
        this.sampleDataQueue = new SampleDataQueue(allocator);
        this.drmSessionManager = drmSessionManager;
        this.eventDispatcher = eventDispatcher;
    }

    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    public void reset(boolean resetUpstreamFormat) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.upstreamCommittedFormat = null;
        if (resetUpstreamFormat) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void discardUpstreamSamples(int discardFromIndex) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(discardFromIndex));
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    public synchronized boolean isReady(boolean loadingFinished) {
        Format format;
        boolean z = true;
        if (!hasNextSample()) {
            if (!loadingFinished && !this.isLastSampleQueued && ((format = this.upstreamFormat) == null || format == this.downstreamFormat)) {
                z = false;
            }
            return z;
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (this.formats[relativeIndex] != this.downstreamFormat) {
            return true;
        }
        return mayReadSample(relativeIndex);
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired, boolean loadingFinished, long decodeOnlyUntilUs) {
        int sampleMetadata = readSampleMetadata(formatHolder, buffer, formatRequired, loadingFinished, decodeOnlyUntilUs, this.extrasHolder);
        if (sampleMetadata == -4 && !buffer.isEndOfStream() && !buffer.isFlagsOnly()) {
            this.sampleDataQueue.readToBuffer(buffer, this.extrasHolder);
        }
        return sampleMetadata;
    }

    public final synchronized boolean seekTo(int sampleIndex) {
        rewind();
        int i = this.absoluteFirstIndex;
        if (sampleIndex >= i && sampleIndex <= this.length + i) {
            this.readPosition = sampleIndex - i;
            return true;
        }
        return false;
    }

    public final synchronized boolean seekTo(long timeUs, boolean allowTimeBeyondBuffer) {
        rewind();
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && timeUs >= this.timesUs[relativeIndex] && (timeUs <= this.largestQueuedTimestampUs || allowTimeBeyondBuffer)) {
            int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, timeUs, true);
            if (iFindSampleBefore == -1) {
                return false;
            }
            this.readPosition += iFindSampleBefore;
            return true;
        }
        return false;
    }

    public final synchronized int advanceTo(long timeUs) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && timeUs >= this.timesUs[relativeIndex]) {
            int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, timeUs, true);
            if (iFindSampleBefore == -1) {
                return 0;
            }
            this.readPosition += iFindSampleBefore;
            return iFindSampleBefore;
        }
        return 0;
    }

    public final synchronized int advanceToEnd() {
        int i;
        int i2 = this.length;
        i = i2 - this.readPosition;
        this.readPosition = i2;
        return i;
    }

    public final void discardTo(long timeUs, boolean toKeyframe, boolean stopAtReadPosition) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(timeUs, toKeyframe, stopAtReadPosition));
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void setSampleOffsetUs(long sampleOffsetUs) {
        if (this.sampleOffsetUs != sampleOffsetUs) {
            this.sampleOffsetUs = sampleOffsetUs;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener listener) {
        this.upstreamFormatChangeListener = listener;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format unadjustedUpstreamFormat) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(unadjustedUpstreamFormat);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = unadjustedUpstreamFormat;
        boolean upstreamFormat = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !upstreamFormat) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(DataReader input, int length, boolean allowEndOfInput) throws IOException {
        return this.sampleDataQueue.sampleData(input, length, allowEndOfInput);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray buffer, int length) {
        this.sampleDataQueue.sampleData(buffer, length);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long timeUs, int flags, int size, int offset, TrackOutput.CryptoData cryptoData) {
        if (this.upstreamFormatAdjustmentRequired) {
            format((Format) Assertions.checkStateNotNull(this.unadjustedUpstreamFormat));
        }
        long j = timeUs + this.sampleOffsetUs;
        if (this.pendingSplice) {
            if ((flags & 1) == 0 || !attemptSplice(j)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        commitSample(j, flags, (this.sampleDataQueue.getTotalBytesWritten() - size) - offset, size, cryptoData);
    }

    protected final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    protected Format getAdjustedUpstreamFormat(Format format) {
        return (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    private synchronized int readSampleMetadata(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired, boolean loadingFinished, long decodeOnlyUntilUs, SampleExtrasHolder extrasHolder) {
        boolean zHasNextSample;
        try {
            buffer.waitingForKeys = false;
            int relativeIndex = -1;
            while (true) {
                zHasNextSample = hasNextSample();
                if (!zHasNextSample) {
                    break;
                }
                relativeIndex = getRelativeIndex(this.readPosition);
                if (this.timesUs[relativeIndex] >= decodeOnlyUntilUs || !MimeTypes.allSamplesAreSyncSamples(this.formats[relativeIndex].sampleMimeType)) {
                    break;
                }
                this.readPosition++;
            }
            if (!zHasNextSample) {
                if (!loadingFinished && !this.isLastSampleQueued) {
                    Format format = this.upstreamFormat;
                    if (format == null || (!formatRequired && format == this.downstreamFormat)) {
                        return -3;
                    }
                    onFormatResult((Format) Assertions.checkNotNull(format), formatHolder);
                    return -5;
                }
                buffer.setFlags(4);
                return -4;
            }
            if (!formatRequired && this.formats[relativeIndex] == this.downstreamFormat) {
                if (!mayReadSample(relativeIndex)) {
                    buffer.waitingForKeys = true;
                    return -3;
                }
                buffer.setFlags(this.flags[relativeIndex]);
                long j = this.timesUs[relativeIndex];
                buffer.timeUs = j;
                if (j < decodeOnlyUntilUs) {
                    buffer.addFlag(Integer.MIN_VALUE);
                }
                if (buffer.isFlagsOnly()) {
                    return -4;
                }
                extrasHolder.size = this.sizes[relativeIndex];
                extrasHolder.offset = this.offsets[relativeIndex];
                extrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
                this.readPosition++;
                return -4;
            }
            onFormatResult(this.formats[relativeIndex], formatHolder);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        if (Util.areEqual(format, this.upstreamCommittedFormat)) {
            this.upstreamFormat = this.upstreamCommittedFormat;
            return true;
        }
        this.upstreamFormat = format;
        return true;
    }

    private synchronized long discardSampleMetadataTo(long timeUs, boolean toKeyframe, boolean stopAtReadPosition) {
        int i;
        try {
            int i2 = this.length;
            if (i2 != 0) {
                long[] jArr = this.timesUs;
                int i3 = this.relativeFirstIndex;
                if (timeUs >= jArr[i3]) {
                    if (stopAtReadPosition && (i = this.readPosition) != i2) {
                        i2 = i + 1;
                    }
                    int iFindSampleBefore = findSampleBefore(i3, i2, timeUs, toKeyframe);
                    if (iFindSampleBefore == -1) {
                        return -1L;
                    }
                    return discardSamples(iFindSampleBefore);
                }
            }
            return -1L;
        } finally {
        }
    }

    public synchronized long discardSampleMetadataToRead() {
        int i = this.readPosition;
        if (i == 0) {
            return -1L;
        }
        return discardSamples(i);
    }

    private synchronized long discardSampleMetadataToEnd() {
        int i = this.length;
        if (i == 0) {
            return -1L;
        }
        return discardSamples(i);
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.eventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private synchronized void commitSample(long timeUs, int sampleFlags, long offset, int size, TrackOutput.CryptoData cryptoData) {
        try {
            if (this.upstreamKeyframeRequired) {
                if ((sampleFlags & 1) == 0) {
                    return;
                } else {
                    this.upstreamKeyframeRequired = false;
                }
            }
            Assertions.checkState(!this.upstreamFormatRequired);
            this.isLastSampleQueued = (536870912 & sampleFlags) != 0;
            this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, timeUs);
            int relativeIndex = getRelativeIndex(this.length);
            this.timesUs[relativeIndex] = timeUs;
            long[] jArr = this.offsets;
            jArr[relativeIndex] = offset;
            this.sizes[relativeIndex] = size;
            this.flags[relativeIndex] = sampleFlags;
            this.cryptoDatas[relativeIndex] = cryptoData;
            Format[] formatArr = this.formats;
            Format format = this.upstreamFormat;
            formatArr[relativeIndex] = format;
            this.sourceIds[relativeIndex] = this.upstreamSourceId;
            this.upstreamCommittedFormat = format;
            int i = this.length + 1;
            this.length = i;
            int i2 = this.capacity;
            if (i == i2) {
                int i3 = i2 + 1000;
                int[] iArr = new int[i3];
                long[] jArr2 = new long[i3];
                long[] jArr3 = new long[i3];
                int[] iArr2 = new int[i3];
                int[] iArr3 = new int[i3];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i3];
                Format[] formatArr2 = new Format[i3];
                int i4 = this.relativeFirstIndex;
                int i5 = i2 - i4;
                System.arraycopy(jArr, i4, jArr2, 0, i5);
                System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i5);
                System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i5);
                System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i5);
                System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i5);
                System.arraycopy(this.formats, this.relativeFirstIndex, formatArr2, 0, i5);
                System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i5);
                int i6 = this.relativeFirstIndex;
                System.arraycopy(this.offsets, 0, jArr2, i5, i6);
                System.arraycopy(this.timesUs, 0, jArr3, i5, i6);
                System.arraycopy(this.flags, 0, iArr2, i5, i6);
                System.arraycopy(this.sizes, 0, iArr3, i5, i6);
                System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i5, i6);
                System.arraycopy(this.formats, 0, formatArr2, i5, i6);
                System.arraycopy(this.sourceIds, 0, iArr, i5, i6);
                this.offsets = jArr2;
                this.timesUs = jArr3;
                this.flags = iArr2;
                this.sizes = iArr3;
                this.cryptoDatas = cryptoDataArr;
                this.formats = formatArr2;
                this.sourceIds = iArr;
                this.relativeFirstIndex = 0;
                this.capacity = i3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized boolean attemptSplice(long timeUs) {
        if (this.length == 0) {
            return timeUs > this.largestDiscardedTimestampUs;
        }
        if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= timeUs) {
            return false;
        }
        int i = this.length;
        int relativeIndex = getRelativeIndex(i - 1);
        while (i > this.readPosition && this.timesUs[relativeIndex] >= timeUs) {
            i--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        discardUpstreamSampleMetadata(this.absoluteFirstIndex + i);
        return true;
    }

    private long discardUpstreamSampleMetadata(int discardFromIndex) {
        int writeIndex = getWriteIndex() - discardFromIndex;
        boolean z = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i = this.length - writeIndex;
        this.length = i;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        int i2 = this.length;
        if (i2 == 0) {
            return 0L;
        }
        return this.offsets[getRelativeIndex(i2 - 1)] + this.sizes[r8];
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    private void onFormatResult(Format newFormat, FormatHolder outputFormatHolder) {
        DrmSession drmSessionAcquirePlaceholderSession;
        outputFormatHolder.format = newFormat;
        Format format = this.downstreamFormat;
        boolean z = format == null;
        DrmInitData drmInitData = z ? null : format.drmInitData;
        this.downstreamFormat = newFormat;
        DrmInitData drmInitData2 = newFormat.drmInitData;
        outputFormatHolder.drmSession = this.currentDrmSession;
        if (z || !Util.areEqual(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.currentDrmSession;
            Looper looper = (Looper) Assertions.checkNotNull(Looper.myLooper());
            if (drmInitData2 != null) {
                drmSessionAcquirePlaceholderSession = this.drmSessionManager.acquireSession(looper, this.eventDispatcher, drmInitData2);
            } else {
                drmSessionAcquirePlaceholderSession = this.drmSessionManager.acquirePlaceholderSession(looper, MimeTypes.getTrackType(newFormat.sampleMimeType));
            }
            this.currentDrmSession = drmSessionAcquirePlaceholderSession;
            outputFormatHolder.drmSession = drmSessionAcquirePlaceholderSession;
            if (drmSession != null) {
                drmSession.release(this.eventDispatcher);
            }
        }
    }

    private boolean mayReadSample(int relativeReadIndex) {
        DrmSession drmSession = this.currentDrmSession;
        return drmSession == null || drmSession.getState() == 4 || ((this.flags[relativeReadIndex] & pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys());
    }

    private int findSampleBefore(int relativeStartIndex, int length, long timeUs, boolean keyframe) {
        int i = -1;
        for (int i2 = 0; i2 < length && this.timesUs[relativeStartIndex] <= timeUs; i2++) {
            if (!keyframe || (this.flags[relativeStartIndex] & 1) != 0) {
                i = i2;
            }
            relativeStartIndex++;
            if (relativeStartIndex == this.capacity) {
                relativeStartIndex = 0;
            }
        }
        return i;
    }

    private long discardSamples(int discardCount) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(discardCount));
        int i = this.length - discardCount;
        this.length = i;
        this.absoluteFirstIndex += discardCount;
        int i2 = this.relativeFirstIndex + discardCount;
        this.relativeFirstIndex = i2;
        int i3 = this.capacity;
        if (i2 >= i3) {
            this.relativeFirstIndex = i2 - i3;
        }
        int i4 = this.readPosition - discardCount;
        this.readPosition = i4;
        if (i4 < 0) {
            this.readPosition = 0;
        }
        if (i == 0) {
            int i5 = this.relativeFirstIndex;
            if (i5 != 0) {
                i3 = i5;
            }
            return this.offsets[i3 - 1] + this.sizes[r2];
        }
        return this.offsets[this.relativeFirstIndex];
    }

    private long getLargestTimestamp(int length) {
        long jMax = Long.MIN_VALUE;
        if (length == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(length - 1);
        for (int i = 0; i < length; i++) {
            jMax = Math.max(jMax, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return jMax;
    }

    private int getRelativeIndex(int offset) {
        int i = this.relativeFirstIndex + offset;
        int i2 = this.capacity;
        return i < i2 ? i : i - i2;
    }

    static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        SampleExtrasHolder() {
        }
    }
}
