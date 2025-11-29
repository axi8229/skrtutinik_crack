package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes2.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long fromIndex, long toIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        reset();
    }

    public void reset() {
        this.currentIndex = this.fromIndex - 1;
    }
}
