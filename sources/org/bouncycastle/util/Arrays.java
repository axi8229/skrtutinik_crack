package org.bouncycastle.util;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position = 0;

        public Iterator(T[] tArr) {
            this.dataArray = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.dataArray.length;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.position;
            T[] tArr = this.dataArray;
            if (i != tArr.length) {
                this.position = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException("Out of elements: " + this.position);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static boolean areEqual(byte[] bArr, byte[] bArr2) {
        return java.util.Arrays.equals(bArr, bArr2);
    }

    public static boolean areEqual(char[] cArr, char[] cArr2) {
        return java.util.Arrays.equals(cArr, cArr2);
    }

    public static boolean areEqual(short[] sArr, short[] sArr2) {
        return java.util.Arrays.equals(sArr, sArr2);
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return concatenate(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return concatenate(bArr, bArr3);
        }
        if (bArr3 == null) {
            return concatenate(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int length = getLength(i, i2);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, length));
        return bArr2;
    }

    public static void fill(byte[] bArr, byte b) {
        java.util.Arrays.fill(bArr, b);
    }

    private static int getLength(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            return i3;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ bArr[length];
        }
    }

    public static int hashCode(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ bArr[i + i2];
        }
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ iArr[length];
        }
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ (sArr[length] & 255);
        }
    }

    public static int hashCode(short[][] sArr) {
        int iHashCode = 0;
        for (int i = 0; i != sArr.length; i++) {
            iHashCode = (iHashCode * 257) + hashCode(sArr[i]);
        }
        return iHashCode;
    }

    public static int hashCode(short[][][] sArr) {
        int iHashCode = 0;
        for (int i = 0; i != sArr.length; i++) {
            iHashCode = (iHashCode * 257) + hashCode(sArr[i]);
        }
        return iHashCode;
    }

    public static byte[] prepend(byte[] bArr, byte b) {
        if (bArr == null) {
            return new byte[]{b};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = b;
        return bArr2;
    }
}
