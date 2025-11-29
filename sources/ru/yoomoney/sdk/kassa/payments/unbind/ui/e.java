package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function2 {
    public final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar) {
        super(2);
        this.a = gVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        F f;
        ViewModelProvider.Factory factory;
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1056539568, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.UnbindCardFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (UnbindCardFragment.kt:81)");
            }
            F f2 = this.a.c;
            if (f2 != null) {
                f = f2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
                f = null;
            }
            LinkedCard linkedCard = (LinkedCard) this.a.d.getValue();
            Q q = (Q) this.a.e.getValue();
            ViewModelProvider.Factory factory2 = this.a.a;
            if (factory2 != null) {
                factory = factory2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                factory = null;
            }
            ru.yoomoney.sdk.kassa.payments.unbind.impl.h.a(f, linkedCard, q, factory, new c(this.a), new d(this.a), composer, 4160);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
