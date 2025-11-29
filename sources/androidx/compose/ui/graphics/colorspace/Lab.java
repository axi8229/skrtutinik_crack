package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: Lab.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010#\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010\u0010\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "id", "<init>", "(Ljava/lang/String;I)V", "component", "", "getMinValue", "(I)F", "getMaxValue", "", "v", "toXyz", "([F)[F", "v0", "v1", "v2", "", "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "fromXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {
    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    public Lab(String str, int i) {
        super(str, ColorModel.INSTANCE.m1116getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        float f = v[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        v[0] = f;
        float f2 = v[1];
        if (f2 < -128.0f) {
            f2 = -128.0f;
        }
        if (f2 > 128.0f) {
            f2 = 128.0f;
        }
        v[1] = f2;
        float f3 = v[2];
        float f4 = f3 >= -128.0f ? f3 : -128.0f;
        float f5 = f4 <= 128.0f ? f4 : 128.0f;
        v[2] = f5;
        float f6 = (f + 16.0f) / 116.0f;
        float f7 = (f2 * 0.002f) + f6;
        float f8 = f6 - (f5 * 0.005f);
        float f9 = f7 > 0.20689656f ? f7 * f7 * f7 : (f7 - 0.13793103f) * 0.12841855f;
        float f10 = f6 > 0.20689656f ? f6 * f6 * f6 : (f6 - 0.13793103f) * 0.12841855f;
        float f11 = f8 > 0.20689656f ? f8 * f8 * f8 : (f8 - 0.13793103f) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        v[0] = f9 * illuminant.getD50Xyz$ui_graphics_release()[0];
        v[1] = f10 * illuminant.getD50Xyz$ui_graphics_release()[1];
        v[2] = f11 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v1 < -128.0f) {
            v1 = -128.0f;
        }
        if (v1 > 128.0f) {
            v1 = 128.0f;
        }
        float f = (v0 + 16.0f) / 116.0f;
        float f2 = (v1 * 0.002f) + f;
        float f3 = f2 > 0.20689656f ? f2 * f2 * f2 : (f2 - 0.13793103f) * 0.12841855f;
        float f4 = f > 0.20689656f ? f * f * f : (f - 0.13793103f) * 0.12841855f;
        float f5 = f3 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        return (Float.floatToRawIntBits(f4 * r5.getD50Xyz$ui_graphics_release()[1]) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v2 < -128.0f) {
            v2 = -128.0f;
        }
        if (v2 > 128.0f) {
            v2 = 128.0f;
        }
        float f = ((v0 + 16.0f) / 116.0f) - (v2 * 0.005f);
        return (f > 0.20689656f ? f * f * f : 0.12841855f * (f - 0.13793103f)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1120xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        Illuminant illuminant = Illuminant.INSTANCE;
        float f = x / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f2 = y / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f3 = z / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f > 0.008856452f ? (float) Math.cbrt(f) : (f * 7.787037f) + 0.13793103f;
        float fCbrt2 = f2 > 0.008856452f ? (float) Math.cbrt(f2) : (f2 * 7.787037f) + 0.13793103f;
        float f4 = (116.0f * fCbrt2) - 16.0f;
        float f5 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f3 > 0.008856452f ? (float) Math.cbrt(f3) : (f3 * 7.787037f) + 0.13793103f)) * 200.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 100.0f) {
            f4 = 100.0f;
        }
        if (f5 < -128.0f) {
            f5 = -128.0f;
        }
        if (f5 > 128.0f) {
            f5 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return ColorKt.Color(f4, f5, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, a, colorSpace);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        float f = v[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f2 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f3 = v[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f4 = v[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f2 > 0.008856452f ? (float) Math.cbrt(f2) : (f2 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f3 > 0.008856452f ? (float) Math.cbrt(f3) : (f3 * 7.787037f) + 0.13793103f;
        float fCbrt3 = f4 > 0.008856452f ? (float) Math.cbrt(f4) : (f4 * 7.787037f) + 0.13793103f;
        float f5 = (116.0f * fCbrt2) - 16.0f;
        float f6 = (fCbrt - fCbrt2) * 500.0f;
        float f7 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 100.0f) {
            f5 = 100.0f;
        }
        v[0] = f5;
        if (f6 < -128.0f) {
            f6 = -128.0f;
        }
        if (f6 > 128.0f) {
            f6 = 128.0f;
        }
        v[1] = f6;
        if (f7 < -128.0f) {
            f7 = -128.0f;
        }
        v[2] = f7 <= 128.0f ? f7 : 128.0f;
        return v;
    }
}
