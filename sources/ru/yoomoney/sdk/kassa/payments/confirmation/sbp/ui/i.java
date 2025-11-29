package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.s;

/* loaded from: classes5.dex */
public final class i extends Lambda implements Function2 {
    public final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar) {
        super(2);
        this.a = jVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        s sVar;
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar;
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(134646357, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui.SBPConfirmationFragment.onCreateView.<anonymous> (SBPConfirmationFragment.kt:65)");
            }
            g gVar = new g(this.a);
            String str = (String) this.a.d.getValue();
            s sVar2 = this.a.a;
            if (sVar2 != null) {
                sVar = sVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                sVar = null;
            }
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar2 = this.a.b;
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
                bVar = null;
            }
            e.a(gVar, new h(this.a), str, bVar, sVar, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
