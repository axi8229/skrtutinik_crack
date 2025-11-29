package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

/* loaded from: classes2.dex */
interface ProgressiveMediaExtractor {
    void disableSeekingOnMp3Streams();

    long getCurrentInputPosition();

    void init(DataReader dataReader, Uri uri, long position, long length, ExtractorOutput output) throws IOException;

    int read(PositionHolder positionHolder) throws IOException;

    void release();

    void seek(long position, long seekTimeUs);
}
