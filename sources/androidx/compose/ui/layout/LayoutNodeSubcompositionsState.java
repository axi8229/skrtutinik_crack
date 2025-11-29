package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003stuB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000e\u0010\u0012J?\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\f*\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010%J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b+\u0010,J)\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010/\u001a\u00020\u001dH\u0002¢\u0006\u0004\b0\u00101J-\u00104\u001a\b\u0012\u0004\u0012\u000203022\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\fH\u0016¢\u0006\u0004\b6\u0010%J\u000f\u00107\u001a\u00020\fH\u0016¢\u0006\u0004\b7\u0010%J\u000f\u00108\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u0010%J+\u0010\u000e\u001a\b\u0012\u0004\u0012\u000203022\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u00105J\u0015\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\f¢\u0006\u0004\b<\u0010%J'\u0010C\u001a\u00020B2\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0=¢\u0006\u0004\bC\u0010DJ%\u0010F\u001a\u00020E2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020\f¢\u0006\u0004\bH\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010IR$\u0010J\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010\u0005\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR0\u0010[\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100Yj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R4\u0010]\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020Yj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0002`Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010\\R\u0018\u0010_\u001a\u00060^R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010b\u001a\u00060aR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR4\u0010d\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020Yj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0002`Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010\\R\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010i\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020E0h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001c\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010WR\u0016\u0010o\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010WR\u0014\u0010q\u001a\u00020p8\u0002X\u0082D¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006v"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/LayoutNode;", "root", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "slotReusePolicy", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "node", "", "slotId", "Lkotlin/Function0;", "", "content", "subcompose", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;)V", "Landroidx/compose/runtime/ReusableComposition;", "existing", "container", "", "reuseContent", "Landroidx/compose/runtime/CompositionContext;", "parent", "composable", "subcomposeInto", "(Landroidx/compose/runtime/ReusableComposition;Landroidx/compose/ui/node/LayoutNode;ZLandroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/ReusableComposition;", "", "index", "getSlotIdAtIndex", "(I)Ljava/lang/Object;", "deactivate", "markActiveNodesAsReused", "(Z)V", "disposeCurrentNodes", "()V", "resetLayoutState", "(Landroidx/compose/ui/node/LayoutNode;)V", "takeNodeFromReusables", "(Ljava/lang/Object;)Landroidx/compose/ui/node/LayoutNode;", "disposeUnusedSlotsInPostLookahead", "createNodeAt", "(I)Landroidx/compose/ui/node/LayoutNode;", RemoteMessageConst.FROM, RemoteMessageConst.TO, "count", "move", "(III)V", "", "Landroidx/compose/ui/layout/Measurable;", "postLookaheadSubcompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "onReuse", "onDeactivate", "onRelease", "startIndex", "disposeOrReuseStartingFromIndex", "(I)V", "makeSureStateIsConsistent", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "block", "Landroidx/compose/ui/layout/MeasurePolicy;", "createMeasurePolicy", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "forceRecomposeChildren", "Landroidx/compose/ui/node/LayoutNode;", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "currentIndex", "I", "currentPostLookaheadIndex", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeToNodeState", "Ljava/util/HashMap;", "slotIdToNode", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "postLookaheadMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "precomposeMap", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "", "postLookaheadPrecomposeSlotHandleMap", "Ljava/util/Map;", "Landroidx/compose/runtime/collection/MutableVector;", "postLookaheadComposedSlotIds", "Landroidx/compose/runtime/collection/MutableVector;", "reusableCount", "precomposedCount", "", "NoIntrinsicsMessage", "Ljava/lang/String;", "NodeState", "PostLookaheadMeasureScopeImpl", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    private CompositionContext compositionContext;
    private int currentIndex;
    private int currentPostLookaheadIndex;
    private int precomposedCount;
    private int reusableCount;
    private final LayoutNode root;
    private SubcomposeSlotReusePolicy slotReusePolicy;
    private final HashMap<LayoutNode, NodeState> nodeToNodeState = new HashMap<>();
    private final HashMap<Object, LayoutNode> slotIdToNode = new HashMap<>();
    private final Scope scope = new Scope();
    private final PostLookaheadMeasureScopeImpl postLookaheadMeasureScope = new PostLookaheadMeasureScopeImpl();
    private final HashMap<Object, LayoutNode> precomposeMap = new HashMap<>();
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);
    private final Map<Object, SubcomposeLayoutState.PrecomposedSlotHandle> postLookaheadPrecomposeSlotHandleMap = new LinkedHashMap();
    private final MutableVector<Object> postLookaheadComposedSlotIds = new MutableVector<>(new Object[16], 0);
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ]\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00102\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0014\u0010-\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "", "slotId", "Lkotlin/Function0;", "", "content", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "", "width", "height", "", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "", "density", "F", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "", "isLookingAhead", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getWidth, reason: from getter */
                public int get$width() {
                    return width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getHeight, reason: from getter */
                public int get$height() {
                    return height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Function1<RulerScope, Unit> getRulers() {
                    return rulers;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    LookaheadDelegate lookaheadDelegate;
                    if (!this.isLookingAhead() || (lookaheadDelegate = layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getLookaheadDelegate()) == null) {
                        placementBlock.invoke(layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getPlacementScope());
                    } else {
                        placementBlock.invoke(lookaheadDelegate.getPlacementScope());
                    }
                }
            };
        }

        public Scope() {
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, null);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        disposeCurrentNodes();
    }

    public final List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Measuring;
        if (!(layoutState$ui_release == layoutState || layoutState$ui_release == LayoutNode.LayoutState.LayingOut || layoutState$ui_release == LayoutNode.LayoutState.LookaheadMeasuring || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut)) {
            InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
        }
        HashMap<Object, LayoutNode> map = this.slotIdToNode;
        LayoutNode layoutNodeRemove = map.get(slotId);
        if (layoutNodeRemove == null) {
            layoutNodeRemove = this.precomposeMap.remove(slotId);
            if (layoutNodeRemove != null) {
                if (!(this.precomposedCount > 0)) {
                    InlineClassHelperKt.throwIllegalStateException("Check failed.");
                }
                this.precomposedCount--;
            } else {
                LayoutNode layoutNodeTakeNodeFromReusables = takeNodeFromReusables(slotId);
                if (layoutNodeTakeNodeFromReusables == null) {
                    layoutNodeTakeNodeFromReusables = createNodeAt(this.currentIndex);
                }
                layoutNodeRemove = layoutNodeTakeNodeFromReusables;
            }
            map.put(slotId, layoutNodeRemove);
        }
        LayoutNode layoutNode = layoutNodeRemove;
        if (CollectionsKt.getOrNull(this.root.getFoldedChildren$ui_release(), this.currentIndex) != layoutNode) {
            int iIndexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNode);
            int i = this.currentIndex;
            if (iIndexOf < i) {
                throw new IllegalArgumentException(("Key \"" + slotId + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
            }
            if (i != iIndexOf) {
                move$default(this, iIndexOf, i, 0, 4, null);
            }
        }
        this.currentIndex++;
        subcompose(layoutNode, slotId, content);
        if (layoutState$ui_release == layoutState || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
            return layoutNode.getChildMeasurables$ui_release();
        }
        return layoutNode.getChildLookaheadMeasurables$ui_release();
    }

    private final void subcompose(LayoutNode node, Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        HashMap<LayoutNode, NodeState> map = this.nodeToNodeState;
        NodeState nodeState = map.get(node);
        if (nodeState == null) {
            nodeState = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m1410getLambda1$ui_release(), null, 4, null);
            map.put(node, nodeState);
        }
        NodeState nodeState2 = nodeState;
        ReusableComposition composition = nodeState2.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState2.getContent() != content || hasInvalidations || nodeState2.getForceRecompose()) {
            nodeState2.setContent(content);
            subcompose(node, nodeState2);
            nodeState2.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode node, final NodeState nodeState) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LayoutNode layoutNode = this.root;
            layoutNode.ignoreRemeasureRequests = true;
            final Function2<Composer, Integer, Unit> content = nodeState.getContent();
            ReusableComposition composition = nodeState.getComposition();
            CompositionContext compositionContext = this.compositionContext;
            if (compositionContext != null) {
                nodeState.setComposition(subcomposeInto(composition, node, nodeState.getForceReuse(), compositionContext, ComposableLambdaKt.composableLambdaInstance(-1750409193, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1750409193, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:493)");
                        }
                        boolean active = nodeState.getActive();
                        Function2<Composer, Integer, Unit> function2 = content;
                        composer.startReusableGroup(207, Boolean.valueOf(active));
                        boolean zChanged = composer.changed(active);
                        composer.startReplaceGroup(-869707859);
                        if (active) {
                            function2.invoke(composer, 0);
                        } else {
                            composer.deactivateToEndGroup(zChanged);
                        }
                        composer.endReplaceGroup();
                        composer.endReusableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                })));
                nodeState.setForceReuse(false);
                layoutNode.ignoreRemeasureRequests = false;
                Unit unit = Unit.INSTANCE;
                return;
            }
            throw new IllegalStateException("parent composition reference not set");
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    private final ReusableComposition subcomposeInto(ReusableComposition existing, LayoutNode container, boolean reuseContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> composable) {
        if (existing == null || existing.getDisposed()) {
            existing = Wrapper_androidKt.createSubcomposition(container, parent);
        }
        if (!reuseContent) {
            existing.setContent(composable);
        } else {
            existing.setContentWithReuse(composable);
        }
        return existing;
    }

    private final Object getSlotIdAtIndex(int index) {
        NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        boolean z = false;
        this.reusableCount = 0;
        int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        if (startIndex <= size) {
            this.reusableSlotIdsSet.clear();
            if (startIndex <= size) {
                int i = startIndex;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i));
                    if (i == size) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            boolean z2 = false;
            while (size >= startIndex) {
                try {
                    LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(size);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    Intrinsics.checkNotNull(nodeState);
                    NodeState nodeState2 = nodeState;
                    Object slotId = nodeState2.getSlotId();
                    if (this.reusableSlotIdsSet.contains(slotId)) {
                        this.reusableCount++;
                        if (nodeState2.getActive()) {
                            resetLayoutState(layoutNode);
                            nodeState2.setActive(false);
                            z2 = true;
                        }
                    } else {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        ReusableComposition composition = nodeState2.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui_release(size, 1);
                        layoutNode2.ignoreRemeasureRequests = false;
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            z = z2;
        }
        if (z) {
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    private final void markActiveNodesAsReused(boolean deactivate) {
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        int size = this.root.getFoldedChildren$ui_release().size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            for (int i = 0; i < size; i++) {
                try {
                    LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(i);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && nodeState.getActive()) {
                        resetLayoutState(layoutNode);
                        if (deactivate) {
                            ReusableComposition composition = nodeState.getComposition();
                            if (composition != null) {
                                composition.deactivate();
                            }
                            nodeState.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null));
                        } else {
                            nodeState.setActive(false);
                        }
                        nodeState.setSlotId(SubcomposeLayoutKt.ReusedSlotId);
                    }
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    private final void disposeCurrentNodes() {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        Iterator<T> it = this.nodeToNodeState.values().iterator();
        while (it.hasNext()) {
            ReusableComposition composition = ((NodeState) it.next()).getComposition();
            if (composition != null) {
                composition.dispose();
            }
        }
        this.root.removeAll$ui_release();
        layoutNode.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        int size = this.root.getFoldedChildren$ui_release().size();
        if (this.nodeToNodeState.size() != size) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        }
        if ((size - this.reusableCount) - this.precomposedCount >= 0) {
            if (this.precomposeMap.size() == this.precomposedCount) {
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
        }
        throw new IllegalArgumentException(("Incorrect state. Total children " + size + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
    }

    private final void resetLayoutState(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        measurePassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
        }
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        int size = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int i2 = size - this.reusableCount;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(getSlotIdAtIndex(i4), slotId)) {
                i = i4;
                break;
            }
            i4--;
        }
        if (i == -1) {
            while (i3 >= i2) {
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(i3));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (nodeState2.getSlotId() == SubcomposeLayoutKt.ReusedSlotId || this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    i4 = i3;
                    i = i4;
                    break;
                }
                i3--;
            }
            i4 = i3;
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            move(i4, i2, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(i2);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null));
        nodeState4.setForceReuse(true);
        nodeState4.setForceRecompose(true);
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> block) {
        return new LayoutNode.NoIntrinsicsMeasurePolicy(this.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo87measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                LayoutNodeSubcompositionsState.this.scope.setLayoutDirection(measureScope.getLayoutDirection());
                LayoutNodeSubcompositionsState.this.scope.setDensity(measureScope.getDensity());
                LayoutNodeSubcompositionsState.this.scope.setFontScale(measureScope.getFontScale());
                if (measureScope.isLookingAhead() || LayoutNodeSubcompositionsState.this.root.getLookaheadRoot() == null) {
                    LayoutNodeSubcompositionsState.this.currentIndex = 0;
                    final MeasureResult measureResultInvoke = block.invoke(LayoutNodeSubcompositionsState.this.scope, Constraints.m2073boximpl(j));
                    final int i = LayoutNodeSubcompositionsState.this.currentIndex;
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return measureResultInvoke.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getHeight */
                        public int get$height() {
                            return measureResultInvoke.get$height();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Function1<RulerScope, Unit> getRulers() {
                            return measureResultInvoke.getRulers();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getWidth */
                        public int get$width() {
                            return measureResultInvoke.get$width();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            layoutNodeSubcompositionsState.currentIndex = i;
                            measureResultInvoke.placeChildren();
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                            layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState2.currentIndex);
                        }
                    };
                }
                LayoutNodeSubcompositionsState.this.currentPostLookaheadIndex = 0;
                final MeasureResult measureResultInvoke2 = block.invoke(LayoutNodeSubcompositionsState.this.postLookaheadMeasureScope, Constraints.m2073boximpl(j));
                final int i2 = LayoutNodeSubcompositionsState.this.currentPostLookaheadIndex;
                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Map<AlignmentLine, Integer> getAlignmentLines() {
                        return measureResultInvoke2.getAlignmentLines();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getHeight */
                    public int get$height() {
                        return measureResultInvoke2.get$height();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Function1<RulerScope, Unit> getRulers() {
                        return measureResultInvoke2.getRulers();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getWidth */
                    public int get$width() {
                        return measureResultInvoke2.get$width();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public void placeChildren() {
                        layoutNodeSubcompositionsState2.currentPostLookaheadIndex = i2;
                        measureResultInvoke2.placeChildren();
                        layoutNodeSubcompositionsState2.disposeUnusedSlotsInPostLookahead();
                    }
                };
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeUnusedSlotsInPostLookahead() {
        CollectionsKt.removeAll(this.postLookaheadPrecomposeSlotHandleMap.entrySet(), new Function1<Map.Entry<Object, SubcomposeLayoutState.PrecomposedSlotHandle>, Boolean>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.disposeUnusedSlotsInPostLookahead.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Map.Entry<Object, SubcomposeLayoutState.PrecomposedSlotHandle> entry) {
                boolean z;
                Object key = entry.getKey();
                SubcomposeLayoutState.PrecomposedSlotHandle value = entry.getValue();
                int iIndexOf = LayoutNodeSubcompositionsState.this.postLookaheadComposedSlotIds.indexOf(key);
                if (iIndexOf < 0 || iIndexOf >= LayoutNodeSubcompositionsState.this.currentPostLookaheadIndex) {
                    value.dispose();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(final Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!this.root.isAttached()) {
            return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precompose.1
                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
                public void dispose() {
                }
            };
        }
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(slotId)) {
            this.postLookaheadPrecomposeSlotHandleMap.remove(slotId);
            HashMap<Object, LayoutNode> map = this.precomposeMap;
            LayoutNode layoutNodeTakeNodeFromReusables = map.get(slotId);
            if (layoutNodeTakeNodeFromReusables == null) {
                layoutNodeTakeNodeFromReusables = takeNodeFromReusables(slotId);
                if (layoutNodeTakeNodeFromReusables != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(layoutNodeTakeNodeFromReusables), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNodeTakeNodeFromReusables = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                map.put(slotId, layoutNodeTakeNodeFromReusables);
            }
            subcompose(layoutNodeTakeNodeFromReusables, slotId, content);
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precompose.2
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                LayoutNodeSubcompositionsState.this.makeSureStateIsConsistent();
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.remove(slotId);
                if (layoutNode != null) {
                    if (LayoutNodeSubcompositionsState.this.precomposedCount > 0) {
                        int iIndexOf = LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().indexOf(layoutNode);
                        if (iIndexOf < LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().size() - LayoutNodeSubcompositionsState.this.precomposedCount) {
                            throw new IllegalStateException("Item is not in pre-composed item range");
                        }
                        LayoutNodeSubcompositionsState.this.reusableCount++;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                        layoutNodeSubcompositionsState.precomposedCount--;
                        int size = (LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().size() - LayoutNodeSubcompositionsState.this.precomposedCount) - LayoutNodeSubcompositionsState.this.reusableCount;
                        LayoutNodeSubcompositionsState.this.move(iIndexOf, size, 1);
                        LayoutNodeSubcompositionsState.this.disposeOrReuseStartingFromIndex(size);
                        return;
                    }
                    throw new IllegalStateException("No pre-composed items to dispose");
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                List<LayoutNode> children$ui_release;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
                    return 0;
                }
                return children$ui_release.size();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
            public void mo1432premeasure0kLqBqw(int index, long constraints) {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || !layoutNode.isAttached()) {
                    return;
                }
                int size = layoutNode.getChildren$ui_release().size();
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                }
                if (!layoutNode.isPlaced()) {
                    LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.root;
                    layoutNode2.ignoreRemeasureRequests = true;
                    LayoutNodeKt.requireOwner(layoutNode).mo1562measureAndLayout0kLqBqw(layoutNode.getChildren$ui_release().get(index), constraints);
                    layoutNode2.ignoreRemeasureRequests = false;
                    return;
                }
                throw new IllegalArgumentException("Pre-measure called on node that is not placed");
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void traverseDescendants(Object key, Function1<? super TraversableNode, ? extends TraversableNode$Companion$TraverseDescendantsAction> block) {
                NodeChain nodes;
                Modifier.Node head;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (nodes = layoutNode.getNodes()) == null || (head = nodes.getHead()) == null) {
                    return;
                }
                TraversableNodeKt.traverseDescendants(head, key, block);
            }
        };
    }

    public final void forceRecomposeChildren() {
        if (this.reusableCount != this.root.getFoldedChildren$ui_release().size()) {
            Iterator<Map.Entry<LayoutNode, NodeState>> it = this.nodeToNodeState.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().setForceRecompose(true);
            }
            if (this.root.getMeasurePending$ui_release()) {
                return;
            }
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, null);
        }
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, layoutNode);
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void move(int from, int to, int count) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        layoutNode.ignoreRemeasureRequests = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010-\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001f¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "Lkotlin/Function0;", "", "content", "Landroidx/compose/runtime/ReusableComposition;", "composition", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "Ljava/lang/Object;", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "Lkotlin/jvm/functions/Function2;", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/runtime/ReusableComposition;", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "", "forceRecompose", "Z", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "forceReuse", "getForceReuse", "setForceReuse", "Landroidx/compose/runtime/MutableState;", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getActive", "setActive", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class NodeState {
        private MutableState<Boolean> activeState;
        private ReusableComposition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private Object slotId;

        public NodeState(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, ReusableComposition reusableComposition) {
            this.slotId = obj;
            this.content = function2;
            this.composition = reusableComposition;
            this.activeState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : reusableComposition);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.content = function2;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final void setComposition(ReusableComposition reusableComposition) {
            this.composition = reusableComposition;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final void setForceReuse(boolean z) {
            this.forceReuse = z;
        }

        public final void setActiveState(MutableState<Boolean> mutableState) {
            this.activeState = mutableState;
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final void setActive(boolean z) {
            this.activeState.setValue(Boolean.valueOf(z));
        }
    }

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004Jb\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013JJ\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u0005*\u00020\u0015H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u0015*\u00020\u0019H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u0015*\u00020\u001dH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u001c\u001a\u00020\u0015*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010%\u001a\u00020\"*\u00020!H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u001d*\u00020\u0015H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001fJ\u0017\u0010'\u001a\u00020\u001d*\u00020\u0019H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u001bJ\u0017\u0010*\u001a\u00020!*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010$J\u0017\u0010-\u001a\u00020\u0019*\u00020\u0015H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020\u0019*\u00020\u001dH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010,J-\u00105\u001a\b\u0012\u0004\u0012\u000204032\b\u00100\u001a\u0004\u0018\u00010/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\r01H\u0016¢\u0006\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010=\u001a\u00020<8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "", "width", "height", "", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp", "", "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", "", "slotId", "Lkotlin/Function0;", "content", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "getDensity", "()F", "density", "getFontScale", "fontScale", "", "isLookingAhead", "()Z", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class PostLookaheadMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, rulers, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo248roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo248roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public float mo249toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo249toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo250toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo250toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo251toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo251toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo252toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo252toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo253toPxR2X_6o(long j) {
            return this.$$delegate_0.mo253toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo254toPx0680j_4(float f) {
            return this.$$delegate_0.mo254toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo255toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo255toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public long mo256toSp0xMU5do(float f) {
            return this.$$delegate_0.mo256toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo257toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo257toSpkPz2Gy4(f);
        }

        public PostLookaheadMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(slotId);
            List<Measurable> childMeasurables$ui_release = layoutNode != null ? layoutNode.getChildMeasurables$ui_release() : null;
            return childMeasurables$ui_release != null ? childMeasurables$ui_release : LayoutNodeSubcompositionsState.this.postLookaheadSubcompose(slotId, content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Measurable> postLookaheadSubcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.postLookaheadComposedSlotIds.getSize() < this.currentPostLookaheadIndex) {
            throw new IllegalArgumentException("Error: currentPostLookaheadIndex cannot be greater than the size of thepostLookaheadComposedSlotIds list.");
        }
        int size = this.postLookaheadComposedSlotIds.getSize();
        int i = this.currentPostLookaheadIndex;
        if (size == i) {
            this.postLookaheadComposedSlotIds.add(slotId);
        } else {
            this.postLookaheadComposedSlotIds.set(i, slotId);
        }
        this.currentPostLookaheadIndex++;
        if (!this.precomposeMap.containsKey(slotId)) {
            this.postLookaheadPrecomposeSlotHandleMap.put(slotId, precompose(slotId, content));
            if (this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                this.root.requestLookaheadRelayout$ui_release(true);
            } else {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(this.root, true, false, false, 6, null);
            }
        }
        LayoutNode layoutNode = this.precomposeMap.get(slotId);
        if (layoutNode != null) {
            List<LayoutNodeLayoutDelegate.MeasurePassDelegate> childDelegates$ui_release = layoutNode.getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
            int size2 = childDelegates$ui_release.size();
            for (int i2 = 0; i2 < size2; i2++) {
                childDelegates$ui_release.get(i2).markDetachedFromParentLookaheadPass$ui_release();
            }
            return childDelegates$ui_release;
        }
        return CollectionsKt.emptyList();
    }
}
