package com.huawei.location.tiles.utils;

/* loaded from: classes3.dex */
public class E5 {
    private static final int[] yn = {16, 8, 4, 2, 1};

    public static d2 yn(long j) {
        long j2 = j << 5;
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        int i = (((int) (j2 >>> 59)) * 2) + 1;
        boolean z = true;
        int i2 = 0;
        for (int i3 = 1; i3 < 13; i3++) {
            int i4 = (int) (j2 >>> 59);
            j2 <<= 5;
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = yn[i5];
                if (z) {
                    yn(dArr2, i4, i6);
                } else {
                    yn(dArr, i4, i6);
                }
                z = !z;
                i2++;
                if (i2 >= i) {
                    break;
                }
            }
            if (i2 >= i) {
                break;
            }
        }
        return new d2((dArr[0] + dArr[1]) / 2.0d, (dArr2[0] + dArr2[1]) / 2.0d);
    }

    private static void yn(double[] dArr, int i, int i2) {
        if ((i & i2) != 0) {
            dArr[0] = (dArr[0] + dArr[1]) / 2.0d;
        } else {
            dArr[1] = (dArr[0] + dArr[1]) / 2.0d;
        }
    }
}
