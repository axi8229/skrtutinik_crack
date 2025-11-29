package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface ExtractorInput extends DataReader {
    void advancePeekPosition(int length) throws IOException;

    boolean advancePeekPosition(int length, boolean allowEndOfInput) throws IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] target, int offset, int length) throws IOException;

    void peekFully(byte[] target, int offset, int length) throws IOException;

    boolean peekFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws IOException;

    @Override // com.google.android.exoplayer2.upstream.DataReader
    int read(byte[] target, int offset, int length) throws IOException;

    void readFully(byte[] target, int offset, int length) throws IOException;

    boolean readFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws IOException;

    void resetPeekPosition();

    void skipFully(int length) throws IOException;
}
