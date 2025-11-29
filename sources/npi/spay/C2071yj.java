package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.yj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2071yj extends SuspendLambda implements Function3 {
    public /* synthetic */ ListOfCardsResponseBody a;
    public /* synthetic */ ListOfCardsResponseBody.PaymentToolInfo.Tool b;
    public final /* synthetic */ Jj c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2071yj(Jj jj, Continuation continuation) {
        super(3, continuation);
        this.c = jj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C2071yj c2071yj = new C2071yj(this.c, (Continuation) obj3);
        c2071yj.a = (ListOfCardsResponseBody) obj;
        c2071yj.b = (ListOfCardsResponseBody.PaymentToolInfo.Tool) obj2;
        return c2071yj.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r8)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r8 = r7.a
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r0 = r7.b
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r1 = r8.getPaymentToolInfo()
            java.util.List r1 = r1.getToolList()
            r2 = 0
            if (r1 == 0) goto L3a
            java.util.Iterator r1 = r1.iterator()
        L19:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L35
            java.lang.Object r3 = r1.next()
            r4 = r3
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r4 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r4
            java.lang.String r4 = r4.getCardNumber()
            java.lang.String r5 = r0.getCardNumber()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L19
            goto L36
        L35:
            r3 = r2
        L36:
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r3 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r3
            if (r3 != 0) goto L4d
        L3a:
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r8 = r8.getPaymentToolInfo()
            java.util.List r8 = r8.getToolList()
            if (r8 == 0) goto L4c
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            r3 = r8
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r3 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r3
            goto L4d
        L4c:
            r3 = r2
        L4d:
            npi.spay.Jj r8 = r7.c
            npi.spay.vg r8 = r8.f
            npi.spay.h r0 = npi.spay.EnumC1628h.CARD_BALANCE
            r8.getClass()
            java.lang.String r1 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.Map r8 = r8.c
            java.lang.Object r8 = r8.get(r0)
            npi.spay.zc r8 = (npi.spay.InterfaceC2089zc) r8
            r0 = 0
            r4 = 1
            if (r8 == 0) goto L75
            java.lang.Object r8 = r8.a(r2)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != r4) goto L75
            r8 = r4
            goto L76
        L75:
            r8 = r0
        L76:
            npi.spay.Jj r5 = r7.c
            npi.spay.vg r5 = r5.f
            npi.spay.h r6 = npi.spay.EnumC1628h.COMPOUND_WALLET
            r5.getClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.util.Map r1 = r5.c
            java.lang.Object r1 = r1.get(r6)
            npi.spay.zc r1 = (npi.spay.InterfaceC2089zc) r1
            if (r1 == 0) goto La5
            java.lang.Object r1 = r1.a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != r4) goto La5
            if (r3 == 0) goto L9e
            java.lang.Integer r2 = r3.getCountAdditionalCards()
        L9e:
            boolean r1 = npi.spay.AbstractC2095zi.a(r2, r0)
            if (r1 == 0) goto La5
            r0 = r4
        La5:
            npi.spay.z6 r8 = npi.spay.AbstractC2058y6.a(r3, r8, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2071yj.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
