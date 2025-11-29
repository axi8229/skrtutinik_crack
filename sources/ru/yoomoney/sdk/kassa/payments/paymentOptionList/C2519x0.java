package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.x0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2519x0 extends Lambda implements Function1 {
    public final /* synthetic */ E1 a;
    public final /* synthetic */ BankCardPaymentOption b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2519x0(E1 e1, BankCardPaymentOption bankCardPaymentOption) {
        super(1);
        this.a = e1;
        this.b = bankCardPaymentOption;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new C2517w0(this.a, this.b, null));
        CoreKt.input(invoke, this.a.c);
        return Unit.INSTANCE;
    }
}
