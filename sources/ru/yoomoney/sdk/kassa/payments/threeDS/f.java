package ru.yoomoney.sdk.kassa.payments.threeDS;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function0 {
    public final /* synthetic */ WebViewFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(WebViewFragment webViewFragment) {
        super(0);
        this.a = webViewFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.close3DSProcess();
        return Unit.INSTANCE;
    }
}
