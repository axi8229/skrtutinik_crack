package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Om extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1928t1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Om(C1928t1 c1928t1, Continuation continuation) {
        super(2, continuation);
        this.b = c1928t1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Om om = new Om(this.b, continuation);
        om.a = obj;
        return om;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Om om = new Om(this.b, (Continuation) obj2);
        om.a = (ListOfCardsResponseBody) obj;
        return om.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.a;
        if (this.b.g()) {
            return new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList());
        }
        ListOfCardsResponseBody.MerchantInfo merchantInfo = listOfCardsResponseBody.getMerchantInfo();
        String merchantName = merchantInfo != null ? merchantInfo.getMerchantName() : null;
        if (merchantName == null) {
            merchantName = "";
        }
        return AbstractC1854q1.a(merchantName, "text", merchantName);
    }
}
