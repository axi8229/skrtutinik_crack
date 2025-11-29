package ru.yoomoney.sdk.auth.oauth.notFound.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory implements Factory<Fragment> {
    private final Provider<OauthNotFoundInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final OauthNotFoundModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory(OauthNotFoundModule oauthNotFoundModule, Provider<OauthNotFoundInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<Lazy<Config>> provider6) {
        this.module = oauthNotFoundModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyRemoteConfigProvider = provider5;
        this.lazyConfigProvider = provider6;
    }

    public static OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory create(OauthNotFoundModule oauthNotFoundModule, Provider<OauthNotFoundInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<Lazy<Config>> provider6) {
        return new OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory(oauthNotFoundModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment provideOauthNotFoundFragment(OauthNotFoundModule oauthNotFoundModule, OauthNotFoundInteractor oauthNotFoundInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazy, Lazy<Config> lazy2) {
        return (Fragment) Preconditions.checkNotNullFromProvides(oauthNotFoundModule.provideOauthNotFoundFragment(oauthNotFoundInteractor, router, processMapper, resourceMapper, lazy, lazy2));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideOauthNotFoundFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyRemoteConfigProvider.get(), this.lazyConfigProvider.get());
    }
}
