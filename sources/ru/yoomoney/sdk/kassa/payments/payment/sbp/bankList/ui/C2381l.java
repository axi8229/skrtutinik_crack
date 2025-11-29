package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2381l extends Lambda implements Function0 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2381l(C2382m c2382m) {
        super(0);
        this.a = c2382m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        String string = arguments != null ? arguments.getString("PAYMENT_ID_KEY") : null;
        return string == null ? "" : string;
    }
}
