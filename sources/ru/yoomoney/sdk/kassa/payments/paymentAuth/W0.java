package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class W0 extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ A1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W0(RuntimeViewModel runtimeViewModel, A1 a1) {
        super(0);
        this.a = runtimeViewModel;
        this.b = a1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(new D(((x1) this.b).a));
        return Unit.INSTANCE;
    }
}
