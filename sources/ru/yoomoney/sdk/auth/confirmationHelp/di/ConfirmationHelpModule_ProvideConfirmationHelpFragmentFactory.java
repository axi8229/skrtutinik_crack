package ru.yoomoney.sdk.auth.confirmationHelp.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory implements Factory<Fragment> {
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final ConfirmationHelpModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory(ConfirmationHelpModule confirmationHelpModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4) {
        this.module = confirmationHelpModule;
        this.lazyConfigProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
    }

    public static ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory create(ConfirmationHelpModule confirmationHelpModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4) {
        return new ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory(confirmationHelpModule, provider, provider2, provider3, provider4);
    }

    public static Fragment provideConfirmationHelpFragment(ConfirmationHelpModule confirmationHelpModule, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(confirmationHelpModule.provideConfirmationHelpFragment(lazy, router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideConfirmationHelpFragment(this.module, this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
