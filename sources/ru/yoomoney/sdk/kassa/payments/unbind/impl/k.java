package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class k extends Lambda implements Function1 {
    public final /* synthetic */ w a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(w wVar) {
        super(1);
        this.a = wVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new i(this.a, invoke, null));
        CoreKt.input(invoke, new j(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
