package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: RippleAnimation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\u000b\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "size", "", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleStartRadius", "Landroidx/compose/ui/unit/Density;", "", "bounded", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Dp;", "BoundedRippleExtraRadius", "F", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m2102constructorimpl(10);

    /* renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m693getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m878getWidthimpl(j), Size.m876getHeightimpl(j)) * 0.3f;
    }

    /* renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m692getRippleEndRadiuscSwnlzA(Density density, boolean z, long j) {
        float fM840getDistanceimpl = Offset.m840getDistanceimpl(OffsetKt.Offset(Size.m878getWidthimpl(j), Size.m876getHeightimpl(j))) / 2.0f;
        return z ? fM840getDistanceimpl + density.mo254toPx0680j_4(BoundedRippleExtraRadius) : fM840getDistanceimpl;
    }
}
