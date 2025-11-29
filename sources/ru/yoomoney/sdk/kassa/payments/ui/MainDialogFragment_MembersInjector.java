package ru.yoomoney.sdk.kassa.payments.ui;

import dagger.MembersInjector;
import javax.inject.Provider;
import ru.yoomoney.sdk.kassa.payments.metrics.N;
import ru.yoomoney.sdk.kassa.payments.payment.c;

/* loaded from: classes5.dex */
public final class MainDialogFragment_MembersInjector implements MembersInjector<MainDialogFragment> {
    private final Provider<c> loadedPaymentOptionListRepositoryProvider;
    private final Provider<ru.yoomoney.sdk.kassa.payments.navigation.c> routerProvider;
    private final Provider<N> sessionReporterProvider;

    public MainDialogFragment_MembersInjector(Provider<N> provider, Provider<ru.yoomoney.sdk.kassa.payments.navigation.c> provider2, Provider<c> provider3) {
        this.sessionReporterProvider = provider;
        this.routerProvider = provider2;
        this.loadedPaymentOptionListRepositoryProvider = provider3;
    }

    public static MembersInjector<MainDialogFragment> create(Provider<N> provider, Provider<ru.yoomoney.sdk.kassa.payments.navigation.c> provider2, Provider<c> provider3) {
        return new MainDialogFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectLoadedPaymentOptionListRepository(MainDialogFragment mainDialogFragment, c cVar) {
        mainDialogFragment.loadedPaymentOptionListRepository = cVar;
    }

    public static void injectRouter(MainDialogFragment mainDialogFragment, ru.yoomoney.sdk.kassa.payments.navigation.c cVar) {
        mainDialogFragment.router = cVar;
    }

    public static void injectSessionReporter(MainDialogFragment mainDialogFragment, N n) {
        mainDialogFragment.sessionReporter = n;
    }

    public void injectMembers(MainDialogFragment mainDialogFragment) {
        injectSessionReporter(mainDialogFragment, this.sessionReporterProvider.get());
        injectRouter(mainDialogFragment, this.routerProvider.get());
        injectLoadedPaymentOptionListRepository(mainDialogFragment, this.loadedPaymentOptionListRepositoryProvider.get());
    }
}
