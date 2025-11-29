package ru.yoomoney.sdk.kassa.payments.contract;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class V extends Lambda implements Function2 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(C2264y0 c2264y0) {
        super(2);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String key = (String) obj;
        Bundle bundle = (Bundle) obj2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Serializable serializable = bundle.getSerializable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.TOKENIZE_RESULT_EXTRA");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.navigation.Screen.Tokenize.TokenizeResult");
        if (((ru.yoomoney.sdk.kassa.payments.navigation.n) serializable) == ru.yoomoney.sdk.kassa.payments.navigation.n.a) {
            C2264y0.a(this.a).handleAction(C2232i.a);
        }
        return Unit.INSTANCE;
    }
}
