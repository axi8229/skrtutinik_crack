package ru.yoomoney.sdk.kassa.payments.userAuth;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.C2292a;
import ru.yoomoney.sdk.kassa.payments.metrics.C2293b;
import ru.yoomoney.sdk.kassa.payments.metrics.C2294c;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class r implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final Function2 b;

    public r(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, K businessLogic) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        this.a = reporter;
        this.b = businessLogic;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AbstractC2554q state = (AbstractC2554q) obj;
        AbstractC2546i action = (AbstractC2546i) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        List listListOf = action instanceof C2543f ? CollectionsKt.listOf((Object[]) new ru.yoomoney.sdk.kassa.payments.metrics.E[]{new C2294c(), ((C2543f) action).d}) : action instanceof C2540c ? CollectionsKt.listOf((Object[]) new ru.yoomoney.sdk.kassa.payments.metrics.E[]{new C2292a(), new ru.yoomoney.sdk.kassa.payments.metrics.A()}) : action instanceof C2541d ? CollectionsKt.listOf((Object[]) new ru.yoomoney.sdk.kassa.payments.metrics.E[]{new C2293b(), new ru.yoomoney.sdk.kassa.payments.metrics.B()}) : null;
        if (listListOf != null) {
            this.a.a("actionMoneyAuthLogin", listListOf);
        }
        return (Out) this.b.invoke(state, action);
    }
}
