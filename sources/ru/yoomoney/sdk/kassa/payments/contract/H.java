package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class H extends Lambda implements Function1 {
    public final /* synthetic */ P a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(P p) {
        super(1);
        this.a = p;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new G(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
