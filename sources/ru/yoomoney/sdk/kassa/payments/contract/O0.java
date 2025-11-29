package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class O0 extends ViewModelProvider.NewInstanceFactory {
    public final Context a;
    public final X0 b;
    public final PaymentParameters c;
    public final ru.yoomoney.sdk.kassa.payments.logout.c d;
    public final ru.yoomoney.sdk.kassa.payments.metrics.F e;
    public final ru.yoomoney.sdk.kassa.payments.metrics.e0 f;
    public final ru.yoomoney.sdk.kassa.payments.model.B g;
    public final ru.yoomoney.sdk.kassa.payments.payment.c h;
    public final ru.yoomoney.sdk.kassa.payments.secure.j i;
    public final ru.yoomoney.sdk.kassa.payments.metrics.V j;
    public final M1 k;
    public final ru.yoomoney.sdk.kassa.payments.config.f l;
    public final int m;
    public final String n;

    public O0(Context context, X0 selectPaymentMethodUseCase, PaymentParameters paymentParameters, ru.yoomoney.sdk.kassa.payments.logout.c logoutUseCase, ru.yoomoney.sdk.kassa.payments.metrics.F reporter, ru.yoomoney.sdk.kassa.payments.metrics.e0 userAuthTypeParamProvider, ru.yoomoney.sdk.kassa.payments.model.B getConfirmation, ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.secure.j userAuthInfoRepository, ru.yoomoney.sdk.kassa.payments.metrics.V tokenizeSchemeParamProvider, M1 shopPropertiesRepository, ru.yoomoney.sdk.kassa.payments.config.f configRepository, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectPaymentMethodUseCase, "selectPaymentMethodUseCase");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(logoutUseCase, "logoutUseCase");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(userAuthTypeParamProvider, "userAuthTypeParamProvider");
        Intrinsics.checkNotNullParameter(getConfirmation, "getConfirmation");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(tokenizeSchemeParamProvider, "tokenizeSchemeParamProvider");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        this.a = context;
        this.b = selectPaymentMethodUseCase;
        this.c = paymentParameters;
        this.d = logoutUseCase;
        this.e = reporter;
        this.f = userAuthTypeParamProvider;
        this.g = getConfirmation;
        this.h = loadedPaymentOptionListRepository;
        this.i = userAuthInfoRepository;
        this.j = tokenizeSchemeParamProvider;
        this.k = shopPropertiesRepository;
        this.l = configRepository;
        this.m = i;
        this.n = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("CONTRACT", new L0(this), new N0(this), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.kassa.payments.contract.ContractVmFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
