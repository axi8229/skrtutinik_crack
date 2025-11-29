package ru.yoomoney.sdk.kassa.payments.confirmation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function0 {
    public final /* synthetic */ ConfirmationActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ConfirmationActivity confirmationActivity) {
        super(0);
        this.a = confirmationActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return (ColorScheme) this.a.getIntent().getParcelableExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_COLOR_SCHEME");
    }
}
