package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;

/* compiled from: IntSize.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0016\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u001e\u0010\u000e\u001a\u00020\n*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"", "width", "height", "Landroidx/compose/ui/unit/IntSize;", "IntSize", "(II)J", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "(J)J", "toSize", "Landroidx/compose/ui/unit/IntOffset;", "getCenter-ozmzZPI", "getCenter-ozmzZPI$annotations", "(J)V", "center", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntSizeKt {
    public static final long IntSize(int i, int i2) {
        return IntSize.m2152constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m2161getCenterozmzZPI(long j) {
        return IntOffset.m2133constructorimpl((((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32));
    }

    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m2162toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m2156getWidthimpl(j), IntSize.m2155getHeightimpl(j));
    }
}
