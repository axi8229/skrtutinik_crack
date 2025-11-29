package androidx.compose.ui.node;

import kotlin.Metadata;

/* compiled from: LayoutNodeLayoutDelegate.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "", "isOutMostLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegateKt {
    public static final boolean isOutMostLookaheadRoot(LayoutNode layoutNode) {
        if (layoutNode.getLookaheadRoot() != null) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLookaheadRoot() : null) == null || layoutNode.getLayoutDelegate().getDetachedFromParentLookaheadPass()) {
                return true;
            }
        }
        return false;
    }
}
