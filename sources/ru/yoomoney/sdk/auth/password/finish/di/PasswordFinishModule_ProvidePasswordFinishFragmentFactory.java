package ru.yoomoney.sdk.auth.password.finish.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class PasswordFinishModule_ProvidePasswordFinishFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<BusinessLogicEventSubscriber> businessLogicEventsSubscriberProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final PasswordFinishModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public PasswordFinishModule_ProvidePasswordFinishFragmentFactory(PasswordFinishModule passwordFinishModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<BusinessLogicEventSubscriber> provider5, Provider<AnalyticsLogger> provider6) {
        this.module = passwordFinishModule;
        this.lazyConfigProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.businessLogicEventsSubscriberProvider = provider5;
        this.analyticsLoggerProvider = provider6;
    }

    public static PasswordFinishModule_ProvidePasswordFinishFragmentFactory create(PasswordFinishModule passwordFinishModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<BusinessLogicEventSubscriber> provider5, Provider<AnalyticsLogger> provider6) {
        return new PasswordFinishModule_ProvidePasswordFinishFragmentFactory(passwordFinishModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment providePasswordFinishFragment(PasswordFinishModule passwordFinishModule, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, BusinessLogicEventSubscriber businessLogicEventSubscriber, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(passwordFinishModule.providePasswordFinishFragment(lazy, router, processMapper, resourceMapper, businessLogicEventSubscriber, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePasswordFinishFragment(this.module, this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.businessLogicEventsSubscriberProvider.get(), this.analyticsLoggerProvider.get());
    }
}
