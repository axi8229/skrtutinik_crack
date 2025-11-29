package ru.yoomoney.sdk.kassa.payments.confirmation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0 {
    public final /* synthetic */ ConfirmationActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ConfirmationActivity confirmationActivity) {
        super(0);
        this.a = confirmationActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a.getIntent().getStringExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_CLIENT_APPLICATION_KEY");
    }
}
