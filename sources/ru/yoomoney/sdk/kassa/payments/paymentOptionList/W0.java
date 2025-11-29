package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class W0 extends Lambda implements Function1 {
    public final /* synthetic */ E1 a;
    public final /* synthetic */ C b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W0(E1 e1, C c) {
        super(1);
        this.a = e1;
        this.b = c;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        E1.a(this.a, invoke, (C2508s) this.b);
        return Unit.INSTANCE;
    }
}
