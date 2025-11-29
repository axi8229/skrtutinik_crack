package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatingNode.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0019*\u00020\u00182\u0006\u0010\u001a\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0018H\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020\u0007H\u0010¢\u0006\u0004\b \u0010\u0003J\u000f\u0010#\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010%\u001a\u00020\u0007H\u0010¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010'\u001a\u00020\u0007H\u0010¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010)\u001a\u00020\u0007H\u0010¢\u0006\u0004\b(\u0010\u0003R \u0010*\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010\u0003\u001a\u0004\b,\u0010-R$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0016¨\u00063"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "", "delegateKindSet", "delegateNode", "", "validateDelegateKindSet", "(ILandroidx/compose/ui/Modifier$Node;)V", "newKindSet", "", "recalculateOwner", "updateNodeKindSet", "(IZ)V", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "updateCoordinator$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "updateCoordinator", "owner", "setAsDelegateTo$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "setAsDelegateTo", "Landroidx/compose/ui/node/DelegatableNode;", "T", "delegatableNode", "delegate", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "instance", "undelegate", "(Landroidx/compose/ui/node/DelegatableNode;)V", "markAsAttached$ui_release", "markAsAttached", "runAttachLifecycle$ui_release", "runAttachLifecycle", "runDetachLifecycle$ui_release", "runDetachLifecycle", "markAsDetached$ui_release", "markAsDetached", "reset$ui_release", "reset", "selfKindSet", "I", "getSelfKindSet$ui_release", "()I", "getSelfKindSet$ui_release$annotations", "Landroidx/compose/ui/Modifier$Node;", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    /* renamed from: getSelfKindSet$ui_release, reason: from getter */
    public final int getSelfKindSet() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui_release(coordinator);
        }
    }

    /* renamed from: getDelegate$ui_release, reason: from getter */
    public final Modifier.Node getDelegate() {
        return this.delegate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui_release(Modifier.Node owner) {
        super.setAsDelegateTo$ui_release(owner);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.setAsDelegateTo$ui_release(owner);
        }
    }

    protected final <T extends DelegatableNode> T delegate(T delegatableNode) {
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node parent = node2 != null ? node2.getParent() : null;
            if (node == getNode() && Intrinsics.areEqual(parent, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node");
        }
        if (node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui_release(getNode());
        int kindSet = getKindSet();
        int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
        node.setKindSet$ui_release(iCalculateNodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(iCalculateNodeKindSetFromIncludingDelegates, node);
        node.setChild$ui_release(this.delegate);
        this.delegate = node;
        node.setParent$ui_release(this);
        updateNodeKindSet(getKindSet() | iCalculateNodeKindSetFromIncludingDelegates, false);
        if (getIsAttached()) {
            if ((iCalculateNodeKindSetFromIncludingDelegates & NodeKind.m1552constructorimpl(2)) != 0 && (kindSet & NodeKind.m1552constructorimpl(2)) == 0) {
                NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                getNode().updateCoordinator$ui_release(null);
                nodes.syncCoordinators();
            } else {
                updateCoordinator$ui_release(getCoordinator());
            }
            node.markAsAttached$ui_release();
            node.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
        return delegatableNode;
    }

    protected final void undelegate(DelegatableNode instance) {
        Modifier.Node node = null;
        for (Modifier.Node child = this.delegate; child != null; child = child.getChild()) {
            if (child == instance) {
                if (child.getIsAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(child);
                    child.runDetachLifecycle$ui_release();
                    child.markAsDetached$ui_release();
                }
                child.setAsDelegateTo$ui_release(child);
                child.setAggregateChildKindSet$ui_release(0);
                if (node == null) {
                    this.delegate = child.getChild();
                } else {
                    node.setChild$ui_release(child.getChild());
                }
                child.setChild$ui_release(null);
                child.setParent$ui_release(null);
                int kindSet = getKindSet();
                int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(iCalculateNodeKindSetFromIncludingDelegates, true);
                if (getIsAttached() && (kindSet & NodeKind.m1552constructorimpl(2)) != 0 && (NodeKind.m1552constructorimpl(2) & iCalculateNodeKindSetFromIncludingDelegates) == 0) {
                    NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                    getNode().updateCoordinator$ui_release(null);
                    nodes.syncCoordinators();
                    return;
                }
                return;
            }
            node = child;
        }
        throw new IllegalStateException(("Could not find delegate: " + instance).toString());
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int kindSet = getKindSet();
        if ((delegateKindSet & NodeKind.m1552constructorimpl(2)) == 0 || (NodeKind.m1552constructorimpl(2) & kindSet) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode);
    }

    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        Modifier.Node child;
        int kindSet = getKindSet();
        setKindSet$ui_release(newKindSet);
        if (kindSet != newKindSet) {
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui_release(newKindSet);
            }
            if (getIsAttached()) {
                Modifier.Node node = getNode();
                Modifier.Node parent = this;
                while (parent != null) {
                    newKindSet |= parent.getKindSet();
                    parent.setKindSet$ui_release(newKindSet);
                    if (parent == node) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (recalculateOwner && parent == node) {
                    newKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui_release(newKindSet);
                }
                int aggregateChildKindSet = newKindSet | ((parent == null || (child = parent.getChild()) == null) ? 0 : child.getAggregateChildKindSet());
                while (parent != null) {
                    aggregateChildKindSet |= parent.getKindSet();
                    parent.setAggregateChildKindSet$ui_release(aggregateChildKindSet);
                    parent = parent.getParent();
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui_release(getCoordinator());
            if (!delegate.getIsAttached()) {
                delegate.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.reset$ui_release();
        }
    }
}
