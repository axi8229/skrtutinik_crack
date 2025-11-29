package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.zj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2096zj extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C2096zj(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2096zj c2096zj = new C2096zj(continuation);
        c2096zj.a = obj;
        return c2096zj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C2096zj c2096zj = new C2096zj((Continuation) obj2);
        c2096zj.a = (OrderScreenDataResponse) obj;
        return c2096zj.invokeSuspend(Unit.INSTANCE);
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
