package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class i extends Lambda implements Function0 {
    public final /* synthetic */ WebViewFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(WebViewFragment webViewFragment) {
        super(0);
        this.a = webViewFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        if (arguments != null) {
            return arguments.getString("returnUrl");
        }
        return null;
    }
}
