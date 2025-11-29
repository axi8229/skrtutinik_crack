package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public final class GoppaCode {
    public static GF2Matrix createCanonicalCheckMatrix(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int degree = gF2mField.getDegree();
        int i = 1 << degree;
        int degree2 = polynomialGF2mSmallM.getDegree();
        int i2 = 0;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, degree2, i);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, degree2, i);
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[0][i3] = gF2mField.inverse(polynomialGF2mSmallM.evaluateAt(i3));
        }
        for (int i4 = 1; i4 < degree2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                iArr2[i4][i5] = gF2mField.mult(iArr2[i4 - 1][i5], i5);
            }
        }
        int i6 = 0;
        while (i6 < degree2) {
            int i7 = i2;
            while (i7 < i) {
                for (int i8 = i2; i8 <= i6; i8++) {
                    int[] iArr3 = iArr[i6];
                    iArr3[i7] = gF2mField.add(iArr3[i7], gF2mField.mult(iArr2[i8][i7], polynomialGF2mSmallM.getCoefficient((degree2 + i8) - i6)));
                }
                i7++;
                i2 = 0;
            }
            i6++;
            i2 = 0;
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, degree2 * degree, (i + 31) >>> 5);
        for (int i9 = 0; i9 < i; i9++) {
            int i10 = i9 >>> 5;
            int i11 = 1 << (i9 & 31);
            for (int i12 = 0; i12 < degree2; i12++) {
                int i13 = iArr[i12][i9];
                for (int i14 = 0; i14 < degree; i14++) {
                    if (((i13 >>> i14) & 1) != 0) {
                        int[] iArr5 = iArr4[(((i12 + 1) * degree) - i14) - 1];
                        iArr5[i10] = iArr5[i10] ^ i11;
                    }
                }
            }
        }
        return new GF2Matrix(i, iArr4);
    }
}
