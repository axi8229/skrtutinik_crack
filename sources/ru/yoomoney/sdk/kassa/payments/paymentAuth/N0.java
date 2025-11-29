package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* loaded from: classes5.dex */
public final class N0 extends Lambda implements Function2 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(O0 o0) {
        super(2);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-295581263, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.PaymentAuthFragment.onViewCreated.<anonymous>.<anonymous> (PaymentAuthFragment.kt:98)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, -177585290, true, new M0(this.a)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
