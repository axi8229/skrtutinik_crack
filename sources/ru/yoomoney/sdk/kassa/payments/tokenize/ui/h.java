package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function2 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar) {
        super(2);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Amount charge = (Amount) obj;
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        Intrinsics.checkNotNullParameter(charge, "charge");
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.a.b;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.i(charge, zBooleanValue));
        return Unit.INSTANCE;
    }
}
