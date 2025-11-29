package ru.yoomoney.sdk.auth.finishing.success.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractor;

/* loaded from: classes4.dex */
public final class AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory implements Factory<AuthFinishingSuccessInteractor> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<Lazy<Config>> configProvider;
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthFinishingSuccessModule module;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ResultData> resultDataProvider;

    public AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory(AuthFinishingSuccessModule authFinishingSuccessModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<RegistrationV2Repository> provider3, Provider<MigrationRepository> provider4, Provider<AccountRepository> provider5, Provider<Lazy<Config>> provider6, Provider<ResultData> provider7) {
        this.module = authFinishingSuccessModule;
        this.enrollmentRepositoryProvider = provider;
        this.loginRepositoryProvider = provider2;
        this.registrationV2RepositoryProvider = provider3;
        this.migrationRepositoryProvider = provider4;
        this.accountRepositoryProvider = provider5;
        this.configProvider = provider6;
        this.resultDataProvider = provider7;
    }

    public static AuthFinishingSuccessInteractor authFinishingSuccessInteractor(AuthFinishingSuccessModule authFinishingSuccessModule, EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, AccountRepository accountRepository, Lazy<Config> lazy, ResultData resultData) {
        return (AuthFinishingSuccessInteractor) Preconditions.checkNotNullFromProvides(authFinishingSuccessModule.authFinishingSuccessInteractor(enrollmentRepository, loginRepository, registrationV2Repository, migrationRepository, accountRepository, lazy, resultData));
    }

    public static AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory create(AuthFinishingSuccessModule authFinishingSuccessModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<RegistrationV2Repository> provider3, Provider<MigrationRepository> provider4, Provider<AccountRepository> provider5, Provider<Lazy<Config>> provider6, Provider<ResultData> provider7) {
        return new AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory(authFinishingSuccessModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public AuthFinishingSuccessInteractor get() {
        return authFinishingSuccessInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.loginRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.accountRepositoryProvider.get(), this.configProvider.get(), this.resultDataProvider.get());
    }
}
