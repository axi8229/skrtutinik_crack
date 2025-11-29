package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0019\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ#\u0010\u001d\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ#\u0010\u001e\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aR(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R(\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R(\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00102\u001a\u00020\u000f*\u00020/8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", "maxWidth", "maxHeight", "", "enforceIncoming", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "F", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "Z", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "targetConstraints", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m341setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m340setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m339setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m338setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m337getTargetConstraintsOenEA2s(Density density) {
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        float f = this.maxWidth;
        Dp.Companion companion = Dp.INSTANCE;
        int i = 0;
        int iCoerceAtLeast3 = !Dp.m2104equalsimpl0(f, companion.m2110getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo248roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int iCoerceAtLeast4 = !Dp.m2104equalsimpl0(this.maxHeight, companion.m2110getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo248roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m2104equalsimpl0(this.minWidth, companion.m2110getUnspecifiedD9Ej5fM()) || (iCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo248roundToPx0680j_4(this.minWidth), iCoerceAtLeast3), 0)) == Integer.MAX_VALUE) {
            iCoerceAtLeast = 0;
        }
        if (!Dp.m2104equalsimpl0(this.minHeight, companion.m2110getUnspecifiedD9Ej5fM()) && (iCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo248roundToPx0680j_4(this.minHeight), iCoerceAtLeast4), 0)) != Integer.MAX_VALUE) {
            i = iCoerceAtLeast2;
        }
        return ConstraintsKt.Constraints(iCoerceAtLeast, iCoerceAtLeast3, i, iCoerceAtLeast4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo105measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iCoerceAtMost;
        int iCoerceAtLeast;
        int iCoerceAtMost2;
        int iCoerceAtLeast2;
        long jConstraints;
        long jM337getTargetConstraintsOenEA2s = m337getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m2096constrainN9IONVI(j, jM337getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.INSTANCE;
            if (!Dp.m2104equalsimpl0(f, companion.m2110getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost = Constraints.m2086getMinWidthimpl(jM337getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost = RangesKt.coerceAtMost(Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(jM337getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2104equalsimpl0(this.maxWidth, companion.m2110getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast = Constraints.m2084getMaxWidthimpl(jM337getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast = RangesKt.coerceAtLeast(Constraints.m2084getMaxWidthimpl(j), Constraints.m2086getMinWidthimpl(jM337getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2104equalsimpl0(this.minHeight, companion.m2110getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost2 = Constraints.m2085getMinHeightimpl(jM337getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost2 = RangesKt.coerceAtMost(Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(jM337getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2104equalsimpl0(this.maxHeight, companion.m2110getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast2 = Constraints.m2083getMaxHeightimpl(jM337getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast2 = RangesKt.coerceAtLeast(Constraints.m2083getMaxHeightimpl(j), Constraints.m2085getMinHeightimpl(jM337getTargetConstraintsOenEA2s));
            }
            jConstraints = ConstraintsKt.Constraints(iCoerceAtMost, iCoerceAtLeast, iCoerceAtMost2, iCoerceAtLeast2);
        }
        final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1420measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM337getTargetConstraintsOenEA2s = m337getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2082getHasFixedWidthimpl(jM337getTargetConstraintsOenEA2s)) {
            return Constraints.m2084getMaxWidthimpl(jM337getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2098constrainWidthK40F9xA(jM337getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM337getTargetConstraintsOenEA2s = m337getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2081getHasFixedHeightimpl(jM337getTargetConstraintsOenEA2s)) {
            return Constraints.m2083getMaxHeightimpl(jM337getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2097constrainHeightK40F9xA(jM337getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM337getTargetConstraintsOenEA2s = m337getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2082getHasFixedWidthimpl(jM337getTargetConstraintsOenEA2s)) {
            return Constraints.m2084getMaxWidthimpl(jM337getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2098constrainWidthK40F9xA(jM337getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM337getTargetConstraintsOenEA2s = m337getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2081getHasFixedHeightimpl(jM337getTargetConstraintsOenEA2s)) {
            return Constraints.m2083getMaxHeightimpl(jM337getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2097constrainHeightK40F9xA(jM337getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
