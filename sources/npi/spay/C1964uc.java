package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.uc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1964uc extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1964uc(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1964uc c1964uc = new C1964uc(continuation);
        c1964uc.a = obj;
        return c1964uc;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1964uc c1964uc = new C1964uc((Continuation) obj2);
        c1964uc.a = (ListOfCardsResponseBody) obj;
        return c1964uc.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.a;
        if (listOfCardsResponseBody == null || (paymentToolInfo = listOfCardsResponseBody.getPaymentToolInfo()) == null) {
            return null;
        }
        return paymentToolInfo.getToolList();
    }
}
