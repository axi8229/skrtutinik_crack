package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a@\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0015\u0010\u0018\u001a\u00020\u000e*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u001a\u001a\u00020\u0019*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"", "left", "top", "right", "bottom", "radiusX", "radiusY", "Landroidx/compose/ui/geometry/RoundRect;", "RoundRect", "(FFFFFF)Landroidx/compose/ui/geometry/RoundRect;", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "Landroidx/compose/ui/geometry/Rect;", "rect", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "boundingRect", "", "isSimple", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m871RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m828getXimpl(j), CornerRadius.m829getYimpl(j));
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m870RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final boolean isSimple(RoundRect roundRect) {
        return CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m829getYimpl(roundRect.getTopLeftCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m828getXimpl(roundRect.getTopRightCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m829getYimpl(roundRect.getTopRightCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m828getXimpl(roundRect.getBottomRightCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m829getYimpl(roundRect.getBottomRightCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m828getXimpl(roundRect.getBottomLeftCornerRadius()) && CornerRadius.m828getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m829getYimpl(roundRect.getBottomLeftCornerRadius());
    }
}
