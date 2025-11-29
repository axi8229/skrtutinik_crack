package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.q0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.x0;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2379j extends Lambda implements Function2 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2379j(C2382m c2382m) {
        super(2);
        this.a = c2382m;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar;
        x0 x0Var;
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d0Var;
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2048152119, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankListFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (BankListFragment.kt:88)");
            }
            q0 q0Var = (q0) this.a.h.getValue();
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar2 = this.a.a;
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
                bVar = null;
            }
            x0 x0Var2 = this.a.b;
            if (x0Var2 != null) {
                x0Var = x0Var2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                x0Var = null;
            }
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d0Var2 = this.a.d;
            if (d0Var2 != null) {
                d0Var = d0Var2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("bankListInteractor");
                d0Var = null;
            }
            AbstractC2374e.a(q0Var, bVar, x0Var, d0Var, new C2377h(this.a), new C2378i(this.a), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
