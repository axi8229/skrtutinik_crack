package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: SimpleChannelFlow.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0011\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/paging/SimpleProducerScopeImpl;", "T", "Landroidx/paging/SimpleProducerScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "scope", "channel", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlin/Function0;", "block", "awaitClose", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleProducerScopeImpl<T> implements SimpleProducerScope<T>, CoroutineScope, SendChannel<T> {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final SendChannel<T> channel;

    /* compiled from: SimpleChannelFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SimpleProducerScopeImpl", f = "SimpleChannelFlow.kt", l = {101}, m = "awaitClose")
    /* renamed from: androidx.paging.SimpleProducerScopeImpl$awaitClose$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SimpleProducerScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimpleProducerScopeImpl<T> simpleProducerScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = simpleProducerScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitClose(null, this);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this.channel.close(cause);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.channel.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation<? super Unit> continuation) {
        return this.channel.send(t, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo2240trySendJP2dKIU(T element) {
        return this.channel.mo2240trySendJP2dKIU(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleProducerScopeImpl(CoroutineScope scope, SendChannel<? super T> channel) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.$$delegate_0 = scope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.paging.SimpleProducerScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object awaitClose(kotlin.jvm.functions.Function0<kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.SimpleProducerScopeImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.paging.SimpleProducerScopeImpl$awaitClose$1 r0 = (androidx.paging.SimpleProducerScopeImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.SimpleProducerScopeImpl$awaitClose$1 r0 = new androidx.paging.SimpleProducerScopeImpl$awaitClose$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L31
            goto L76
        L31:
            r7 = move-exception
            goto L84
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.coroutines.CoroutineContext r7 = r5.getCoroutineContext()     // Catch: java.lang.Throwable -> L31
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.INSTANCE     // Catch: java.lang.Throwable -> L31
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r2)     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L7c
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7     // Catch: java.lang.Throwable -> L31
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L31
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L31
            r0.label = r3     // Catch: java.lang.Throwable -> L31
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L31
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch: java.lang.Throwable -> L31
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L31
            r2.initCancellability()     // Catch: java.lang.Throwable -> L31
            androidx.paging.SimpleProducerScopeImpl$awaitClose$2$1 r3 = new androidx.paging.SimpleProducerScopeImpl$awaitClose$2$1     // Catch: java.lang.Throwable -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L31
            r7.invokeOnCompletion(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r2.getResult()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Throwable -> L31
            if (r7 != r2) goto L73
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch: java.lang.Throwable -> L31
        L73:
            if (r7 != r1) goto L76
            return r1
        L76:
            r6.invoke()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7c:
            java.lang.String r7 = "Internal error, context should have a job."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L31
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L31
            throw r0     // Catch: java.lang.Throwable -> L31
        L84:
            r6.invoke()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SimpleProducerScopeImpl.awaitClose(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
