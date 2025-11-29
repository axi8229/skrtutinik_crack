package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001aF\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "previouslyFocusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m812customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusProperties focusPropertiesFetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m780equalsimpl0(i, companion.m788getNextdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m789getPreviousdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m791getUpdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m784getDowndhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m787getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                end = focusPropertiesFetchFocusProperties$ui_release.getStart();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = focusPropertiesFetchFocusProperties$ui_release.getEnd();
            }
            if (end == FocusRequester.INSTANCE.getDefault()) {
                end = null;
            }
            if (end == null) {
                return focusPropertiesFetchFocusProperties$ui_release.getLeft();
            }
        } else if (FocusDirection.m780equalsimpl0(i, companion.m790getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                end = focusPropertiesFetchFocusProperties$ui_release.getEnd();
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = focusPropertiesFetchFocusProperties$ui_release.getStart();
            }
            if (end == FocusRequester.INSTANCE.getDefault()) {
                end = null;
            }
            if (end == null) {
                return focusPropertiesFetchFocusProperties$ui_release.getRight();
            }
        } else {
            if (FocusDirection.m780equalsimpl0(i, companion.m785getEnterdhqQ8s())) {
                return focusPropertiesFetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.m777boximpl(i));
            }
            if (FocusDirection.m780equalsimpl0(i, companion.m786getExitdhqQ8s())) {
                return focusPropertiesFetchFocusProperties$ui_release.getExit().invoke(FocusDirection.m777boximpl(i));
            }
            throw new IllegalStateException("invalid FocusDirection");
        }
        return end;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM1552constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM1552constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (!(nodePop instanceof FocusTargetNode)) {
                                if ((nodePop.getKindSet() & iM1552constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return focusTargetNode2;
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* renamed from: focusSearch-0X8WOeE, reason: not valid java name */
    public static final Boolean m813focusSearch0X8WOeE(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        int iM790getRightdhqQ8s;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m780equalsimpl0(i, companion.m788getNextdhqQ8s()) ? true : FocusDirection.m780equalsimpl0(i, companion.m789getPreviousdhqQ8s())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.m816oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1));
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m787getLeftdhqQ8s()) ? true : FocusDirection.m780equalsimpl0(i, companion.m790getRightdhqQ8s()) ? true : FocusDirection.m780equalsimpl0(i, companion.m791getUpdhqQ8s()) ? true : FocusDirection.m780equalsimpl0(i, companion.m784getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m825twoDimensionalFocusSearchsMXa3k8(focusTargetNode, i, rect, function1);
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m785getEnterdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                iM790getRightdhqQ8s = companion.m790getRightdhqQ8s();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                iM790getRightdhqQ8s = companion.m787getLeftdhqQ8s();
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode = findActiveFocusNode(focusTargetNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m825twoDimensionalFocusSearchsMXa3k8(focusTargetNodeFindActiveFocusNode, iM790getRightdhqQ8s, rect, function1);
            }
            return null;
        }
        if (FocusDirection.m780equalsimpl0(i, companion.m786getExitdhqQ8s())) {
            FocusTargetNode focusTargetNodeFindActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
            FocusTargetNode focusTargetNodeFindNonDeactivatedParent = focusTargetNodeFindActiveFocusNode2 != null ? findNonDeactivatedParent(focusTargetNodeFindActiveFocusNode2) : null;
            return Boolean.valueOf((focusTargetNodeFindNonDeactivatedParent == null || Intrinsics.areEqual(focusTargetNodeFindNonDeactivatedParent, focusTargetNode)) ? false : function1.invoke(focusTargetNodeFindNonDeactivatedParent).booleanValue());
        }
        throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m782toStringimpl(i))).toString());
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        Rect rectLocalBoundingBoxOf;
        NodeCoordinator coordinator = focusTargetNode.getCoordinator();
        return (coordinator == null || (rectLocalBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(coordinator).localBoundingBoxOf(coordinator, false)) == null) ? Rect.INSTANCE.getZero() : rectLocalBoundingBoxOf;
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator2 = focusTargetNode.getCoordinator();
        return (coordinator2 == null || (layoutNode = coordinator2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator = focusTargetNode.getCoordinator()) == null || (layoutNode2 = coordinator.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x003b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode getActiveChild(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            boolean r0 = r0.getIsAttached()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m1552constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r2 = r10.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 == 0) goto Ld1
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            r3 = 16
            androidx.compose.ui.Modifier$Node[] r4 = new androidx.compose.ui.Modifier.Node[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.Modifier$Node r4 = r10.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getChild()
            if (r4 != 0) goto L38
            androidx.compose.ui.Modifier$Node r10 = r10.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10)
            goto L3b
        L38:
            r2.add(r4)
        L3b:
            boolean r10 = r2.isNotEmpty()
            if (r10 == 0) goto Ld0
            int r10 = r2.getSize()
            r4 = 1
            int r10 = r10 - r4
            java.lang.Object r10 = r2.removeAt(r10)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r6 = r10.getAggregateChildKindSet()
            r6 = r6 & r0
            if (r6 != 0) goto L58
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10)
            goto L3b
        L58:
            if (r10 == 0) goto L3b
            int r6 = r10.getKindSet()
            r6 = r6 & r0
            if (r6 == 0) goto Lcb
            r6 = r1
        L62:
            if (r10 == 0) goto L3b
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L8a
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.Modifier$Node r7 = r10.getNode()
            boolean r7 = r7.getIsAttached()
            if (r7 == 0) goto Lc6
            androidx.compose.ui.focus.FocusStateImpl r7 = r10.getFocusState()
            int[] r8 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r4) goto L89
            r8 = 2
            if (r7 == r8) goto L89
            r8 = 3
            if (r7 == r8) goto L89
            goto Lc6
        L89:
            return r10
        L8a:
            int r7 = r10.getKindSet()
            r7 = r7 & r0
            if (r7 == 0) goto Lc6
            boolean r7 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto Lc6
            r7 = r10
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = r5
        L9d:
            if (r7 == 0) goto Lc3
            int r9 = r7.getKindSet()
            r9 = r9 & r0
            if (r9 == 0) goto Lbe
            int r8 = r8 + 1
            if (r8 != r4) goto Lac
            r10 = r7
            goto Lbe
        Lac:
            if (r6 != 0) goto Lb5
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r3]
            r6.<init>(r9, r5)
        Lb5:
            if (r10 == 0) goto Lbb
            r6.add(r10)
            r10 = r1
        Lbb:
            r6.add(r7)
        Lbe:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L9d
        Lc3:
            if (r8 != r4) goto Lc6
            goto L62
        Lc6:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L62
        Lcb:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild()
            goto L58
        Ld0:
            return r1
        Ld1:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitChildren called on an unattached node"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.getActiveChild(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x004f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.focus.FocusStateImpl r0 = r10.getFocusState()
            int[] r1 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto Ld4
            r2 = 2
            r3 = 0
            if (r0 == r2) goto L20
            r1 = 3
            if (r0 == r1) goto Ld4
            r10 = 4
            if (r0 != r10) goto L1a
            return r3
        L1a:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L20:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m1552constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r2 = r10.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 == 0) goto Lcb
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            r4 = 16
            androidx.compose.ui.Modifier$Node[] r5 = new androidx.compose.ui.Modifier.Node[r4]
            r6 = 0
            r2.<init>(r5, r6)
            androidx.compose.ui.Modifier$Node r5 = r10.getNode()
            androidx.compose.ui.Modifier$Node r5 = r5.getChild()
            if (r5 != 0) goto L4c
            androidx.compose.ui.Modifier$Node r10 = r10.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10)
            goto L4f
        L4c:
            r2.add(r5)
        L4f:
            boolean r10 = r2.isNotEmpty()
            if (r10 == 0) goto Lca
            int r10 = r2.getSize()
            int r10 = r10 - r1
            java.lang.Object r10 = r2.removeAt(r10)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r5 = r10.getAggregateChildKindSet()
            r5 = r5 & r0
            if (r5 != 0) goto L6b
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10)
            goto L4f
        L6b:
            if (r10 == 0) goto L4f
            int r5 = r10.getKindSet()
            r5 = r5 & r0
            if (r5 == 0) goto Lc5
            r5 = r3
        L75:
            if (r10 == 0) goto L4f
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L84
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.focus.FocusTargetNode r10 = findActiveFocusNode(r10)
            if (r10 == 0) goto Lc0
            return r10
        L84:
            int r7 = r10.getKindSet()
            r7 = r7 & r0
            if (r7 == 0) goto Lc0
            boolean r7 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto Lc0
            r7 = r10
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = r6
        L97:
            if (r7 == 0) goto Lbd
            int r9 = r7.getKindSet()
            r9 = r9 & r0
            if (r9 == 0) goto Lb8
            int r8 = r8 + 1
            if (r8 != r1) goto La6
            r10 = r7
            goto Lb8
        La6:
            if (r5 != 0) goto Laf
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r4]
            r5.<init>(r9, r6)
        Laf:
            if (r10 == 0) goto Lb5
            r5.add(r10)
            r10 = r3
        Lb5:
            r5.add(r7)
        Lb8:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L97
        Lbd:
            if (r8 != r1) goto Lc0
            goto L75
        Lc0:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r5)
            goto L75
        Lc5:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild()
            goto L6b
        Lca:
            return r3
        Lcb:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitChildren called on an unattached node"
            r10.<init>(r0)
            throw r10
        Ld4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }
}
