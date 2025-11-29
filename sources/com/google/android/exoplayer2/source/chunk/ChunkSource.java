package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters);

    void getNextChunk(long playbackPositionUs, long loadPositionUs, List<? extends MediaChunk> queue, ChunkHolder out);

    int getPreferredQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean cancelable, Exception e, long blacklistDurationMs);
}
