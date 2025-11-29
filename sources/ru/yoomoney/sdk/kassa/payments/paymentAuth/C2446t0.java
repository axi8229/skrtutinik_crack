package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.t0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2446t0 extends Lambda implements Function1 {
    public final /* synthetic */ H0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2446t0(H0 h0) {
        super(1);
        this.a = h0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new C2444s0(this.a, null));
        CoreKt.input(invoke, this.a.c);
        return Unit.INSTANCE;
    }
}
