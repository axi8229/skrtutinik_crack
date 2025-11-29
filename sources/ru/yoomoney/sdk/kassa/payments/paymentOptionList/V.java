package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class V extends Lambda implements Function2 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(C2487j0 c2487j0) {
        super(2);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object obj3;
        Bundle bundle = (Bundle) obj2;
        Intrinsics.checkNotNullParameter((String) obj, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Serializable serializable = bundle.getSerializable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_EXTRA");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.navigation.Screen.MoneyAuth.Result");
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.a.e.getValue();
        int iOrdinal = ((ru.yoomoney.sdk.kassa.payments.navigation.f) serializable).ordinal();
        if (iOrdinal == 0) {
            obj3 = C2520y.a;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            obj3 = C2518x.a;
        }
        runtimeViewModel.handleAction(obj3);
        return Unit.INSTANCE;
    }
}
