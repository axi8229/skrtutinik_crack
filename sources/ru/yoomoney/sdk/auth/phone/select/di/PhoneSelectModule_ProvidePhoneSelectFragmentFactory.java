package ru.yoomoney.sdk.auth.phone.select.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class PhoneSelectModule_ProvidePhoneSelectFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<PhoneSelectInteractor> interactorProvider;
    private final PhoneSelectModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public PhoneSelectModule_ProvidePhoneSelectFragmentFactory(PhoneSelectModule phoneSelectModule, Provider<PhoneSelectInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5) {
        this.module = phoneSelectModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.analyticsLoggerProvider = provider5;
    }

    public static PhoneSelectModule_ProvidePhoneSelectFragmentFactory create(PhoneSelectModule phoneSelectModule, Provider<PhoneSelectInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5) {
        return new PhoneSelectModule_ProvidePhoneSelectFragmentFactory(phoneSelectModule, provider, provider2, provider3, provider4, provider5);
    }

    public static Fragment providePhoneSelectFragment(PhoneSelectModule phoneSelectModule, PhoneSelectInteractor phoneSelectInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(phoneSelectModule.providePhoneSelectFragment(phoneSelectInteractor, router, processMapper, resourceMapper, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePhoneSelectFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.analyticsLoggerProvider.get());
    }
}
