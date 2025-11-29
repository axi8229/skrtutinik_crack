package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function2 {
    public final /* synthetic */ SavePaymentMethodInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SavePaymentMethodInfoActivity savePaymentMethodInfoActivity) {
        super(2);
        this.a = savePaymentMethodInfoActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213758361, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.SavePaymentMethodInfoActivity.onCreate.<anonymous> (SavePaymentMethodInfoActivity.kt:47)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, 1102781484, true, new c(this.a)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
