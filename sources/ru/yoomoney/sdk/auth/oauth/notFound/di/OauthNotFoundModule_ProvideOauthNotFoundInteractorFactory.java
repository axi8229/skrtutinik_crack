package ru.yoomoney.sdk.auth.oauth.notFound.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractor;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory implements Factory<OauthNotFoundInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final OauthNotFoundModule module;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory(OauthNotFoundModule oauthNotFoundModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<LoginRepository> provider3, Provider<ServerTimeRepository> provider4, Provider<YooProfiler> provider5, Provider<ResultData> provider6, Provider<Lazy<Config>> provider7) {
        this.module = oauthNotFoundModule;
        this.enrollmentRepositoryProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.loginRepositoryProvider = provider3;
        this.serverTimeRepositoryProvider = provider4;
        this.profilerProvider = provider5;
        this.resultDataProvider = provider6;
        this.lazyConfigProvider = provider7;
    }

    public static OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory create(OauthNotFoundModule oauthNotFoundModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<LoginRepository> provider3, Provider<ServerTimeRepository> provider4, Provider<YooProfiler> provider5, Provider<ResultData> provider6, Provider<Lazy<Config>> provider7) {
        return new OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory(oauthNotFoundModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static OauthNotFoundInteractor provideOauthNotFoundInteractor(OauthNotFoundModule oauthNotFoundModule, EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, ServerTimeRepository serverTimeRepository, YooProfiler yooProfiler, ResultData resultData, Lazy<Config> lazy) {
        return (OauthNotFoundInteractor) Preconditions.checkNotNullFromProvides(oauthNotFoundModule.provideOauthNotFoundInteractor(enrollmentRepository, registrationV2Repository, loginRepository, serverTimeRepository, yooProfiler, resultData, lazy));
    }

    @Override // javax.inject.Provider
    public OauthNotFoundInteractor get() {
        return provideOauthNotFoundInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.loginRepositoryProvider.get(), this.serverTimeRepositoryProvider.get(), this.profilerProvider.get(), this.resultDataProvider.get(), this.lazyConfigProvider.get());
    }
}
