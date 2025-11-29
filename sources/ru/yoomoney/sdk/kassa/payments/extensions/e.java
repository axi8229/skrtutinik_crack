package ru.yoomoney.sdk.kassa.payments.extensions;

import androidx.core.graphics.ColorUtils;

/* loaded from: classes5.dex */
public abstract class e {
    public static final int a(int i) {
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(i, fArr);
        float f = fArr[2];
        if (f > 0.8d) {
            fArr[2] = f - 0.15f;
        } else {
            fArr[2] = f + 0.15f;
        }
        return ColorUtils.HSLToColor(fArr);
    }
}
