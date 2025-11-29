package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.h8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1637h8 extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ N8 c;
    public final /* synthetic */ C7 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1637h8(N8 n8, C7 c7, Continuation continuation) {
        super(2, continuation);
        this.c = n8;
        this.d = c7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1637h8 c1637h8 = new C1637h8(this.c, this.d, continuation);
        c1637h8.b = obj;
        return c1637h8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1637h8) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.a
            r2 = 0
            switch(r1) {
                case 0: goto L2c;
                case 1: goto L28;
                case 2: goto L23;
                case 3: goto L1b;
                case 4: goto L23;
                case 5: goto L12;
                case 6: goto L23;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L12:
            java.lang.Object r1 = r6.b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L9d
        L1b:
            java.lang.Object r1 = r6.b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7b
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            goto Lab
        L28:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L2c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.b
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            npi.spay.N8 r7 = r6.c
            spay.sdk.domain.model.request.AuthWithPurchaseRequestBody r3 = r7.f
            if (r3 == 0) goto L55
            spay.sdk.domain.model.request.AuthWithOrderIdRequestBody r4 = r7.e
            if (r4 == 0) goto L55
            timber.log.Timber$Forest r7 = timber.log.Timber.INSTANCE
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "Passed both purchase and orderId"
            r7.e(r4, r3)
            r7 = 1
            r6.a = r7
            java.lang.Object r7 = r1.emit(r2, r6)
            if (r7 != r0) goto L52
            return r0
        L52:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L55:
            if (r3 != 0) goto L65
            spay.sdk.domain.model.request.AuthWithOrderIdRequestBody r4 = r7.e
            if (r4 != 0) goto L65
            r7 = 2
            r6.a = r7
            java.lang.Object r7 = r1.emit(r2, r6)
            if (r7 != r0) goto Lab
            return r0
        L65:
            spay.sdk.domain.model.request.AuthWithOrderIdRequestBody r4 = r7.e
            if (r4 == 0) goto L89
            npi.spay.C7 r3 = r6.d
            npi.spay.Zk r3 = r3.e
            java.lang.String r7 = r7.a
            r6.b = r1
            r5 = 3
            r6.a = r5
            java.lang.Object r7 = r3.a(r2, r4, r7, r6)
            if (r7 != r0) goto L7b
            return r0
        L7b:
            npi.spay.q2 r7 = (npi.spay.AbstractC1855q2) r7
            r6.b = r2
            r2 = 4
            r6.a = r2
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto Lab
            return r0
        L89:
            if (r3 == 0) goto Lab
            npi.spay.C7 r4 = r6.d
            npi.spay.Zk r4 = r4.e
            java.lang.String r7 = r7.a
            r6.b = r1
            r5 = 5
            r6.a = r5
            java.lang.Object r7 = r4.a(r3, r2, r7, r6)
            if (r7 != r0) goto L9d
            return r0
        L9d:
            npi.spay.q2 r7 = (npi.spay.AbstractC1855q2) r7
            r6.b = r2
            r2 = 6
            r6.a = r2
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto Lab
            return r0
        Lab:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1637h8.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
