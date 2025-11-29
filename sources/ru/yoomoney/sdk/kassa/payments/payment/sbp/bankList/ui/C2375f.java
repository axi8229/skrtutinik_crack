package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.q0;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2375f extends Lambda implements Function0 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2375f(C2382m c2382m) {
        super(0);
        this.a = c2382m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new q0((String) this.a.f.getValue(), (String) this.a.g.getValue());
    }
}
