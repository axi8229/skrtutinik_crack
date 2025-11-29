package com.google.android.exoplayer2.decoder;

import java.lang.Exception;

/* loaded from: classes2.dex */
public interface Decoder<I, O, E extends Exception> {
    I dequeueInputBuffer() throws Exception;

    O dequeueOutputBuffer() throws Exception;

    void flush();

    String getName();

    void queueInputBuffer(I inputBuffer) throws Exception;

    void release();

    default void setPlaybackParams(long currentPositionUs, float rendererOperatingRate) {
    }
}
