package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {
    public final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar) {
        super(0);
        this.a = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        if (arguments != null) {
            return (Q) arguments.getParcelable("ru.yoomoney.sdk.kassa.payments.unbind.PAYMENT_OPTION_INSTRUMENT");
        }
        return null;
    }
}
