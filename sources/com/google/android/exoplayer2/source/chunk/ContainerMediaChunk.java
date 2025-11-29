package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ContainerMediaChunk extends BaseMediaChunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = new PositionHolder();
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    protected ChunkExtractorWrapper.TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long startTimeUs, long endTimeUs, long clippedStartTimeUs, long clippedEndTimeUs, long chunkIndex, int chunkCount, long sampleOffsetUs, ChunkExtractorWrapper extractorWrapper) {
        super(dataSource, dataSpec, trackFormat, trackSelectionReason, trackSelectionData, startTimeUs, endTimeUs, clippedStartTimeUs, clippedEndTimeUs, chunkIndex);
        this.chunkCount = chunkCount;
        this.sampleOffsetUs = sampleOffsetUs;
        this.extractorWrapper = extractorWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.chunkCount;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        if (this.nextLoadPosition == 0) {
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.sampleOffsetUs);
            ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrapper;
            ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j = this.clippedStartTimeUs;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.sampleOffsetUs;
            long j3 = this.clippedEndTimeUs;
            chunkExtractorWrapper.init(trackOutputProvider, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.sampleOffsetUs);
        }
        try {
            DataSpec dataSpecSubrange = this.dataSpec.subrange(this.nextLoadPosition);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecSubrange.position, statsDataSource.open(dataSpecSubrange));
            try {
                Extractor extractor = this.extractorWrapper.extractor;
                int i = 0;
                while (i == 0 && !this.loadCanceled) {
                    i = extractor.read(defaultExtractorInput, DUMMY_POSITION_HOLDER);
                }
                Assertions.checkState(i != 1);
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.position;
                Util.closeQuietly(this.dataSource);
                this.loadCompleted = true;
            } catch (Throwable th) {
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.position;
                throw th;
            }
        } catch (Throwable th2) {
            Util.closeQuietly(this.dataSource);
            throw th2;
        }
    }
}
