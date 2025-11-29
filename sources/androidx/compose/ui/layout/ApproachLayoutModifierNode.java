package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import kotlin.Metadata;

/* compiled from: ApproachLayoutModifierNode.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\u0004*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0015\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u001a\u001a\u00020\u0018*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\u00020\u0018*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ#\u0010\u001e\u001a\u00020\u0018*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ#\u0010\u001f\u001a\u00020\u0018*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001f\u0010\u001bø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "isMeasurementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoordinates", "isPlacementApproachInProgress", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/LayoutCoordinates;)Z", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "minApproachIntrinsicWidth", "(Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "width", "minApproachIntrinsicHeight", "maxApproachIntrinsicWidth", "maxApproachIntrinsicHeight", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ApproachLayoutModifierNode extends LayoutModifierNode {
    /* renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    MeasureResult m1398approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j);

    /* renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    boolean m1399isMeasurementApproachInProgressozmzZPI(long lookaheadSize);

    default boolean isPlacementApproachInProgress(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        return false;
    }

    default int minApproachIntrinsicWidth(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo1400measure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.m1398approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int minApproachIntrinsicHeight(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo1400measure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.m1398approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxApproachIntrinsicWidth(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo1400measure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.m1398approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxApproachIntrinsicHeight(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult mo1400measure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.m1398approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
