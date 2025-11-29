package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function1 {
    public final /* synthetic */ w a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(w wVar) {
        super(1);
        this.a = wVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new n(this.a, invoke, null));
        CoreKt.input(invoke, this.a.c);
        return Unit.INSTANCE;
    }
}
