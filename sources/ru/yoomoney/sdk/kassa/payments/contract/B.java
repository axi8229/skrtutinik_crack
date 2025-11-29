package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class B extends Lambda implements Function1 {
    public final /* synthetic */ P a;
    public final /* synthetic */ AbstractC2236k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(P p, AbstractC2236k abstractC2236k) {
        super(1);
        this.a = p;
        this.b = abstractC2236k;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, this.a.c);
        CoreKt.output(invoke, new A(this.a, invoke, this.b, null));
        return Unit.INSTANCE;
    }
}
