package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Row.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\r*\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\r*\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J,\u0010\u001e\u001a\u00020\u001b*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010&Ji\u0010-\u001a\u00020\u001b2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0'2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010.J=\u00107\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\r*\u0002082\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u00162\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\b;\u0010<J)\u0010>\u001a\u00020\r*\u0002082\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u00162\u0006\u0010=\u001a\u00020\rH\u0016¢\u0006\u0004\b>\u0010<J)\u0010?\u001a\u00020\r*\u0002082\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u00162\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\b?\u0010<J)\u0010@\u001a\u00020\r*\u0002082\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u00162\u0006\u0010=\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010<J\u0010\u0010B\u001a\u00020AHÖ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bD\u0010EJ\u001a\u0010H\u001a\u0002032\b\u0010G\u001a\u0004\u0018\u00010FHÖ\u0003¢\u0006\u0004\bH\u0010IR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010JR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010K\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Landroidx/compose/foundation/layout/RowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;)V", "Landroidx/compose/ui/layout/Placeable;", "placeable", "Landroidx/compose/foundation/layout/RowColumnParentData;", "parentData", "", "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "getCrossAxisPosition", "(Landroidx/compose/ui/layout/Placeable;Landroidx/compose/foundation/layout/RowColumnParentData;II)I", "mainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "crossAxisSize", "Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "mainAxisLayoutSize", "", "childrenMainAxisSize", "mainAxisPositions", "measureScope", "", "populateMainAxisPositions", "(I[I[ILandroidx/compose/ui/layout/MeasureScope;)V", "", "placeables", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "placeHelper", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "", "isPrioritizing", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "createConstraints", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RowMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    private final Arrangement.Horizontal horizontalArrangement;
    private final Alignment.Vertical verticalAlignment;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowMeasurePolicy)) {
            return false;
        }
        RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) other;
        return Intrinsics.areEqual(this.horizontalArrangement, rowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalAlignment, rowMeasurePolicy.verticalAlignment);
    }

    public int hashCode() {
        return (this.horizontalArrangement.hashCode() * 31) + this.verticalAlignment.hashCode();
    }

    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.horizontalArrangement + ", verticalAlignment=" + this.verticalAlignment + ')';
    }

    public RowMeasurePolicy(Arrangement.Horizontal horizontal, Alignment.Vertical vertical) {
        this.horizontalArrangement = horizontal;
        this.verticalAlignment = vertical;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable placeable) {
        return placeable.getWidth();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable placeable) {
        return placeable.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo87measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return RowColumnMeasurePolicyKt.measure(this, Constraints.m2086getMinWidthimpl(j), Constraints.m2085getMinHeightimpl(j), Constraints.m2084getMaxWidthimpl(j), Constraints.m2083getMaxHeightimpl(j), measureScope.mo248roundToPx0680j_4(this.horizontalArrangement.getSpacing()), measureScope, list, new Placeable[list.size()], 0, list.size(), (3072 & 1024) != 0 ? null : null, (3072 & 2048) != 0 ? 0 : 0);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.horizontalArrangement.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(final Placeable[] placeables, MeasureScope measureScope, final int beforeCrossAxisAlignmentLine, final int[] mainAxisPositions, int mainAxisLayoutSize, final int crossAxisLayoutSize, int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        return MeasureScope.layout$default(measureScope, mainAxisLayoutSize, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowMeasurePolicy$placeHelper$1$1
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
                Placeable[] placeableArr = placeables;
                RowMeasurePolicy rowMeasurePolicy = this;
                int i = crossAxisLayoutSize;
                int i2 = beforeCrossAxisAlignmentLine;
                int[] iArr = mainAxisPositions;
                int length = placeableArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    Placeable placeable = placeableArr[i3];
                    Intrinsics.checkNotNull(placeable);
                    Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i4], rowMeasurePolicy.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i, i2), 0.0f, 4, null);
                    i3++;
                    i4++;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* renamed from: createConstraints-xF2OJ5Q */
    public long mo298createConstraintsxF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        return RowKt.createRowConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment crossAxisAlignment = parentData != null ? parentData.getCrossAxisAlignment() : null;
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - placeable.getHeight(), LayoutDirection.Ltr, placeable, beforeCrossAxisAlignmentLine);
        }
        return this.verticalAlignment.align(0, crossAxisLayoutSize - placeable.getHeight());
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinWidth(list, i, intrinsicMeasureScope.mo248roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinHeight(list, i, intrinsicMeasureScope.mo248roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxWidth(list, i, intrinsicMeasureScope.mo248roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxHeight(list, i, intrinsicMeasureScope.mo248roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }
}
