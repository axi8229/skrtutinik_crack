package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function0 {
    public final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar) {
        super(0);
        this.a = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.a.c;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(ru.yoomoney.sdk.kassa.payments.navigation.k.a);
        return Unit.INSTANCE;
    }
}
