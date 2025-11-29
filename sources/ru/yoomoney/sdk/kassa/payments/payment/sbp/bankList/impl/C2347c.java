package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2347c extends Lambda implements Function1 {
    public final /* synthetic */ c0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2347c(c0 c0Var) {
        super(1);
        this.a = c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new C2346b(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
