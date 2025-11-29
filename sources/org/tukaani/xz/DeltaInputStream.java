package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.delta.DeltaDecoder;

/* loaded from: classes4.dex */
public class DeltaInputStream extends InputStream {
    private final DeltaDecoder delta;
    private InputStream in;
    private IOException exception = null;
    private final byte[] tempBuf = new byte[1];

    public DeltaInputStream(InputStream inputStream, int i) {
        inputStream.getClass();
        this.in = inputStream;
        this.delta = new DeltaDecoder(i);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException == null) {
            return inputStream.available();
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
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
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 == -1) {
                return -1;
            }
            this.delta.decode(bArr, i, i3);
            return i3;
        } catch (IOException e) {
            this.exception = e;
            throw e;
        }
    }
}
