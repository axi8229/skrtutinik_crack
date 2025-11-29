package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(RuntimeViewModel runtimeViewModel) {
        super(1);
        this.a = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String cardId = (String) obj;
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        this.a.handleAction(new ru.yoomoney.sdk.kassa.payments.unbind.c(cardId));
        return Unit.INSTANCE;
    }
}
