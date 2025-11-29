package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;

/* loaded from: classes2.dex */
interface MediaCodecAdapter {
    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    MediaFormat getOutputFormat();

    void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags);

    void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags);

    void shutdown();

    void start();
}
