package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.C2296e;
import ru.yoomoney.sdk.kassa.payments.metrics.C2297f;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class T implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final Function2 b;
    public final Function0 c;
    public final Function0 d;

    public T(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, E1 businessLogic, ru.yoomoney.sdk.kassa.payments.metrics.e0 getUserAuthType, ru.yoomoney.sdk.kassa.payments.metrics.V getTokenizeScheme) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(getUserAuthType, "getUserAuthType");
        Intrinsics.checkNotNullParameter(getTokenizeScheme, "getTokenizeScheme");
        this.a = reporter;
        this.b = businessLogic;
        this.c = getUserAuthType;
        this.d = getTokenizeScheme;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.metrics.F f;
        Object c2297f;
        List listListOf;
        S state = (S) obj;
        C action = (C) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof r) {
            ru.yoomoney.sdk.kassa.payments.metrics.P p = (ru.yoomoney.sdk.kassa.payments.metrics.P) this.d.invoke();
            if (p == null || (listListOf = CollectionsKt.listOf((Object[]) new ru.yoomoney.sdk.kassa.payments.metrics.E[]{this.c.invoke(), p})) == null) {
                listListOf = CollectionsKt.listOf(this.c.invoke());
            }
            this.a.a("screenError", listListOf);
        } else if (action instanceof C2508s) {
            this.a.a("screenPaymentOptions", CollectionsKt.listOf(this.c.invoke()));
        } else {
            if (action instanceof A) {
                f = this.a;
                c2297f = new C2296e();
            } else if (action instanceof B) {
                f = this.a;
                c2297f = new C2297f();
            }
            f.a("actionUnbindBankCard", CollectionsKt.listOf(c2297f));
        }
        return (Out) this.b.invoke(state, action);
    }
}
