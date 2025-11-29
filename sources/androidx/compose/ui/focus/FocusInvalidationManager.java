package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: FocusInvalidationManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t) && this.focusTargetNodes.get_size() + this.focusEventNodes.get_size() + this.focusPropertiesNodes.get_size() == 1) {
            this.onRequestApplyChangesListener.invoke(new AnonymousClass1(this));
        }
    }

    /* compiled from: FocusInvalidationManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateNodes() {
        int i;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        FocusState focusState;
        MutableVector mutableVector;
        int i2;
        int i3;
        int i4;
        long[] jArr3;
        Object[] objArr3;
        boolean z;
        Object[] objArr4;
        boolean z2;
        int i5;
        MutableVector mutableVector2;
        long[] jArr4;
        long[] jArr5;
        int i6;
        long[] jArr6;
        long[] jArr7;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet = this.focusPropertiesNodes;
        Object[] objArr5 = mutableScatterSet.elements;
        long[] jArr8 = mutableScatterSet.metadata;
        int length = jArr8.length - 2;
        char c = 7;
        long j = -9187201950435737472L;
        int i7 = 8;
        int i8 = 1;
        if (length >= 0) {
            int i9 = 0;
            while (true) {
                long j2 = jArr8[i9];
                if ((((~j2) << c) & j2 & j) != j) {
                    int i10 = 8 - ((~(i9 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j2 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr5[(i9 << 3) + i11];
                            if (focusPropertiesModifierNode.getNode().getIsAttached()) {
                                int iM1552constructorimpl = NodeKind.m1552constructorimpl(1024);
                                Modifier.Node node = focusPropertiesModifierNode.getNode();
                                MutableVector mutableVector3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.focusTargetNodes.add((FocusTargetNode) node);
                                    } else {
                                        if ((node.getKindSet() & iM1552constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                            Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                                            int i12 = 0;
                                            while (delegate != null) {
                                                if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                                                    i12++;
                                                    if (i12 == i8) {
                                                        jArr7 = jArr8;
                                                        node = delegate;
                                                    } else {
                                                        if (mutableVector3 == null) {
                                                            jArr7 = jArr8;
                                                            mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            jArr7 = jArr8;
                                                        }
                                                        if (node != null) {
                                                            mutableVector3.add(node);
                                                            node = null;
                                                        }
                                                        mutableVector3.add(delegate);
                                                    }
                                                } else {
                                                    jArr7 = jArr8;
                                                }
                                                delegate = delegate.getChild();
                                                jArr8 = jArr7;
                                                i8 = 1;
                                            }
                                            jArr6 = jArr8;
                                            int i13 = i8;
                                            if (i12 == i13) {
                                                i8 = i13;
                                                jArr8 = jArr6;
                                            }
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector3);
                                        jArr8 = jArr6;
                                        i8 = 1;
                                    }
                                    jArr6 = jArr8;
                                    node = DelegatableNodeKt.pop(mutableVector3);
                                    jArr8 = jArr6;
                                    i8 = 1;
                                }
                                jArr5 = jArr8;
                                if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
                                if (child == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, focusPropertiesModifierNode.getNode());
                                } else {
                                    mutableVector4.add(child);
                                }
                                while (mutableVector4.isNotEmpty()) {
                                    Modifier.Node nodePop = (Modifier.Node) mutableVector4.removeAt(mutableVector4.getSize() - 1);
                                    if ((nodePop.getAggregateChildKindSet() & iM1552constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, nodePop);
                                    } else {
                                        while (true) {
                                            if (nodePop == null) {
                                                break;
                                            }
                                            if ((nodePop.getKindSet() & iM1552constructorimpl) != 0) {
                                                MutableVector mutableVector5 = null;
                                                while (nodePop != null) {
                                                    if (nodePop instanceof FocusTargetNode) {
                                                        this.focusTargetNodes.add((FocusTargetNode) nodePop);
                                                    } else if ((nodePop.getKindSet() & iM1552constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                                        int i14 = 0;
                                                        for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                                            if ((delegate2.getKindSet() & iM1552constructorimpl) != 0) {
                                                                i14++;
                                                                if (i14 == 1) {
                                                                    nodePop = delegate2;
                                                                } else {
                                                                    if (mutableVector5 == null) {
                                                                        mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                                                    }
                                                                    if (nodePop != null) {
                                                                        mutableVector5.add(nodePop);
                                                                        nodePop = null;
                                                                    }
                                                                    mutableVector5.add(delegate2);
                                                                }
                                                            }
                                                        }
                                                        if (i14 == 1) {
                                                        }
                                                    }
                                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                                }
                                            } else {
                                                nodePop = nodePop.getChild();
                                            }
                                        }
                                    }
                                }
                            } else {
                                jArr5 = jArr8;
                            }
                            i6 = 8;
                        } else {
                            jArr5 = jArr8;
                            i6 = i7;
                        }
                        j2 >>= i6;
                        i11++;
                        i7 = i6;
                        jArr8 = jArr5;
                        i8 = 1;
                    }
                    jArr4 = jArr8;
                    if (i10 != i7) {
                        break;
                    }
                } else {
                    jArr4 = jArr8;
                }
                if (i9 == length) {
                    break;
                }
                i9++;
                jArr8 = jArr4;
                c = 7;
                j = -9187201950435737472L;
                i8 = 1;
                i7 = 8;
            }
        }
        this.focusPropertiesNodes.clear();
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet2 = this.focusEventNodes;
        Object[] objArr6 = mutableScatterSet2.elements;
        long[] jArr9 = mutableScatterSet2.metadata;
        int length2 = jArr9.length - 2;
        if (length2 >= 0) {
            int i15 = 0;
            while (true) {
                long j3 = jArr9[i15];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i16 = 8 - ((~(i15 - length2)) >>> 31);
                    int i17 = 0;
                    while (i17 < i16) {
                        if ((j3 & 255) < 128) {
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr6[(i15 << 3) + i17];
                            if (focusEventModifierNode.getNode().getIsAttached()) {
                                int iM1552constructorimpl2 = NodeKind.m1552constructorimpl(1024);
                                Modifier.Node node2 = focusEventModifierNode.getNode();
                                boolean z3 = false;
                                boolean z4 = true;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector6 = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                        if (focusTargetNode != null) {
                                            z3 = true;
                                        }
                                        if (this.focusTargetNodes.contains(focusTargetNode2)) {
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode2);
                                            z4 = false;
                                        }
                                        jArr3 = jArr9;
                                        objArr3 = objArr6;
                                        focusTargetNode = focusTargetNode2;
                                    } else {
                                        if ((node2.getKindSet() & iM1552constructorimpl2) == 0 || !(node2 instanceof DelegatingNode)) {
                                            jArr3 = jArr9;
                                            objArr3 = objArr6;
                                            z = z3;
                                        } else {
                                            Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                                            jArr3 = jArr9;
                                            int i18 = 0;
                                            while (delegate3 != null) {
                                                if ((delegate3.getKindSet() & iM1552constructorimpl2) != 0) {
                                                    i18++;
                                                    objArr4 = objArr6;
                                                    if (i18 == 1) {
                                                        node2 = delegate3;
                                                    } else {
                                                        if (mutableVector6 == null) {
                                                            i5 = i18;
                                                            z2 = z3;
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i5 = i18;
                                                            z2 = z3;
                                                            mutableVector2 = mutableVector6;
                                                        }
                                                        if (node2 != null) {
                                                            mutableVector2.add(node2);
                                                            node2 = null;
                                                        }
                                                        mutableVector2.add(delegate3);
                                                        mutableVector6 = mutableVector2;
                                                        i18 = i5;
                                                        delegate3 = delegate3.getChild();
                                                        objArr6 = objArr4;
                                                        z3 = z2;
                                                    }
                                                } else {
                                                    objArr4 = objArr6;
                                                }
                                                z2 = z3;
                                                delegate3 = delegate3.getChild();
                                                objArr6 = objArr4;
                                                z3 = z2;
                                            }
                                            objArr3 = objArr6;
                                            z = z3;
                                            if (i18 == 1) {
                                                jArr9 = jArr3;
                                                objArr6 = objArr3;
                                                z3 = z;
                                            }
                                        }
                                        z3 = z;
                                    }
                                    node2 = DelegatableNodeKt.pop(mutableVector6);
                                    jArr9 = jArr3;
                                    objArr6 = objArr3;
                                }
                                jArr2 = jArr9;
                                objArr2 = objArr6;
                                boolean z5 = z3;
                                if (!focusEventModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child2 = focusEventModifierNode.getNode().getChild();
                                if (child2 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector7.add(child2);
                                }
                                boolean z6 = z5;
                                while (mutableVector7.isNotEmpty()) {
                                    Modifier.Node nodePop2 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                                    if ((nodePop2.getAggregateChildKindSet() & iM1552constructorimpl2) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, nodePop2);
                                    } else {
                                        while (nodePop2 != null) {
                                            if ((nodePop2.getKindSet() & iM1552constructorimpl2) != 0) {
                                                MutableVector mutableVector8 = null;
                                                while (nodePop2 != null) {
                                                    if (nodePop2 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop2;
                                                        if (focusTargetNode != null) {
                                                            z6 = true;
                                                        }
                                                        if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                                            z4 = false;
                                                        }
                                                        mutableVector = mutableVector7;
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((nodePop2.getKindSet() & iM1552constructorimpl2) == 0 || !(nodePop2 instanceof DelegatingNode)) {
                                                        mutableVector = mutableVector7;
                                                    } else {
                                                        Modifier.Node delegate4 = ((DelegatingNode) nodePop2).getDelegate();
                                                        mutableVector = mutableVector7;
                                                        int i19 = 0;
                                                        while (delegate4 != null) {
                                                            if ((delegate4.getKindSet() & iM1552constructorimpl2) != 0) {
                                                                i19++;
                                                                i3 = iM1552constructorimpl2;
                                                                if (i19 == 1) {
                                                                    nodePop2 = delegate4;
                                                                } else {
                                                                    if (mutableVector8 == null) {
                                                                        i4 = i19;
                                                                        mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        i4 = i19;
                                                                    }
                                                                    if (nodePop2 != null) {
                                                                        mutableVector8.add(nodePop2);
                                                                        nodePop2 = null;
                                                                    }
                                                                    mutableVector8.add(delegate4);
                                                                    i19 = i4;
                                                                    delegate4 = delegate4.getChild();
                                                                    iM1552constructorimpl2 = i3;
                                                                }
                                                            } else {
                                                                i3 = iM1552constructorimpl2;
                                                            }
                                                            delegate4 = delegate4.getChild();
                                                            iM1552constructorimpl2 = i3;
                                                        }
                                                        i2 = iM1552constructorimpl2;
                                                        if (i19 != 1) {
                                                            nodePop2 = DelegatableNodeKt.pop(mutableVector8);
                                                        }
                                                        mutableVector7 = mutableVector;
                                                        iM1552constructorimpl2 = i2;
                                                    }
                                                    i2 = iM1552constructorimpl2;
                                                    nodePop2 = DelegatableNodeKt.pop(mutableVector8);
                                                    mutableVector7 = mutableVector;
                                                    iM1552constructorimpl2 = i2;
                                                }
                                            } else {
                                                nodePop2 = nodePop2.getChild();
                                                iM1552constructorimpl2 = iM1552constructorimpl2;
                                            }
                                        }
                                    }
                                    mutableVector7 = mutableVector7;
                                    iM1552constructorimpl2 = iM1552constructorimpl2;
                                }
                                if (z4) {
                                    if (z6) {
                                        focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState);
                                }
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                jArr2 = jArr9;
                                objArr2 = objArr6;
                            }
                        } else {
                            jArr2 = jArr9;
                            objArr2 = objArr6;
                        }
                        j3 >>= 8;
                        i17++;
                        jArr9 = jArr2;
                        objArr6 = objArr2;
                    }
                    jArr = jArr9;
                    objArr = objArr6;
                    i = 0;
                    if (i16 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr9;
                    objArr = objArr6;
                    i = 0;
                }
                if (i15 == length2) {
                    break;
                }
                i15++;
                jArr9 = jArr;
                objArr6 = objArr;
            }
        } else {
            i = 0;
        }
        this.focusEventNodes.clear();
        MutableScatterSet<FocusTargetNode> mutableScatterSet3 = this.focusTargetNodes;
        Object[] objArr7 = mutableScatterSet3.elements;
        long[] jArr10 = mutableScatterSet3.metadata;
        int length3 = jArr10.length - 2;
        if (length3 >= 0) {
            int i20 = i;
            while (true) {
                long j4 = jArr10[i20];
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i21 = 8 - ((~(i20 - length3)) >>> 31);
                    for (int i22 = i; i22 < i21; i22++) {
                        if ((j4 & 255) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr7[(i20 << 3) + i22];
                            if (focusTargetNode4.getIsAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        j4 >>= 8;
                    }
                    if (i21 != 8) {
                        break;
                    }
                }
                if (i20 == length3) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodes.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }
}
