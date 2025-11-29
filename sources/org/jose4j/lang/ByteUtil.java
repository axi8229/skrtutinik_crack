package org.jose4j.lang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class ByteUtil {
    public static final byte[] EMPTY_BYTES = new byte[0];

    public static boolean secureEquals(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = EMPTY_BYTES;
        }
        if (bArr2 == null) {
            bArr2 = EMPTY_BYTES;
        }
        int iMin = Math.min(bArr.length, bArr2.length);
        int iMax = Math.max(bArr.length, bArr2.length);
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0 && iMin == iMax;
    }

    public static byte[] concat(byte[]... bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                byteArrayOutputStream.write(bArr2);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("IOEx from ByteArrayOutputStream?!", e);
        }
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] leftHalf(byte[] bArr) {
        return subArray(bArr, 0, bArr.length / 2);
    }

    public static byte[] rightHalf(byte[] bArr) {
        int length = bArr.length / 2;
        return subArray(bArr, length, length);
    }

    public static int bitLength(byte[] bArr) {
        return bitLength(bArr.length);
    }

    public static int bitLength(int i) {
        if (i <= 268435455 && i >= 0) {
            return i * 8;
        }
        throw new UncheckedJoseException("Invalid byte length (" + i + ") for converting to bit length");
    }

    public static int byteLength(int i) {
        return i / 8;
    }

    public static byte[] randomBytes(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        byte[] bArr = new byte[i];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static byte[] randomBytes(int i) {
        return randomBytes(i, null);
    }
}
