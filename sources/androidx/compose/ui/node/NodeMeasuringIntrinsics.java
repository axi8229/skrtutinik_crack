package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachIntrinsicsMeasureScope;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LayoutModifierNode.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ-\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J-\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0015J-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0015¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics;", "", "()V", "maxHeight", "", "measureBlock", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$ApproachMeasureBlock;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "w", "maxHeight$ui_release", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$MeasureBlock;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "maxWidth", "h", "maxWidth$ui_release", "minHeight", "minHeight$ui_release", "minWidth", "minWidth$ui_release", "ApproachMeasureBlock", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "MeasureBlock", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NodeMeasuringIntrinsics {
    public static final NodeMeasuringIntrinsics INSTANCE = new NodeMeasuringIntrinsics();

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$ApproachMeasureBlock;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ApproachMeasureBlock {
        /* renamed from: measure-3p2s80s */
        MeasureResult mo1400measure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j);
    }

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private enum IntrinsicMinMax {
        Min,
        Max
    }

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "", "(Ljava/lang/String;I)V", "Width", "Height", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private enum IntrinsicWidthHeight {
        Width,
        Height
    }

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$MeasureBlock;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface MeasureBlock {
        /* renamed from: measure-3p2s80s */
        MeasureResult mo1473measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);
    }

    private NodeMeasuringIntrinsics() {
    }

    public final int minWidth$ui_release(ApproachMeasureBlock measureBlock, ApproachIntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int h) {
        return measureBlock.mo1400measure3p2s80s(new ApproachIntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, h, 7, null)).get$w();
    }

    public final int minHeight$ui_release(ApproachMeasureBlock measureBlock, ApproachIntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int w) {
        return measureBlock.mo1400measure3p2s80s(new ApproachIntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, w, 0, 0, 13, null)).get$h();
    }

    public final int maxWidth$ui_release(ApproachMeasureBlock measureBlock, ApproachIntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int h) {
        return measureBlock.mo1400measure3p2s80s(new ApproachIntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, h, 7, null)).get$w();
    }

    public final int maxHeight$ui_release(ApproachMeasureBlock measureBlock, ApproachIntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int w) {
        return measureBlock.mo1400measure3p2s80s(new ApproachIntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, w, 0, 0, 13, null)).get$h();
    }

    public final int minWidth$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int h) {
        return measureBlock.mo1473measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, h, 7, null)).get$w();
    }

    public final int minHeight$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int w) {
        return measureBlock.mo1473measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, w, 0, 0, 13, null)).get$h();
    }

    public final int maxWidth$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int h) {
        return measureBlock.mo1473measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, h, 7, null)).get$w();
    }

    public final int maxHeight$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int w) {
        return measureBlock.mo1473measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, w, 0, 0, 13, null)).get$h();
    }

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "measurable", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "minMax", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "widthHeight", "<init>", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;)V", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "getMinMax", "()Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "getWidthHeight", "()Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "", "getParentData", "()Ljava/lang/Object;", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DefaultIntrinsicMeasurable implements Measurable {
        private final IntrinsicMeasurable measurable;
        private final IntrinsicMinMax minMax;
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMinMax intrinsicMinMax, IntrinsicWidthHeight intrinsicWidthHeight) {
            this.measurable = intrinsicMeasurable;
            this.minMax = intrinsicMinMax;
            this.widthHeight = intrinsicWidthHeight;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo1420measureBRTryo0(long constraints) {
            int iMinIntrinsicHeight;
            int iMinIntrinsicWidth;
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                if (this.minMax == IntrinsicMinMax.Max) {
                    iMinIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.m2083getMaxHeightimpl(constraints));
                } else {
                    iMinIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.m2083getMaxHeightimpl(constraints));
                }
                return new EmptyPlaceable(iMinIntrinsicWidth, Constraints.m2079getHasBoundedHeightimpl(constraints) ? Constraints.m2083getMaxHeightimpl(constraints) : 32767);
            }
            if (this.minMax == IntrinsicMinMax.Max) {
                iMinIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.m2084getMaxWidthimpl(constraints));
            } else {
                iMinIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.m2084getMaxWidthimpl(constraints));
            }
            return new EmptyPlaceable(Constraints.m2080getHasBoundedWidthimpl(constraints) ? Constraints.m2084getMaxWidthimpl(constraints) : 32767, iMinIntrinsicHeight);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            return this.measurable.minIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            return this.measurable.maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            return this.measurable.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            return this.measurable.maxIntrinsicHeight(width);
        }
    }

    /* compiled from: LayoutModifierNode.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0014ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "", "width", "height", "<init>", "(II)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class EmptyPlaceable extends Placeable {
        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            return Integer.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo1421placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        }

        public EmptyPlaceable(int i, int i2) {
            m1442setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        }
    }
}
