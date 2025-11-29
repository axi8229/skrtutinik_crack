package androidx.compose.ui.util;

import kotlin.Metadata;

/* compiled from: MathHelpers.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\t\u001a%\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "start", "stop", "fraction", "lerp", "(FFF)F", "x", "fastCbrt", "(F)F", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MathHelpersKt {
    public static final float lerp(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final float fastCbrt(float f) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f) & 8589934591L) / 3)) + 709952852);
        float f2 = fIntBitsToFloat - ((fIntBitsToFloat - (f / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f2 - ((f2 - (f / (f2 * f2))) * 0.33333334f);
    }
}
