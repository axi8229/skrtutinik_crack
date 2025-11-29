package ru.yoomoney.sdk.two_fa.exception;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ExecuteUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aL\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0080@¢\u0006\u0002\u0010\u000b\u001aB\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0080@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"RETRY_COUNT", "", "execute", "Lkotlin/Result;", "T", "", "exceptionResolver", "Lru/yoomoney/sdk/two_fa/exception/ExceptionResolver;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lru/yoomoney/sdk/two_fa/exception/ExceptionResolver;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWithRetry", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExecuteUtilKt {
    private static final int RETRY_COUNT = 5;

    /* compiled from: ExecuteUtil.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt", f = "ExecuteUtil.kt", l = {12}, m = "execute")
    /* renamed from: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$execute$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objExecute = ExecuteUtilKt.execute(null, null, this);
            return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : Result.m2627boximpl(objExecute);
        }
    }

    /* compiled from: ExecuteUtil.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt", f = "ExecuteUtil.kt", l = {18}, m = "executeWithRetry")
    /* renamed from: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$1, reason: invalid class name and case insensitive filesystem */
    static final class C26001<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C26001(Continuation<? super C26001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objExecuteWithRetry = ExecuteUtilKt.executeWithRetry(null, this);
            return objExecuteWithRetry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecuteWithRetry : Result.m2627boximpl(objExecuteWithRetry);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object execute(ru.yoomoney.sdk.two_fa.exception.ExceptionResolver r4, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$execute$1 r0 = (ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$execute$1 r0 = new ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$execute$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            ru.yoomoney.sdk.two_fa.exception.ExceptionResolver r4 = (ru.yoomoney.sdk.two_fa.exception.ExceptionResolver) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L45
        L2d:
            r5 = move-exception
            goto L4c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2d
            r0.label = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r6 = r5.invoke(r0)     // Catch: java.lang.Exception -> L2d
            if (r6 != r1) goto L45
            return r1
        L45:
            kotlin.Result r6 = (kotlin.Result) r6     // Catch: java.lang.Exception -> L2d
            java.lang.Object r4 = r6.getValue()     // Catch: java.lang.Exception -> L2d
            goto L5a
        L4c:
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            ru.yoomoney.sdk.two_fa.exception.Failure r4 = r4.resolve(r5)
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m2628constructorimpl(r4)
        L5a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.execute(ru.yoomoney.sdk.two_fa.exception.ExceptionResolver, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object execute$default(ExceptionResolver exceptionResolver, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            exceptionResolver = BaseExceptionResolverKt.getBaseExceptionResolver();
        }
        return execute(exceptionResolver, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ExecuteUtil.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "T", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$2", f = "ExecuteUtil.kt", l = {19, 24, 25}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$2, reason: invalid class name */
    static final class AnonymousClass2<T> extends SuspendLambda implements Function1<Continuation<? super Result<? extends T>>, Object> {
        final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> $block;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends T>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0075 -> B:30:0x0078). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                int r1 = r7.I$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L78
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                int r1 = r7.I$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L6b
            L25:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L37
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r8 = r7.$block
                r7.label = r4
                java.lang.Object r8 = r8.invoke(r7)
                if (r8 != r0) goto L37
                return r0
            L37:
                kotlin.Result r8 = (kotlin.Result) r8
                java.lang.Object r8 = r8.getValue()
                r1 = 0
            L3e:
                r5 = 5
                if (r1 >= r5) goto L80
                boolean r5 = kotlin.Result.m2633isFailureimpl(r8)
                if (r5 == 0) goto L80
                java.lang.Throwable r5 = kotlin.Result.m2631exceptionOrNullimpl(r8)
                boolean r6 = r5 instanceof ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure
                if (r6 == 0) goto L80
                ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure r5 = (ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure) r5
                java.lang.Integer r6 = r5.getRetryAfter()
                if (r6 == 0) goto L80
                java.lang.Integer r8 = r5.getRetryAfter()
                int r8 = r8.intValue()
                long r5 = (long) r8
                r7.I$0 = r1
                r7.label = r3
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
                if (r8 != r0) goto L6b
                return r0
            L6b:
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r8 = r7.$block
                r7.I$0 = r1
                r7.label = r2
                java.lang.Object r8 = r8.invoke(r7)
                if (r8 != r0) goto L78
                return r0
            L78:
                kotlin.Result r8 = (kotlin.Result) r8
                java.lang.Object r8 = r8.getValue()
                int r1 = r1 + r4
                goto L3e
            L80:
                kotlin.Result r8 = kotlin.Result.m2627boximpl(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object executeWithRetry(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r4, kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.C26001
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$1 r0 = (ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.C26001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$1 r0 = new ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$2 r5 = new ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt$executeWithRetry$2
            r2 = 0
            r5.<init>(r4, r2)
            r0.label = r3
            java.lang.Object r4 = execute$default(r2, r5, r0, r3, r2)
            if (r4 != r1) goto L49
            return r1
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.executeWithRetry(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
