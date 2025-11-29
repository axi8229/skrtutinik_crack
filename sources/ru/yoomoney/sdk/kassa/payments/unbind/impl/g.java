package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function1 {
    public static final g a = new g();

    public g() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object vVar;
        ru.yoomoney.sdk.kassa.payments.unbind.n it = (ru.yoomoney.sdk.kassa.payments.unbind.n) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(it, "<this>");
        if (it instanceof ru.yoomoney.sdk.kassa.payments.unbind.l) {
            return ru.yoomoney.sdk.kassa.payments.unbind.ui.x.a;
        }
        if (it instanceof ru.yoomoney.sdk.kassa.payments.unbind.k) {
            vVar = new ru.yoomoney.sdk.kassa.payments.unbind.ui.w(((ru.yoomoney.sdk.kassa.payments.unbind.k) it).a);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.unbind.j) {
            vVar = new ru.yoomoney.sdk.kassa.payments.unbind.ui.v(((ru.yoomoney.sdk.kassa.payments.unbind.j) it).a, false);
        } else {
            if (!(it instanceof ru.yoomoney.sdk.kassa.payments.unbind.m)) {
                throw new NoWhenBranchMatchedException();
            }
            vVar = new ru.yoomoney.sdk.kassa.payments.unbind.ui.v(((ru.yoomoney.sdk.kassa.payments.unbind.m) it).a, true);
        }
        return vVar;
    }
}
