package androidx.compose.ui.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: DragAndDropNode.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\f\u001a\u00020\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u0012\u001a\u00020\u0003\"\b\b\u0000\u0010\u000e*\u00020\r*\u00028\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "event", "", "dispatchEntered", "(Landroidx/compose/ui/draganddrop/DragAndDropTarget;Landroidx/compose/ui/draganddrop/DragAndDropEvent;)V", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/geometry/Offset;", "position", "", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "contains", "Landroidx/compose/ui/node/TraversableNode;", "T", "Lkotlin/Function1;", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "block", "traverseSelfAndDescendants", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.onEntered(dragAndDropEvent);
        dragAndDropTarget.onMoved(dragAndDropEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m764containsUv8p0NA(DragAndDropModifierNode dragAndDropModifierNode, long j) {
        if (!dragAndDropModifierNode.getNode().getIsAttached()) {
            return false;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(dragAndDropModifierNode).getCoordinates();
        if (!coordinates.isAttached()) {
            return false;
        }
        long jMo1422getSizeYbymL2g = coordinates.mo1422getSizeYbymL2g();
        int iM2156getWidthimpl = IntSize.m2156getWidthimpl(jMo1422getSizeYbymL2g);
        int iM2155getHeightimpl = IntSize.m2155getHeightimpl(jMo1422getSizeYbymL2g);
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        float fM842getXimpl = Offset.m842getXimpl(jPositionInRoot);
        float fM843getYimpl = Offset.m843getYimpl(jPositionInRoot);
        float f = iM2156getWidthimpl + fM842getXimpl;
        float f2 = iM2155getHeightimpl + fM843getYimpl;
        float fM842getXimpl2 = Offset.m842getXimpl(j);
        if (fM842getXimpl > fM842getXimpl2 || fM842getXimpl2 > f) {
            return false;
        }
        float fM843getYimpl2 = Offset.m843getYimpl(j);
        return fM843getYimpl <= fM843getYimpl2 && fM843getYimpl2 <= f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends TraversableNode> void traverseSelfAndDescendants(T t, Function1<? super T, ? extends TraversableNode$Companion$TraverseDescendantsAction> function1) {
        if (function1.invoke(t) != TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal) {
            return;
        }
        TraversableNodeKt.traverseDescendants(t, function1);
    }
}
