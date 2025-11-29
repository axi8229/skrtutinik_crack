package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.a0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2460a0 extends Lambda implements Function0 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2460a0(C2487j0 c2487j0) {
        super(0);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        if (arguments != null) {
            return arguments.getString("PAYMENT_METHOD_ID");
        }
        return null;
    }
}
