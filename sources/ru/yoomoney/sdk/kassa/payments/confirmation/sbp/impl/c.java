package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {
    public final /* synthetic */ m a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(m mVar, ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a aVar) {
        super(1);
        this.a = mVar;
        this.b = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new a(this.a, invoke, null));
        CoreKt.input(invoke, new b(this.a, this.b, null));
        return Unit.INSTANCE;
    }
}
