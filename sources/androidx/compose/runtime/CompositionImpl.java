package androidx.compose.runtime;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002£\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0018\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(J)\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010/\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.H\u0002¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b4\u0010\u0011J\u001d\u00105\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b5\u0010\u0011J\u001d\u00106\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b6\u0010\u0011J\u000f\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u0013J\u001d\u00108\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u000e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010\u001fJ\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b@\u0010\u001fJ\u000f\u0010A\u001a\u00020\u0016H\u0016¢\u0006\u0004\bA\u0010BJ+\u0010G\u001a\u00020\u000e2\u001a\u0010F\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020E\u0012\u0006\u0012\u0004\u0018\u00010E0D0CH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u000eH\u0016¢\u0006\u0004\bM\u0010\u0013J\u000f\u0010N\u001a\u00020\u000eH\u0016¢\u0006\u0004\bN\u0010\u0013J\u000f\u0010O\u001a\u00020\u000eH\u0016¢\u0006\u0004\bO\u0010\u0013J\u000f\u0010P\u001a\u00020\u000eH\u0016¢\u0006\u0004\bP\u0010\u0013J\u000f\u0010Q\u001a\u00020\u000eH\u0016¢\u0006\u0004\bQ\u0010\u0013J5\u0010V\u001a\u00028\u0000\"\u0004\b\u0000\u0010R2\b\u0010S\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020T2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\bV\u0010WJ!\u0010X\u001a\u00020+2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\bZ\u0010[J\u001f\u0010^\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b\\\u0010]J\u001b\u0010b\u001a\u00020\u000e2\n\u0010J\u001a\u0006\u0012\u0002\b\u00030_H\u0000¢\u0006\u0004\b`\u0010aJ\u000f\u0010c\u001a\u00020\u000eH\u0016¢\u0006\u0004\bc\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010dR\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010eR(\u0010h\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR \u0010n\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bn\u0010o\u0012\u0004\bp\u0010\u0013R \u0010r\u001a\u00020q8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\br\u0010s\u0012\u0004\bv\u0010\u0013\u001a\u0004\bt\u0010uR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020$0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020$0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{R$\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030_0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010xR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010~R\u0014\u0010\u007f\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010~R\"\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0.8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010xR$\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010xR/\u0010\u0082\u0001\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u001e\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u0012\u0005\b\u0087\u0001\u0010\u0013\u001a\u0005\b\u0084\u0001\u0010B\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u00020\u00168\u0006¢\u0006\u000f\n\u0006\b\u0096\u0001\u0010\u0083\u0001\u001a\u0005\b\u0096\u0001\u0010BR\u0019\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0083\u0001R.\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0005\b\u009c\u0001\u0010\u0011R\u0016\u0010\u009e\u0001\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010BR\u0016\u0010\u009f\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010BR\u0016\u0010 \u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010BR\u0016\u0010¢\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010B¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "", "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/Applier;", "applier", "Lkotlin/coroutines/CoroutineContext;", "recomposeContext", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/Function0;", "", "content", "composeInitial", "(Lkotlin/jvm/functions/Function2;)V", "drainPendingModificationsForCompositionLocked", "()V", "drainPendingModificationsLocked", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "forgetConditionalScopes", "addPendingInvalidationsLocked", "(Ljava/lang/Object;Z)V", "", "values", "(Ljava/util/Set;Z)V", "cleanUpDerivedStateObservations", "invalidateScopeOfLocked", "(Ljava/lang/Object;)V", "Landroidx/compose/runtime/changelist/ChangeList;", "changes", "applyChangesInLocked", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "tryImminentInvalidation", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Z", "Landroidx/compose/runtime/Anchor;", "anchor", "Landroidx/compose/runtime/InvalidationResult;", "invalidateChecked", "(Landroidx/compose/runtime/RecomposeScopeImpl;Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "Landroidx/compose/runtime/collection/ScopeMap;", "takeInvalidations", "()Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observer", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "setContent", "setContentWithReuse", "composeContent", "dispose", "recordModificationsOf", "(Ljava/util/Set;)V", "observesAnyOf", "(Ljava/util/Set;)Z", "block", "prepareCompose", "(Lkotlin/jvm/functions/Function0;)V", "recordReadOf", "recordWriteOf", "recompose", "()Z", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContent", "(Ljava/util/List;)V", "Landroidx/compose/runtime/MovableContentState;", "state", "disposeUnusedMovableContent", "(Landroidx/compose/runtime/MovableContentState;)V", "applyChanges", "applyLateChanges", "changesApplied", "abandonChanges", "invalidateAll", "R", RemoteMessageConst.TO, "", "groupIndex", "delegateInvalidations", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invalidate", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "recomposeScopeReleased", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "removeObservation$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/RecomposeScopeImpl;)V", "removeObservation", "Landroidx/compose/runtime/DerivedState;", "removeDerivedStateObservation$runtime_release", "(Landroidx/compose/runtime/DerivedState;)V", "removeDerivedStateObservation", "deactivate", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Applier;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Ljava/lang/Object;", "", "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Ljava/util/Set;", "getAbandonSet$annotations", "Landroidx/compose/runtime/SlotTable;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterSet;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "Z", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "getPendingInvalidScopes$runtime_release$annotations", "invalidationDelegate", "Landroidx/compose/runtime/CompositionImpl;", "invalidationDelegateGroup", "I", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "Landroidx/compose/runtime/ComposerImpl;", FFmpegMediaMetadataRetriever.METADATA_KEY_COMPOSER, "Landroidx/compose/runtime/ComposerImpl;", "_recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "isRoot", "disposed", "composable", "Lkotlin/jvm/functions/Function2;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "getAreChildrenComposing", "areChildrenComposing", "isComposing", "isDisposed", "getHasInvalidations", "hasInvalidations", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<Object, RecomposeScopeImpl> observations;
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z = true;
        int size = references.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                z = false;
                break;
            }
            i++;
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0180 A[EDGE_INSN: B:69:0x0180->B:221:0x0111 BREAK  A[LOOP:13: B:59:0x0146->B:70:0x0182]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 1134
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime_release()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r11 = r14.observations
            boolean r11 = r11.contains(r10)
            if (r11 != 0) goto L50
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r11 = r14.derivedStates
            boolean r10 = r11.contains(r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r3 = r14.observations
            boolean r3 = r3.contains(r0)
            if (r3 != 0) goto L7c
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r3 = r14.derivedStates
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> setAsMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = setAsMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setAsMutableSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m704getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    /* renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
                try {
                    observer();
                    this.composer.composeContent$runtime_release(scopeMapTakeInvalidations, content);
                } catch (Exception e) {
                    this.invalidations = scopeMapTakeInvalidations;
                    throw e;
                }
            }
        } finally {
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.getIsComposing()) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.disposed) {
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m705getLambda2$runtime_release();
                    ChangeList deferredChanges$runtime_release = this.composer.getDeferredChanges();
                    if (deferredChanges$runtime_release != null) {
                        applyChangesInLocked(deferredChanges$runtime_release);
                    }
                    boolean z = this.slotTable.getGroupsSize() > 0;
                    if (z || !this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> setPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null ? true : Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                setPlus = values;
            } else if (obj instanceof Set) {
                setPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                setPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, setPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!this.observationsProcessed.remove(value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (this.observationsProcessed.remove(value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        int i4;
        boolean zIsEmpty;
        Object[] objArr;
        long[] jArr3;
        long[] jArr4;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr5 = map.metadata;
        int length = jArr5.length - 2;
        char c = 7;
        long j = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j2 = jArr5[i6];
                if ((((~j2) << c) & j2 & j) != j) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j2 & 255) < 128) {
                            int i9 = (i6 << 3) + i8;
                            Object obj = map.keys[i9];
                            Object obj2 = map.values[i9];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr2 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i2 = length;
                                if (length2 >= 0) {
                                    int i10 = 0;
                                    while (true) {
                                        long j3 = jArr6[i10];
                                        i3 = i6;
                                        Object[] objArr3 = objArr2;
                                        if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            int i12 = 0;
                                            while (i12 < i11) {
                                                int i13 = i12;
                                                Object[] objArr4 = objArr3;
                                                if ((j3 & 255) < 128) {
                                                    int i14 = (i10 << 3) + i13;
                                                    jArr4 = jArr6;
                                                    if (!this.observations.contains((DerivedState) objArr4[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr4 = jArr6;
                                                }
                                                j3 >>= 8;
                                                i12 = i13 + 1;
                                                jArr6 = jArr4;
                                                objArr3 = objArr4;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i11 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        jArr6 = jArr3;
                                        objArr2 = objArr;
                                        i6 = i3;
                                        c = 7;
                                    }
                                } else {
                                    i3 = i6;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i2 = length;
                                i3 = i6;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                zIsEmpty = !this.observations.contains((DerivedState) obj2);
                            }
                            if (zIsEmpty) {
                                map.removeValueAt(i9);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr5;
                            i2 = length;
                            i3 = i6;
                            i4 = i5;
                        }
                        j2 >>= i4;
                        i8++;
                        i5 = i4;
                        jArr5 = jArr2;
                        length = i2;
                        i6 = i3;
                        c = 7;
                    }
                    jArr = jArr5;
                    int i15 = length;
                    int i16 = i6;
                    if (i7 != i5) {
                        break;
                    }
                    length = i15;
                    i = i16;
                } else {
                    jArr = jArr5;
                    i = i6;
                }
                if (i == length) {
                    break;
                }
                i6 = i + 1;
                jArr5 = jArr;
                c = 7;
                j = -9187201950435737472L;
                i5 = 8;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr5 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j4 = jArr7[i17];
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i18 = 8 - ((~(i17 - length3)) >>> 31);
                for (int i19 = 0; i19 < i18; i19++) {
                    if ((j4 & 255) < 128) {
                        int i20 = (i17 << 3) + i19;
                        if (!((RecomposeScopeImpl) objArr5[i20]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i20);
                        }
                    }
                    j4 >>= 8;
                }
                if (i18 != 8) {
                    return;
                }
            }
            if (i17 == length3) {
                return;
            } else {
                i17++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        long[] jArr;
        long[] jArr2;
        int i;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ((StateObjectImpl) value).m751recordReadInh_f27i8$runtime_release(ReaderKind.m749constructorimpl(1));
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            this.derivedStates.removeScope(value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr3 = dependencies.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i2 << 3) + i5];
                                if (stateObject instanceof StateObjectImpl) {
                                    jArr2 = jArr3;
                                    ((StateObjectImpl) stateObject).m751recordReadInh_f27i8$runtime_release(ReaderKind.m749constructorimpl(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                this.derivedStates.add(stateObject, value);
                                i = 8;
                            } else {
                                jArr2 = jArr3;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                this.observationsProcessed.add(value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(value, recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void recordWriteOf(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.lock
            monitor-enter(r0)
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L53
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r1 = r14.derivedStates     // Catch: java.lang.Throwable -> L53
            androidx.collection.MutableScatterMap r1 = r1.getMap()     // Catch: java.lang.Throwable -> L53
            java.lang.Object r15 = r1.get(r15)     // Catch: java.lang.Throwable -> L53
            if (r15 == 0) goto L65
            boolean r1 = r15 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L60
            androidx.collection.MutableScatterSet r15 = (androidx.collection.MutableScatterSet) r15     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r1 = r15.elements     // Catch: java.lang.Throwable -> L53
            long[] r15 = r15.metadata     // Catch: java.lang.Throwable -> L53
            int r2 = r15.length     // Catch: java.lang.Throwable -> L53
            int r2 = r2 + (-2)
            if (r2 < 0) goto L65
            r3 = 0
            r4 = r3
        L23:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L53
            long r7 = ~r5     // Catch: java.lang.Throwable -> L53
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L5b
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L53
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L3d:
            if (r9 >= r7) goto L59
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L55
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L53
            androidx.compose.runtime.DerivedState r10 = (androidx.compose.runtime.DerivedState) r10     // Catch: java.lang.Throwable -> L53
            r14.invalidateScopeOfLocked(r10)     // Catch: java.lang.Throwable -> L53
            goto L55
        L53:
            r15 = move-exception
            goto L69
        L55:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L3d
        L59:
            if (r7 != r8) goto L65
        L5b:
            if (r4 == r2) goto L65
            int r4 = r4 + 1
            goto L23
        L60:
            androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15     // Catch: java.lang.Throwable -> L53
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L53
        L65:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L53
            monitor-exit(r0)
            return
        L69:
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordWriteOf(java.lang.Object):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            try {
                drainPendingModificationsForCompositionLocked();
                try {
                    ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
                    try {
                        observer();
                        zRecompose$runtime_release = this.composer.recompose$runtime_release(scopeMapTakeInvalidations);
                        if (!zRecompose$runtime_release) {
                            drainPendingModificationsLocked();
                        }
                    } catch (Exception e) {
                        this.invalidations = scopeMapTakeInvalidations;
                        throw e;
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = state.getSlotTable().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab A[Catch: all -> 0x001e, EDGE_INSN: B:65:0x00ab->B:51:0x00ab BREAK  A[LOOP:0: B:32:0x0064->B:47:0x00a3], EDGE_INSN: B:66:0x00ab->B:51:0x00ab BREAK  A[LOOP:0: B:32:0x0064->B:47:0x00a3], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0032, B:22:0x003b, B:24:0x003f, B:25:0x0048, B:27:0x0054, B:29:0x0058, B:32:0x0064, B:34:0x0074, B:36:0x0080, B:38:0x008a, B:43:0x0099, B:47:0x00a3, B:48:0x00a6, B:51:0x00ab), top: B:63:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap<RecomposeScopeImpl, Object> scopeMap = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return scopeMap;
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            compositionObserverHolder.getObserver();
        } else {
            CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder();
            if (observerHolder$runtime_release != null) {
                observerHolder$runtime_release.getObserver();
            }
            compositionObserverHolder.getObserver();
            if (!Intrinsics.areEqual(null, null)) {
                compositionObserverHolder.setObserver(null);
            }
        }
        return null;
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            try {
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    Trace trace = Trace.INSTANCE;
                    Object objBeginSection = trace.beginSection("Compose:deactivate");
                    try {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        Unit unit2 = Unit.INSTANCE;
                        trace.endSection(objBeginSection);
                    } catch (Throwable th2) {
                        Trace.INSTANCE.endSection(objBeginSection);
                        throw th2;
                    }
                }
                this.observations.clear();
                this.derivedStates.clear();
                this.invalidations.clear();
                this.changes.clear();
                this.lateChanges.clear();
                this.composer.deactivate$runtime_release();
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* compiled from: Composition.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", "", "", "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "endRelativeOrder", "", RemoteMessageConst.Notification.PRIORITY, "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Object> leaving = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();
        private final List<Object> pending = new ArrayList();
        private final MutableIntList priorities = new MutableIntList(0, 1, null);
        private final MutableIntList afters = new MutableIntList(0, 1, null);

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            this.sideEffects.add(effect);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSetMutableScatterSetOf = this.releasing;
            if (mutableScatterSetMutableScatterSetOf == null) {
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSetMutableScatterSetOf;
            }
            mutableScatterSetMutableScatterSetOf.plusAssign((MutableScatterSet<ComposeNodeLifecycleCallback>) instance);
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        public final void dispatchRememberObservers() {
            Object objBeginSection;
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    ScatterSet scatterSet = this.releasing;
                    for (int size = this.leaving.size() - 1; -1 < size; size--) {
                        Object obj = this.leaving.get(size);
                        if (obj instanceof RememberObserver) {
                            this.abandoning.remove(obj);
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (scatterSet != null && scatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                } finally {
                }
            }
            if (this.remembering.isEmpty()) {
                return;
            }
            objBeginSection = Trace.INSTANCE.beginSection("Compose:onRemembered");
            try {
                List<RememberObserver> list = this.remembering;
                int size2 = list.size();
                for (int i = 0; i < size2; i++) {
                    RememberObserver rememberObserver = list.get(i);
                    this.abandoning.remove(rememberObserver);
                    rememberObserver.onRemembered();
                }
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } finally {
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th;
            }
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    RememberObserver next = it.next();
                    it.remove();
                    next.onAbandoned();
                }
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th;
            }
        }

        private final void recordLeaving(Object instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            processPendingLeaving(endRelativeOrder);
            if (endRelativeAfter >= 0 && endRelativeAfter < endRelativeOrder) {
                this.pending.add(instance);
                this.priorities.add(priority);
                this.afters.add(endRelativeAfter);
                return;
            }
            this.leaving.add(instance);
        }

        private final void processPendingLeaving(int endRelativeOrder) {
            if (this.pending.isEmpty()) {
                return;
            }
            int i = 0;
            int i2 = 0;
            List listMutableListOf = null;
            MutableIntList mutableIntList = null;
            MutableIntList mutableIntList2 = null;
            while (i2 < this.afters.get_size()) {
                if (endRelativeOrder <= this.afters.get(i2)) {
                    Object objRemove = this.pending.remove(i2);
                    int iRemoveAt = this.afters.removeAt(i2);
                    int iRemoveAt2 = this.priorities.removeAt(i2);
                    if (listMutableListOf == null) {
                        listMutableListOf = CollectionsKt.mutableListOf(objRemove);
                        mutableIntList2 = new MutableIntList(0, 1, null);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList = new MutableIntList(0, 1, null);
                        mutableIntList.add(iRemoveAt2);
                    } else {
                        Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        listMutableListOf.add(objRemove);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList.add(iRemoveAt2);
                    }
                } else {
                    i2++;
                }
            }
            if (listMutableListOf != null) {
                Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = listMutableListOf.size() - 1;
                while (i < size) {
                    int i3 = i + 1;
                    int size2 = listMutableListOf.size();
                    for (int i4 = i3; i4 < size2; i4++) {
                        int i5 = mutableIntList2.get(i);
                        int i6 = mutableIntList2.get(i4);
                        if (i5 < i6 || (i6 == i5 && mutableIntList.get(i) < mutableIntList.get(i4))) {
                            CompositionKt.swap(listMutableListOf, i, i4);
                            CompositionKt.swap(mutableIntList, i, i4);
                            CompositionKt.swap(mutableIntList2, i, i4);
                        }
                    }
                    i = i3;
                }
                this.leaving.addAll(listMutableListOf);
            }
        }
    }
}
