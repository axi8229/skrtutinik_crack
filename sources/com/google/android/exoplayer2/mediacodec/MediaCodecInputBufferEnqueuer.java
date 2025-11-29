package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.CryptoInfo;

/* loaded from: classes2.dex */
interface MediaCodecInputBufferEnqueuer {
    void flush();

    void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags);

    void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags);

    void shutdown();

    void start();
}
