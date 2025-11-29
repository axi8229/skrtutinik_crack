package com.google.android.exoplayer2.decoder;

/* loaded from: classes2.dex */
public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedToKeyframeCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;
    public long totalVideoFrameProcessingOffsetUs;
    public int videoFrameProcessingOffsetCount;

    public synchronized void ensureUpdated() {
    }

    public void addVideoFrameProcessingOffsetSample(long sampleUs) {
        addVideoFrameProcessingOffsetSamples(sampleUs, 1);
    }

    private void addVideoFrameProcessingOffsetSamples(long sampleUs, int count) {
        this.totalVideoFrameProcessingOffsetUs += sampleUs;
        this.videoFrameProcessingOffsetCount += count;
    }
}
