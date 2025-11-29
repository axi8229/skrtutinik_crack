package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class H extends Lambda implements Function1 {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(c0 c0Var, String str) {
        super(1);
        this.a = c0Var;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, this.a.c);
        CoreKt.output(invoke, new G(this.a, this.b, null));
        ((j0) this.a.d).c = true;
        return Unit.INSTANCE;
    }
}
