package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

/* loaded from: classes4.dex */
public class LZMAInputStream extends InputStream {
    private ArrayCache arrayCache;
    private InputStream in;
    private LZDecoder lz;
    private LZMADecoder lzma;
    private RangeDecoderFromStream rc;
    private long remainingSize;
    private boolean endReached = false;
    private boolean relaxedEndCondition = false;
    private final byte[] tempBuf = new byte[1];
    private IOException exception = null;

    public LZMAInputStream(InputStream inputStream, long j, byte b, int i) throws IOException {
        initialize(inputStream, j, b, i, null, ArrayCache.getDefaultCache());
    }

    private static int getDictSize(int i) {
        if (i < 0 || i > 2147483632) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (i < 4096) {
            i = 4096;
        }
        return (i + 15) & (-16);
    }

    public static int getMemoryUsage(int i, byte b) throws CorruptedInputException, UnsupportedOptionsException {
        if (i < 0 || i > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        int i2 = b & 255;
        if (i2 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int i3 = i2 % 45;
        int i4 = i3 / 9;
        return getMemoryUsage(i, i3 - (i4 * 9), i4);
    }

    public static int getMemoryUsage(int i, int i2, int i3) {
        if (i2 < 0 || i2 > 8 || i3 < 0 || i3 > 4) {
            throw new IllegalArgumentException("Invalid lc or lp");
        }
        return (getDictSize(i) / 1024) + 10 + ((1536 << (i2 + i3)) / 1024);
    }

    private void initialize(InputStream inputStream, long j, byte b, int i, byte[] bArr, ArrayCache arrayCache) throws IOException {
        if (j < -1) {
            throw new UnsupportedOptionsException("Uncompressed size is too big");
        }
        int i2 = b & 255;
        if (i2 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int i3 = i2 / 45;
        int i4 = i2 - (i3 * 45);
        int i5 = i4 / 9;
        int i6 = i4 - (i5 * 9);
        if (i < 0 || i > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        initialize(inputStream, j, i6, i5, i3, i, bArr, arrayCache);
    }

    private void initialize(InputStream inputStream, long j, int i, int i2, int i3, int i4, byte[] bArr, ArrayCache arrayCache) throws IOException {
        if (j < -1 || i < 0 || i > 8 || i2 < 0 || i2 > 4 || i3 < 0 || i3 > 4) {
            throw new IllegalArgumentException();
        }
        this.in = inputStream;
        this.arrayCache = arrayCache;
        int dictSize = getDictSize(i4);
        if (j >= 0 && dictSize > j) {
            dictSize = getDictSize((int) j);
        }
        this.lz = new LZDecoder(getDictSize(dictSize), bArr, arrayCache);
        RangeDecoderFromStream rangeDecoderFromStream = new RangeDecoderFromStream(inputStream);
        this.rc = rangeDecoderFromStream;
        this.lzma = new LZMADecoder(this.lz, rangeDecoderFromStream, i, i2, i3);
        this.remainingSize = j;
    }

    private void putArraysToCache() {
        LZDecoder lZDecoder = this.lz;
        if (lZDecoder != null) {
            lZDecoder.putArraysToCache(this.arrayCache);
            this.lz = null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.in != null) {
            putArraysToCache();
            try {
                this.in.close();
            } finally {
                this.in = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.endReached) {
            return -1;
        }
        while (i2 > 0) {
            try {
                long j = this.remainingSize;
                this.lz.setLimit((j < 0 || j >= ((long) i2)) ? i2 : (int) j);
                try {
                    this.lzma.decode();
                } catch (CorruptedInputException e) {
                    if (this.remainingSize != -1 || !this.lzma.endMarkerDetected()) {
                        throw e;
                    }
                    this.endReached = true;
                    this.rc.normalize();
                }
                int iFlush = this.lz.flush(bArr, i);
                i += iFlush;
                i2 -= iFlush;
                i4 += iFlush;
                long j2 = this.remainingSize;
                if (j2 >= 0) {
                    long j3 = j2 - iFlush;
                    this.remainingSize = j3;
                    if (j3 == 0) {
                        this.endReached = true;
                    }
                }
                if (this.endReached) {
                    if (this.lz.hasPending() || !(this.relaxedEndCondition || this.rc.isFinished())) {
                        throw new CorruptedInputException();
                    }
                    putArraysToCache();
                    if (i4 == 0) {
                        return -1;
                    }
                    return i4;
                }
            } catch (IOException e2) {
                this.exception = e2;
                throw e2;
            }
        }
        return i4;
    }
}
