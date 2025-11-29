package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* compiled from: Rect.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "offset", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/geometry/Rect;", "Rect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/Rect;", "Rect", "topLeft", "bottomRight", "Rect-0a9Yr6o", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RectKt {
    /* renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m865Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m842getXimpl(j), Offset.m843getYimpl(j), Offset.m842getXimpl(j) + Size.m878getWidthimpl(j2), Offset.m843getYimpl(j) + Size.m876getHeightimpl(j2));
    }

    /* renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m864Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m842getXimpl(j), Offset.m843getYimpl(j), Offset.m842getXimpl(j2), Offset.m843getYimpl(j2));
    }
}
