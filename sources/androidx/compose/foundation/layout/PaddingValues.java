package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Padding.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR&\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0003\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u000fR&\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0004\u0010 \u0012\u0004\b%\u0010#\u001a\u0004\b$\u0010\u000fR&\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0005\u0010 \u0012\u0004\b'\u0010#\u001a\u0004\b&\u0010\u000fR&\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0006\u0010 \u0012\u0004\b)\u0010#\u001a\u0004\b(\u0010\u000f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "Landroidx/compose/ui/unit/Dp;", "start", "top", "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateLeftPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateTopPadding", "calculateRightPadding-u2uoSUM", "calculateRightPadding", "calculateBottomPadding-D9Ej5fM", "calculateBottomPadding", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getStart-D9Ej5fM", "getStart-D9Ej5fM$annotations", "()V", "getTop-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getEnd-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.PaddingValuesImpl, reason: from toString */
/* loaded from: classes.dex */
public final class PaddingValues implements androidx.compose.foundation.layout.PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValues(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private PaddingValues(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        if (f < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateLeftPadding-u2uoSUM */
    public float mo300calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
    public float getTop() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateRightPadding-u2uoSUM */
    public float mo301calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateBottomPadding-D9Ej5fM, reason: from getter */
    public float getBottom() {
        return this.bottom;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PaddingValues)) {
            return false;
        }
        PaddingValues paddingValues = (PaddingValues) other;
        return Dp.m2104equalsimpl0(this.start, paddingValues.start) && Dp.m2104equalsimpl0(this.top, paddingValues.top) && Dp.m2104equalsimpl0(this.end, paddingValues.end) && Dp.m2104equalsimpl0(this.bottom, paddingValues.bottom);
    }

    public int hashCode() {
        return (((((Dp.m2105hashCodeimpl(this.start) * 31) + Dp.m2105hashCodeimpl(this.top)) * 31) + Dp.m2105hashCodeimpl(this.end)) * 31) + Dp.m2105hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) Dp.m2106toStringimpl(this.start)) + ", top=" + ((Object) Dp.m2106toStringimpl(this.top)) + ", end=" + ((Object) Dp.m2106toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m2106toStringimpl(this.bottom)) + ')';
    }
}
