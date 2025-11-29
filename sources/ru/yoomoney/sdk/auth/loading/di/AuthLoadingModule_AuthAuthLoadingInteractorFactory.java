package ru.yoomoney.sdk.auth.loading.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class AuthLoadingModule_AuthAuthLoadingInteractorFactory implements Factory<AuthLoadingInteractor> {
    private final Provider<Context> contextProvider;
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthLoadingModule module;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthLoadingModule_AuthAuthLoadingInteractorFactory(AuthLoadingModule authLoadingModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<LoginRepository> provider3, Provider<MigrationRepository> provider4, Provider<ServerTimeRepository> provider5, Provider<YooProfiler> provider6, Provider<Lazy<Config>> provider7, Provider<ResultData> provider8, Provider<Context> provider9) {
        this.module = authLoadingModule;
        this.enrollmentRepositoryProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.loginRepositoryProvider = provider3;
        this.migrationRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
        this.profilerProvider = provider6;
        this.lazyConfigProvider = provider7;
        this.resultDataProvider = provider8;
        this.contextProvider = provider9;
    }

    public static AuthLoadingInteractor authAuthLoadingInteractor(AuthLoadingModule authLoadingModule, EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository, YooProfiler yooProfiler, Lazy<Config> lazy, ResultData resultData, Context context) {
        return (AuthLoadingInteractor) Preconditions.checkNotNullFromProvides(authLoadingModule.authAuthLoadingInteractor(enrollmentRepository, registrationV2Repository, loginRepository, migrationRepository, serverTimeRepository, yooProfiler, lazy, resultData, context));
    }

    public static AuthLoadingModule_AuthAuthLoadingInteractorFactory create(AuthLoadingModule authLoadingModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<LoginRepository> provider3, Provider<MigrationRepository> provider4, Provider<ServerTimeRepository> provider5, Provider<YooProfiler> provider6, Provider<Lazy<Config>> provider7, Provider<ResultData> provider8, Provider<Context> provider9) {
        return new AuthLoadingModule_AuthAuthLoadingInteractorFactory(authLoadingModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public AuthLoadingInteractor get() {
        return authAuthLoadingInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.loginRepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.serverTimeRepositoryProvider.get(), this.profilerProvider.get(), this.lazyConfigProvider.get(), this.resultDataProvider.get(), this.contextProvider.get());
    }
}
