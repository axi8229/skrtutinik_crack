package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class E0 extends Lambda implements Function1 {
    public final /* synthetic */ E1 a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.T b;
    public final /* synthetic */ C2514v c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E0(E1 e1, ru.yoomoney.sdk.kassa.payments.model.T t, C2514v c2514v) {
        super(1);
        this.a = e1;
        this.b = t;
        this.c = c2514v;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new D0(this.a, this.b, this.c, null));
        CoreKt.input(invoke, this.a.c);
        return Unit.INSTANCE;
    }
}
