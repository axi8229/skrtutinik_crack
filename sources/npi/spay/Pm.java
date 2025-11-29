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
import spay.sdk.domain.model.response.SPaySdkConfig;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Pm extends SuspendLambda implements Function3 {
    public /* synthetic */ Long a;
    public /* synthetic */ ListOfCardsResponseBody b;
    public final /* synthetic */ C1928t1 c;
    public final /* synthetic */ InterfaceC1728l0 d;
    public final /* synthetic */ Ei e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pm(C1928t1 c1928t1, InterfaceC1728l0 interfaceC1728l0, Ei ei, Continuation continuation) {
        super(3, continuation);
        this.c = c1928t1;
        this.d = interfaceC1728l0;
        this.e = ei;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Pm pm = new Pm(this.c, this.d, this.e, (Continuation) obj3);
        pm.a = (Long) obj;
        pm.b = (ListOfCardsResponseBody) obj2;
        return pm.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ListOfCardsResponseBody.OrderInfo orderInfo;
        ListOfCardsResponseBody.OrderInfo.OrderAmount orderAmount;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Long l = this.a;
        ListOfCardsResponseBody listOfCardsResponseBody = this.b;
        if (l == null) {
            return null;
        }
        C1928t1 c1928t1 = this.c;
        InterfaceC1728l0 interfaceC1728l0 = this.d;
        Ei ei = this.e;
        if (!c1928t1.g()) {
            int i = R$string.spay_currency_pattern;
            String strA = AbstractC2095zi.a(l.longValue());
            if (listOfCardsResponseBody != null && (orderInfo = listOfCardsResponseBody.getOrderInfo()) != null && (orderAmount = orderInfo.getOrderAmount()) != null) {
                currency = orderAmount.getCurrency();
            }
            Object[] args = {strA, currency != null ? currency : ""};
            Intrinsics.checkNotNullParameter(args, "args");
            return new C2097zk(i, ArraysKt.toList(args));
        }
        int i2 = R$string.spay_card_number_pattern_success_payment;
        SPaySdkConfig sPaySdkConfig = ((O0) interfaceC1728l0).c;
        if (sPaySdkConfig == null) {
            throw C1808o5.a;
        }
        String successEnableSPay = sPaySdkConfig.getLocalization().getSuccessEnableSPay();
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = ((C1604g0) ((C1822oj) ei).b.getValue()).b;
        currency = tool != null ? tool.getCardNumber() : null;
        Object[] args2 = {successEnableSPay, currency != null ? currency : ""};
        Intrinsics.checkNotNullParameter(args2, "args");
        return new C2097zk(i2, ArraysKt.toList(args2));
    }
}
