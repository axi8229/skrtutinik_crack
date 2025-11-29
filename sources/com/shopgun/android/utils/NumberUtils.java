package com.shopgun.android.utils;

/* loaded from: classes3.dex */
public class NumberUtils {
    public static boolean isEqual(float f, float f2) {
        return isEqual(f, f2, 0.001f);
    }

    public static boolean isEqual(float f, float f2, float f3) {
        return Float.compare(f, f2) == 0 || Math.abs(f - f2) <= f3;
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f, Math.min(f2, f3));
    }
}
