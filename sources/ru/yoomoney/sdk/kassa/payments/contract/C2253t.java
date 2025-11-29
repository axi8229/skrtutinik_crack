package ru.yoomoney.sdk.kassa.payments.contract;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2253t implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final Function2 b;
    public final Function0 c;
    public final PaymentParameters d;
    public final ru.yoomoney.sdk.kassa.payments.metrics.V e;
    public final Function2 f;

    public C2253t(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, P businessLogic, ru.yoomoney.sdk.kassa.payments.metrics.e0 getUserAuthType, PaymentParameters paymentParameters, ru.yoomoney.sdk.kassa.payments.metrics.V tokenizeSchemeParamProvider, M0 getTokenizeScheme) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(getUserAuthType, "getUserAuthType");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(tokenizeSchemeParamProvider, "tokenizeSchemeParamProvider");
        Intrinsics.checkNotNullParameter(getTokenizeScheme, "getTokenizeScheme");
        this.a = reporter;
        this.b = businessLogic;
        this.c = getUserAuthType;
        this.d = paymentParameters;
        this.e = tokenizeSchemeParamProvider;
        this.f = getTokenizeScheme;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Pair pair;
        ru.yoomoney.sdk.kassa.payments.metrics.I g;
        AbstractC2251s state = (AbstractC2251s) obj;
        AbstractC2236k action = (AbstractC2236k) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        List<Pair> listListOf = null;
        if (Intrinsics.areEqual(action, C2226f.a)) {
            listListOf = CollectionsKt.listOf(TuplesKt.to("actionLogout", null));
        } else if (action instanceof C2224e) {
            Function2 function2 = this.f;
            ru.yoomoney.sdk.kassa.payments.payment.selectOption.a aVar = ((C2224e) action).a;
            listListOf = CollectionsKt.listOf(TuplesKt.to("screenPaymentContract", CollectionsKt.listOf((Object[]) new ru.yoomoney.sdk.kassa.payments.metrics.E[]{this.c.invoke(), function2.invoke(aVar.a, aVar.b)})));
        } else {
            if (action instanceof C2222d) {
                ru.yoomoney.sdk.kassa.payments.metrics.P p = this.e.a;
                if (p != null) {
                    ru.yoomoney.sdk.kassa.payments.metrics.E[] eArr = new ru.yoomoney.sdk.kassa.payments.metrics.E[3];
                    eArr[0] = this.c.invoke();
                    eArr[1] = p;
                    PaymentParameters parameters = this.d;
                    Intrinsics.checkNotNullParameter(parameters, "parameters");
                    int i = ru.yoomoney.sdk.kassa.payments.metrics.J.a[parameters.getSavePaymentMethod().ordinal()];
                    if (i == 1) {
                        g = new ru.yoomoney.sdk.kassa.payments.metrics.G();
                    } else if (i == 2) {
                        g = new ru.yoomoney.sdk.kassa.payments.metrics.H();
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        g = new ru.yoomoney.sdk.kassa.payments.metrics.K();
                    }
                    eArr[2] = g;
                    pair = TuplesKt.to("screenErrorContract", CollectionsKt.listOf((Object[]) eArr));
                }
            } else {
                pair = TuplesKt.to(null, null);
            }
            listListOf = CollectionsKt.listOf(pair);
        }
        if (listListOf != null) {
            for (Pair pair2 : listListOf) {
                String str = (String) pair2.getFirst();
                if (str != null) {
                    this.a.a(str, (List) pair2.getSecond());
                }
            }
        }
        return (Out) this.b.invoke(state, action);
    }
}
