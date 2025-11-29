package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* loaded from: classes4.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    protected void count(int i) {
        count(i);
    }

    protected void count(long j) {
        if (j != -1) {
            this.bytesRead += j;
        }
    }
}
