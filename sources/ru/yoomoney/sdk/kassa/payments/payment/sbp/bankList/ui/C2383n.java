package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2383n extends Lambda implements Function0 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ a0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2383n(Function1 function1, a0 a0Var) {
        super(0);
        this.a = function1;
        this.b = a0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.invoke(this.b.c);
        return Unit.INSTANCE;
    }
}
