package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes4.dex */
public class LZMA2Options extends FilterOptions {
    private int depthLimit;
    private int dictSize;
    private int lc;
    private int lp;
    private int mf;
    private int mode;
    private int niceLen;
    private int pb;
    private byte[] presetDict = null;
    private static final int[] presetToDictSize = {262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, 33554432, 67108864};
    private static final int[] presetToDepthLimit = {4, 8, 24, 48};

    public LZMA2Options() {
        try {
            setPreset(6);
        } catch (UnsupportedOptionsException unused) {
            throw new RuntimeException();
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) throws IOException {
        return new LZMA2InputStream(inputStream, this.dictSize, this.presetDict, arrayCache);
    }

    public void setDictSize(int i) throws UnsupportedOptionsException {
        if (i < 4096) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must be at least 4 KiB: " + i + " B");
        }
        if (i <= 805306368) {
            this.dictSize = i;
            return;
        }
        throw new UnsupportedOptionsException("LZMA2 dictionary size must not exceed 768 MiB: " + i + " B");
    }

    public void setLcLp(int i, int i2) throws UnsupportedOptionsException {
        if (i >= 0 && i2 >= 0 && i <= 4 && i2 <= 4 && i + i2 <= 4) {
            this.lc = i;
            this.lp = i2;
            return;
        }
        throw new UnsupportedOptionsException("lc + lp must not exceed 4: " + i + " + " + i2);
    }

    public void setPb(int i) throws UnsupportedOptionsException {
        if (i >= 0 && i <= 4) {
            this.pb = i;
            return;
        }
        throw new UnsupportedOptionsException("pb must not exceed 4: " + i);
    }

    public void setPreset(int i) throws UnsupportedOptionsException {
        if (i < 0 || i > 9) {
            throw new UnsupportedOptionsException("Unsupported preset: " + i);
        }
        this.lc = 3;
        this.lp = 0;
        this.pb = 2;
        this.dictSize = presetToDictSize[i];
        if (i <= 3) {
            this.mode = 1;
            this.mf = 4;
            this.niceLen = i <= 1 ? 128 : 273;
            this.depthLimit = presetToDepthLimit[i];
            return;
        }
        this.mode = 2;
        this.mf = 20;
        this.niceLen = i == 4 ? 16 : i == 5 ? 32 : 64;
        this.depthLimit = 0;
    }
}
