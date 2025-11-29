package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function0 {
    public final /* synthetic */ Function0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Function0 function0) {
        super(0);
        this.a = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.invoke();
        return Unit.INSTANCE;
    }
}
