package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class Mm extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1993vg b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mm(C1993vg c1993vg, Continuation continuation) {
        super(2, continuation);
        this.b = c1993vg;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Mm mm = new Mm(this.b, continuation);
        mm.a = obj;
        return mm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Mm mm = new Mm(this.b, (Continuation) obj2);
        mm.a = (C1604g0) obj;
        return mm.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.Object r4 = r3.a
            npi.spay.g0 r4 = (npi.spay.C1604g0) r4
            npi.spay.vg r0 = r3.b
            npi.spay.h r1 = npi.spay.EnumC1628h.S_BONUSES
            r0.getClass()
            java.lang.String r2 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.Map r0 = r0.c
            java.lang.Object r0 = r0.get(r1)
            npi.spay.zc r0 = (npi.spay.InterfaceC2089zc) r0
            if (r0 == 0) goto L3b
            r1 = 0
            java.lang.Object r0 = r0.a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            if (r0 != r2) goto L3b
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r4 = r4.b
            if (r4 == 0) goto L36
            java.lang.String r1 = r4.getPrecalculateBonuses()
        L36:
            int r4 = npi.spay.AbstractC1946tj.d(r1)
            goto L3c
        L3b:
            r4 = 0
        L3c:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Mm.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
