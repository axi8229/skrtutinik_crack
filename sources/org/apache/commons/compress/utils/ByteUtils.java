package org.apache.commons.compress.utils;

/* loaded from: classes4.dex */
public final class ByteUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static long fromLittleEndian(byte[] bArr, int i, int i2) {
        checkReadLength(i2);
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (bArr[i + i3] & 255) << (i3 * 8);
        }
        return j;
    }

    private static void checkReadLength(int i) {
        if (i > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }
}
