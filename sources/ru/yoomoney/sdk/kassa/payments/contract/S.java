package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.contract.savePayment.SavePaymentMethodInfoActivity;

/* loaded from: classes5.dex */
public final class S extends Lambda implements Function0 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(C2264y0 c2264y0) {
        super(0);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context contextRequireContext = this.a.requireContext();
        int i = SavePaymentMethodInfoActivity.$r8$clinit;
        Context context = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
        int i2 = R$string.ym_safe_payments_agreement_title;
        int i3 = R$string.ym_safe_payments_agreement_message;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) SavePaymentMethodInfoActivity.class);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TITLE", i2);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TEXT", i3);
        intent.putExtra("ru.yoo.money.android.extra.ADDITIONAL_TEXT_RES", (Serializable) null);
        ContextCompat.startActivity(contextRequireContext, intent.setFlags(268435456), null);
        return Unit.INSTANCE;
    }
}
