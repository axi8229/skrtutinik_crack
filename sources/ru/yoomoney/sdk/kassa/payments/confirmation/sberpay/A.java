package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class A extends Lambda implements Function0 {
    public final /* synthetic */ H a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(H h) {
        super(0);
        this.a = h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        String string = arguments != null ? arguments.getString("SHOP_ID") : null;
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
        return string;
    }
}
