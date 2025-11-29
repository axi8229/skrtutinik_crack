package ru.yoomoney.sdk.kassa.payments.contract.di;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {
    public final /* synthetic */ PaymentParameters a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.http.a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, PaymentParameters paymentParameters, ru.yoomoney.sdk.kassa.payments.http.a aVar) {
        super(1);
        this.a = paymentParameters;
        this.b = context;
        this.c = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        String str = (String) obj;
        if (str != null && this.a.getPaymentMethodTypes().contains(PaymentMethodType.YOO_MONEY)) {
            YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
            Context applicationContext = this.b.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            YooMoneyAuth.logout$default(yooMoneyAuth, applicationContext, str, ((ru.yoomoney.sdk.kassa.payments.http.b) this.c).b(), false, 8, null);
        }
        return Unit.INSTANCE;
    }
}
