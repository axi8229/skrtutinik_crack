package ru.yoomoney.sdk.auth.oauth.failure.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class OauthFailureModule_ProvideOauthFailureFragmentFactory implements Factory<Fragment> {
    private final OauthFailureModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public OauthFailureModule_ProvideOauthFailureFragmentFactory(OauthFailureModule oauthFailureModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<ResourceMapper> provider3) {
        this.module = oauthFailureModule;
        this.routerProvider = provider;
        this.processMapperProvider = provider2;
        this.resourceMapperProvider = provider3;
    }

    public static OauthFailureModule_ProvideOauthFailureFragmentFactory create(OauthFailureModule oauthFailureModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<ResourceMapper> provider3) {
        return new OauthFailureModule_ProvideOauthFailureFragmentFactory(oauthFailureModule, provider, provider2, provider3);
    }

    public static Fragment provideOauthFailureFragment(OauthFailureModule oauthFailureModule, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(oauthFailureModule.provideOauthFailureFragment(router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideOauthFailureFragment(this.module, this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
