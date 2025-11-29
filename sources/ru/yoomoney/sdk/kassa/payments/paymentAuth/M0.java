package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class M0 extends Lambda implements Function2 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M0(O0 o0) {
        super(2);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar;
        ViewModelProvider.Factory factory;
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-177585290, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.PaymentAuthFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (PaymentAuthFragment.kt:99)");
            }
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar2 = this.a.b;
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
                bVar = null;
            }
            boolean zBooleanValue = ((Boolean) this.a.d.getValue()).booleanValue();
            Amount amount = (Amount) this.a.c.getValue();
            ViewModelProvider.Factory factory2 = this.a.a;
            if (factory2 != null) {
                factory = factory2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                factory = null;
            }
            p1.a(bVar, zBooleanValue, amount, factory, new K0(this.a), new L0(this.a), composer, 4608);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
