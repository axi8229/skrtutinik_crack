package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class C extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ P b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(P p, Continuation continuation) {
        super(1, continuation);
        this.b = p;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L84
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L34
        L22:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.kassa.payments.contract.P r6 = r5.b
            ru.yoomoney.sdk.kassa.payments.logout.c r6 = r6.f
            r5.a = r4
            ru.yoomoney.sdk.kassa.payments.logout.d r6 = (ru.yoomoney.sdk.kassa.payments.logout.d) r6
            kotlin.Unit r6 = r6.a()
            if (r6 != r0) goto L34
            return r0
        L34:
            ru.yoomoney.sdk.kassa.payments.contract.P r6 = r5.b
            ru.yoomoney.sdk.kassa.payments.payment.c r6 = r6.h
            ru.yoomoney.sdk.kassa.payments.payment.d r6 = (ru.yoomoney.sdk.kassa.payments.payment.d) r6
            java.util.List r6 = r6.b
            int r1 = r6.size()
            if (r1 == r4) goto L75
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L52
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L52
            goto L75
        L52:
            java.util.Iterator r6 = r6.iterator()
        L56:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L75
            java.lang.Object r1 = r6.next()
            ru.yoomoney.sdk.kassa.payments.model.T r1 = (ru.yoomoney.sdk.kassa.payments.model.T) r1
            boolean r1 = r1 instanceof ru.yoomoney.sdk.kassa.payments.model.x0
            if (r1 != 0) goto L56
            ru.yoomoney.sdk.kassa.payments.contract.P r6 = r5.b
            kotlin.jvm.functions.Function2 r6 = r6.b
            ru.yoomoney.sdk.kassa.payments.contract.m r1 = ru.yoomoney.sdk.kassa.payments.contract.C2240m.a
            r5.a = r2
            java.lang.Object r6 = r6.invoke(r1, r5)
            if (r6 != r0) goto L84
            return r0
        L75:
            ru.yoomoney.sdk.kassa.payments.contract.P r6 = r5.b
            kotlin.jvm.functions.Function2 r6 = r6.b
            ru.yoomoney.sdk.kassa.payments.contract.l r1 = ru.yoomoney.sdk.kassa.payments.contract.C2238l.a
            r5.a = r3
            java.lang.Object r6 = r6.invoke(r1, r5)
            if (r6 != r0) goto L84
            return r0
        L84:
            ru.yoomoney.sdk.kassa.payments.contract.g r6 = ru.yoomoney.sdk.kassa.payments.contract.C2228g.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.contract.C.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
