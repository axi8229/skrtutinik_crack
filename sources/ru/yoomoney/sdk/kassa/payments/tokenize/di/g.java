package ru.yoomoney.sdk.kassa.payments.tokenize.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2309s;
import ru.yoomoney.sdk.kassa.payments.metrics.V;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.secure.j;
import ru.yoomoney.sdk.kassa.payments.tokenize.I;
import ru.yoomoney.sdk.march.CodeKt;

/* loaded from: classes5.dex */
public final class g implements Factory {
    public final e a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;

    public g(e eVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, Factory factory, dagger.internal.Provider provider5, dagger.internal.Provider provider6, dagger.internal.Provider provider7) {
        this.a = eVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = factory;
        this.g = provider5;
        this.h = provider6;
        this.i = provider7;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        e eVar = this.a;
        I tokenizeUseCase = (I) this.b.get();
        F reporter = (F) this.c.get();
        InterfaceC2309s errorScreenReporter = (InterfaceC2309s) this.d.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.e.get();
        UiParameters uiParameters = (UiParameters) this.f.get();
        j tokensStorage = (j) this.g.get();
        e0 userAuthTypeParamProvider = (e0) this.h.get();
        V tokenizeSchemeParamProvider = (V) this.i.get();
        eVar.getClass();
        Intrinsics.checkNotNullParameter(tokenizeUseCase, "tokenizeUseCase");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(errorScreenReporter, "errorScreenReporter");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        Intrinsics.checkNotNullParameter(userAuthTypeParamProvider, "userAuthTypeParamProvider");
        Intrinsics.checkNotNullParameter(tokenizeSchemeParamProvider, "tokenizeSchemeParamProvider");
        return (ViewModel) Preconditions.checkNotNullFromProvides(CodeKt.RuntimeViewModel$default("Tokenize", c.a, new d(paymentParameters, uiParameters, errorScreenReporter, reporter, tokenizeSchemeParamProvider, userAuthTypeParamProvider, tokensStorage, tokenizeUseCase), null, null, null, null, null, null, null, null, 2040, null));
    }
}
