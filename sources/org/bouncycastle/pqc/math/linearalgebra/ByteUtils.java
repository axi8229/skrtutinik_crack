package org.bouncycastle.pqc.math.linearalgebra;

/* loaded from: classes4.dex */
public final class ByteUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] fromHexString(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i = 0;
        for (char c : charArray) {
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
                i++;
            }
        }
        byte[] bArr = new byte[(i + 1) >> 1];
        int i2 = i & 1;
        for (char c2 : charArray) {
            if (c2 >= '0' && c2 <= '9') {
                int i3 = i2 >> 1;
                byte b = (byte) (bArr[i3] << 4);
                bArr[i3] = b;
                bArr[i3] = (byte) ((c2 - '0') | b);
            } else if (c2 >= 'A' && c2 <= 'F') {
                int i4 = i2 >> 1;
                byte b2 = (byte) (bArr[i4] << 4);
                bArr[i4] = b2;
                bArr[i4] = (byte) ((c2 - '7') | b2);
            }
            i2++;
        }
        return bArr;
    }
}
