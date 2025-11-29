package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2279m implements ru.yoomoney.sdk.kassa.payments.model.B {
    public final /* synthetic */ Context a;
    public final /* synthetic */ PaymentParameters b;

    public C2279m(Context context, PaymentParameters paymentParameters) {
        this.a = context;
        this.b = paymentParameters;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Resources.NotFoundException {
        ru.yoomoney.sdk.kassa.payments.model.T paymentOption = (ru.yoomoney.sdk.kassa.payments.model.T) obj;
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        Context context = this.a;
        String customReturnUrl = this.b.getCustomReturnUrl();
        if (customReturnUrl == null) {
            customReturnUrl = "https://checkoutsdk.success";
        }
        String string = this.a.getResources().getString(R$string.ym_app_scheme);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return ru.yoomoney.sdk.kassa.payments.extensions.i.a(paymentOption, context, customReturnUrl, string);
    }
}
