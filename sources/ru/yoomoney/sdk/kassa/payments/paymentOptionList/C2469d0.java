package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.res.Resources;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.ui.compose.ErrorStateScreenKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.d0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2469d0 extends Lambda implements Function2 {
    public final /* synthetic */ C2487j0 a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2469d0(C2487j0 c2487j0, Throwable th) {
        super(2);
        this.a = c2487j0;
        this.b = th;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421318217, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.paymentOptionList.PaymentOptionListFragment.showError.<anonymous>.<anonymous>.<anonymous> (PaymentOptionListFragment.kt:342)");
            }
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar = null;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String strStringResource = StringResources_androidKt.stringResource(R$string.ym_retry, composer, 0);
            ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar2 = this.a.b;
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
            }
            ErrorStateScreenKt.ErrorStateScreen(modifierFillMaxSize$default, 0, strStringResource, null, bVar.a(this.b).toString(), new C2466c0(this.a), composer, 6, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
