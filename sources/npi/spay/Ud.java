package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Ud extends SuspendLambda implements Function3 {
    public /* synthetic */ long a;
    public /* synthetic */ ListOfCardsResponseBody b;

    public Ud(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        long jLongValue = ((Number) obj).longValue();
        Ud ud = new Ud((Continuation) obj3);
        ud.a = jLongValue;
        ud.b = (ListOfCardsResponseBody) obj2;
        return ud.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        long j = this.a;
        ListOfCardsResponseBody listOfCardsResponseBody = this.b;
        int i = R$string.spay_currency_pattern;
        String strA = AbstractC2095zi.a(j);
        ListOfCardsResponseBody.OrderInfo.OrderAmount orderAmount = listOfCardsResponseBody.getOrderInfo().getOrderAmount();
        String currency = orderAmount != null ? orderAmount.getCurrency() : null;
        if (currency == null) {
            currency = "";
        }
        Object[] args = {strA, currency};
        Intrinsics.checkNotNullParameter(args, "args");
        return new C2097zk(i, ArraysKt.toList(args));
    }
}
