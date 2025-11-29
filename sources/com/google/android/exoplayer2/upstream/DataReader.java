package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface DataReader {
    int read(byte[] target, int offset, int length) throws IOException;
}
