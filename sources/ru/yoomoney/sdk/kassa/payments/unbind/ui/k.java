package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class k extends Lambda implements Function0 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ w b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Function1 function1, w wVar) {
        super(0);
        this.a = function1;
        this.b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.invoke(this.b.a.getCardId());
        return Unit.INSTANCE;
    }
}
