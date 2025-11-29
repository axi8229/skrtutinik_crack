package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* compiled from: DispatchedContinuation.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "", "onCancellation", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "", "yieldUndispatched", "(Lkotlinx/coroutines/internal/DispatchedContinuation;)Z", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DispatchedContinuationKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        resumeCancellableWith(continuation, obj, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[Catch: all -> 0x0068, DONT_GENERATE, TryCatch #0 {all -> 0x0068, blocks: (B:11:0x003f, B:13:0x004d, B:15:0x0053, B:28:0x0092, B:18:0x006a, B:20:0x007a, B:25:0x0089, B:27:0x008f, B:33:0x009f, B:36:0x00a8, B:35:0x00a5, B:23:0x0080), top: B:44:0x003f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> void resumeCancellableWith(kotlin.coroutines.Continuation<? super T> r6, java.lang.Object r7, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto Lb2
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r8 = kotlinx.coroutines.CompletionStateKt.toState(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.dispatcher
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.isDispatchNeeded(r1)
            r1 = 1
            if (r0 == 0) goto L26
            r6._state = r8
            r6.resumeMode = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.dispatcher
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.dispatch(r8, r6)
            goto Lb5
        L26:
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r0 = r0.getEventLoop$kotlinx_coroutines_core()
            boolean r2 = r0.isUnconfinedLoopActive()
            if (r2 == 0) goto L3b
            r6._state = r8
            r6.resumeMode = r1
            r0.dispatchUnconfined(r6)
            goto Lb5
        L3b:
            r0.incrementUseCount(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch: java.lang.Throwable -> L68
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.INSTANCE     // Catch: java.lang.Throwable -> L68
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L68
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L6a
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L68
            if (r4 != 0) goto L6a
            java.util.concurrent.CancellationException r7 = r3.getCancellationException()     // Catch: java.lang.Throwable -> L68
            r6.cancelCompletedResult$kotlinx_coroutines_core(r8, r7)     // Catch: java.lang.Throwable -> L68
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = kotlin.Result.m2628constructorimpl(r7)     // Catch: java.lang.Throwable -> L68
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L68
            goto L92
        L68:
            r7 = move-exception
            goto La9
        L6a:
            kotlin.coroutines.Continuation<T> r8 = r6.continuation     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r6.countOrElement     // Catch: java.lang.Throwable -> L68
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L68
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch: java.lang.Throwable -> L68
            if (r3 == r5) goto L7f
            kotlinx.coroutines.UndispatchedCoroutine r8 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r8, r4, r3)     // Catch: java.lang.Throwable -> L68
            goto L80
        L7f:
            r8 = r2
        L80:
            kotlin.coroutines.Continuation<T> r5 = r6.continuation     // Catch: java.lang.Throwable -> L9c
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9c
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9c
            if (r8 == 0) goto L8f
            boolean r7 = r8.clearThreadContext()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L92
        L8f:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L68
        L92:
            boolean r7 = r0.processUnconfinedEvent()     // Catch: java.lang.Throwable -> L68
            if (r7 != 0) goto L92
        L98:
            r0.decrementUseCount(r1)
            goto Lb5
        L9c:
            r7 = move-exception
            if (r8 == 0) goto La5
            boolean r8 = r8.clearThreadContext()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto La8
        La5:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L68
        La8:
            throw r7     // Catch: java.lang.Throwable -> L68
        La9:
            r6.handleFatalException$kotlinx_coroutines_core(r7, r2)     // Catch: java.lang.Throwable -> Lad
            goto L98
        Lad:
            r6 = move-exception
            r0.decrementUseCount(r1)
            throw r6
        Lb2:
            r6.resumeWith(r7)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (!eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                dispatchedContinuation.run();
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } finally {
                try {
                    return false;
                } finally {
                }
            }
            return false;
        }
        dispatchedContinuation._state = unit;
        dispatchedContinuation.resumeMode = 1;
        eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
        return true;
    }
}
