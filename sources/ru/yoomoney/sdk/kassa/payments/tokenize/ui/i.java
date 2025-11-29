package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class i extends Lambda implements Function2 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(n nVar) {
        super(2);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar;
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2067344843, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.tokenize.ui.TokenizeFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (TokenizeFragment.kt:88)");
            }
            RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.a.d.getValue();
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar2 = this.a.c;
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
                bVar = null;
            }
            Bundle arguments = this.a.getArguments();
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.i iVar = arguments != null ? (ru.yoomoney.sdk.kassa.payments.payment.tokenize.i) arguments.getParcelable("tokenizeInputModel") : null;
            if (iVar == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            e.a(bVar, runtimeViewModel, iVar, new f(this.a), new g(this.a), new h(this.a), composer, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
