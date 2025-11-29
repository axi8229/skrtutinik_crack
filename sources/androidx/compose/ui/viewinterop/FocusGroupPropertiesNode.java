package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: FocusGroupNode.android.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J#\u0010\u001a\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b!\u0010 R$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "<init>", "()V", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTargetOfEmbeddedViewWrapper", "()Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "", "applyFocusProperties", "(Landroidx/compose/ui/focus/FocusProperties;)V", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "Landroidx/compose/ui/focus/FocusRequester;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onEnter", "onExit-3ESFkO8", "onExit", "Landroid/view/View;", "oldFocus", "newFocus", "onGlobalFocusChanged", "(Landroid/view/View;Landroid/view/View;)V", "onAttach", "onDetach", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {
    private View focusedChild;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new AnonymousClass1(this));
        focusProperties.setExit(new AnonymousClass2(this));
    }

    /* compiled from: FocusGroupNode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        AnonymousClass1(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onEnter", "onEnter-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m2204invoke3ESFkO8(focusDirection.getValue());
        }

        /* renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m2204invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m2202onEnter3ESFkO8(i);
        }
    }

    /* compiled from: FocusGroupNode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        AnonymousClass2(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onExit", "onExit-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m2205invoke3ESFkO8(focusDirection.getValue());
        }

        /* renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m2205invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m2203onExit3ESFkO8(i);
        }
    }

    /* renamed from: onEnter-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2202onEnter3ESFkO8(int focusDirection) {
        View view = FocusGroupNode_androidKt.getView(this);
        if (view.isFocused() || view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        return FocusInteropUtils_androidKt.requestInteropFocus(view, FocusInteropUtils_androidKt.m792toAndroidFocusDirection3ESFkO8(focusDirection), FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, (View) objRequireOwner, view)) ? FocusRequester.INSTANCE.getDefault() : FocusRequester.INSTANCE.getCancel();
    }

    /* renamed from: onExit-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2203onExit3ESFkO8(int focusDirection) {
        View viewFindNextFocusFromRect;
        View view = FocusGroupNode_androidKt.getView(this);
        if (!view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) objRequireOwner;
        if (view instanceof ViewGroup) {
            Rect currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, view2, view);
            Integer numM792toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m792toAndroidFocusDirection3ESFkO8(focusDirection);
            int iIntValue = numM792toAndroidFocusDirection3ESFkO8 != null ? numM792toAndroidFocusDirection3ESFkO8.intValue() : pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6;
            FocusFinder focusFinder = FocusFinder.getInstance();
            View view3 = this.focusedChild;
            if (view3 != null) {
                viewFindNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) view2, view3, iIntValue);
            } else {
                viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) view2, currentlyFocusedRect, iIntValue);
            }
            if (viewFindNextFocusFromRect != null && FocusGroupNode_androidKt.containsDescendant(view, viewFindNextFocusFromRect)) {
                viewFindNextFocusFromRect.requestFocus(iIntValue, currentlyFocusedRect);
                return FocusRequester.INSTANCE.getCancel();
            }
            if (!view2.requestFocus()) {
                throw new IllegalStateException("host view did not take focus");
            }
            return FocusRequester.INSTANCE.getDefault();
        }
        if (!view2.requestFocus()) {
            throw new IllegalStateException("host view did not take focus");
        }
        return FocusRequester.INSTANCE.getDefault();
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(1024);
        if (!getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet() & iM1552constructorimpl) != 0) {
            boolean z = false;
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM1552constructorimpl) != 0) {
                    Modifier.Node nodePop = child;
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
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner() == null) {
            return;
        }
        View view = FocusGroupNode_androidKt.getView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner ownerRequireOwner = DelegatableNodeKt.requireOwner(this);
        boolean z = (oldFocus == null || Intrinsics.areEqual(oldFocus, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view, oldFocus)) ? false : true;
        boolean z2 = (newFocus == null || Intrinsics.areEqual(newFocus, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view, newFocus)) ? false : true;
        if (z && z2) {
            this.focusedChild = newFocus;
            return;
        }
        if (!z2) {
            if (z) {
                this.focusedChild = null;
                if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                    focusOwner.mo795clearFocusI7lrPNg(false, true, false, FocusDirection.INSTANCE.m786getExitdhqQ8s());
                    return;
                }
                return;
            }
            this.focusedChild = null;
            return;
        }
        this.focusedChild = newFocus;
        FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
        if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
            return;
        }
        FocusTransactionManager focusTransactionManager = focusOwner.getFocusTransactionManager();
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
            focusTransactionManager.commitTransaction();
        } catch (Throwable th) {
            focusTransactionManager.commitTransaction();
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.getView(this).addOnAttachStateChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FocusGroupNode_androidKt.getView(this).removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        v.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        v.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }
}
