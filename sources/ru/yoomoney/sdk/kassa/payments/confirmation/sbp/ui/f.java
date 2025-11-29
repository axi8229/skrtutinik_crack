package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function0 {
    public final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar) {
        super(0);
        this.a = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        String string = arguments != null ? arguments.getString("ru.yoomoney.sdk.kassa.payments.confirmation.CONFIRMATION_DATA") : null;
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
        return string;
    }
}
