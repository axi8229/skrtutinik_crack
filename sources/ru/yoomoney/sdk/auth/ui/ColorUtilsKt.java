package ru.yoomoney.sdk.auth.ui;

import android.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"HSV_ARRAY_SIZE", "", "HSV_BRIGHTNESS_INDEX", "HSV_SATURATION_INDEX", "adjustSaturationAndBrightness", "saturationMultiplier", "", "brightnessMultiplier", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ColorUtilsKt {
    private static final int HSV_ARRAY_SIZE = 3;
    private static final int HSV_BRIGHTNESS_INDEX = 2;
    private static final int HSV_SATURATION_INDEX = 1;

    public static final int adjustSaturationAndBrightness(int i, float f, float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f2;
        return Color.HSVToColor(fArr);
    }
}
