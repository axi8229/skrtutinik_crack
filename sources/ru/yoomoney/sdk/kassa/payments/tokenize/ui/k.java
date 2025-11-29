package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.tokenize.v;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class k extends Lambda implements Function2 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n nVar) {
        super(2);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Bundle bundle = (Bundle) obj2;
        Intrinsics.checkNotNullParameter((String) obj, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        n nVar = this.a;
        Serializable serializable = bundle.getSerializable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.PAYMENT_AUTH_RESULT_EXTRA");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.navigation.Screen.PaymentAuth.PaymentAuthResult");
        int i = n.$r8$clinit;
        nVar.getClass();
        int iOrdinal = ((ru.yoomoney.sdk.kassa.payments.navigation.h) serializable).ordinal();
        if (iOrdinal == 0) {
            ((RuntimeViewModel) nVar.d.getValue()).handleAction(v.a);
        } else if (iOrdinal == 1) {
            ((RuntimeViewModel) nVar.d.getValue()).handleAction(ru.yoomoney.sdk.kassa.payments.tokenize.t.a);
        }
        return Unit.INSTANCE;
    }
}
