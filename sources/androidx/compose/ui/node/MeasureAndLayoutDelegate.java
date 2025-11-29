package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasureAndLayoutDelegate.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001:\u0001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u001f\u0010\u0017\u001a\u00020\r2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\r¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0005J$\u0010+\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J$\u0010-\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010*J\u0017\u0010.\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0005J\u0017\u0010/\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u0010\u001aJ+\u00102\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010\u001aJ\u001f\u00105\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u0010#J\u001f\u00106\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b6\u0010#J\u001f\u00107\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b7\u0010#J\u001b\u00108\u001a\u00020\r*\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b8\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010H\u001a\u00020F2\u0006\u0010G\u001a\u00020F8F@BX\u0086\u000e¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020L0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010ER\u001e\u0010N\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u0004\u0018\u00010P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0011\u0010U\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010W\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0018\u0010Z\u001a\u00020\r*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0018\u0010\\\u001a\u00020\r*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u0018\u0010^\u001a\u00020\r*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010YR\u0018\u0010`\u001a\u00020\r*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010Y\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "Landroidx/compose/ui/node/LayoutNode;", "root", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "updateRootConstraints-BRTryo0", "(J)V", "updateRootConstraints", "layoutNode", "", "forced", "requestLookaheadRemeasure", "(Landroidx/compose/ui/node/LayoutNode;Z)Z", "requestRemeasure", "requestLookaheadRelayout", "requestRelayout", "requestOnPositionedCallback", "Lkotlin/Function0;", "onLayout", "measureAndLayout", "(Lkotlin/jvm/functions/Function0;)Z", "measureOnly", "()V", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnLayoutCompletedListener", "(Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;)V", "affectsLookahead", "forceMeasureTheSubtree", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "forceDispatch", "dispatchOnPositionedCallbacks", "(Z)V", "node", "onNodeDetached", "doLookaheadRemeasure-sdFAvZA", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/unit/Constraints;)Z", "doLookaheadRemeasure", "doRemeasure-sdFAvZA", "doRemeasure", "remeasureLookaheadRootsInSubtree", "ensureSubtreeLookaheadReplaced", "callOnLayoutCompletedListeners", "relayoutNeeded", "remeasureAndRelayoutIfNeeded", "(Landroidx/compose/ui/node/LayoutNode;ZZ)Z", "drainPostponedMeasureRequests", "remeasureOnly", "onlyRemeasureIfScheduled", "forceMeasureTheSubtreeInternal", "measurePending", "Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "duringMeasureLayout", "Z", "duringFullMeasureLayoutPass", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "Landroidx/compose/runtime/collection/MutableVector;", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "", "<set-?>", "measureIteration", "J", "getMeasureIteration", "()J", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "postponedMeasureRequests", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "getHasPendingMeasureOrLayout", "()Z", "hasPendingMeasureOrLayout", "getHasPendingOnPositionedCallbacks", "hasPendingOnPositionedCallbacks", "getMeasureAffectsParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "measureAffectsParent", "getCanAffectParent", "canAffectParent", "getCanAffectParentInLookahead", "canAffectParentInLookahead", "getMeasureAffectsParentLookahead", "measureAffectsParentLookahead", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MeasureAndLayoutDelegate {
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringFullMeasureLayoutPass;
    private boolean duringMeasureLayout;
    private long measureIteration;
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners;
    private final OnPositionedDispatcher onPositionedDispatcher;
    private final MutableVector<PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;
    private Constraints rootConstraints;

    /* compiled from: MeasureAndLayoutDelegate.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode layoutNode) {
        this.root = layoutNode;
        Owner.Companion companion = Owner.INSTANCE;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = new DepthSortedSetsForDifferentPasses(companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSetsForDifferentPasses;
        this.onPositionedDispatcher = new OnPositionedDispatcher();
        this.onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
        this.measureIteration = 1L;
        MutableVector<PostponedRequest> mutableVector = new MutableVector<>(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = mutableVector;
        this.consistencyChecker = companion.getEnableExtraAssertions() ? new LayoutTreeConsistencyChecker(layoutNode, depthSortedSetsForDifferentPasses, mutableVector.asMutableList()) : null;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    public final long getMeasureIteration() {
        if (!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }
        return this.measureIteration;
    }

    /* renamed from: updateRootConstraints-BRTryo0, reason: not valid java name */
    public final void m1516updateRootConstraintsBRTryo0(long constraints) {
        Constraints constraints2 = this.rootConstraints;
        if (constraints2 == null ? false : Constraints.m2078equalsimpl0(constraints2.getValue(), constraints)) {
            return;
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
        }
        this.rootConstraints = Constraints.m2073boximpl(constraints);
        if (this.root.getLookaheadRoot() != null) {
            this.root.markLookaheadMeasurePending$ui_release();
        }
        this.root.markMeasurePending$ui_release();
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
        LayoutNode layoutNode = this.root;
        depthSortedSetsForDifferentPasses.add(layoutNode, layoutNode.getLookaheadRoot() != null);
    }

    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean forced) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        if (!(layoutNode.getLookaheadRoot() != null)) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2 || i == 3 || i == 4) {
            this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, forced));
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker == null) {
                return false;
            }
            layoutTreeConsistencyChecker.assertConsistent();
            return false;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (layoutNode.getLookaheadMeasurePending$ui_release() && !forced) {
            return false;
        }
        layoutNode.markLookaheadMeasurePending$ui_release();
        layoutNode.markMeasurePending$ui_release();
        if (layoutNode.getIsDeactivated()) {
            return false;
        }
        if ((Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode)) && ((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getLookaheadMeasurePending$ui_release())) {
            this.relayoutNodes.add(layoutNode, true);
        } else if ((layoutNode.isPlaced() || getCanAffectParent(layoutNode)) && ((parent$ui_release2 = layoutNode.getParent$ui_release()) == null || !parent$ui_release2.getMeasurePending$ui_release())) {
            this.relayoutNodes.add(layoutNode, false);
        }
        return !this.duringFullMeasureLayoutPass;
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z);
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean forced) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, forced));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i == 5) {
                if (!layoutNode.getMeasurePending$ui_release() || forced) {
                    layoutNode.markMeasurePending$ui_release();
                    if (!layoutNode.getIsDeactivated() && (layoutNode.isPlaced() || getCanAffectParent(layoutNode))) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()) {
                            this.relayoutNodes.add(layoutNode, false);
                        }
                        if (!this.duringFullMeasureLayoutPass) {
                            return true;
                        }
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }

    private final void ensureSubtreeLookaheadReplaced(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = content[i];
                if (Intrinsics.areEqual(layoutNode2.isPlacedInLookahead(), Boolean.TRUE) && !layoutNode2.getIsDeactivated()) {
                    if (this.relayoutNodes.contains(layoutNode2, true)) {
                        layoutNode2.lookaheadReplace$ui_release();
                    }
                    ensureSubtreeLookaheadReplaced(layoutNode2);
                }
                i++;
            } while (i < size);
        }
    }

    private final void forceMeasureTheSubtreeInternal(LayoutNode layoutNode, boolean affectsLookahead) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = content[i];
                if ((!affectsLookahead && getMeasureAffectsParent(layoutNode2)) || (affectsLookahead && getMeasureAffectsParentLookahead(layoutNode2))) {
                    if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(layoutNode2) && !affectsLookahead) {
                        if (layoutNode2.getLookaheadMeasurePending$ui_release() && this.relayoutNodes.contains(layoutNode2, true)) {
                            remeasureAndRelayoutIfNeeded(layoutNode2, true, false);
                        } else {
                            forceMeasureTheSubtree(layoutNode2, true);
                        }
                    }
                    onlyRemeasureIfScheduled(layoutNode2, affectsLookahead);
                    if (!measurePending(layoutNode2, affectsLookahead)) {
                        forceMeasureTheSubtreeInternal(layoutNode2, affectsLookahead);
                    }
                }
                i++;
            } while (i < size);
        }
        onlyRemeasureIfScheduled(layoutNode, affectsLookahead);
    }

    private final void remeasureLookaheadRootsInSubtree(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = content[i];
                if (getMeasureAffectsParent(layoutNode2)) {
                    if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(layoutNode2)) {
                        remeasureOnly(layoutNode2, true);
                    } else {
                        remeasureLookaheadRootsInSubtree(layoutNode2);
                    }
                }
                i++;
            } while (i < size);
        }
    }

    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean forced) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !forced) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            }
            layoutNode.markLookaheadLayoutPending$ui_release();
            layoutNode.markLayoutPending$ui_release();
            if (layoutNode.getIsDeactivated()) {
                return false;
            }
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) && ((parent$ui_release == null || !parent$ui_release.getLookaheadMeasurePending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getLookaheadLayoutPending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, true);
            } else if (layoutNode.isPlaced() && ((parent$ui_release == null || !parent$ui_release.getLayoutPending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, false);
            }
            return !this.duringFullMeasureLayoutPass;
        }
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
        if (layoutTreeConsistencyChecker2 == null) {
            return false;
        }
        layoutTreeConsistencyChecker2.assertConsistent();
        return false;
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean forced) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        } else if (i == 5) {
            if (!forced && layoutNode.isPlaced() == layoutNode.isPlacedByParent() && (layoutNode.getMeasurePending$ui_release() || layoutNode.getLayoutPending$ui_release())) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                if (layoutTreeConsistencyChecker2 != null) {
                    layoutTreeConsistencyChecker2.assertConsistent();
                }
            } else {
                layoutNode.markLayoutPending$ui_release();
                if (!layoutNode.getIsDeactivated() && layoutNode.isPlacedByParent()) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if ((parent$ui_release == null || !parent$ui_release.getLayoutPending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release())) {
                        this.relayoutNodes.add(layoutNode, false);
                    }
                    if (!this.duringFullMeasureLayoutPass) {
                        return true;
                    }
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA, reason: not valid java name */
    private final boolean m1513doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean zM1478lookaheadRemeasure_Sx5XlM$ui_release$default;
        if (layoutNode.getLookaheadRoot() == null) {
            return false;
        }
        if (constraints != null) {
            zM1478lookaheadRemeasure_Sx5XlM$ui_release$default = layoutNode.m1482lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        } else {
            zM1478lookaheadRemeasure_Sx5XlM$ui_release$default = LayoutNode.m1478lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (zM1478lookaheadRemeasure_Sx5XlM$ui_release$default && parent$ui_release != null) {
            if (parent$ui_release.getLookaheadRoot() == null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        }
        return zM1478lookaheadRemeasure_Sx5XlM$ui_release$default;
    }

    /* renamed from: doRemeasure-sdFAvZA, reason: not valid java name */
    private final boolean m1514doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean zM1479remeasure_Sx5XlM$ui_release$default;
        if (constraints != null) {
            zM1479remeasure_Sx5XlM$ui_release$default = layoutNode.m1483remeasure_Sx5XlM$ui_release(constraints);
        } else {
            zM1479remeasure_Sx5XlM$ui_release$default = LayoutNode.m1479remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (zM1479remeasure_Sx5XlM$ui_release$default && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        }
        return zM1479remeasure_Sx5XlM$ui_release$default;
    }

    public final void measureOnly() {
        if (this.relayoutNodes.isNotEmpty()) {
            if (!this.root.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            if (!this.root.isPlaced()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            if (this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                this.duringFullMeasureLayoutPass = false;
                try {
                    if (!this.relayoutNodes.isEmpty(true)) {
                        if (this.root.getLookaheadRoot() != null) {
                            remeasureOnly(this.root, true);
                        } else {
                            remeasureLookaheadRootsInSubtree(this.root);
                        }
                    }
                    remeasureOnly(this.root, false);
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw th;
                }
            }
        }
    }

    /* renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m1515measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        if (layoutNode.getIsDeactivated()) {
            return;
        }
        if (Intrinsics.areEqual(layoutNode, this.root)) {
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }
        if (!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = false;
            try {
                this.relayoutNodes.remove(layoutNode);
                if (m1513doLookaheadRemeasuresdFAvZA(layoutNode, Constraints.m2073boximpl(constraints)) || layoutNode.getLookaheadLayoutPending$ui_release()) {
                    if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                        layoutNode.lookaheadReplace$ui_release();
                    }
                }
                ensureSubtreeLookaheadReplaced(layoutNode);
                m1514doRemeasuresdFAvZA(layoutNode, Constraints.m2073boximpl(constraints));
                if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                    layoutNode.replace$ui_release();
                    this.onPositionedDispatcher.onNodePositioned(layoutNode);
                }
                drainPostponedMeasureRequests();
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
    }

    public final boolean measureAndLayout(Function0<Unit> onLayout) {
        boolean z;
        if (!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        boolean z2 = false;
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = true;
            try {
                if (this.relayoutNodes.isNotEmpty()) {
                    DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
                    z = false;
                    while (depthSortedSetsForDifferentPasses.isNotEmpty()) {
                        boolean zIsEmpty = depthSortedSetsForDifferentPasses.lookaheadSet.isEmpty();
                        boolean z3 = !zIsEmpty;
                        LayoutNode layoutNodePop = (!zIsEmpty ? depthSortedSetsForDifferentPasses.lookaheadSet : depthSortedSetsForDifferentPasses.set).pop();
                        boolean zRemeasureAndRelayoutIfNeeded$default = remeasureAndRelayoutIfNeeded$default(this, layoutNodePop, z3, false, 4, null);
                        if (layoutNodePop == this.root && zRemeasureAndRelayoutIfNeeded$default) {
                            z = true;
                        }
                    }
                    if (onLayout != null) {
                        onLayout.invoke();
                    }
                } else {
                    z = false;
                }
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                z2 = z;
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
        return z2;
    }

    public final void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.onLayoutCompletedListeners.add(listener);
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Owner.OnLayoutCompletedListener[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].onLayoutComplete();
                i++;
            } while (i < size);
        }
        this.onLayoutCompletedListeners.clear();
    }

    static /* synthetic */ boolean remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return measureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(layoutNode, z, z2);
    }

    private final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode, boolean affectsLookahead, boolean relayoutNeeded) {
        Constraints constraints;
        LayoutNode parent$ui_release;
        if (layoutNode.getIsDeactivated()) {
            return false;
        }
        if (layoutNode.isPlaced() || layoutNode.isPlacedByParent() || getCanAffectParent(layoutNode) || Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode) || layoutNode.getAlignmentLinesRequired$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (affectsLookahead) {
                zM1513doLookaheadRemeasuresdFAvZA = layoutNode.getLookaheadMeasurePending$ui_release() ? m1513doLookaheadRemeasuresdFAvZA(layoutNode, constraints) : false;
                if (relayoutNeeded && ((zM1513doLookaheadRemeasuresdFAvZA || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE))) {
                    layoutNode.lookaheadReplace$ui_release();
                }
            } else {
                boolean zM1514doRemeasuresdFAvZA = layoutNode.getMeasurePending$ui_release() ? m1514doRemeasuresdFAvZA(layoutNode, constraints) : false;
                if (relayoutNeeded && layoutNode.getLayoutPending$ui_release() && (layoutNode == this.root || ((parent$ui_release = layoutNode.getParent$ui_release()) != null && parent$ui_release.isPlaced() && layoutNode.isPlacedByParent()))) {
                    if (layoutNode == this.root) {
                        layoutNode.place$ui_release(0, 0);
                    } else {
                        layoutNode.replace$ui_release();
                    }
                    this.onPositionedDispatcher.onNodePositioned(layoutNode);
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                }
                zM1513doLookaheadRemeasuresdFAvZA = zM1514doRemeasuresdFAvZA;
            }
            drainPostponedMeasureRequests();
        }
        return zM1513doLookaheadRemeasuresdFAvZA;
    }

    private final void drainPostponedMeasureRequests() {
        if (this.postponedMeasureRequests.isNotEmpty()) {
            MutableVector<PostponedRequest> mutableVector = this.postponedMeasureRequests;
            int size = mutableVector.getSize();
            if (size > 0) {
                PostponedRequest[] content = mutableVector.getContent();
                int i = 0;
                do {
                    PostponedRequest postponedRequest = content[i];
                    if (postponedRequest.getNode().isAttached()) {
                        if (!postponedRequest.getIsLookahead()) {
                            LayoutNode.requestRemeasure$ui_release$default(postponedRequest.getNode(), postponedRequest.getIsForced(), false, false, 2, null);
                        } else {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(postponedRequest.getNode(), postponedRequest.getIsForced(), false, false, 2, null);
                        }
                    }
                    i++;
                } while (i < size);
            }
            this.postponedMeasureRequests.clear();
        }
    }

    private final void remeasureOnly(LayoutNode layoutNode, boolean affectsLookahead) {
        Constraints constraints;
        if (layoutNode.getIsDeactivated()) {
            return;
        }
        if (layoutNode == this.root) {
            constraints = this.rootConstraints;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (affectsLookahead) {
            m1513doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            m1514doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        if (this.relayoutNodes.isEmpty(affectsLookahead)) {
            return;
        }
        if (!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (measurePending(layoutNode, affectsLookahead)) {
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }
        forceMeasureTheSubtreeInternal(layoutNode, affectsLookahead);
    }

    private final void onlyRemeasureIfScheduled(LayoutNode node, boolean affectsLookahead) {
        if (measurePending(node, affectsLookahead) && this.relayoutNodes.contains(node, affectsLookahead)) {
            remeasureAndRelayoutIfNeeded(node, affectsLookahead, false);
        }
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean forceDispatch) {
        if (forceDispatch) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode node) {
        this.relayoutNodes.remove(node);
        this.onPositionedDispatcher.remove(node);
    }

    private final boolean getMeasureAffectsParent(LayoutNode layoutNode) {
        return layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getLayoutDelegate().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release();
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getMeasurePending$ui_release() && getMeasureAffectsParent(layoutNode);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        return layoutNode.getLookaheadMeasurePending$ui_release() && getMeasureAffectsParentLookahead(layoutNode);
    }

    private final boolean getMeasureAffectsParentLookahead(LayoutNode layoutNode) {
        AlignmentLines alignmentLines;
        if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNode.getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
        return (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) ? false : true;
    }

    private final boolean measurePending(LayoutNode layoutNode, boolean z) {
        return z ? layoutNode.getLookaheadMeasurePending$ui_release() : layoutNode.getMeasurePending$ui_release();
    }

    /* compiled from: MeasureAndLayoutDelegate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostponedRequest {
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        public PostponedRequest(LayoutNode layoutNode, boolean z, boolean z2) {
            this.node = layoutNode;
            this.isLookahead = z;
            this.isForced = z2;
        }

        public final LayoutNode getNode() {
            return this.node;
        }

        /* renamed from: isForced, reason: from getter */
        public final boolean getIsForced() {
            return this.isForced;
        }

        /* renamed from: isLookahead, reason: from getter */
        public final boolean getIsLookahead() {
            return this.isLookahead;
        }
    }
}
