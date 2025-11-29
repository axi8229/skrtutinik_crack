package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class G extends Lambda implements Function0 {
    public final /* synthetic */ H a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(H h) {
        super(0);
        this.a = h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Y y = this.a.a;
        if (y == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
            y = null;
        }
        return new X((I) y.a.a.get(), new Q((String) this.a.e.getValue(), (String) this.a.f.getValue()));
    }
}
