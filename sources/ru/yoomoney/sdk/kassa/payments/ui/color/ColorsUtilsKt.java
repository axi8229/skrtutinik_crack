package ru.yoomoney.sdk.kassa.payments.ui.color;

import android.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"COLOR_FADE_TINT_BRIGHTNESS_MULTIPLIER", "", "COLOR_FADE_TINT_SATURATION_MULTIPLIER", "COLOR_GHOST_TINT_ALPHA", "", "HSV_ARRAY_SIZE", "HSV_BRIGHTNESS_INDEX", "HSV_SATURATION_INDEX", "getFadeTint", "Landroidx/compose/ui/graphics/Color;", "accentColor", "(I)J", "getGhostTint", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ColorsUtilsKt {
    private static final float COLOR_FADE_TINT_BRIGHTNESS_MULTIPLIER = 0.9f;
    private static final float COLOR_FADE_TINT_SATURATION_MULTIPLIER = 0.5f;
    private static final int COLOR_GHOST_TINT_ALPHA = 33;
    private static final int HSV_ARRAY_SIZE = 3;
    private static final int HSV_BRIGHTNESS_INDEX = 2;
    private static final int HSV_SATURATION_INDEX = 1;

    public static final long getFadeTint(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] * COLOR_FADE_TINT_SATURATION_MULTIPLIER;
        fArr[2] = fArr[2] * COLOR_FADE_TINT_BRIGHTNESS_MULTIPLIER;
        return ColorKt.Color(Color.HSVToColor(fArr));
    }

    public static final long getGhostTint(int i) {
        return ColorKt.Color(ColorUtils.setAlphaComponent(i, 33));
    }
}
