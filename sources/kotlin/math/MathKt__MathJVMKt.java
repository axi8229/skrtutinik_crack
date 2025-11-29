package kotlin.math;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MathJVM.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\u0002\u0010\b\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t\"\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u000f¨\u0006\u0011"}, d2 = {"", "", "roundToInt", "(D)I", "", "roundToLong", "(D)J", "", "(F)I", "(F)J", "getSign", "(I)I", "getSign$annotations", "(I)V", "sign", "(J)I", "(J)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/math/MathKt")
/* loaded from: classes3.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static int getSign(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    public static int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    public static long roundToLong(float f) {
        return MathKt.roundToLong(f);
    }
}
