package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;

/* loaded from: classes5.dex */
public final class P implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final PaymentParameters d;
    public final X0 e;
    public final ru.yoomoney.sdk.kassa.payments.logout.c f;
    public final ru.yoomoney.sdk.kassa.payments.model.B g;
    public final ru.yoomoney.sdk.kassa.payments.payment.c h;
    public final ru.yoomoney.sdk.kassa.payments.userAuth.U i;
    public final M1 j;
    public final ru.yoomoney.sdk.kassa.payments.config.f k;
    public final String l;
    public final int m;
    public final String n;

    public P(Function2 showState, Function2 showEffect, Function1 source, PaymentParameters paymentParameters, X0 selectPaymentMethodUseCase, ru.yoomoney.sdk.kassa.payments.logout.c logoutUseCase, ru.yoomoney.sdk.kassa.payments.model.B getConfirmation, ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.secure.j userAuthInfoRepository, M1 shopPropertiesRepository, ru.yoomoney.sdk.kassa.payments.config.f configRepository, String defaultAgentSchemeUserAgreementUrl, int i, String str) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(selectPaymentMethodUseCase, "selectPaymentMethodUseCase");
        Intrinsics.checkNotNullParameter(logoutUseCase, "logoutUseCase");
        Intrinsics.checkNotNullParameter(getConfirmation, "getConfirmation");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        Intrinsics.checkNotNullParameter(defaultAgentSchemeUserAgreementUrl, "defaultAgentSchemeUserAgreementUrl");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = paymentParameters;
        this.e = selectPaymentMethodUseCase;
        this.f = logoutUseCase;
        this.g = getConfirmation;
        this.h = loadedPaymentOptionListRepository;
        this.i = userAuthInfoRepository;
        this.j = shopPropertiesRepository;
        this.k = configRepository;
        this.l = defaultAgentSchemeUserAgreementUrl;
        this.m = i;
        this.n = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r24, java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 805
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.contract.P.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
