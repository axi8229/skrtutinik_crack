package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0011\u001a\u00020\u000e*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/layout/Direction;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "fraction", "<init>", "(Landroidx/compose/foundation/layout/Direction;F)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/foundation/layout/Direction;", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "F", "getFraction", "()F", "setFraction", "(F)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo105measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM2086getMinWidthimpl;
        int iM2084getMaxWidthimpl;
        int iM2083getMaxHeightimpl;
        int iCoerceIn;
        if (Constraints.m2080getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            iM2086getMinWidthimpl = RangesKt.coerceIn(Math.round(Constraints.m2084getMaxWidthimpl(j) * this.fraction), Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(j));
            iM2084getMaxWidthimpl = iM2086getMinWidthimpl;
        } else {
            iM2086getMinWidthimpl = Constraints.m2086getMinWidthimpl(j);
            iM2084getMaxWidthimpl = Constraints.m2084getMaxWidthimpl(j);
        }
        if (Constraints.m2079getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            iCoerceIn = RangesKt.coerceIn(Math.round(Constraints.m2083getMaxHeightimpl(j) * this.fraction), Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(j));
            iM2083getMaxHeightimpl = iCoerceIn;
        } else {
            int iM2085getMinHeightimpl = Constraints.m2085getMinHeightimpl(j);
            iM2083getMaxHeightimpl = Constraints.m2083getMaxHeightimpl(j);
            iCoerceIn = iM2085getMinHeightimpl;
        }
        final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(ConstraintsKt.Constraints(iM2086getMinWidthimpl, iM2084getMaxWidthimpl, iCoerceIn, iM2083getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
}
