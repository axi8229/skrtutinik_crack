package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNodeCoordinator.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 O2\u00020\u0001:\u0002OPB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J*\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014ø\u0001\u0000¢\u0006\u0004\b \u0010!J8\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b\u0018\u00010#H\u0014ø\u0001\u0000¢\u0006\u0004\b \u0010&J\u0017\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J!\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b.\u0010/R*\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00107\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010?\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=8\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0011\u0010N\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bL\u0010M\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "measureNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "", "onAfterPlaceAt", "()V", "ensureLookaheadDelegateCreated", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeAt", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "(JFLkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "calculateAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "graphicsLayer", "performDraw", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "layoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui_release", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "<set-?>", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "wrappedNonNull", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    private static final Paint modifierBoundsPaint;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode;
        ApproachMeasureScopeImpl approachMeasureScopeImpl = null;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((layoutModifierNode.getNode().getKindSet() & NodeKind.m1552constructorimpl(512)) != 0) {
            Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode);
        }
        this.approachMeasureScope = approachMeasureScopeImpl;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode) {
        if (!Intrinsics.areEqual(layoutModifierNode, this.layoutModifierNode)) {
            Modifier.Node node = layoutModifierNode.getNode();
            if ((node.getKindSet() & NodeKind.m1552constructorimpl(512)) != 0) {
                Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.setApproachNode(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.approachMeasureScope = approachMeasureScopeImpl;
            } else {
                this.approachMeasureScope = null;
            }
        }
        this.layoutModifierNode = layoutModifierNode;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped = getWrapped();
        Intrinsics.checkNotNull(wrapped);
        return wrapped;
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw$ui_release, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM$ui_release, reason: not valid java name */
    public final void m1475setLookaheadConstraints_Sx5XlM$ui_release(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    protected void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo1420measureBRTryo0(long constraints) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            m1443setMeasurementConstraintsBRTryo0(constraints);
            layoutModifierNodeCoordinator.m1475setLookaheadConstraints_Sx5XlM$ui_release(Constraints.m2073boximpl(constraints));
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            set_measureResult(layoutModifierNode.mo105measure3p2s80s(this, lookaheadDelegate, constraints));
            return this;
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int iCalculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(iCalculateAlignmentAndPlaceChildAsNeeded));
            return iCalculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, width);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.ui.layout.Placeable mo1420measureBRTryo0(long r7) {
        /*
            r6 = this;
            boolean r0 = r6.getForceMeasureWithLookaheadConstraints()
            if (r0 == 0) goto L17
            androidx.compose.ui.unit.Constraints r7 = r6.lookaheadConstraints
            if (r7 == 0) goto Lf
            long r7 = r7.getValue()
            goto L17
        Lf:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Lookahead constraints cannot be null in approach pass."
            r7.<init>(r8)
            throw r7
        L17:
            androidx.compose.ui.node.NodeCoordinator.m1523access$setMeasurementConstraintsBRTryo0(r6, r7)
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = access$getApproachMeasureScope$p(r6)
            if (r0 == 0) goto Lb2
            androidx.compose.ui.layout.ApproachLayoutModifierNode r1 = r0.getApproachNode()
            long r2 = r0.m1401getLookaheadSizeYbymL2g()
            boolean r2 = r1.m1399isMeasurementApproachInProgressozmzZPI(r2)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L3d
            androidx.compose.ui.unit.Constraints r2 = r6.getLookaheadConstraints()
            boolean r2 = androidx.compose.ui.unit.Constraints.m2077equalsimpl(r7, r2)
            if (r2 != 0) goto L3b
            goto L3d
        L3b:
            r2 = r4
            goto L3e
        L3d:
            r2 = r3
        L3e:
            r0.setApproachMeasureRequired$ui_release(r2)
            boolean r2 = r0.getApproachMeasureRequired()
            if (r2 != 0) goto L4e
            androidx.compose.ui.node.NodeCoordinator r2 = r6.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r3)
        L4e:
            androidx.compose.ui.node.NodeCoordinator r2 = r6.getWrappedNonNull()
            androidx.compose.ui.layout.MeasureResult r7 = r1.m1398approachMeasure3p2s80s(r0, r2, r7)
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            r8.setForceMeasureWithLookaheadConstraints$ui_release(r4)
            int r8 = r7.getWidth()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getWidth()
            if (r8 != r1) goto L80
            int r8 = r7.getHeight()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getHeight()
            if (r8 != r1) goto L80
            goto L81
        L80:
            r3 = r4
        L81:
            boolean r8 = r0.getApproachMeasureRequired()
            if (r8 != 0) goto Lbe
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            long r0 = r8.mo1422getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r8 = r8.getLookaheadDelegate()
            if (r8 == 0) goto La2
            long r4 = r8.m1509getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r8 = androidx.compose.ui.unit.IntSize.m2151boximpl(r4)
            goto La3
        La2:
            r8 = 0
        La3:
            boolean r8 = androidx.compose.ui.unit.IntSize.m2153equalsimpl(r0, r8)
            if (r8 == 0) goto Lbe
            if (r3 != 0) goto Lbe
            androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1 r8 = new androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
            r8.<init>(r6)
            r7 = r8
            goto Lbe
        Lb2:
            androidx.compose.ui.node.LayoutModifierNode r0 = r6.getLayoutModifierNode()
            androidx.compose.ui.node.NodeCoordinator r1 = r6.getWrappedNonNull()
            androidx.compose.ui.layout.MeasureResult r7 = r0.mo105measure3p2s80s(r6, r1, r7)
        Lbe:
            r6.setMeasureResult$ui_release(r7)
            r6.onMeasured()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.mo1420measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo1441placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.mo1441placeAtf8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo1421placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo1421placeAtf8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void onAfterPlaceAt() {
        /*
            r7 = this;
            boolean r0 = r7.getIsShallowPlacing()
            if (r0 == 0) goto L7
            return
        L7:
            r7.onPlaced()
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = r7.approachMeasureScope
            r1 = 0
            if (r0 == 0) goto L73
            androidx.compose.ui.layout.ApproachLayoutModifierNode r2 = r0.getApproachNode()
            androidx.compose.ui.layout.Placeable$PlacementScope r3 = r7.getPlacementScope()
            androidx.compose.ui.node.LookaheadDelegate r4 = r7.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.ui.layout.LookaheadLayoutCoordinates r4 = r4.getLookaheadLayoutCoordinates()
            boolean r2 = r2.isPlacementApproachInProgress(r3, r4)
            if (r2 != 0) goto L6b
            boolean r0 = r0.getApproachMeasureRequired()
            if (r0 != 0) goto L6b
            long r2 = r7.mo1422getSizeYbymL2g()
            androidx.compose.ui.node.LookaheadDelegate r0 = r7.getLookaheadDelegate()
            r4 = 0
            if (r0 == 0) goto L42
            long r5 = r0.m1509getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.m2151boximpl(r5)
            goto L43
        L42:
            r0 = r4
        L43:
            boolean r0 = androidx.compose.ui.unit.IntSize.m2153equalsimpl(r2, r0)
            if (r0 == 0) goto L6b
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            long r2 = r0.mo1422getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto L63
            long r4 = r0.m1509getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r4 = androidx.compose.ui.unit.IntSize.m2151boximpl(r4)
        L63:
            boolean r0 = androidx.compose.ui.unit.IntSize.m2153equalsimpl(r2, r4)
            if (r0 == 0) goto L6b
            r0 = 1
            goto L6c
        L6b:
            r0 = r1
        L6c:
            androidx.compose.ui.node.NodeCoordinator r2 = r7.getWrappedNonNull()
            r2.setForcePlaceWithLookaheadOffset$ui_release(r0)
        L73:
            androidx.compose.ui.layout.MeasureResult r0 = r7.getMeasureResult$ui_release()
            r0.placeChildren()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            r0.setForcePlaceWithLookaheadOffset$ui_release(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.onAfterPlaceAt():void");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        return lookaheadDelegate != null ? lookaheadDelegate.getCachedAlignmentLine$ui_release(alignmentLine) : LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo909setColor8_81llA(Color.INSTANCE.m987getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo913setStylek9PVt8s(PaintingStyle.INSTANCE.m1057getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
