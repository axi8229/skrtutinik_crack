package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0016\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"", "width", "height", "Landroidx/compose/ui/geometry/Size;", "Size", "(FF)J", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "toRect", "Landroidx/compose/ui/geometry/Offset;", "getCenter-uvyYCjk", "(J)J", "getCenter-uvyYCjk$annotations", "(J)V", "center", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SizeKt {
    public static final long Size(float f, float f2) {
        return Size.m873constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m886toRectuvyYCjk(long j) {
        return RectKt.m865Recttz77jQw(Offset.INSTANCE.m854getZeroF1C5BW0(), j);
    }

    /* renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m885getCenteruvyYCjk(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return OffsetKt.Offset(Float.intBitsToFloat((int) (j >> 32)) / 2.0f, Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f);
    }
}
