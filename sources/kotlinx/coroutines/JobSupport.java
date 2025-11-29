package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;

/* compiled from: JobSupport.kt */
@Deprecated
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006±\u0001²\u0001³\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u0014*\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b$\u0010!J\u0019\u0010&\u001a\u00020%2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b&\u0010'J1\u0010-\u001a\u00020,2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)2\u0006\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020,H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b@\u0010=J\u0019\u0010A\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bE\u0010FJ#\u0010G\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bJ\u0010KJ*\u0010M\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010L\u001a\u00020I2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0082\u0010¢\u0006\u0004\bM\u0010NJ)\u0010P\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010O\u001a\u00020I2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u0004\u0018\u00010I*\u00020RH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u00020U2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0004\bX\u0010;J\u0019\u0010Z\u001a\u00020\u00142\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b\\\u00109J\u000f\u0010]\u001a\u00020\u0014H\u0014¢\u0006\u0004\b]\u0010^J\u0011\u0010a\u001a\u00060_j\u0002``¢\u0006\u0004\ba\u0010bJ#\u0010d\u001a\u00060_j\u0002``*\u00020\u000f2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010UH\u0004¢\u0006\u0004\bd\u0010eJ'\u0010g\u001a\u00020f2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)¢\u0006\u0004\bg\u0010hJ7\u0010g\u001a\u00020f2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)¢\u0006\u0004\bg\u0010jJ\u0013\u0010k\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\bk\u0010;J\u0017\u0010m\u001a\u00020\u00142\u0006\u00100\u001a\u00020,H\u0000¢\u0006\u0004\bl\u00107J\u001f\u0010n\u001a\u00020\u00142\u000e\u0010\u001f\u001a\n\u0018\u00010_j\u0004\u0018\u0001``H\u0016¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020UH\u0014¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sJ\u0015\u0010u\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u0003¢\u0006\u0004\bu\u0010vJ\u0017\u0010w\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\bw\u0010#J\u0017\u0010x\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bx\u0010#J\u0019\u0010{\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\by\u0010zJ\u0013\u0010|\u001a\u00060_j\u0002``H\u0016¢\u0006\u0004\b|\u0010bJ\u0019\u0010~\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b}\u0010zJ\u001c\u0010\u0080\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u007f\u0010=J\u0019\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00142\u0007\u0010\u0084\u0001\u001a\u00020\u000fH\u0010¢\u0006\u0005\b\u0085\u0001\u0010sJ\u0019\u0010+\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b+\u0010sJ\u001a\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0084\u0001\u001a\u00020\u000fH\u0014¢\u0006\u0005\b\u0087\u0001\u0010#J\u001c\u0010\u0088\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u0011\u0010\u008b\u0001\u001a\u00020UH\u0016¢\u0006\u0005\b\u008b\u0001\u0010qJ\u0011\u0010\u008c\u0001\u001a\u00020UH\u0007¢\u0006\u0005\b\u008c\u0001\u0010qJ\u0011\u0010\u008e\u0001\u001a\u00020UH\u0010¢\u0006\u0005\b\u008d\u0001\u0010qJ\u0014\u0010\u0091\u0001\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0017\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nH\u0084@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010;R\u001e\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010?R\u0019\u0010\u0098\u0001\u001a\u0007\u0012\u0002\b\u00030\u0095\u00018F¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R0\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0081\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0081\u00018@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010Y\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u0090\u0001R\u0016\u0010¢\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u00109R\u0013\u0010£\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b£\u0001\u00109R\u0013\u0010¤\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b¤\u0001\u00109R\u0016\u0010¦\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u00109R\u001b\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010§\u00018F¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u0016\u0010«\u0001\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u00109R\u0016\u0010\u00ad\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¬\u0001\u00109R\u0016\u0010¯\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010®\u00018\u0002X\u0082\u0004R\u0015\u0010°\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0®\u00018\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006´\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "<init>", "(Z)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "", "proposedUpdate", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "cause", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "cancelParent", "(Ljava/lang/Throwable;)Z", "notifyCompletion", "", "startInternal", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lkotlinx/coroutines/JobNode;", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "joinInternal", "()Z", "joinSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "makeCancelling", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "child", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "awaitSuspend", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "start", "onStart", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", CrashHianalyticsData.MESSAGE, "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "removeNode$kotlinx_coroutines_core", "removeNode", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "()Ljava/lang/String;", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "getChildJobCancellationCause", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "handleJobException", "onCompletionInternal", "(Ljava/lang/Object;)V", "afterCompletion", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal", "getExceptionOrNull", "exceptionOrNull", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getParent", "()Lkotlinx/coroutines/Job;", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isScopedCoroutine", "getHandlesException$kotlinx_coroutines_core", "handlesException", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class JobSupport implements Job, ChildJob, ParentJob {
    private volatile Object _parentHandle;
    private volatile Object _state;
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    protected void afterCompletion(Object state) {
    }

    /* renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    protected boolean handleJobException(Throwable exception) {
        return false;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    protected void onCancelling(Throwable cause) {
    }

    protected void onCompletionInternal(Object state) {
    }

    protected void onStart() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    private final boolean addLastAtomic(final Object expect, NodeList list, final JobNode node) {
        int iTryCondAddNext;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(node) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(LockFreeLinkedListNode affected) {
                if (this.getState$kotlinx_coroutines_core() == expect) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        do {
            iTryCondAddNext = list.getPrevNode().tryCondAddNext(node, list, condAddOp);
            if (iTryCondAddNext == 1) {
                return true;
            }
        } while (iTryCondAddNext != 2);
        return false;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) _parentHandle$FU.get(this);
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle childHandle) {
        _parentHandle$FU.set(this, childHandle);
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    protected final void initParentJob(Job parent) {
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle childHandleAttachChild = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    public final Object getState$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final Object cancelMakeCompleting(Object cause) {
        Object objTryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(cause), false, 2, null));
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    private final Object makeCancelling(Object cause) throws Throwable {
        Throwable thCreateCauseException = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Finishing) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((Finishing) state$kotlinx_coroutines_core).isSealed()) {
                        return JobSupportKt.TOO_LATE_TO_CANCEL;
                    }
                    boolean zIsCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                    if (cause != null || !zIsCancelling) {
                        if (thCreateCauseException == null) {
                            thCreateCauseException = createCauseException(cause);
                        }
                        ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                    }
                    Throwable rootCause = zIsCancelling ? null : ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                    if (rootCause != null) {
                        notifyCancelling(((Finishing) state$kotlinx_coroutines_core).getList(), rootCause);
                    }
                    return JobSupportKt.COMPLETING_ALREADY;
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return JobSupportKt.TOO_LATE_TO_CANCEL;
            }
            if (thCreateCauseException == null) {
                thCreateCauseException = createCauseException(cause);
            }
            Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
            if (incomplete.getIsActive()) {
                if (tryMakeCancelling(incomplete, thCreateCauseException)) {
                    return JobSupportKt.COMPLETING_ALREADY;
                }
            } else {
                Object objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false, 2, null));
                if (objTryMakeCompleting != JobSupportKt.COMPLETING_ALREADY) {
                    if (objTryMakeCompleting != JobSupportKt.COMPLETING_RETRY) {
                        return objTryMakeCompleting;
                    }
                } else {
                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                }
            }
        }
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object proposedUpdate) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                return false;
            }
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        afterCompletion(objTryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object proposedUpdate) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, getExceptionOrNull(proposedUpdate));
            }
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode node) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof JobNode)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                node.remove();
                return;
            }
            if (state$kotlinx_coroutines_core != node) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state$kotlinx_coroutines_core, JobSupportKt.EMPTY_ACTIVE));
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iStartInternal;
        do {
            iStartInternal = startInternal(getState$kotlinx_coroutines_core());
            if (iStartInternal == 0) {
                return false;
            }
        } while (iStartInternal != 1);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling());
    }

    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) throws Throwable {
        boolean zIsCancelling;
        Throwable finalRootCause;
        CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (state) {
            zIsCancelling = state.isCancelling();
            List<Throwable> listSealLocked = state.sealLocked(th);
            finalRootCause = getFinalRootCause(state, listSealLocked);
            if (finalRootCause != null) {
                addSuppressedExceptions(finalRootCause, listSealLocked);
            }
        }
        if (finalRootCause != null && finalRootCause != th) {
            proposedUpdate = new CompletedExceptionally(finalRootCause, false, 2, null);
        }
        if (finalRootCause != null && (cancelParent(finalRootCause) || handleJobException(finalRootCause))) {
            Intrinsics.checkNotNull(proposedUpdate, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally) proposedUpdate).makeHandled();
        }
        if (!zIsCancelling) {
            onCancelling(finalRootCause);
        }
        onCompletionInternal(proposedUpdate);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, JobSupportKt.boxIncomplete(proposedUpdate));
        completeStateFinalization(state, proposedUpdate);
        return proposedUpdate;
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Object next;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list = exceptions;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        for (Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                kotlin.ExceptionsKt.addSuppressed(rootCause, th);
            }
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) throws Throwable {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, JobSupportKt.boxIncomplete(update))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(update);
        completeStateFinalization(state, update);
        return true;
    }

    private final void completeStateFinalization(Incomplete state, Object update) throws Throwable {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally) update : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (state instanceof JobNode) {
            try {
                ((JobNode) state).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
                return;
            }
        }
        NodeList list = state.getList();
        if (list != null) {
            notifyCompletion(list, th);
        }
    }

    private final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new ResumeOnCompletion(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final void notifyCancelling(NodeList list, Throwable cause) throws Throwable {
        onCancelling(cause);
        Object next = list.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, list); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) nextNode;
                try {
                    jobNode.invoke(cause);
                } catch (Throwable th) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(cause);
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) throws Throwable {
        Object next = nodeList.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, nodeList); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof JobNode) {
                JobNode jobNode = (JobNode) nextNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    private final boolean cancelParent(Throwable cause) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = cause instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) ? z : parentHandle$kotlinx_coroutines_core.childCancelled(cause) || z;
    }

    private final int startInternal(Object state) {
        if (state instanceof Empty) {
            if (((Empty) state).getIsActive()) {
                return 0;
            }
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, JobSupportKt.EMPTY_ACTIVE)) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(state instanceof InactiveNodeList)) {
            return 0;
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, ((InactiveNodeList) state).getList())) {
            return -1;
        }
        onStart();
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                CancellationException cancellationException = toCancellationException(rootCause, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null);
        }
        return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th, str);
    }

    protected final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        JobNode jobNodeMakeNode = makeNode(handler, onCancelling);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state$kotlinx_coroutines_core, jobNodeMakeNode)) {
                        return jobNodeMakeNode;
                    }
                } else {
                    promoteEmptyToNodeList(empty);
                }
            } else {
                if (state$kotlinx_coroutines_core instanceof Incomplete) {
                    NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                    if (list == null) {
                        Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                    } else {
                        DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                        if (onCancelling && (state$kotlinx_coroutines_core instanceof Finishing)) {
                            synchronized (state$kotlinx_coroutines_core) {
                                try {
                                    rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                    if (rootCause == null || ((handler instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                        if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNodeMakeNode)) {
                                            if (rootCause == null) {
                                                return jobNodeMakeNode;
                                            }
                                            disposableHandle = jobNodeMakeNode;
                                        }
                                    }
                                    Unit unit = Unit.INSTANCE;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        if (rootCause != null) {
                            if (invokeImmediately) {
                                handler.invoke(rootCause);
                            }
                            return disposableHandle;
                        }
                        if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNodeMakeNode)) {
                            return jobNodeMakeNode;
                        }
                    }
                } else {
                    if (invokeImmediately) {
                        CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    }
                    return NonDisposableHandle.INSTANCE;
                }
            }
        }
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        JobNode invokeOnCompletion;
        if (onCancelling) {
            invokeOnCompletion = handler instanceof JobCancellingNode ? (JobCancellingNode) handler : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCancelling(handler);
            }
        } else {
            invokeOnCompletion = handler instanceof JobNode ? (JobNode) handler : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCompletion(handler);
            }
        }
        invokeOnCompletion.setJob(this);
        return invokeOnCompletion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    private final void promoteEmptyToNodeList(Empty state) {
        NodeList nodeList = new NodeList();
        if (!state.getIsActive()) {
            nodeList = new InactiveNodeList(nodeList);
        }
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, nodeList);
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, state.getNextNode());
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        if (!joinInternal()) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object objJoinSuspend = joinSuspend(continuation);
        return objJoinSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public void cancelInternal(Throwable cause) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException();
    }

    public final boolean cancelCoroutine(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object cause) throws Throwable {
        Object objMakeCancelling = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (objMakeCancelling = cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (objMakeCancelling == JobSupportKt.COMPLETING_ALREADY) {
            objMakeCancelling = makeCancelling(cause);
        }
        if (objMakeCancelling == JobSupportKt.COMPLETING_ALREADY || objMakeCancelling == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (objMakeCancelling == JobSupportKt.TOO_LATE_TO_CANCEL) {
            return false;
        }
        afterCompletion(objMakeCancelling);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cause) throws Throwable {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        CancellationException rootCause;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? rootCause : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), rootCause, this);
    }

    private final Throwable createCauseException(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        }
        Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) cause).getChildJobCancellationCause();
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof Empty) {
            return new NodeList();
        }
        if (state instanceof JobNode) {
            promoteSingleToNodeList((JobNode) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) throws Throwable {
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return false;
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, new Finishing(orPromoteCancellingList, false, rootCause))) {
            return false;
        }
        notifyCancelling(orPromoteCancellingList, rootCause);
        return true;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        if (!(state instanceof Incomplete)) {
            return JobSupportKt.COMPLETING_ALREADY;
        }
        if ((!(state instanceof Empty) && !(state instanceof JobNode)) || (state instanceof ChildHandleNode) || (proposedUpdate instanceof CompletedExceptionally)) {
            return tryMakeCompletingSlowPath((Incomplete) state, proposedUpdate);
        }
        return tryFinalizeSimpleState((Incomplete) state, proposedUpdate) ? proposedUpdate : JobSupportKt.COMPLETING_RETRY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) throws Throwable {
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return JobSupportKt.COMPLETING_RETRY;
        }
        Finishing finishing = state instanceof Finishing ? (Finishing) state : null;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            finishing.setCompleting(true);
            if (finishing != state && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, finishing)) {
                return JobSupportKt.COMPLETING_RETRY;
            }
            boolean zIsCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            ?? rootCause = zIsCancelling ? 0 : finishing.getRootCause();
            ref$ObjectRef.element = rootCause;
            Unit unit = Unit.INSTANCE;
            if (rootCause != 0) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            ChildHandleNode childHandleNodeFirstChild = firstChild(state);
            if (childHandleNodeFirstChild != null && tryWaitForChild(finishing, childHandleNodeFirstChild, proposedUpdate)) {
                return JobSupportKt.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(finishing, proposedUpdate);
        }
    }

    private final Throwable getExceptionOrNull(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete state) {
        ChildHandleNode childHandleNode = state instanceof ChildHandleNode ? (ChildHandleNode) state : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = state.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (Job.DefaultImpls.invokeOnCompletion$default(child.childJob, false, false, new ChildCompletion(this, state, child, proposedUpdate), 1, null) == NonDisposableHandle.INSTANCE) {
            child = nextChild(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        ChildHandleNode childHandleNodeNextChild = nextChild(lastChild);
        if (childHandleNodeNextChild == null || !tryWaitForChild(state, childHandleNodeNextChild, proposedUpdate)) {
            afterCompletion(finalizeFinishingState(state, proposedUpdate));
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob child) {
        DisposableHandle disposableHandleInvokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(child), 2, null);
        Intrinsics.checkNotNull(disposableHandleInvokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) disposableHandleInvokeOnCompletion$default;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) throws Throwable {
        throw exception;
    }

    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        if (!(state instanceof Finishing)) {
            return state instanceof Incomplete ? ((Incomplete) state).getIsActive() ? "Active" : "New" : state instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) state;
        return finishing.isCancelling() ? "Cancelling" : finishing.isCompleting() ? "Completing" : "Active";
    }

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\b\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)2\b\u0010*\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", AppMeasurementSdk.ConditionalUserProperty.VALUE, "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final NodeList list;
        private static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
        private static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final boolean isCompleting() {
            return _isCompleting$FU.get(this) != 0;
        }

        public final void setCompleting(boolean z) {
            _isCompleting$FU.set(this, z ? 1 : 0);
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        public final void setRootCause(Throwable th) {
            _rootCause$FU.set(this, th);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object obj) {
            _exceptionsHolder$FU.set(this, obj);
        }

        public final boolean isSealed() {
            return getExceptionsHolder() == JobSupportKt.SEALED;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: isActive */
        public boolean getIsActive() {
            return getRootCause() == null;
        }

        public final List<Throwable> sealLocked(Throwable proposedException) {
            ArrayList<Throwable> arrayListAllocateList;
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                arrayListAllocateList = allocateList();
            } else if (exceptionsHolder instanceof Throwable) {
                ArrayList<Throwable> arrayListAllocateList2 = allocateList();
                arrayListAllocateList2.add(exceptionsHolder);
                arrayListAllocateList = arrayListAllocateList2;
            } else {
                if (!(exceptionsHolder instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + exceptionsHolder).toString());
                }
                arrayListAllocateList = (ArrayList) exceptionsHolder;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayListAllocateList.add(0, rootCause);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                arrayListAllocateList.add(proposedException);
            }
            setExceptionsHolder(JobSupportKt.SEALED);
            return arrayListAllocateList;
        }

        public final void addExceptionLocked(Throwable exception) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(exception);
                return;
            }
            if (exception == rootCause) {
                return;
            }
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                setExceptionsHolder(exception);
                return;
            }
            if (exceptionsHolder instanceof Throwable) {
                if (exception == exceptionsHolder) {
                    return;
                }
                ArrayList<Throwable> arrayListAllocateList = allocateList();
                arrayListAllocateList.add(exceptionsHolder);
                arrayListAllocateList.add(exception);
                setExceptionsHolder(arrayListAllocateList);
                return;
            }
            if (exceptionsHolder instanceof ArrayList) {
                ((ArrayList) exceptionsHolder).add(exception);
                return;
            }
            throw new IllegalStateException(("State is " + exceptionsHolder).toString());
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job parent) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof Finishing) || (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) == null) ? state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : parent.getCancellationException() : rootCause;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    protected final Object awaitInternal(Continuation<Object> continuation) throws Throwable {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                }
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    private final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
