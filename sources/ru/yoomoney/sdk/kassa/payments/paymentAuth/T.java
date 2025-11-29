package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class T extends Lambda implements Function1 {
    public final /* synthetic */ H0 a;
    public final /* synthetic */ E b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(H0 h0, E e) {
        super(1);
        this.a = h0;
        this.b = e;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new Q(this.a, invoke, null));
        CoreKt.input(invoke, new S(this.a, this.b, null));
        return Unit.INSTANCE;
    }
}
