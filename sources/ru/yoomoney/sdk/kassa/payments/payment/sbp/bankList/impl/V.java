package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class V extends Lambda implements Function1 {
    public final /* synthetic */ c0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(c0 c0Var) {
        super(1);
        this.a = c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new T(this.a, invoke, null));
        CoreKt.input(invoke, new U(this.a, null));
        return Unit.INSTANCE;
    }
}
