package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class D extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(RuntimeViewModel runtimeViewModel) {
        super(1);
        this.a = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.handleAction(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n(it));
        return Unit.INSTANCE;
    }
}
