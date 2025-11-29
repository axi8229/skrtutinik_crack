package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\n\u001a'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0013\u0010\u0014\u001a\u00020\b*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0019\u0010\u0007\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u001c\u0010!\u001a\u00020\u0016*\u0006\u0012\u0002\b\u00030\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "element", "", "calculateNodeKindSetFrom", "(Landroidx/compose/ui/Modifier$Element;)I", "Landroidx/compose/ui/Modifier$Node;", "node", "(Landroidx/compose/ui/Modifier$Node;)I", "", "autoInvalidateRemovedNode", "(Landroidx/compose/ui/Modifier$Node;)V", "autoInvalidateInsertedNode", "autoInvalidateUpdatedNode", "remainingSet", "phase", "autoInvalidateNodeIncludingDelegates", "(Landroidx/compose/ui/Modifier$Node;II)V", "selfKindSet", "autoInvalidateNodeSelf", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "scheduleInvalidationOfAssociatedFocusTargets", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)V", "", "specifiesCanFocusProperty", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)Z", "calculateNodeKindSetFromIncludingDelegates", "Landroidx/collection/MutableObjectIntMap;", "", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "includeSelfInTraversal", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NodeKindKt {
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(1);
        if (element instanceof LayoutModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            iM1552constructorimpl |= NodeKind.m1552constructorimpl(64);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? iM1552constructorimpl | NodeKind.m1552constructorimpl(128) : iM1552constructorimpl;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m1553getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m1552constructorimpl(128)) != 0;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet() & iM1552constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM1552constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
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
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) nodePop);
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object objClassKeyForObject = Actual_jvmKt.classKeyForObject(node);
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(objClassKeyForObject);
        if (iFindKeyIndex < 0) {
            int iM1552constructorimpl = NodeKind.m1552constructorimpl(1);
            if (node instanceof LayoutModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(2);
            }
            if (node instanceof DrawModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(4);
            }
            if (node instanceof SemanticsModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(8);
            }
            if (node instanceof PointerInputModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(16);
            }
            if (node instanceof ModifierLocalModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(32);
            }
            if (node instanceof ParentDataModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(64);
            }
            if (node instanceof LayoutAwareModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(128);
            }
            if (node instanceof GlobalPositionAwareModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(256);
            }
            if (node instanceof ApproachLayoutModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(512);
            }
            if (node instanceof FocusTargetNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(1024);
            }
            if (node instanceof FocusPropertiesModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(2048);
            }
            if (node instanceof FocusEventModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(4096);
            }
            if (node instanceof KeyInputModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(8192);
            }
            if (node instanceof RotaryInputModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(16384);
            }
            if (node instanceof CompositionLocalConsumerModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP);
            }
            if (node instanceof SoftKeyboardInterceptionModifierNode) {
                iM1552constructorimpl |= NodeKind.m1552constructorimpl(131072);
            }
            int iM1552constructorimpl2 = node instanceof TraversableNode ? NodeKind.m1552constructorimpl(262144) | iM1552constructorimpl : iM1552constructorimpl;
            mutableObjectIntMap.set(objClassKeyForObject, iM1552constructorimpl2);
            return iM1552constructorimpl2;
        }
        return mutableObjectIntMap.values[iFindKeyIndex];
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet() & i, i2);
            int i3 = (~delegatingNode.getSelfKindSet()) & i;
            for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                autoInvalidateNodeIncludingDelegates(delegate, i3, i2);
            }
            return;
        }
        autoInvalidateNodeSelf(node, i & node.getKindSet(), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m1552constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m1466requireCoordinator64DMado(node, NodeKind.m1552constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m1552constructorimpl(128) & i) != 0 && (node instanceof LayoutAwareModifierNode) && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m1552constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode) && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateOnPositioned$ui_release();
            }
            if ((NodeKind.m1552constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m1552constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m1552constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m1552constructorimpl(1024) & i) != 0 && (node instanceof FocusTargetNode) && i2 != 2) {
                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
            }
            if ((NodeKind.m1552constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i2 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i & NodeKind.m1552constructorimpl(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.applyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int selfKindSet = delegatingNode.getSelfKindSet();
            for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                selfKindSet |= calculateNodeKindSetFromIncludingDelegates(delegate);
            }
            return selfKindSet;
        }
        return calculateNodeKindSetFrom(node);
    }
}
