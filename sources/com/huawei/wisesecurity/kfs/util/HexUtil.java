package com.huawei.wisesecurity.kfs.util;

import com.huawei.wisesecurity.kfs.exception.CodecException;
import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public final class HexUtil {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static byte[] decodeHex(char[] cArr) throws CodecException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new CodecException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iDigit = Character.digit(cArr[i], 16);
            if (iDigit == -1) {
                throw new CodecException("Illegal hexadecimal character at index " + i);
            }
            int i3 = i + 1;
            int iDigit2 = Character.digit(cArr[i3], 16);
            if (iDigit2 == -1) {
                throw new CodecException("Illegal hexadecimal character at index " + i3);
            }
            i += 2;
            bArr[i2] = (byte) (((iDigit << 4) | iDigit2) & KotlinVersion.MAX_COMPONENT_VALUE);
            i2++;
        }
        return bArr;
    }

    public static byte[] decodeHexString(String str) throws CodecException {
        return decodeHex(str.toCharArray());
    }

    private static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_UPPER : DIGITS_LOWER);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        return new String(encodeHex(bArr, z));
    }
}
