package ru.yoomoney.sdk.kassa.payments.unbind.ui;

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
import ru.yoomoney.sdk.kassa.payments.metrics.F;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function0 {
    public final /* synthetic */ Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, F f) {
        super(0);
        this.a = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context context = this.a;
        int i = R$string.ym_how_unbind_wallet_card_title;
        int i2 = R$string.ym_how_unbind_wallet_card_body;
        int i3 = SavePaymentMethodInfoActivity.$r8$clinit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) SavePaymentMethodInfoActivity.class);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TITLE", i);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TEXT", i2);
        intent.putExtra("ru.yoo.money.android.extra.ADDITIONAL_TEXT_RES", (Serializable) null);
        ContextCompat.startActivity(context, intent.setFlags(268435456), null);
        return Unit.INSTANCE;
    }
}
