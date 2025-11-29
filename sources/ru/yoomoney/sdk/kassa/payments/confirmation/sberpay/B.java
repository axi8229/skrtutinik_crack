package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class B extends Lambda implements Function0 {
    public final /* synthetic */ H a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(H h) {
        super(0);
        this.a = h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((RuntimeViewModel) this.a.d.getValue()).handleAction(C2202l.a);
        return Unit.INSTANCE;
    }
}
