package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.e0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2472e0 extends Lambda implements Function2 {
    public final /* synthetic */ C2487j0 a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2472e0(C2487j0 c2487j0, Throwable th) {
        super(2);
        this.a = c2487j0;
        this.b = th;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-449981436, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.paymentOptionList.PaymentOptionListFragment.showError.<anonymous>.<anonymous> (PaymentOptionListFragment.kt:341)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, 421318217, true, new C2469d0(this.a, this.b)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
