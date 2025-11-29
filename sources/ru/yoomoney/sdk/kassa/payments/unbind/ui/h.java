package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function0 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Q b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Function1 function1, Q q) {
        super(0);
        this.a = function1;
        this.b = q;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.invoke(this.b.a);
        return Unit.INSTANCE;
    }
}
