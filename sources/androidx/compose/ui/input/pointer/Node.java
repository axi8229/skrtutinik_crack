package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001d\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J5\u0010!\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010\u000eJ\r\u0010#\u001a\u00020\f¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108¨\u0006;"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "Landroidx/compose/ui/Modifier$Node;", "modifierNode", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "oldEvent", "newEvent", "", "hasPositionChanged", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "", "clearCache", "()V", "", "pointerIdValue", "Landroidx/collection/MutableObjectList;", "hitNodes", "removeInvalidPointerIdsAndChanges", "(JLandroidx/collection/MutableObjectList;)V", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changes", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "internalPointerEvent", "isInBounds", "dispatchMainEventPass", "(Landroidx/collection/LongSparseArray;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/input/pointer/InternalPointerEvent;Z)Z", "dispatchFinalEventPass", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;)Z", "buildCache", "dispatchCancel", "markIsIn", "cleanUpHits", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/Modifier$Node;", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "Z", "isIn", "hasExited", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;

    /* renamed from: modifierNode, reason: from kotlin metadata and from toString */
    private final Modifier.Node pointerInputFilter;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.pointerInputFilter = node;
    }

    /* renamed from: getModifierNode, reason: from getter */
    public final Modifier.Node getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
                i++;
            } while (i < size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0238  */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean buildCache(androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r37, androidx.compose.ui.layout.LayoutCoordinates r38, androidx.compose.ui.input.pointer.InternalPointerEvent r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m839equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.pointerInputFilter.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jMo1422getSizeYbymL2g = layoutCoordinates.mo1422getSizeYbymL2g();
            DelegatingNode delegatingNodePop = this.pointerInputFilter;
            int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
            MutableVector mutableVector = null;
            while (delegatingNodePop != 0) {
                if (!(delegatingNodePop instanceof PointerInputModifierNode)) {
                    if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate = delegatingNodePop.getDelegate();
                        int i2 = 0;
                        delegatingNodePop = delegatingNodePop;
                        while (delegate != null) {
                            if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                                i2++;
                                if (i2 == 1) {
                                    delegatingNodePop = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNodePop != 0) {
                                        mutableVector.add(delegatingNodePop);
                                        delegatingNodePop = 0;
                                    }
                                    mutableVector.add(delegate);
                                }
                            }
                            delegate = delegate.getChild();
                            delegatingNodePop = delegatingNodePop;
                        }
                        if (i2 == 1) {
                        }
                    }
                } else {
                    ((PointerInputModifierNode) delegatingNodePop).mo153onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo1422getSizeYbymL2g);
                }
                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo1422getSizeYbymL2g = layoutCoordinates.mo1422getSizeYbymL2g();
        DelegatingNode delegatingNodePop = this.pointerInputFilter;
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (delegatingNodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNodePop).mo153onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo1422getSizeYbymL2g);
            } else if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodePop.getDelegate();
                int i = 0;
                delegatingNodePop = delegatingNodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodePop != 0) {
                                mutableVector.add(delegatingNodePop);
                                delegatingNodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodePop = delegatingNodePop;
                }
                if (i == 1) {
                }
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            int i2 = 0;
            do {
                Node node = content[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
                i2++;
            } while (i2 < size);
        }
        if (this.pointerInputFilter.getIsAttached()) {
            DelegatingNode delegatingNodePop2 = this.pointerInputFilter;
            int iM1552constructorimpl2 = NodeKind.m1552constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (delegatingNodePop2 != 0) {
                if (delegatingNodePop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNodePop2).mo153onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo1422getSizeYbymL2g);
                } else if ((delegatingNodePop2.getKindSet() & iM1552constructorimpl2) != 0 && (delegatingNodePop2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = delegatingNodePop2.getDelegate();
                    int i3 = 0;
                    delegatingNodePop2 = delegatingNodePop2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & iM1552constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                delegatingNodePop2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNodePop2 != 0) {
                                    mutableVector2.add(delegatingNodePop2);
                                    delegatingNodePop2 = 0;
                                }
                                mutableVector2.add(delegate2);
                            }
                        }
                        delegate2 = delegate2.getChild();
                        delegatingNodePop2 = delegatingNodePop2;
                    }
                    if (i3 == 1) {
                    }
                }
                delegatingNodePop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        DelegatingNode delegatingNodePop = this.pointerInputFilter;
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (!(delegatingNodePop instanceof PointerInputModifierNode)) {
                if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                    Modifier.Node delegate = delegatingNodePop.getDelegate();
                    int i2 = 0;
                    delegatingNodePop = delegatingNodePop;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
                                delegatingNodePop = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNodePop != 0) {
                                    mutableVector.add(delegatingNodePop);
                                    delegatingNodePop = 0;
                                }
                                mutableVector.add(delegate);
                            }
                        }
                        delegate = delegate.getChild();
                        delegatingNodePop = delegatingNodePop;
                    }
                    if (i2 == 1) {
                    }
                }
            } else {
                ((PointerInputModifierNode) delegatingNodePop).onCancelPointerInput();
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean zM1319activeHoverEvent0FcD4WY = internalPointerEvent.m1319activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z = this.isIn;
            if ((!pressed && !zM1319activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.m1393remove0FcD4WY(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m1330equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m1332getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
