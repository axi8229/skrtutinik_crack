package org.apache.commons.compress.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.LinkOption;

/* loaded from: classes4.dex */
public final class IOUtils {
    public static final LinkOption[] EMPTY_LINK_OPTIONS = new LinkOption[0];
    private static final byte[] SKIP_BUF = new byte[4096];

    public static long skip(InputStream inputStream, long j) throws IOException {
        int fully;
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip == 0) {
                break;
            }
            j2 -= jSkip;
        }
        while (j2 > 0 && (fully = readFully(inputStream, SKIP_BUF, 0, (int) Math.min(j2, 4096L))) >= 1) {
            j2 -= fully;
        }
        return j - j2;
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i2 < 0 || i < 0 || (i3 = i2 + i) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        while (i4 != i2) {
            int i5 = inputStream.read(bArr, i + i4, i2 - i4);
            if (i5 == -1) {
                break;
            }
            i4 += i5;
        }
        return i4;
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        int i = 0;
        while (i < iRemaining) {
            int i2 = readableByteChannel.read(byteBuffer);
            if (i2 <= 0) {
                break;
            } else {
                i += i2;
            }
        }
        if (i < iRemaining) {
            throw new EOFException();
        }
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copyRange(InputStream inputStream, long j, OutputStream outputStream) throws IOException {
        return copyRange(inputStream, j, outputStream, 8024);
    }

    public static long copyRange(InputStream inputStream, long j, OutputStream outputStream, int i) throws IOException {
        int i2;
        if (i < 1) {
            throw new IllegalArgumentException("buffersize must be bigger than 0");
        }
        int iMin = (int) Math.min(i, j);
        byte[] bArr = new byte[iMin];
        long j2 = 0;
        while (j2 < j && -1 != (i2 = inputStream.read(bArr, 0, (int) Math.min(j - j2, iMin)))) {
            outputStream.write(bArr, 0, i2);
            j2 += i2;
        }
        return j2;
    }

    public static byte[] readRange(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyRange(inputStream, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
