package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.y2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2054y2 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ A2 b;
    public final /* synthetic */ Ih c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2054y2(A2 a2, Ih ih, Continuation continuation) {
        super(2, continuation);
        this.b = a2;
        this.c = ih;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2054y2 c2054y2 = new C2054y2(this.b, this.c, continuation);
        c2054y2.a = obj;
        return c2054y2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2054y2) create((C1604g0) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.Object r3 = r2.a
            npi.spay.g0 r3 = (npi.spay.C1604g0) r3
            boolean r0 = r3.c
            if (r0 != 0) goto L11
            int r3 = ru.yoomoney.sdk.kassa.payments.R$drawable.bg_sdk_successful
            goto L71
        L11:
            npi.spay.A2 r0 = r2.b
            java.lang.Boolean r0 = r0.d()
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L6f
            npi.spay.q2 r0 = r3.a
            boolean r1 = r0 instanceof npi.spay.C1581f2
            if (r1 != 0) goto L6f
            boolean r1 = r0 instanceof npi.spay.C1556e2
            if (r1 != 0) goto L6f
            boolean r1 = r0 instanceof npi.spay.C1755m2
            if (r1 != 0) goto L6f
            boolean r1 = r0 instanceof npi.spay.W1
            if (r1 != 0) goto L6f
            boolean r1 = r0 instanceof npi.spay.G1
            if (r1 != 0) goto L6f
            boolean r0 = r0 instanceof npi.spay.C1705k2
            if (r0 == 0) goto L65
            npi.spay.Ih r0 = r2.c
            npi.spay.Di r0 = (npi.spay.Di) r0
            kotlinx.coroutines.flow.StateFlow r0 = r0.k
            java.lang.Object r0 = r0.getValue()
            spay.sdk.domain.model.response.OrderScreenDataResponse r0 = (spay.sdk.domain.model.response.OrderScreenDataResponse) r0
            if (r0 == 0) goto L5b
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r0 = r0.getListOfCardsResponseBody()
            if (r0 == 0) goto L5b
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r0 = r0.getPaymentToolInfo()
            if (r0 == 0) goto L5b
            java.util.List r0 = r0.getToolList()
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == 0) goto L6f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L65
            goto L6f
        L65:
            npi.spay.q2 r3 = r3.a
            boolean r3 = r3 instanceof npi.spay.I1
            if (r3 == 0) goto L6c
            goto L6f
        L6c:
            int r3 = ru.yoomoney.sdk.kassa.payments.R$drawable.bg_sdk_successful
            goto L71
        L6f:
            int r3 = ru.yoomoney.sdk.kassa.payments.R$drawable.bg_sdk_error
        L71:
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2054y2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
