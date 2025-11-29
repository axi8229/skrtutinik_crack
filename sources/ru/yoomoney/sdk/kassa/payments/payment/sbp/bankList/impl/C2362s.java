package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2362s extends Lambda implements Function1 {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2362s(c0 c0Var, ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v vVar) {
        super(1);
        this.a = c0Var;
        this.b = vVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, this.a.c);
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v vVar = this.b;
        if (vVar.b) {
            CoreKt.input(invoke, new C2361q(this.a, vVar, null));
        } else {
            CoreKt.output(invoke, new r(this.a, null));
        }
        return Unit.INSTANCE;
    }
}
