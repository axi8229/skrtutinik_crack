package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0015J\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001f\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ&\u0010&\u001a\u00020#*\u00020 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J#\u0010+\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010,J#\u0010/\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b/\u0010,J#\u00100\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b0\u0010,J\u0013\u00103\u001a\u000202*\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010?R\u0014\u0010Y\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010?\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "", "sizeToIntrinsics", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "calculateScaledSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "modifyConstraints", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteHeight-uvyYCjk", "hasSpecifiedAndFiniteHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "Z", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "F", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getUseIntrinsicSize", "useIntrinsicSize", "getShouldAutoInvalidate", "shouldAutoInvalidate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.ui.draw.PainterNode, reason: from toString */
/* loaded from: classes.dex */
final class PainterModifier extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo1216getIntrinsicSizeNHjbRc() != 9205357640488583168L;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo105measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(m770modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (getUseIntrinsicSize()) {
            long jM770modifyConstraintsZezNO4M = m770modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m2086getMinWidthimpl(jM770modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM770modifyConstraintsZezNO4M = m770modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m2086getMinWidthimpl(jM770modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM770modifyConstraintsZezNO4M = m770modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m2085getMinHeightimpl(jM770modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM770modifyConstraintsZezNO4M = m770modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m2085getMinHeightimpl(jM770modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m767calculateScaledSizeE7KxVPU(long dstSize) {
        float fM878getWidthimpl;
        float fM876getHeightimpl;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m769hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo1216getIntrinsicSizeNHjbRc())) {
            fM878getWidthimpl = Size.m878getWidthimpl(dstSize);
        } else {
            fM878getWidthimpl = Size.m878getWidthimpl(this.painter.mo1216getIntrinsicSizeNHjbRc());
        }
        if (!m768hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo1216getIntrinsicSizeNHjbRc())) {
            fM876getHeightimpl = Size.m876getHeightimpl(dstSize);
        } else {
            fM876getHeightimpl = Size.m876getHeightimpl(this.painter.mo1216getIntrinsicSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM878getWidthimpl, fM876getHeightimpl);
        if (Size.m878getWidthimpl(dstSize) != 0.0f && Size.m876getHeightimpl(dstSize) != 0.0f) {
            return ScaleFactorKt.m1459timesUQTWf7w(jSize, this.contentScale.mo1411computeScaleFactorH7hwNQA(jSize, dstSize));
        }
        return Size.INSTANCE.m884getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m770modifyConstraintsZezNO4M(long constraints) {
        boolean z = false;
        boolean z2 = Constraints.m2080getHasBoundedWidthimpl(constraints) && Constraints.m2079getHasBoundedHeightimpl(constraints);
        if (Constraints.m2082getHasFixedWidthimpl(constraints) && Constraints.m2081getHasFixedHeightimpl(constraints)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m2076copyZbe2FdA$default(constraints, Constraints.m2084getMaxWidthimpl(constraints), 0, Constraints.m2083getMaxHeightimpl(constraints), 0, 10, null);
        }
        long jMo1216getIntrinsicSizeNHjbRc = this.painter.mo1216getIntrinsicSizeNHjbRc();
        long jM767calculateScaledSizeE7KxVPU = m767calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m2098constrainWidthK40F9xA(constraints, m769hasSpecifiedAndFiniteWidthuvyYCjk(jMo1216getIntrinsicSizeNHjbRc) ? Math.round(Size.m878getWidthimpl(jMo1216getIntrinsicSizeNHjbRc)) : Constraints.m2086getMinWidthimpl(constraints)), ConstraintsKt.m2097constrainHeightK40F9xA(constraints, m768hasSpecifiedAndFiniteHeightuvyYCjk(jMo1216getIntrinsicSizeNHjbRc) ? Math.round(Size.m876getHeightimpl(jMo1216getIntrinsicSizeNHjbRc)) : Constraints.m2085getMinHeightimpl(constraints))));
        return Constraints.m2076copyZbe2FdA$default(constraints, ConstraintsKt.m2098constrainWidthK40F9xA(constraints, Math.round(Size.m878getWidthimpl(jM767calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2097constrainHeightK40F9xA(constraints, Math.round(Size.m876getHeightimpl(jM767calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jMo1216getIntrinsicSizeNHjbRc = this.painter.mo1216getIntrinsicSizeNHjbRc();
        long jSize = SizeKt.Size(m769hasSpecifiedAndFiniteWidthuvyYCjk(jMo1216getIntrinsicSizeNHjbRc) ? Size.m878getWidthimpl(jMo1216getIntrinsicSizeNHjbRc) : Size.m878getWidthimpl(contentDrawScope.mo1176getSizeNHjbRc()), m768hasSpecifiedAndFiniteHeightuvyYCjk(jMo1216getIntrinsicSizeNHjbRc) ? Size.m876getHeightimpl(jMo1216getIntrinsicSizeNHjbRc) : Size.m876getHeightimpl(contentDrawScope.mo1176getSizeNHjbRc()));
        long jM884getZeroNHjbRc = (Size.m878getWidthimpl(contentDrawScope.mo1176getSizeNHjbRc()) == 0.0f || Size.m876getHeightimpl(contentDrawScope.mo1176getSizeNHjbRc()) == 0.0f) ? Size.INSTANCE.m884getZeroNHjbRc() : ScaleFactorKt.m1459timesUQTWf7w(jSize, this.contentScale.mo1411computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo1176getSizeNHjbRc()));
        long jMo752alignKFBX0sM = this.alignment.mo752alignKFBX0sM(IntSizeKt.IntSize(Math.round(Size.m878getWidthimpl(jM884getZeroNHjbRc)), Math.round(Size.m876getHeightimpl(jM884getZeroNHjbRc))), IntSizeKt.IntSize(Math.round(Size.m878getWidthimpl(contentDrawScope.mo1176getSizeNHjbRc())), Math.round(Size.m876getHeightimpl(contentDrawScope.mo1176getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM2138getXimpl = IntOffset.m2138getXimpl(jMo752alignKFBX0sM);
        float fM2139getYimpl = IntOffset.m2139getYimpl(jMo752alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM2138getXimpl, fM2139getYimpl);
        try {
            this.painter.m1217drawx_KDEd0(contentDrawScope, jM884getZeroNHjbRc, this.alpha, this.colorFilter);
            contentDrawScope.getDrawContext().getTransform().translate(-fM2138getXimpl, -fM2139getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope.getDrawContext().getTransform().translate(-fM2138getXimpl, -fM2139getYimpl);
            throw th;
        }
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m769hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m875equalsimpl0(j, Size.INSTANCE.m883getUnspecifiedNHjbRc())) {
            float fM878getWidthimpl = Size.m878getWidthimpl(j);
            if (!Float.isInfinite(fM878getWidthimpl) && !Float.isNaN(fM878getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m768hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m875equalsimpl0(j, Size.INSTANCE.m883getUnspecifiedNHjbRc())) {
            float fM876getHeightimpl = Size.m876getHeightimpl(j);
            if (!Float.isInfinite(fM876getHeightimpl) && !Float.isNaN(fM876getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
