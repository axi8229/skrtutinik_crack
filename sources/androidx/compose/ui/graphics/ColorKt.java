package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\u001a;\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a;\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\t\u001a\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\b\u0010\u000f\u001a\u001e\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0016\u001a\u00020\u0000*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0016\u0010\u0019\u001a\u00020\u000b*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"", "red", "green", "blue", "alpha", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "Color", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "", RemoteMessageConst.Notification.COLOR, "(I)J", "", "(J)J", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeOver", "luminance-8_81llA", "(J)F", "luminance", "toArgb-8_81llA", "(J)I", "toArgb", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:112:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m972constructorimpl(ULong.m2682constructorimpl(ULong.m2682constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m972constructorimpl(ULong.m2682constructorimpl(j << 32));
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m994compositeOverOWjLjI(long j, long j2) {
        long jM973convertvNxB06k = Color.m973convertvNxB06k(j, Color.m980getColorSpaceimpl(j2));
        float fM978getAlphaimpl = Color.m978getAlphaimpl(j2);
        float fM978getAlphaimpl2 = Color.m978getAlphaimpl(jM973convertvNxB06k);
        float f = 1.0f - fM978getAlphaimpl2;
        float f2 = (fM978getAlphaimpl * f) + fM978getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m982getRedimpl(jM973convertvNxB06k) * fM978getAlphaimpl2) + ((Color.m982getRedimpl(j2) * fM978getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m981getGreenimpl(jM973convertvNxB06k) * fM978getAlphaimpl2) + ((Color.m981getGreenimpl(j2) * fM978getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m979getBlueimpl(jM973convertvNxB06k) * fM978getAlphaimpl2) + ((Color.m979getBlueimpl(j2) * fM978getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m980getColorSpaceimpl(j2));
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m995luminance8_81llA(long j) {
        ColorSpace colorSpaceM980getColorSpaceimpl = Color.m980getColorSpaceimpl(j);
        if (!ColorModel.m1112equalsimpl0(colorSpaceM980getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m1117getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m1115toStringimpl(colorSpaceM980getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(colorSpaceM980getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM980getColorSpaceimpl).getEotfFunc();
        float fInvoke = (float) ((eotfFunc$ui_graphics_release.invoke(Color.m982getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m981getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m979getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m996toArgb8_81llA(long j) {
        return (int) ULong.m2682constructorimpl(Color.m973convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }
}
