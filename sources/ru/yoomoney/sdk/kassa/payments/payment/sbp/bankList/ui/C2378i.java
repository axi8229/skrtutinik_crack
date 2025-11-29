package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2378i extends Lambda implements Function0 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2378i(C2382m c2382m) {
        super(0);
        this.a = c2382m;
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
