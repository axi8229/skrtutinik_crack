package ru.yoomoney.sdk.kassa.payments.ui;

import dagger.MembersInjector;
import javax.inject.Provider;
import ru.yoomoney.sdk.kassa.payments.errorFormatter.b;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2311u;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.secure.j;

/* loaded from: classes5.dex */
public final class CheckoutActivity_MembersInjector implements MembersInjector<CheckoutActivity> {
    private final Provider<b> errorFormatterProvider;
    private final Provider<InterfaceC2311u> exceptionReporterProvider;
    private final Provider<F> reporterProvider;
    private final Provider<j> tokensStorageProvider;
    private final Provider<e0> userAuthParamProvider;

    public CheckoutActivity_MembersInjector(Provider<b> provider, Provider<InterfaceC2311u> provider2, Provider<F> provider3, Provider<e0> provider4, Provider<j> provider5) {
        this.errorFormatterProvider = provider;
        this.exceptionReporterProvider = provider2;
        this.reporterProvider = provider3;
        this.userAuthParamProvider = provider4;
        this.tokensStorageProvider = provider5;
    }

    public static MembersInjector<CheckoutActivity> create(Provider<b> provider, Provider<InterfaceC2311u> provider2, Provider<F> provider3, Provider<e0> provider4, Provider<j> provider5) {
        return new CheckoutActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectErrorFormatter(CheckoutActivity checkoutActivity, b bVar) {
        checkoutActivity.errorFormatter = bVar;
    }

    public static void injectExceptionReporter(CheckoutActivity checkoutActivity, InterfaceC2311u interfaceC2311u) {
        checkoutActivity.exceptionReporter = interfaceC2311u;
    }

    public static void injectReporter(CheckoutActivity checkoutActivity, F f) {
        checkoutActivity.reporter = f;
    }

    public static void injectTokensStorage(CheckoutActivity checkoutActivity, j jVar) {
        checkoutActivity.tokensStorage = jVar;
    }

    public static void injectUserAuthParamProvider(CheckoutActivity checkoutActivity, e0 e0Var) {
        checkoutActivity.userAuthParamProvider = e0Var;
    }

    public void injectMembers(CheckoutActivity checkoutActivity) {
        injectErrorFormatter(checkoutActivity, this.errorFormatterProvider.get());
        injectExceptionReporter(checkoutActivity, this.exceptionReporterProvider.get());
        injectReporter(checkoutActivity, this.reporterProvider.get());
        injectUserAuthParamProvider(checkoutActivity, this.userAuthParamProvider.get());
        injectTokensStorage(checkoutActivity, this.tokensStorageProvider.get());
    }
}
