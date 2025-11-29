package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsets;", "insets", "union", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;)Landroidx/compose/foundation/layout/WindowInsets;", "exclude", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/layout/PaddingValues;", "", "left", "top", "right", "bottom", "WindowInsets", "(IIII)Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/ui/unit/Dp;", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInsetsKt {
    /* renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m345WindowInsetsa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2102constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2102constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m2102constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m2102constructorimpl(0);
        }
        return m344WindowInsetsa9UjIt4(f, f2, f3, f4);
    }

    public static final WindowInsets union(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new UnionInsets(windowInsets, windowInsets2);
    }

    public static final WindowInsets exclude(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    public static final PaddingValues asPaddingValues(WindowInsets windowInsets, Density density) {
        return new InsetsPaddingValues(windowInsets, density);
    }

    public static final WindowInsets WindowInsets(int i, int i2, int i3, int i4) {
        return new Insets(i, i2, i3, i4);
    }

    /* renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m344WindowInsetsa9UjIt4(float f, float f2, float f3, float f4) {
        return new Insets(f, f2, f3, f4, null);
    }
}
