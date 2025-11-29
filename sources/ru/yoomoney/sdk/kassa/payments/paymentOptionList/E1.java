package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class E1 implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final F1 d;
    public final PaymentParameters e;
    public final String f;
    public final ru.yoomoney.sdk.kassa.payments.logout.c g;
    public final ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a h;
    public final ru.yoomoney.sdk.kassa.payments.model.B i;
    public final M1 j;
    public final ru.yoomoney.sdk.kassa.payments.config.f k;
    public final Function2 l;
    public final ru.yoomoney.sdk.kassa.payments.metrics.V m;

    public E1(Function2 showState, Function2 showEffect, Function1 source, F1 useCase, PaymentParameters paymentParameters, String str, ru.yoomoney.sdk.kassa.payments.logout.c logoutUseCase, ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a unbindCardUseCase, ru.yoomoney.sdk.kassa.payments.model.B getConfirmation, M1 shopPropertiesRepository, ru.yoomoney.sdk.kassa.payments.config.f configRepository, ru.yoomoney.sdk.kassa.payments.di.g getTokenizeScheme, ru.yoomoney.sdk.kassa.payments.metrics.V tokenizeSchemeProvider) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(logoutUseCase, "logoutUseCase");
        Intrinsics.checkNotNullParameter(unbindCardUseCase, "unbindCardUseCase");
        Intrinsics.checkNotNullParameter(getConfirmation, "getConfirmation");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        Intrinsics.checkNotNullParameter(getTokenizeScheme, "getTokenizeScheme");
        Intrinsics.checkNotNullParameter(tokenizeSchemeProvider, "tokenizeSchemeProvider");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = useCase;
        this.e = paymentParameters;
        this.f = str;
        this.g = logoutUseCase;
        this.h = unbindCardUseCase;
        this.i = getConfirmation;
        this.j = shopPropertiesRepository;
        this.k = configRepository;
        this.l = getTokenizeScheme;
        this.m = tokenizeSchemeProvider;
    }

    public static final void a(E1 e1, Out.Builder builder, C2508s c2508s) {
        Function1 o0;
        Function1 n0;
        e1.getClass();
        if (c2508s.a.a().size() == 1) {
            ru.yoomoney.sdk.kassa.payments.model.T t = (ru.yoomoney.sdk.kassa.payments.model.T) CollectionsKt.first(c2508s.a.a());
            if (!(t instanceof BankCardPaymentOption)) {
                n0 = new N0(t, null);
            } else if (((BankCardPaymentOption) t).getPaymentInstruments().isEmpty()) {
                n0 = new L0(t, null);
            } else {
                o0 = new M0(e1, builder, null);
            }
            CoreKt.input(builder, n0);
            return;
        }
        o0 = new O0(e1, builder, null);
        CoreKt.input(builder, o0);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 1065
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.E1.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
