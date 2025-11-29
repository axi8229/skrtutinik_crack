package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2380k extends Lambda implements Function2 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2380k(C2382m c2382m) {
        super(2);
        this.a = c2382m;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1572232132, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankListFragment.onViewCreated.<anonymous>.<anonymous> (BankListFragment.kt:87)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, -2048152119, true, new C2379j(this.a)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
