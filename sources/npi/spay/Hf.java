package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class Hf extends SuspendLambda implements Function2 {
    public final /* synthetic */ Xf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hf(Xf xf, Continuation continuation) {
        super(2, continuation);
        this.a = xf;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Hf(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Hf(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r7)
            npi.spay.Xf r7 = r6.a
            boolean r0 = r7.k
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L2c
            kotlinx.coroutines.flow.StateFlow r7 = r7.l
            java.lang.Object r7 = r7.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r7 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r7
            if (r7 == 0) goto L93
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r7 = r7.getPaymentToolInfo()
            if (r7 == 0) goto L93
            java.util.List r7 = r7.getToolList()
            if (r7 == 0) goto L93
            java.lang.Object r7 = r7.get(r1)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r7 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r7
            goto L94
        L2c:
            npi.spay.Ei r7 = r7.e
            npi.spay.oj r7 = (npi.spay.C1822oj) r7
            kotlinx.coroutines.flow.StateFlow r7 = r7.b
            java.lang.Object r7 = r7.getValue()
            npi.spay.g0 r7 = (npi.spay.C1604g0) r7
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r7 = r7.b
            if (r7 != 0) goto L94
            npi.spay.Xf r7 = r6.a
            kotlinx.coroutines.flow.StateFlow r7 = r7.l
            java.lang.Object r7 = r7.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r7 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r7
            if (r7 == 0) goto L71
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r7 = r7.getPaymentToolInfo()
            if (r7 == 0) goto L71
            java.util.List r7 = r7.getToolList()
            if (r7 == 0) goto L71
            java.util.Iterator r7 = r7.iterator()
        L58:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6c
            java.lang.Object r0 = r7.next()
            r3 = r0
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r3 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r3
            boolean r3 = r3.getPriorityCard()
            if (r3 == 0) goto L58
            goto L6d
        L6c:
            r0 = r2
        L6d:
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r0 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r0
            r7 = r0
            goto L72
        L71:
            r7 = r2
        L72:
            if (r7 != 0) goto L94
            npi.spay.Xf r7 = r6.a
            kotlinx.coroutines.flow.StateFlow r7 = r7.l
            java.lang.Object r7 = r7.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r7 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r7
            if (r7 == 0) goto L93
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r7 = r7.getPaymentToolInfo()
            if (r7 == 0) goto L93
            java.util.List r7 = r7.getToolList()
            if (r7 == 0) goto L93
            java.lang.Object r7 = r7.get(r1)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r7 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r7
            goto L94
        L93:
            r7 = r2
        L94:
            if (r7 == 0) goto Lb4
            npi.spay.Xf r0 = r6.a
            npi.spay.Ei r0 = r0.e
            npi.spay.oj r0 = (npi.spay.C1822oj) r0
            r0.getClass()
            java.lang.String r3 = "incomeSelectedCard"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            kotlinx.coroutines.flow.MutableStateFlow r0 = r0.a
            java.lang.Object r3 = r0.getValue()
            npi.spay.g0 r3 = (npi.spay.C1604g0) r3
            r4 = 5
            npi.spay.g0 r1 = npi.spay.C1604g0.a(r3, r2, r7, r1, r4)
            r0.setValue(r1)
        Lb4:
            npi.spay.Xf r0 = r6.a
            npi.spay.t1 r0 = r0.h
            java.util.List r0 = r0.a()
            npi.spay.Xf r1 = r6.a
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.A
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        Lcf:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Le8
            java.lang.Object r3 = r0.next()
            npi.spay.H9 r3 = (npi.spay.H9) r3
            npi.spay.wa r4 = new npi.spay.wa
            int r5 = r3.a
            npi.spay.Bk r3 = r3.b
            r4.<init>(r5, r3)
            r2.add(r4)
            goto Lcf
        Le8:
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r2)
            r1.setValue(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Hf.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
