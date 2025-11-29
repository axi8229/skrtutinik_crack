package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class E extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(RuntimeViewModel runtimeViewModel) {
        super(0);
        this.a = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.g.a);
        return Unit.INSTANCE;
    }
}
