package ru.yoomoney.sdk.kassa.payments.di;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.V;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.model.B;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.InterfaceC2468d;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class i extends ViewModelProvider.NewInstanceFactory {
    public final b a;
    public final F1 b;
    public final PaymentParameters c;
    public final F d;
    public final e0 e;
    public final V f;
    public final ru.yoomoney.sdk.kassa.payments.logout.c g;
    public final B h;
    public final ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a i;
    public final M1 j;
    public final InterfaceC2468d k;
    public final ru.yoomoney.sdk.kassa.payments.config.f l;
    public final Context m;

    public i(b paymentOptionsAssisted, F1 paymentOptionsListUseCase, PaymentParameters paymentParameters, F reporter, e0 userAuthTypeParamProvider, V tokenizeSchemeParamProvider, ru.yoomoney.sdk.kassa.payments.logout.c logoutUseCase, B getConfirmation, ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a unbindCardUseCase, M1 shopPropertiesRepository, InterfaceC2468d configUseCase, ru.yoomoney.sdk.kassa.payments.config.f configRepository, Context appContext) {
        Intrinsics.checkNotNullParameter(paymentOptionsAssisted, "paymentOptionsAssisted");
        Intrinsics.checkNotNullParameter(paymentOptionsListUseCase, "paymentOptionsListUseCase");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(userAuthTypeParamProvider, "userAuthTypeParamProvider");
        Intrinsics.checkNotNullParameter(tokenizeSchemeParamProvider, "tokenizeSchemeParamProvider");
        Intrinsics.checkNotNullParameter(logoutUseCase, "logoutUseCase");
        Intrinsics.checkNotNullParameter(getConfirmation, "getConfirmation");
        Intrinsics.checkNotNullParameter(unbindCardUseCase, "unbindCardUseCase");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        Intrinsics.checkNotNullParameter(configUseCase, "configUseCase");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.a = paymentOptionsAssisted;
        this.b = paymentOptionsListUseCase;
        this.c = paymentParameters;
        this.d = reporter;
        this.e = userAuthTypeParamProvider;
        this.f = tokenizeSchemeParamProvider;
        this.g = logoutUseCase;
        this.h = getConfirmation;
        this.i = unbindCardUseCase;
        this.j = shopPropertiesRepository;
        this.k = configUseCase;
        this.l = configRepository;
        this.m = appContext;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("PaymentOptionList", new f(this), new h(this), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.kassa.payments.di.PaymentOptionsViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
