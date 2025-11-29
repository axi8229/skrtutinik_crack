package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.threeDS.WebViewActivity;

/* loaded from: classes5.dex */
public final class Q extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(C2264y0 c2264y0) {
        super(1);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Context contextRequireContext = this.a.requireContext();
        int i = WebViewActivity.$r8$clinit;
        Context contextRequireContext2 = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        TestParameters testParameters = this.a.d;
        if (testParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("testParameters");
            testParameters = null;
        }
        ContextCompat.startActivity(contextRequireContext, ru.yoomoney.sdk.kassa.payments.threeDS.a.a(contextRequireContext2, it, null, testParameters).setFlags(268435456), null);
        return Unit.INSTANCE;
    }
}
