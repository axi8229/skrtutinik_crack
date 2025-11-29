package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class o1 extends SuspendLambda implements Function2 {
    public long a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ MutableState d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(MutableState mutableState, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.d = mutableState;
        this.e = j;
        this.f = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        o1 o1Var = new o1(this.d, this.e, this.f, continuation);
        o1Var.c = obj;
        return o1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((o1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ae -> B:17:0x0054). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.b
            r2 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L37
            if (r1 == r6) goto L2f
            if (r1 == r5) goto L25
            if (r1 != r4) goto L1d
            long r6 = r13.a
            java.lang.Object r1 = r13.c
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L54
        L1d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L25:
            long r6 = r13.a
            java.lang.Object r1 = r13.c
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L7c
        L2f:
            java.lang.Object r1 = r13.c
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4e
        L37:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.c
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            ru.yoomoney.sdk.kassa.payments.paymentAuth.n1 r1 = ru.yoomoney.sdk.kassa.payments.paymentAuth.n1.a
            r13.c = r14
            r13.b = r6
            java.lang.Object r1 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r1, r13)
            if (r1 != r0) goto L4b
            return r0
        L4b:
            r12 = r1
            r1 = r14
            r14 = r12
        L4e:
            java.lang.Number r14 = (java.lang.Number) r14
            long r6 = r14.longValue()
        L54:
            boolean r14 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r14 == 0) goto Lb1
            androidx.compose.runtime.MutableState r14 = r13.d
            java.lang.Object r14 = r14.getValue()
            java.lang.Number r14 = (java.lang.Number) r14
            long r8 = r14.longValue()
            int r14 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r14 <= 0) goto Lb1
            ru.yoomoney.sdk.kassa.payments.paymentAuth.m1 r14 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.m1
            r14.<init>(r6)
            r13.c = r1
            r13.a = r6
            r13.b = r5
            java.lang.Object r14 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r14, r13)
            if (r14 != r0) goto L7c
            return r0
        L7c:
            java.lang.Number r14 = (java.lang.Number) r14
            long r8 = r14.longValue()
            androidx.compose.runtime.MutableState r14 = r13.d
            long r10 = r13.e
            long r10 = r10 - r8
            long r8 = kotlin.ranges.RangesKt.coerceAtLeast(r10, r2)
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            r14.setValue(r8)
            long r8 = r13.f
            androidx.compose.runtime.MutableState r14 = r13.d
            java.lang.Object r14 = r14.getValue()
            java.lang.Number r14 = (java.lang.Number) r14
            long r10 = r14.longValue()
            long r8 = kotlin.ranges.RangesKt.coerceAtMost(r8, r10)
            r13.c = r1
            r13.a = r6
            r13.b = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r8, r13)
            if (r14 != r0) goto L54
            return r0
        Lb1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.o1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
