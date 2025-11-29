package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Od extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public Od(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Od od = new Od(continuation);
        od.a = obj;
        return od;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Od od = new Od((Continuation) obj2);
        od.a = (OrderScreenDataResponse) obj;
        return od.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ListOfCardsResponseBody listOfCardsResponseBody;
        ListOfCardsResponseBody.OrderInfo orderInfo;
        ListOfCardsResponseBody.OrderInfo.OrderAmount orderAmount;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.a;
        if (orderScreenDataResponse == null || (listOfCardsResponseBody = orderScreenDataResponse.getListOfCardsResponseBody()) == null || (orderInfo = listOfCardsResponseBody.getOrderInfo()) == null || (orderAmount = orderInfo.getOrderAmount()) == null) {
            return null;
        }
        return orderAmount.getCurrency();
    }
}
