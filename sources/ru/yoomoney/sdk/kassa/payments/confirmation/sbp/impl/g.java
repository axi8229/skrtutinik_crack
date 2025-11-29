package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function1 {
    public final /* synthetic */ m a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(m mVar, ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e eVar) {
        super(1);
        this.a = mVar;
        this.b = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new f(this.a, this.b, null));
        return Unit.INSTANCE;
    }
}
