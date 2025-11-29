package ru.yoomoney.sdk.auth.nickname.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class NicknameModule_ProvideNicknameFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final NicknameModule module;
    private final Provider<NicknameInteractor> nicknameInteractorProvider;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public NicknameModule_ProvideNicknameFragmentFactory(NicknameModule nicknameModule, Provider<ResultData> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<NicknameInteractor> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = nicknameModule;
        this.resultDataProvider = provider;
        this.lazyConfigProvider = provider2;
        this.routerProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.nicknameInteractorProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static NicknameModule_ProvideNicknameFragmentFactory create(NicknameModule nicknameModule, Provider<ResultData> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<NicknameInteractor> provider6, Provider<AnalyticsLogger> provider7) {
        return new NicknameModule_ProvideNicknameFragmentFactory(nicknameModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment provideNicknameFragment(NicknameModule nicknameModule, ResultData resultData, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, NicknameInteractor nicknameInteractor, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(nicknameModule.provideNicknameFragment(resultData, lazy, router, processMapper, resourceMapper, nicknameInteractor, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideNicknameFragment(this.module, this.resultDataProvider.get(), this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.nicknameInteractorProvider.get(), this.analyticsLoggerProvider.get());
    }
}
