package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class V0 extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Amount c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(RuntimeViewModel runtimeViewModel, boolean z, Amount amount) {
        super(0);
        this.a = runtimeViewModel;
        this.b = z;
        this.c = amount;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(new B(this.c, this.b));
        return Unit.INSTANCE;
    }
}
