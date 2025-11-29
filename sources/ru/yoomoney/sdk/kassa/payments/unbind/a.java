package ru.yoomoney.sdk.kassa.payments.unbind;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.w;

/* loaded from: classes5.dex */
public final class a implements Function2 {
    public final F a;
    public final Function2 b;

    public a(F reporter, w businessLogic) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        this.a = reporter;
        this.b = businessLogic;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            ru.yoomoney.sdk.kassa.payments.unbind.n r4 = (ru.yoomoney.sdk.kassa.payments.unbind.n) r4
            ru.yoomoney.sdk.kassa.payments.unbind.f r5 = (ru.yoomoney.sdk.kassa.payments.unbind.f) r5
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.unbind.b
            if (r0 == 0) goto L2f
            r0 = r5
            ru.yoomoney.sdk.kassa.payments.unbind.b r0 = (ru.yoomoney.sdk.kassa.payments.unbind.b) r0
            ru.yoomoney.sdk.kassa.payments.model.Q r0 = r0.b
            java.lang.String r1 = "screenUnbindCard"
            if (r0 == 0) goto L29
            ru.yoomoney.sdk.kassa.payments.metrics.x r0 = new ru.yoomoney.sdk.kassa.payments.metrics.x
            r0.<init>()
        L20:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            goto L4a
        L29:
            ru.yoomoney.sdk.kassa.payments.metrics.y r0 = new ru.yoomoney.sdk.kassa.payments.metrics.y
            r0.<init>()
            goto L20
        L2f:
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.unbind.d
            java.lang.String r1 = "actionUnbindBankCard"
            if (r0 == 0) goto L3b
            ru.yoomoney.sdk.kassa.payments.metrics.e r0 = new ru.yoomoney.sdk.kassa.payments.metrics.e
            r0.<init>()
            goto L20
        L3b:
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.unbind.e
            if (r0 == 0) goto L45
            ru.yoomoney.sdk.kassa.payments.metrics.f r0 = new ru.yoomoney.sdk.kassa.payments.metrics.f
            r0.<init>()
            goto L20
        L45:
            r0 = 0
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r0)
        L4a:
            java.lang.Object r1 = r0.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.component2()
            java.util.List r0 = (java.util.List) r0
            if (r1 == 0) goto L5d
            ru.yoomoney.sdk.kassa.payments.metrics.F r2 = r3.a
            r2.a(r1, r0)
        L5d:
            kotlin.jvm.functions.Function2 r0 = r3.b
            java.lang.Object r4 = r0.invoke(r4, r5)
            ru.yoomoney.sdk.march.Out r4 = (ru.yoomoney.sdk.march.Out) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.unbind.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
