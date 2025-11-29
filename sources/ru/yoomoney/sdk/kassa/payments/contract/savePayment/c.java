package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.core.text.HtmlCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function2 {
    public final /* synthetic */ SavePaymentMethodInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SavePaymentMethodInfoActivity savePaymentMethodInfoActivity) {
        super(2);
        this.a = savePaymentMethodInfoActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1102781484, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.SavePaymentMethodInfoActivity.onCreate.<anonymous>.<anonymous> (SavePaymentMethodInfoActivity.kt:48)");
            }
            String stringExtra = this.a.getIntent().getStringExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TITLE_STRING");
            CharSequence charSequenceFromHtml = stringExtra != null ? HtmlCompat.fromHtml(stringExtra, 0) : null;
            if (charSequenceFromHtml == null) {
                charSequenceFromHtml = this.a.getResources().getString(this.a.getIntent().getIntExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TITLE", 0));
                Intrinsics.checkNotNullExpressionValue(charSequenceFromHtml, "getString(...)");
            }
            String stringExtra2 = this.a.getIntent().getStringExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TEXT_STRING");
            CharSequence charSequenceFromHtml2 = stringExtra2 != null ? HtmlCompat.fromHtml(stringExtra2, 0) : null;
            if (charSequenceFromHtml2 == null) {
                charSequenceFromHtml2 = this.a.getResources().getString(this.a.getIntent().getIntExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TEXT", 0));
                Intrinsics.checkNotNullExpressionValue(charSequenceFromHtml2, "getString(...)");
            }
            CharSequence charSequence = charSequenceFromHtml2;
            composer.startReplaceableGroup(-166030710);
            boolean zChanged = composer.changed(this.a);
            SavePaymentMethodInfoActivity savePaymentMethodInfoActivity = this.a;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a(savePaymentMethodInfoActivity);
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            composer.endReplaceableGroup();
            String strStringResource = StringResources_androidKt.stringResource(R$string.ym_understand_button, composer, 0);
            composer.startReplaceableGroup(-166030575);
            boolean zChanged2 = composer.changed(this.a);
            SavePaymentMethodInfoActivity savePaymentMethodInfoActivity2 = this.a;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new b(savePaymentMethodInfoActivity2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function02 = (Function0) objRememberedValue2;
            composer.endReplaceableGroup();
            int intExtra = this.a.getIntent().getIntExtra("ru.yoo.money.android.extra.ADDITIONAL_TEXT_RES", 0);
            Integer numValueOf = Integer.valueOf(intExtra);
            if (intExtra == 0) {
                numValueOf = null;
            }
            composer.startReplaceableGroup(-166030455);
            String strStringResource2 = numValueOf != null ? StringResources_androidKt.stringResource(numValueOf.intValue(), composer, 0) : null;
            composer.endReplaceableGroup();
            j.a(charSequenceFromHtml, charSequence, function0, strStringResource, function02, strStringResource2, composer, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
