package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 ·\u00012\u00020\u0001:\b·\u0001¸\u0001¹\u0001º\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0017\u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\u0007H\u0082@¢\u0006\u0004\b \u0010!J:\u0010(\u001a\u00020\u00072(\u0010'\u001a$\b\u0001\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%\u0012\u0006\u0012\u0004\u0018\u00010&0\"H\u0082@¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b*\u0010\u001dJ)\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.J3\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140/2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u001aJ#\u00106\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007052\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b6\u00107J3\u00108\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007052\u0006\u0010\u001b\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b>\u0010!J\r\u0010?\u001a\u00020\u0007¢\u0006\u0004\b?\u0010\u001aJ\u0010\u0010@\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b@\u0010!J%\u0010E\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070AH\u0010¢\u0006\u0004\bC\u0010DJ\r\u0010F\u001a\u00020\u0007¢\u0006\u0004\bF\u0010\u001aJ\r\u0010G\u001a\u00020\u0007¢\u0006\u0004\bG\u0010\u001aJ\u001d\u0010M\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0HH\u0010¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\bN\u0010\u001dJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\bP\u0010\u001dJ\u0017\u0010U\u001a\u00020\u00072\u0006\u0010R\u001a\u000200H\u0010¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020\u00072\u0006\u0010R\u001a\u000200H\u0010¢\u0006\u0004\bV\u0010TJ\u001f\u0010\\\u001a\u00020\u00072\u0006\u0010R\u001a\u0002002\u0006\u0010Y\u001a\u00020XH\u0010¢\u0006\u0004\bZ\u0010[J\u0017\u0010^\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\b]\u0010\u001dJ\u0019\u0010a\u001a\u0004\u0018\u00010X2\u0006\u0010R\u001a\u000200H\u0010¢\u0006\u0004\b_\u0010`R$\u0010d\u001a\u00020b2\u0006\u0010c\u001a\u00020b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00140r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001e\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010tR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020&0+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00140x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00140r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010tR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u0002000r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010tR/\u0010\u007f\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010&0~\u0012\n\u0012\b\u0012\u0004\u0012\u0002000r0}8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R#\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020X0}8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R \u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010tR!\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R!\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008b\u0001R\u001f\u0010\u0092\u0001\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009b\u0001\u001a\u00070\u009a\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001d\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140/8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0016\u0010¡\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010\fR\u0016\u0010£\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\fR\u0016\u0010¥\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\fR\u0016\u0010§\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\fR\u0016\u0010©\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\fR\u001c\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010ª\u00018F¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010°\u0001\u001a\u00030\u0087\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u0016\u0010²\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010\fR\u0016\u0010´\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010\fR\u0016\u0010¶\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010\f¨\u0006»\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "Lkotlin/coroutines/CoroutineContext;", "effectCoroutineContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "deriveStateLocked", "()Lkotlinx/coroutines/CancellableContinuation;", "", "recordComposerModifications", "()Z", "Lkotlinx/coroutines/Job;", "callingJob", "registerRunnerJob", "(Lkotlinx/coroutines/Job;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Landroidx/compose/runtime/ControlledComposition;", "failedInitialComposition", "recoverable", "processCompositionError", "(Ljava/lang/Exception;Landroidx/compose/runtime/ControlledComposition;Z)V", "clearKnownCompositionsLocked", "()V", "composition", "removeKnownCompositionLocked", "(Landroidx/compose/runtime/ControlledComposition;)V", "addKnownCompositionLocked", "recordFailedCompositionLocked", "awaitWorkAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/Continuation;", "", "block", "recompositionRunner", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performInitialMovableContentInserts", "Landroidx/collection/MutableScatterSet;", "modifiedValues", "performRecompose", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)Landroidx/compose/runtime/ControlledComposition;", "", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "performInsertValues", "(Ljava/util/List;Landroidx/collection/MutableScatterSet;)Ljava/util/List;", "discardUnusedValues", "Lkotlin/Function1;", "readObserverOf", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/jvm/functions/Function1;", "writeObserverOf", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshot", "applyAndCheck", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "runRecomposeAndApplyChanges", "cancel", "join", "Lkotlin/Function0;", "content", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitial", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "", "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime_release", "(Ljava/util/Set;)V", "recordInspectionTable", "unregisterComposition$runtime_release", "unregisterComposition", "invalidate$runtime_release", "invalidate", "reference", "insertMovableContent$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "deletedMovableContent$runtime_release", "deletedMovableContent", "Landroidx/compose/runtime/MovableContentState;", RemoteMessageConst.DATA, "movableContentStateReleased$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentState;)V", "movableContentStateReleased", "reportRemovedComposition$runtime_release", "reportRemovedComposition", "movableContentStateResolve$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "", "<set-?>", "changeCount", "J", "getChangeCount", "()J", "Landroidx/compose/runtime/BroadcastFrameClock;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "stateLock", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "", "closeCause", "Ljava/lang/Throwable;", "", "_knownCompositions", "Ljava/util/List;", "_knownCompositionsCache", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/collection/MutableVector;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "compositionValuesAwaitingInsert", "", "Landroidx/compose/runtime/MovableContent;", "compositionValuesRemoved", "Ljava/util/Map;", "compositionValueStatesAvailable", "failedCompositions", "compositionsRemoved", "Ljava/util/Set;", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "concurrentCompositionsOutstanding", "I", "isClosed", "Z", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/CompletableJob;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "getKnownCompositions", "()Ljava/util/List;", "knownCompositions", "getHasBroadcastFrameClockAwaitersLocked", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaiters", "getShouldKeepRecomposing", "shouldKeepRecomposing", "getHasSchedulingWork", "hasSchedulingWork", "getHasFrameWorkLocked", "hasFrameWorkLocked", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentState", "getCompoundHashKey$runtime_release", "()I", "compoundHashKey", "getCollectingCallByInformation$runtime_release", "collectingCallByInformation", "getCollectingParameterInformation$runtime_release", "collectingParameterInformation", "getCollectingSourceInformation$runtime_release", "collectingSourceInformation", "Companion", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingParameterInformation$runtime_release */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingSourceInformation$runtime_release */
    public boolean getCollectingSourceInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCompoundHashKey$runtime_release */
    public int getCompoundHashKey() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        r1 = r7.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        if (r6 >= r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c5, code lost:
    
        if (r7.get(r6).getSecond() == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d8, code lost:
    
        if (r8 >= r6) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00da, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e4, code lost:
    
        if (r9.getSecond() != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
    
        r9 = r9.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ef, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r9 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f2, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f8, code lost:
    
        r6 = r13.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fb, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r13.compositionValuesAwaitingInsert, r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0104, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0105, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0113, code lost:
    
        if (r8 >= r6) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0115, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0120, code lost:
    
        if (r9.getSecond() == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0122, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0125, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r14, androidx.collection.MutableScatterSet<java.lang.Object> r15) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation cancellableContinuationDeriveStateLocked;
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                    if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                    }
                }
                if (cancellableContinuationDeriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationDeriveStateLocked.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        completableJobJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th) {
                CancellableContinuation cancellableContinuation;
                CancellableContinuation cancellableContinuation2;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = this.this$0.stateLock;
                final Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    try {
                        Job job = recomposer.runnerJob;
                        cancellableContinuation = null;
                        if (job != null) {
                            recomposer._state.setValue(Recomposer.State.ShuttingDown);
                            if (recomposer.isClosed) {
                                if (recomposer.workContinuation != null) {
                                    cancellableContinuation2 = recomposer.workContinuation;
                                }
                                recomposer.workContinuation = null;
                                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                        invoke2(th2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th2) {
                                        Object obj2 = recomposer.stateLock;
                                        Recomposer recomposer2 = recomposer;
                                        Throwable th3 = th;
                                        synchronized (obj2) {
                                            if (th3 == null) {
                                                th3 = null;
                                            } else if (th2 != null) {
                                                try {
                                                    if (th2 instanceof CancellationException) {
                                                        th2 = null;
                                                    }
                                                    if (th2 != null) {
                                                        kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                    }
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            }
                                            recomposer2.closeCause = th3;
                                            recomposer2._state.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation2;
                            } else {
                                job.cancel(CancellationException);
                            }
                            cancellableContinuation2 = null;
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                    invoke2(th2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th2) {
                                    Object obj2 = recomposer.stateLock;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 == null) {
                                            th3 = null;
                                        } else if (th2 != null) {
                                            try {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        recomposer2.closeCause = th3;
                                        recomposer2._state.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation2;
                        } else {
                            recomposer.closeCause = CancellationException;
                            recomposer._state.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = completableJobJob;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(completableJobJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        List list2 = list;
        if (list == null) {
            List<ControlledComposition> list3 = this._knownCompositions;
            List listEmptyList = list3.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list3);
            this._knownCompositionsCache = listEmptyList;
            list2 = listEmptyList;
        }
        return list2;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (z) {
            Iterator<Job> it = this.effectJob.getChildren().iterator();
            while (it.hasNext()) {
                if (it.next().isActive()) {
                }
            }
            return false;
        }
        return true;
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class RecomposerInfoImpl {
        public RecomposerInfoImpl() {
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "", "", "recoverable", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "<init>", "(ZLjava/lang/Exception;)V", "Z", "getRecoverable", "()Z", "Ljava/lang/Exception;", "getCause", "()Ljava/lang/Exception;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RecomposerErrorState {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                int size = knownCompositions.size();
                for (int i = 0; i < size; i++) {
                    knownCompositions.get(i).recordModificationsOf(setWrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {574, 585}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    static final class C04332 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C04332(Continuation<? super C04332> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C04332 c04332 = Recomposer.this.new C04332(continuation);
            c04332.L$0 = monotonicFrameClock;
            return c04332.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r10v14, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v14, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v15, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0139 -> B:23:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0151 -> B:24:0x014d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 361
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C04332.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer r23, java.util.List<androidx.compose.runtime.ControlledComposition> r24, java.util.List<androidx.compose.runtime.MovableContentStateReference> r25, java.util.List<androidx.compose.runtime.ControlledComposition> r26, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r27, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r28, androidx.collection.MutableScatterSet<java.lang.Object> r29, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r30) {
            /*
                Method dump skipped, instructions count: 326
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C04332.invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer, java.util.List, java.util.List, java.util.List, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                try {
                    List list2 = recomposer.compositionValuesAwaitingInsert;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((MovableContentStateReference) list2.get(i));
                    }
                    recomposer.compositionValuesAwaitingInsert.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C04332(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) throws Exception {
        if (!_hotReloadEnabled.get().booleanValue() || (e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            }
            throw e;
        }
        synchronized (this.stateLock) {
            try {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.remove(composition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        List arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getHasSchedulingWork() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r2.snapshotInvalidations     // Catch: java.lang.Throwable -> L1c
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L1c
            if (r1 != 0) goto L1e
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionInvalidations     // Catch: java.lang.Throwable -> L1c
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L1c
            if (r1 != 0) goto L1e
            boolean r1 = r2.getHasBroadcastFrameClockAwaitersLocked()     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L1a
            goto L1e
        L1a:
            r1 = 0
            goto L1f
        L1c:
            r1 = move-exception
            goto L21
        L1e:
            r1 = 1
        L1f:
            monitor-exit(r0)
            return r1
        L21:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.getHasSchedulingWork():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (!getHasSchedulingWork()) {
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl2.initCancellability();
            synchronized (this.stateLock) {
                if (getHasSchedulingWork()) {
                    cancellableContinuationImpl = cancellableContinuationImpl2;
                } else {
                    this.workContinuation = cancellableContinuationImpl2;
                    cancellableContinuationImpl = null;
                }
            }
            if (cancellableContinuationImpl != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
            }
            Object result = cancellableContinuationImpl2.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {1054}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    static final class C04322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04322(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C04322> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04322 c04322 = Recomposer.this.new C04322(this.$block, this.$parentFrameClock, continuation);
            c04322.L$0 = obj;
            return c04322;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 230
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C04322.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Recomposer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", l = {1055}, m = "invokeSuspend")
        /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C04322(function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (this._state.getValue().compareTo(State.Idle) >= 0) {
                    this._state.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default(this.effectJob, null, 1, null);
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0) == State.ShutDown);
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new AnonymousClass2(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        boolean zIsComposing = composition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    if (!zIsComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (zIsComposing) {
                                return;
                            }
                            companion.notifyObjectsInitialized();
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, composition, true);
                    }
                } finally {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference next = it.next();
                    if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                        list.add(next);
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.getDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                                ControlledComposition controlledComposition = composition;
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
                                                controlledComposition.recordWriteOf(objArr[(i << 3) + i3]);
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
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = composition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List listEmptyList;
        synchronized (this.stateLock) {
            try {
                if (!this.compositionValuesRemoved.isEmpty()) {
                    List listFlatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    listEmptyList = new ArrayList(listFlatten.size());
                    int size = listFlatten.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listFlatten.get(i2);
                        listEmptyList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                    }
                    this.compositionValueStatesAvailable.clear();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size2 = listEmptyList.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) listEmptyList.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.readObserverOf.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                composition.recordReadOf(obj);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.writeObserverOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                composition.recordWriteOf(obj);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
            }
        };
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            snapshot.dispose();
        }
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            try {
                Set linkedHashSet = this.compositionsRemoved;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.compositionsRemoved = linkedHashSet;
                }
                linkedHashSet.add(composition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        synchronized (this.stateLock) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tR4\u0010\u000f\u001a\"\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bj\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "info", "", "addRunning", "(Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;)V", "removeRunning", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add((PersistentSet) info);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetRemove));
        }
    }
}
