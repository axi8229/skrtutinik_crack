package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: AlignmentLine.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a>\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u001a\u001a\u00020\u0017*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "Landroidx/compose/ui/unit/Dp;", "before", "after", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "paddingFrom", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "alignmentLineOffsetMeasure", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "horizontal", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m289paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM();
        }
        return m288paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m288paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set("before", Dp.m2100boximpl(f));
                inspectorInfo.getProperties().set("after", Dp.m2100boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m290paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier modifierM289paddingFrom4j6BHR0$default;
        Modifier modifierM289paddingFrom4j6BHR0$default2;
        Dp.Companion companion = Dp.INSTANCE;
        if (!Dp.m2104equalsimpl0(f, companion.m2110getUnspecifiedD9Ej5fM())) {
            modifierM289paddingFrom4j6BHR0$default = m289paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            modifierM289paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = modifier.then(modifierM289paddingFrom4j6BHR0$default);
        if (!Dp.m2104equalsimpl0(f2, companion.m2110getUnspecifiedD9Ej5fM())) {
            modifierM289paddingFrom4j6BHR0$default2 = m289paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            modifierM289paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(modifierM289paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m287alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int iMax;
        int height;
        final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m2076copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m2076copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo1420measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? placeableMo1420measureBRTryo0.getHeight() : placeableMo1420measureBRTryo0.getWidth();
        int iM2083getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m2083getMaxHeightimpl(j) : Constraints.m2084getMaxWidthimpl(j);
        Dp.Companion companion = Dp.INSTANCE;
        int i2 = iM2083getMaxHeightimpl - height2;
        final int iCoerceIn = RangesKt.coerceIn((!Dp.m2104equalsimpl0(f, companion.m2110getUnspecifiedD9Ej5fM()) ? measureScope.mo248roundToPx0680j_4(f) : 0) - i, 0, i2);
        final int iCoerceIn2 = RangesKt.coerceIn(((!Dp.m2104equalsimpl0(f2, companion.m2110getUnspecifiedD9Ej5fM()) ? measureScope.mo248roundToPx0680j_4(f2) : 0) - height2) + i, 0, i2 - iCoerceIn);
        if (getHorizontal(alignmentLine)) {
            iMax = placeableMo1420measureBRTryo0.getWidth();
        } else {
            iMax = Math.max(placeableMo1420measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m2086getMinWidthimpl(j));
        }
        final int i3 = iMax;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(placeableMo1420measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m2085getMinHeightimpl(j));
        } else {
            height = placeableMo1420measureBRTryo0.getHeight();
        }
        final int i4 = height;
        return MeasureScope.layout$default(measureScope, i3, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int width;
                int height3 = 0;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    width = 0;
                } else {
                    width = !Dp.m2104equalsimpl0(f, Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i3 - iCoerceIn2) - placeableMo1420measureBRTryo0.getWidth();
                }
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    height3 = !Dp.m2104equalsimpl0(f, Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i4 - iCoerceIn2) - placeableMo1420measureBRTryo0.getHeight();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1420measureBRTryo0, width, height3, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }
}
