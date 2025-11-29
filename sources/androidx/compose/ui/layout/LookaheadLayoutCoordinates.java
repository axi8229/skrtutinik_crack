package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadLayoutCoordinates.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\tJ\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010%\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020\u00068BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u00102\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00105\u001a\u0002038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b4\u0010-R\u0016\u00108\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00109\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "<init>", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "Landroidx/compose/ui/geometry/Offset;", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "screenToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "relativeToLocal", "localToWindow-MK-Hz9U", "localToWindow", "localToRoot-MK-Hz9U", "localToRoot", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", "", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "clipBounds", "Landroidx/compose/ui/geometry/Rect;", "localBoundingBoxOf", "(Landroidx/compose/ui/layout/LayoutCoordinates;Z)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "transformToScreen-58bKbWc", "([F)V", "transformToScreen", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadOffset-F1C5BW0", "()J", "lookaheadOffset", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "isAttached", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo1422getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator wrappedBy = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m1433getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        LayoutCoordinates coordinates = rootLookaheadDelegate.getCoordinates();
        Offset.Companion companion = Offset.INSTANCE;
        return Offset.m846minusMKHz9U(mo1423localPositionOfR5De75A(coordinates, companion.m854getZeroF1C5BW0()), getCoordinator().mo1423localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), companion.m854getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1427screenToLocalMKHz9U(long relativeToScreen) {
        return Offset.m847plusMKHz9U(getCoordinator().mo1427screenToLocalMKHz9U(relativeToScreen), m1433getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo1430windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m847plusMKHz9U(getCoordinator().mo1430windowToLocalMKHz9U(relativeToWindow), m1433getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo1426localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo1426localToWindowMKHz9U(Offset.m847plusMKHz9U(relativeToLocal, m1433getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo1425localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo1425localToRootMKHz9U(Offset.m847plusMKHz9U(relativeToLocal, m1433getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo1423localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo1424localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo1424localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinates) sourceCoordinates).lookaheadDelegate;
            lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui_release();
            LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                long jM2141minusqkQi6aY = IntOffset.m2141minusqkQi6aY(IntOffset.m2142plusqkQi6aY(lookaheadDelegate.m1511positionIniSbpLlY$ui_release(lookaheadDelegate2, !includeMotionFrameOfReference), IntOffsetKt.m2148roundk4lQ0M(relativeToSource)), this.lookaheadDelegate.m1511positionIniSbpLlY$ui_release(lookaheadDelegate2, !includeMotionFrameOfReference));
                return OffsetKt.Offset(IntOffset.m2138getXimpl(jM2141minusqkQi6aY), IntOffset.m2139getYimpl(jM2141minusqkQi6aY));
            }
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
            long jM2142plusqkQi6aY = IntOffset.m2142plusqkQi6aY(IntOffset.m2142plusqkQi6aY(lookaheadDelegate.m1511positionIniSbpLlY$ui_release(rootLookaheadDelegate, !includeMotionFrameOfReference), rootLookaheadDelegate.getPosition()), IntOffsetKt.m2148roundk4lQ0M(relativeToSource));
            LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            long jM2141minusqkQi6aY2 = IntOffset.m2141minusqkQi6aY(jM2142plusqkQi6aY, IntOffset.m2142plusqkQi6aY(this.lookaheadDelegate.m1511positionIniSbpLlY$ui_release(rootLookaheadDelegate2, !includeMotionFrameOfReference), rootLookaheadDelegate2.getPosition()));
            long jOffset = OffsetKt.Offset(IntOffset.m2138getXimpl(jM2141minusqkQi6aY2), IntOffset.m2139getYimpl(jM2141minusqkQi6aY2));
            NodeCoordinator wrappedBy = rootLookaheadDelegate2.getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy);
            NodeCoordinator wrappedBy2 = rootLookaheadDelegate.getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy2);
            return wrappedBy.mo1424localPositionOfS_NoaFU(wrappedBy2, jOffset, includeMotionFrameOfReference);
        }
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m847plusMKHz9U(mo1424localPositionOfS_NoaFU(rootLookaheadDelegate3.getLookaheadLayoutCoordinates(), relativeToSource, includeMotionFrameOfReference), rootLookaheadDelegate3.getCoordinator().getCoordinates().mo1424localPositionOfS_NoaFU(sourceCoordinates, Offset.INSTANCE.m854getZeroF1C5BW0(), includeMotionFrameOfReference));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo1428transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        getCoordinator().mo1428transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo1429transformToScreen58bKbWc(float[] matrix) {
        getCoordinator().mo1429transformToScreen58bKbWc(matrix);
    }
}
