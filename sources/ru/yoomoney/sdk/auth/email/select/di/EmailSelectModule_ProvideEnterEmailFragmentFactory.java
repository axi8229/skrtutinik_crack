package ru.yoomoney.sdk.auth.email.select.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class EmailSelectModule_ProvideEnterEmailFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<EmailSelectInteractor> interactorProvider;
    private final EmailSelectModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public EmailSelectModule_ProvideEnterEmailFragmentFactory(EmailSelectModule emailSelectModule, Provider<EmailSelectInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<AnalyticsLogger> provider6) {
        this.module = emailSelectModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.resultDataProvider = provider5;
        this.analyticsLoggerProvider = provider6;
    }

    public static EmailSelectModule_ProvideEnterEmailFragmentFactory create(EmailSelectModule emailSelectModule, Provider<EmailSelectInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<AnalyticsLogger> provider6) {
        return new EmailSelectModule_ProvideEnterEmailFragmentFactory(emailSelectModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment provideEnterEmailFragment(EmailSelectModule emailSelectModule, EmailSelectInteractor emailSelectInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(emailSelectModule.provideEnterEmailFragment(emailSelectInteractor, router, processMapper, resourceMapper, resultData, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideEnterEmailFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.analyticsLoggerProvider.get());
    }
}
